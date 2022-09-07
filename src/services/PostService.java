package services;

import beans.models.Post;
import dao.PostDAO;
import dao.UserDAO;

import java.util.*;

public class PostService {

    private final PostDAO postDAO;
    private final UserDAO userDAO;

    public PostService(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }

    public List<Post> getAllPosts(){
        List<Post> allPosts =  this.postDAO.getPosts();

        if (allPosts == null) {
            return new ArrayList<>();
        }
        // Sort posts by most recent
        allPosts.sort(Comparator.comparing(Post::getTimestamp));
        Collections.reverse(allPosts);

        return allPosts;
    }

    public void addPost(Post p){
        this.postDAO.addPost(p);
    }

    public void deletePost(Post p){
        this.postDAO.deletePost(p);
    }

    public void deletePost(UUID id){
        this.postDAO.deletePost(id);
    }

    public List<Post> getByUser(String username) {
        return postDAO.getPostsByUserUsername(username);
    }



}