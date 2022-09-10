package controllers;

import beans.models.Comment;
import beans.models.Post;
import com.google.gson.Gson;
import services.PostService;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

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
        for (Post p : allPosts) {
            addUserToPost(p);
            addCommentsToPost(p);
        }
        return new Gson().toJson(postService.getAllPosts());
    };

    private static void addUserToPost(Post p){
        p.setUser(userService.getUser(p.getUsername()));
    }

    private static void addCommentsToPost(Post p) {
        p.setComments(postService.getPostComments(p.getId()));
        addUserToPostComments(p);
    }

    private static void addUserToPostComments(Post p) {
        for(Comment c : p.getComments()){
            c.setUser(userService.getUser(c.getUsername()));
        }
    }

}
