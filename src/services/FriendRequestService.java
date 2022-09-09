package services;

import beans.models.FriendRequest;
import dao.FriendRequestDAO;

import java.util.List;

public class FriendRequestService {

    private final FriendRequestDAO friendRequestDAO;

    public FriendRequestService(FriendRequestDAO friendRequestDAO) {
        this.friendRequestDAO = friendRequestDAO;
    }

    public List<FriendRequest> getSentFriendRequests(String user){
        return friendRequestDAO.getRequestBySender(user);
    }

    public List<FriendRequest> getFriendRequests(String user) {
        return friendRequestDAO.getRequestByRecipient(user);
    }
}
