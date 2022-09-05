package controllers;

import beans.models.User;
import com.google.gson.Gson;
import services.PostService;
import spark.Request;
import spark.Response;
import spark.Route;

public class MainFeedController {

    private static PostService postService;

    public MainFeedController(PostService pS) {
        postService = pS;
    }

    public static Route getMainFeedPosts = (Request request, Response response) -> {
        response.type("application/json");
        return new Gson().toJson(postService.getAllPosts());
    };

}
