package controllers;

import beans.models.Post;
import beans.models.User;
import beans.models.UserRole;
import com.google.gson.Gson;
import dto.EditProfileDTO;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

import java.util.Objects;

public class UserController {

    private static UserService userService;

    public UserController(UserService uS) {
        userService = uS;
    }

    public static Route sendFriendRequest = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String sender = new Gson().fromJson(request.body(), String.class);
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

    public static Route removeFriend = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String friend = request.params("friend");
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            userService.removeFriend(loggedInUser, friend);
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route editProfile = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            EditProfileDTO newUserDetails = new Gson().fromJson(request.body(), EditProfileDTO.class);
            User user = userService.getUser(loggedInUser);
            if(newUserDetails.getUsername().equals(user.getUsername())) {
                if (!newUserDetails.getPassword().isEmpty()) {
                    if (newUserDetails.getPassword().equals(user.getPassword())) {
                        userService.editProfile(newUserDetails);
                        response.status(200);
                    }
                    else {
                        response.status(400);
                        return response;
                    }
                }
                userService.editProfile(newUserDetails);
                response.status(200);
            } else {
                response.status(401);
            }
            return response;
        } catch (Exception e) {
            response.status(501);
            return response;
        }
    };

    public static Route blockUser = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            String userToBlock = request.params("user");
            User user = userService.getUser(loggedInUser);
            if(user.getRole().equals(UserRole.ADMIN)){
                userService.blockUser(userToBlock);
                response.status(200);
            } else {
                response.status(403);
            }
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route unblockUser = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            String userToBlock = request.params("user");
            User user = userService.getUser(loggedInUser);
            if(user.getRole().equals(UserRole.ADMIN)){
                userService.unblockUser(userToBlock);
                response.status(200);
            } else {
                response.status(403);
            }
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route mutualFriends = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String user1 = request.queryParams("user1");
            String user2 = request.queryParams("user2");
            return new Gson().toJson(userService.getMutualFriends(user1, user2));
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getFriends = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            return new Gson().toJson(userService.getFriends(loggedInUser));
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route areFriends = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String user = request.params("user");
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            userService.areFriends(loggedInUser, user);
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getLoggedInUser = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            response.status(200);
            return new Gson().toJson(userService.getUser(loggedInUser));
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };


}
