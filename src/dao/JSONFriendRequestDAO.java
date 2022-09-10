package dao;

import beans.models.FriendRequest;
import beans.models.FriendRequestStatus;
import beans.models.Post;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import utils.FilePathUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

public class JSONFriendRequestDAO implements FriendRequestDAO{

    // Key: Sender username; Value: Set of friend requests that were sent by that user
    private Map<String, Set<FriendRequest>> requests;

    public JSONFriendRequestDAO() {
        load();
    }

    @Override
    public List<FriendRequest> getAllRequests() {
        ArrayList<FriendRequest> all = new ArrayList<>();

        for (Set<FriendRequest> recipientSet : requests.values()) {
            all.addAll(recipientSet);
        }

        return all;
    }

    @Override
    public void addRequest(FriendRequest request) {
        String from = request.getFrom();
        String to = request.getTo();

        if(!friendRequestExists(to, from)) {
            if (requests.containsKey(from) &&
                    !requests.get(from).contains(request)) {
                requests.get(from).add(request);
            } else {
                HashSet<FriendRequest> newRecipientSet = new HashSet<>();
                newRecipientSet.add(request);
                requests.put(from, newRecipientSet);
            }
            saveChanges();
        }
    }

    @Override
    public void deleteRequest(String from, String to) {
        FriendRequest reqToDelete = getFriendRequest(from, to);
        requests.get(from).remove(reqToDelete);
        saveChanges();
    }

    @Override
    public void changeRequestStatus(String from, String to, FriendRequestStatus status) {
        FriendRequest req = getFriendRequest(from, to);
        req.setStatus(status);
        req.setEditTimeStamp(new Date().getTime());
        saveChanges();
    }

    @Override
    public List<FriendRequest> getRequestBySender(String sender) {
        try {
            return requests.get(sender).stream().toList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<FriendRequest> getRequestByRecipient(String recipient) {

        List<FriendRequest> recipientList = new ArrayList<>();

        for (FriendRequest req : getAllRequests()) {
            if (req.getTo().equals(recipient)) {
                recipientList.add(req);
            }
        }
        return recipientList;
    }

    @Override
    public void saveChanges() {
        JsonDatabase.save(new File(FilePathUtil.FRIEND_REQUEST_DATA_FILEPATH), this.requests);
    }

    @Override
    public void load() {
        File f = new File(FilePathUtil.FRIEND_REQUEST_DATA_FILEPATH);

        if (!f.exists()){
            try {
                f.createNewFile();
                this.requests = new HashMap<>();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            Type requestsTypeToken = new TypeToken<Map<String, Set<FriendRequest>>>() {}.getType();

            this.requests = new Gson().fromJson(br, requestsTypeToken);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.requests = new HashMap<>();
        }
    }

    private boolean friendRequestExists(String from, String to) {
        if (requests.containsKey(from)) {
            for (FriendRequest req : requests.get(from)) {
                if (req.getTo().equals(to)) {
                    return true;
                }
            }
        }
        return false;
    }

    public FriendRequest getFriendRequest(String from, String to) {
        try{
            for(FriendRequest req : requests.get(from)) {
                if(req.getTo().equals(to)) {
                    return req;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
