package main;

import controllers.AuthController;
import controllers.SearchController;
import dao.JSONUserDAO;
import dao.UserDAO;
import services.UserService;

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

        AuthController authController = new AuthController(userService);
        post("/login/", authController.login);
        post("/register/", authController.register);

        SearchController searchController = new SearchController(userService);
        get("/user-search/", searchController.userSearch);


    }

}
