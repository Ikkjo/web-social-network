package data;

import beans.models.User;
import dao.*;
import services.*;

public class TestData {
    private static final JSONUserDAO userDAO = new JSONUserDAO();
    private static final JSONPostDAO postDAO = new JSONPostDAO();
    private static final JSONFriendRequestDAO friendRequestDAO = new JSONFriendRequestDAO();
    private static final JSONCommentDAO commentDAO = new JSONCommentDAO();
    private static final JSONDirectMessageDAO directMessageDAO = new JSONDirectMessageDAO();

    private static final UserService userService = new UserService(userDAO, friendRequestDAO);
    private static final PostService postService = new PostService(postDAO, userDAO, commentDAO);
    private static final FriendRequestService friendRequestService = new FriendRequestService(friendRequestDAO);
    private static final ChatService chatService = new ChatService(directMessageDAO);

    public static void main() {
        User u1 = new User();


    }

}
