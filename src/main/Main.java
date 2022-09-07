package main;

import controllers.*;
import dao.JSONPostDAO;
import dao.JSONUserDAO;
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

        UserService userService = new UserService(userDAO);
        PostService postService = new PostService(postDAO, userDAO);

        staticFiles.externalLocation(new File("./static").getCanonicalPath());

        before(SecurityUtils.addTrailingSlashes);

        AuthController authController = new AuthController(userService);
        post("/login/", AuthController.login);
        post("/register/", AuthController.register);

        SearchController searchController = new SearchController(userService);
        get("/user-search/", SearchController.userSearch);
        get("/are-friends", SearchController.areFriends);

        ProfilePageController profilePageController = new ProfilePageController(userService);
        get("/user/:username/", ProfilePageController.getUser);

        MainFeedController mainFeedController = new MainFeedController(postService);
        get("/post/main-feed/", MainFeedController.getMainFeedPosts);

        PostController postController = new PostController(postService);
        post("/post/add/", PostController.addPost);
        delete("/post/delete/", PostController.deletePost);
        get("/post/:postId/", PostController.getPost);
        get("/post/user/:username/", PostController.getUserPosts); // TODO: Add different requests for post and photo

    }

}
