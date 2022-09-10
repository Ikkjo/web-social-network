package dao;

import beans.models.DirectMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import utils.FilePathUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class JSONDirectMessageDAO implements DirectMessageDAO{

    private HashMap<String, List<DirectMessage>> messages;

    public JSONDirectMessageDAO(){
        load();
    }
    @Override
    public void addMessage(DirectMessage m) {
        if (this.messages.containsKey(m.getFrom())) {
            this.messages.get(m.getFrom()).add(m);
        } else {
            this.messages.put(m.getFrom(), new ArrayList<>(Collections.singleton(m)));
        }
        saveChanges();
    }

    @Override
    public List<String> getChats(String user) {
        List<String> chats = new ArrayList<>();

        if (this.messages.containsKey(user)) {
            for (DirectMessage dm : this.messages.get(user)) {
                if (!chats.contains(dm.getTo()))
                    chats.add(dm.getTo());
            }
        }
        return chats;
    }

    @Override
    public List<DirectMessage> getMessages(String sender, String receiver) {
        List<DirectMessage> messages = new ArrayList<>();

        List<DirectMessage> allMessages = new ArrayList<>();

        if (this.messages.containsKey(sender))
            allMessages.addAll(this.messages.get(sender));
        if (this.messages.containsKey(receiver))
            allMessages.addAll(this.messages.get(receiver));

        for(DirectMessage dm : allMessages) {
            if(dm.getTo().equals(sender) || dm.getTo().equals(receiver)){
                messages.add(dm);
            }
        }

        return messages;
    }

    @Override
    public void saveChanges() {
        JsonDatabase.save(new File(FilePathUtil.DIRECT_MESSAGE_DATA_FILEPATH), this.messages);
    }

    @Override
    public void load() {
        File f = new File(FilePathUtil.DIRECT_MESSAGE_DATA_FILEPATH);

        if (!f.exists()){
            try {
                f.createNewFile();
                this.messages = new HashMap<>();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            Type messagesTypeToken = new TypeToken<HashMap<String, List<DirectMessage>>>() {}.getType();

            this.messages = new Gson().fromJson(br, messagesTypeToken);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.messages = new HashMap<>();
        }

    }
}
