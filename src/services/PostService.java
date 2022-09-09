package services;

import beans.models.Comment;
import beans.models.Post;
import dao.CommentDAO;
import dao.PostDAO;
import dao.UserDAO;

import java.util.*;

public class PostService {

    private final PostDAO postDAO;
    private final UserDAO userDAO;
    private final CommentDAO commentDAO;

    public PostService(PostDAO postDAO, UserDAO userDAO, CommentDAO commentDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
        this.commentDAO = commentDAO;
    }

    public List<Post> getAllPosts(){
        return this.postDAO.getPosts();
    }

    private List<Post> sortByDateDesc(List<Post> posts) {
        List<Post> sorted = new ArrayList<>();

        return sorted;
    }

    public Post getPostById (UUID id) {
        if (postExists(id)) {
            return this.postDAO.getPostById(id);
        }
        return null;
    }

    public void addPost(Post p){
        Post newPost = new Post();

        newPost.setUser(p.getUser());
        newPost.setType(p.getType());
        newPost.setText(p.getText());
        newPost.setPicture(p.getPicture());

        this.postDAO.addPost(newPost);
    }

    public Comment getComment(UUID id){
        if(commentDAO.commentExists(id)){
            return commentDAO.getComment(id);
        }
        return null;
    };

    public boolean doesCommentExist(UUID id){
        return commentDAO.commentExists(id);
    }

    public boolean doesPostHaveComments(UUID id) {
        return commentDAO.doesPostHaveComments(id);
    }

    public boolean doesPostExist(UUID id) {
        return postDAO.doesPostExist(id);
    }

    public void deletePost(UUID id){
        if(postDAO.doesPostExist(id)){
            Post p = getPostById(id);
            List<Comment> comments = p.getComments();
            this.postDAO.deletePost(p);
        }
    }

    public List<Post> getPostsByUser(String username) {
        return postDAO.getPostsByUserUsername(username);
    }

    public boolean postExists(UUID id) {
        try {
            Post p = this.postDAO.getPostById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean addComment(Comment c) {
        try {
            postDAO.addCommentToPost(c.getPostId(), c);
            commentDAO.addComment(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteComment(UUID comment){
        try {
            commentDAO.deleteComment(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Comment> getPostComments(UUID postId){
        return commentDAO.getPostComments(postId);
    }

    public List<Comment> getCommentsByUser(String username) {
        return commentDAO.getCommentsByUser(username);
    }

}
