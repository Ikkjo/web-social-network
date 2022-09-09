package dao;

import beans.models.FriendRequest;
import beans.models.FriendRequestStatus;
import beans.models.Post;
import org.eclipse.jetty.http.MetaData;

import java.util.List;
import java.util.UUID;

public interface FriendRequestDAO {
    List<FriendRequest> getAllRequests();
    void addRequest(FriendRequest request);
    void deleteRequest(String from, String to);
    void changeRequestStatus(String from, String to, FriendRequestStatus status);
    List<FriendRequest> getRequestBySender(String sender);
    List<FriendRequest> getRequestByRecipient(String recipient);
    void saveChanges();
    void load();
}
