package controllers;

import com.google.gson.Gson;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

public class UserController {

    private static UserService userService;

    public UserController(UserService uS) {
        userService = uS;
    }

    public static Route sendFriendRequest = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String sender = request.params("sender");
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            userService.sendFriendRequest(loggedInUser, sender);
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route acceptFriendRequest = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String sender = request.params("sender");
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            userService.acceptFriendRequest(loggedInUser, sender);
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route declineFriendRequest = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String sender = request.params("sender");
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            userService.declineFriendRequest(loggedInUser, sender);
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

}
