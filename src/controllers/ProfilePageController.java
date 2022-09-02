package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProfilePageController {

    private static UserService userService;

    public ProfilePageController(final UserService uS) {
        userService = uS;
    }

    public static Route getUser = (Request request, Response response) -> {
        response.type("application/json");
        User user = userService.getUser(request.params("username"));
        return new Gson().toJson(user);
    };



}
