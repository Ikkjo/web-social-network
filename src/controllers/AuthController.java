package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.UserService;

import static spark.Spark.post;

public class AuthController {

    public  AuthController(final UserService userService) {

        post("/login", (request, response) -> {
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

        post("/registration", (request, response) -> {
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