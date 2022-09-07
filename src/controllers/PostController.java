package controllers;

import beans.models.Post;
import com.google.gson.Gson;
import services.PostService;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

public class PostController {

    public static PostService postService;
    public static UserService userService;

    public PostController(PostService pS) {
        postService = pS;
    }

    public static Route addPost = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Post newPost =  new Gson().fromJson(request.body(), Post.class);
            postService.addPost(newPost);
            return new Gson().toJson(newPost);
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route deletePost = (Request request, Response response) -> {
        response.type("application/json");
        try {
            Post post =  new Gson().fromJson(request.body(), Post.class);
            postService.deletePost(post.getId());
            response.status(200);
            return response;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getPost = (Request request, Response response) -> {
        response.type("application/json");
        try {

            Post post =  postService.getPostById(UUID.fromString(request.params("postId")));
            response.status(200);
            return post;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getUserPosts = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String username = request.params("username");
            List<Post> userPosts =  postService.getPostsByUser(username);
            response.status(200);
            return userPosts;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };
}
