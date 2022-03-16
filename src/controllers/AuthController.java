package controllers;

import beans.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.post;

public class AuthController {

    private static UserService userService;

    public AuthController(final UserService userService) {
        this.userService = userService;
    }

    public static Route login = (Request request, Response response) -> {
        response.type("application/json");
        User user = new Gson().fromJson(request.body(), User.class);
        if(userService.isValidUser(user)) {
            user = userService.getUser(user.getUsername());
            // create login token
            return new Gson().toJson(user);
        }
        response.status(401);
        return response;
    };

    public static Route register = (Request request, Response response) -> {
        response.type("application/json");
        User user = new Gson().fromJson(request.body(), User.class);
        if (userService.isValidUsername(user.getUsername()) && userService.isValidEmail(user.getEmail())) {
            userService.addUser(user);
            return new Gson().toJson(user);
        }
        response.status(401);
        return response;
    };

    public static void run(final UserService userService) {

        post("/login/", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            if(userService.isValidUser(user)) {
                user = userService.getUser(user.getUsername());
                // create login token
                return new Gson().toJson(user);
            }
            response.status(401);
            return response;
        });

        post("/register/", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            if (userService.isValidUsername(user.getUsername()) && userService.isValidEmail(user.getEmail())) {
                userService.addUser(user);
                return new Gson().toJson(user);
            }
            response.status(401);
            return response;
        });

    }

}