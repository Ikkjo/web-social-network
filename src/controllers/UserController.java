package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

public class UserController {

    private static UserService userService;

    public static Route sendFriendRequest = (Request request, Response response) -> {
        response.type("application/json");
        String sender = request.params("sender");
        String receiver = request.params("receiver");
        userService.addFriendRequest(sender, receiver);
        return receiver;
    };

}
