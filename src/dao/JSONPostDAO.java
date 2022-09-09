package dao;

import beans.models.Comment;
import beans.models.Post;
import beans.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import utils.FilePathUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JSONPostDAO implements PostDAO {

    private Map<UUID, Post> posts;

    public JSONPostDAO() {
        load();
    }

    @Override
    public List<Post> getPosts() {
        return this.posts.values().stream().toList();
    }

    @Override
    public void addPost(Post post) {
        this.posts.put(post.getId(), post);
        saveChanges();
    }

    @Override
    public void deletePost(Post post) {
        this.posts.get(post.getId()).setDeleted(true);
        saveChanges();
    }

    @Override
    public void deletePost(UUID id) {
        this.posts.get(id).setDeleted(true);
        saveChanges();
    }

    @Override
    public Post getPostById(UUID id) {
        return posts.get(id);
    }

    @Override
    public List<Post> getPostsByUserUsername(String username) {
        List<Post> query = new ArrayList<>();

        if (!posts.isEmpty()){
                query = posts.values()
                    .stream().filter(x -> username.equals(x.getUsername()))
                    .toList();
        }

        return query;
    }

    @Override
    public List<Post> getPostsByDateRange(Long to, Long from) {
        List<Post> query = new ArrayList<>();

        if (!posts.isEmpty()){
            query = posts.values()
                    .stream().filter(x -> (x.getTimestamp() >= to && x.getTimestamp()<= from))
                    .toList();
        }

        return query;
    }

    @Override
    public List<Post> getPostsByDateRangeAndUserUsername(Long to, Long from, String username) {
        List<Post> query = new ArrayList<>();

        if (!posts.isEmpty()){
            query = posts.values()
                    .stream().filter(x -> (x.getTimestamp() >= to && x.getTimestamp()<= from
                            && username.equals(x.getUsername())))
                    .toList();
        }

        return query;
    }

    @Override
    public boolean addCommentToPost(UUID id, Comment c) {
        if(doesPostExist(id)){
            Post p = posts.get(id);
            if (p.getComments() != null){
                p.addComment(c);
            } else {
                p.setComments(new ArrayList<>());
                p.addComment(c);
            }
            saveChanges();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCommentFromPost(UUID post, Comment c) {

        if(doesPostExist(post)){
            Post p = posts.get(post);
            if(p.getComments() != null && !p.getComments().isEmpty() && p.getComments().contains(c)) {
                p.getComments().remove(c);
                saveChanges();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doesPostExist(UUID id) {
        return this.posts.containsKey(id);
    }

    @Override
    public void saveChanges() {
        JsonDatabase.save(new File(FilePathUtil.POST_DATA_FILEPATH), this.posts);
    }

    @Override
    public void load() {
        File f = new File(FilePathUtil.POST_DATA_FILEPATH);

        if (!f.exists()){
            try {
                f.createNewFile();
                this.posts = new HashMap<>();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            Type postsTypeToken = new TypeToken<HashMap<UUID, Post>>() {}.getType();

            this.posts = new Gson().fromJson(br, postsTypeToken);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.posts = new HashMap<>();
        }
    }

    @Override
    public void setPostUser(UUID postId, User u) {
        posts.get(postId).setUser(u);
        saveChanges();
    }
}
