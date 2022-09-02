package main;

import controllers.AuthController;
import controllers.ProfilePageController;
import controllers.SearchController;
import dao.JSONUserDAO;
import services.UserService;
import utils.SecurityUtils;

import java.io.File;
import java.io.IOException;

import static spark.Spark.*;

public class Main {


    public static void main(String[] args) throws IOException {
        port(8080);
        JSONUserDAO userDAO = new JSONUserDAO();
        userDAO.generateTestData();
        UserService userService = new UserService(userDAO);

        staticFiles.externalLocation(new File("./static").getCanonicalPath());

        before(SecurityUtils.addTrailingSlashes);

        AuthController authController = new AuthController(userService);
        post("/login/", AuthController.login);
        post("/register/", AuthController.register);

        SearchController searchController = new SearchController(userService);
        get("/user-search/", SearchController.userSearch);
        get("/are-friends", SearchController.areFriends);

        ProfilePageController profilePageController = new ProfilePageController(userService);
        get("/user/:username", ProfilePageController.getUser);


    }

}
