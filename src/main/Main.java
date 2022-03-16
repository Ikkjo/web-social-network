package main;

import controllers.AuthController;
import dao.JSONUserDAO;
import services.UserService;

import java.io.File;
import java.io.IOException;

import static spark.Spark.*;

public class Main {


    public static void main(String[] args) throws IOException {
        port(8080);
        staticFiles.externalLocation(new File("./static").getCanonicalPath());
        AuthController authController = new AuthController(new UserService(new JSONUserDAO()));
        post("/login/", authController.login);
        post("/register/", authController.register);
    }

}
