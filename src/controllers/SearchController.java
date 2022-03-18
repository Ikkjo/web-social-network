package controllers;

import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class SearchController {

    private static UserService userService;

    public SearchController(final UserService userService) {
        this.userService = userService;
    }

    public static Route userSearch = (Request request, Response response) -> {
        response.type("application/json");
        userService.userSearch(request.queryMap().toMap());
        return null;
    };

}
