package controllers;

import beans.models.Post;
import beans.models.User;
import com.google.gson.Gson;
import services.PostService;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostController {

    public static PostService postService;

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
}
