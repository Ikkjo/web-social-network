package main;

import controllers.*;
import dao.*;
import services.*;
import utils.SecurityUtils;

import java.io.File;
import java.io.IOException;

import static spark.Spark.*;

public class Main {


    public static void main(String[] args) throws IOException {
        port(8080);

        JSONUserDAO userDAO = new JSONUserDAO();
        JSONPostDAO postDAO = new JSONPostDAO();
        JSONFriendRequestDAO friendRequestDAO = new JSONFriendRequestDAO();
        JSONCommentDAO commentDAO = new JSONCommentDAO();
        JSONDirectMessageDAO directMessageDAO = new JSONDirectMessageDAO();

        UserService userService = new UserService(userDAO, friendRequestDAO);
        PostService postService = new PostService(postDAO, userDAO, commentDAO);
        FriendRequestService friendRequestService = new FriendRequestService(friendRequestDAO);
        ChatService chatService = new ChatService(directMessageDAO);

        webSocket("/ws", DirectMessageHandler.class);

        staticFiles.externalLocation(new File("./static").getCanonicalPath());

        before(SecurityUtils.addTrailingSlashes);

        AuthController authController = new AuthController(userService);
        post("/login/", AuthController.login);
        post("/register/", AuthController.register);

        SearchController searchController = new SearchController(userService);
        get("/user-search/", SearchController.userSearch);
        get("/are-friends/", SearchController.areFriends);

        ProfilePageController profilePageController = new ProfilePageController(userService);
        get("/user/:username/", ProfilePageController.getUser);

        MainFeedController mainFeedController = new MainFeedController(postService, userService);
        get("/post/main-feed/", MainFeedController.getMainFeedPosts);

        PostController postController = new PostController(postService, userService);
        post("/add-post/", PostController.addPost);
        delete("/remove-post/:postId/", PostController.deletePost);
        get("/post/:postId/", PostController.getPost);
        get("/my-posts/", PostController.getUserPosts);
        get("/my-photos/", PostController.getUserPhotos);
        post("/add-comment/", PostController.addComment);
        delete("/delete-comment/:commentId/", PostController.deleteComment);
        get("/post/user/:user/", PostController.getAllPostsByUser);
        get("/photos/user/:user/", PostController.getAllPhotosByUser);

        FriendRequestController friendRequestController = new FriendRequestController(friendRequestService);
        get("/friend-requests/", FriendRequestController.getFriendRequests);
        get("/sent-friend-requests/", FriendRequestController.getSentFriendRequests);

        UserController userController = new UserController(userService);
        post("/add-friend/", UserController.sendFriendRequest);
        put("/accept-request/:sender/", UserController.acceptFriendRequest);
        delete("/decline-request/:sender/", UserController.declineFriendRequest);
        delete("/remove-friend/:friend/", UserController.removeFriend);
        put("/edit-profile/", UserController.editProfile);
        put("/block-user/:user/", UserController.blockUser);
        put("/unblock-user/:user/", UserController.unblockUser);
        get("/mutual-friends/", UserController.mutualFriends);
        get("/my-friends/", UserController.getFriends);
        get("/are-friends/:user/", UserController.areFriends);
        get("/user/", UserController.getLoggedInUser);

        ChatController chatController = new ChatController(chatService);
        post("/add-message/", ChatController.addMessage);
        get("/get-chats/", ChatController.getChats);
        get("/get-messages/", ChatController.getMessages);
        // proveri sve sto si do sad odradio
        // povezi sa frontom (napravi api pozive)
    }

}
