package controllers;

import beans.models.Comment;
import beans.models.Post;
import com.google.gson.Gson;
import services.PostService;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

import java.util.*;

public class MainFeedController {

    private static PostService postService;
    private static UserService userService;

    public MainFeedController(PostService pS, UserService uS) {
        postService = pS;
        userService = uS;
    }

    public static Route getMainFeedPosts = (Request request, Response response) -> {
        response.type("application/json");
        List<Post> allPosts = postService.getAllPosts();
        String loggedInUser = AuthUtils.getUsernameFromToken(request);

        if(loggedInUser == null) {
            allPosts = allPosts.subList(0, 5);
        }

        for (Post p : allPosts) {
            p.setUser(userService.getUser(p.getUsername()));
            p.setComments(postService.getPostComments(p.getId()));
            for(Comment c : p.getComments()){
                c.setUser(userService.getUser(c.getUsername()));
            }
        }
        return new Gson().toJson(allPosts);
    };

}
