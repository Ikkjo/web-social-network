package dao;

import beans.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostDAO {

    List<Post> getPosts();
    void addPost(Post post);
    void deletePost(Post post);
    void deletePost(UUID id);
    Post getPostById(UUID id);
    List<Post> getPostsByUserUsername(String username);
    List<Post> getPostsByDateRange(Long to, Long from);
    List<Post> getPostsByDateRangeAndUserUsername(Long to, Long from, String username);
    void saveChanges();
    void load();
}