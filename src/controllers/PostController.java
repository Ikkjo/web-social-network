package controllers;

import beans.models.Comment;
import beans.models.Post;
import com.google.gson.Gson;
import dto.CommentDTO;
import services.PostService;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

import java.util.*;

public class PostController {

    public static PostService postService;
    public static UserService userService;

    public PostController(PostService pS, UserService uS) {
        postService = pS;
        userService = uS;
    }

    public static Route addPost = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String username = AuthUtils.getUsernameFromToken(request);
            Post newPost =  new Gson().fromJson(request.body(), Post.class);
            newPost.setUsername(username);
            newPost.setUser(userService.getUser(username));
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
            String postId = request.params("postId");
            postService.deletePost(UUID.fromString(postId));
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
            addUserToPost(post);
            addCommentsToPost(post);
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
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            List<Post> userPosts =  postService.getPostsByUser(loggedInUser);

            for(Post p : userPosts) {
                addUserToPost(p);
                addCommentsToPost(p);
            }

            response.status(200);
            return userPosts;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getUserPhotos = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            List<Post> userPhotos =  postService.getPhotosByUser(loggedInUser);

            for(Post p : userPhotos) {
                addUserToPost(p);
                addCommentsToPost(p);
            }

            response.status(200);
            return userPhotos;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getAllPostsByUser = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String user = request.params("user");
            List<Post> userPosts =  postService.getPostsByUser(user);
            response.status(200);
            return userPosts;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route getAllPhotosByUser = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String user = request.params("user");
            List<Post> userPosts =  postService.getPhotosByUser(user);
            response.status(200);
            return userPosts;
        } catch (Exception e) {
            response.status(401);
            return response;
        }
    };

    public static Route addComment = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            CommentDTO newComment = new Gson().fromJson(request.body(), CommentDTO.class);
            if(newComment.getUsername().equals(loggedInUser)){
                Comment comment = new Comment(newComment);
                comment.setUser(userService.getUser(loggedInUser));
                postService.addComment(comment);
                response.status(200);
                return newComment;
            } else {
                response.status(401);
                return response;
            }
        } catch (Exception e) {
            response.status(501);
            return response;
        }
    };

    public static Route deleteComment = (Request request, Response response) -> {
        response.type("application/json");
        try {
            String loggedInUser = AuthUtils.getUsernameFromToken(request);
            UUID commentId = UUID.fromString(request.params("commentId"));
            Comment c = postService.getComment(commentId);

            if(c.getUsername().equals(loggedInUser)) {
                if(postService.deleteComment(commentId)){
                    response.status(200);
                } else {
                    response.status(401);
                }
            } else {
                response.status(401);
            }
            return response;
        } catch (Exception e) {
            response.status(501);
            return response;
        }
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
