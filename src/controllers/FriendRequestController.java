package controllers;

import beans.models.Post;
import com.google.gson.Gson;
import services.FriendRequestService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

public class FriendRequestController {

    private static FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService fRS) {
        friendRequestService = fRS;
    }

    public static Route getFriendRequests = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            return new Gson().toJson(friendRequestService.getFriendRequests(loggedInUser));
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getSentFriendRequests = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            return new Gson().toJson(friendRequestService.getSentFriendRequests(loggedInUser));
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };
}
