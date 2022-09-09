package services;

import beans.models.Comment;
import beans.models.Post;
import beans.models.PostType;
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

        newPost.setUsername(p.getUsername());
        newPost.setType(p.getType());
        newPost.setText(p.getText());
        newPost.setPhoto(p.getPhoto());

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
        List<Post> posts = new ArrayList<>();
        List<Post> all = postDAO.getPostsByUserUsername(username);

        for (Post p: all) {
            if(p.getType().equals(PostType.TEXT)){
                posts.add(p);
            }
        }

        return posts;
    }


    public List<Post> getPhotosByUser(String username) {
        List<Post> photos = new ArrayList<>();
        List<Post> all = postDAO.getPostsByUserUsername(username);

        for (Post p: all) {
            if(p.getType().equals(PostType.PHOTO)){
                photos.add(p);
            }
        }

        return photos;
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
