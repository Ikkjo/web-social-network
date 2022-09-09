package main;

import controllers.*;
import dao.JSONFriendRequestDAO;
import dao.JSONPostDAO;
import dao.JSONUserDAO;
import services.FriendRequestService;
import services.PostService;
import services.UserService;
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

        UserService userService = new UserService(userDAO, friendRequestDAO);
        PostService postService = new PostService(postDAO, userDAO);
        FriendRequestService friendRequestService = new FriendRequestService(friendRequestDAO);

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

        MainFeedController mainFeedController = new MainFeedController(postService);
        get("/post/main-feed/", MainFeedController.getMainFeedPosts);

        PostController postController = new PostController(postService);
        post("/post/add/", PostController.addPost);
        delete("/post/delete/", PostController.deletePost);
        get("/post/:postId/", PostController.getPost);
        get("/my-posts/", PostController.getUserPosts);

        FriendRequestController friendRequestController = new FriendRequestController(friendRequestService);
        get("/friend-requests/", FriendRequestController.getFriendRequests);
        get("/sent-friend-requests/", FriendRequestController.getSentFriendRequests);

        UserController userController = new UserController(userService);
        post("/add-friend/", UserController.sendFriendRequest);
        put("/accept-request/:sender/", UserController.acceptFriendRequest);
        delete("/decline-request/:sender/", UserController.declineFriendRequest);
        // todo komentari, chat
        // proveri sve sto si do sad odradio
        // povezi sa frontom (napravi api pozive)
    }

}
