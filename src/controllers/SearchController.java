package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class SearchController {

    private static UserService userService;

    public SearchController(final UserService uS) {
        userService = uS;
    }

    public static Route userSearch = (Request request, Response response) -> {
        response.type("application/json");
        List<User> users = userService.userSearch(request.queryMap().toMap());
        return new Gson().toJson(users);
    };

    public static Route areFriends = (Request request, Response response) -> {
        response.type("application/json");
        return new Gson().toJson(userService.areFriends(request.queryMap().toMap()));
    };

}
