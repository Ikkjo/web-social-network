package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

public class AuthController {

    private static UserService userService;

    public AuthController(final UserService uS) {
        userService = uS;
    }

    public static Route login = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String username = request.queryParams("username");
            String password = request.queryParams("password");
            response.status(200);
            return userService.logIn(username, password);
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route register = (Request request, Response response) -> {
        response.type("application/json");
        String requestBody = request.body();
        User user = new Gson().fromJson(requestBody, User.class);
        if (userService.isValidUsername(user.getUsername()) && userService.isValidEmail(user.getEmail())) {
            userService.addUser(user);
            return new Gson().toJson(user);
        }
        response.status(401);
        return response;
    };

}