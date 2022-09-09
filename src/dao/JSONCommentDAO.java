package dao;

import beans.models.Comment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import utils.FilePathUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JSONCommentDAO implements CommentDAO{

    // Key: postId ; Value: Set of comments
    private HashMap<UUID, List<Comment>> comments;

    public JSONCommentDAO(){
        load();
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> all = new ArrayList<>();

        for (List<Comment> commentSet : comments.values()){
            all.addAll(commentSet);
        }

        return all;
    }

    @Override
    public List<Comment> getCommentsByUser(String username) {
        List<Comment> userComments = new ArrayList<>();
        for (Comment c: getComments()) {
            if(c.getUser().equals(username)){
                userComments.add(c);
            }
        }
        return userComments;
    }

    @Override
    public List<Comment> getPostComments(UUID postId) {
        if(doesPostHaveComments(postId)){
            return this.comments.get(postId);
        }
        return new ArrayList<>();
    }

    @Override
    public Comment getComment(UUID commentId) {
        for (Comment c : getComments()) {
            if (c.getId().equals(commentId)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void addComment(Comment c) {
        if(!commentExists(c.getId())){
            if(doesPostHaveComments(c.getPostId())){
                this.comments.get(c.getPostId()).add(c);
            } else {
                List<Comment> newPostCommentList = new ArrayList<>();
                newPostCommentList.add(c);
                this.comments.put(c.getPostId(), newPostCommentList);
            }
            saveChanges();
        }
    }

    @Override
    public void deleteComment(UUID comment) {
        UUID postId = UUID.randomUUID();
        Comment comm = new Comment();
        for (Comment c : getComments()){
            if(c.getId().equals(comment)){
                comm = c;
                postId = c.getPostId();
                break;
            }
        }
        this.comments.get(postId).remove(comm);
        saveChanges();
    }

    @Override
    public boolean commentExists(UUID comment){
        for (Comment c : getComments()){
            if (c.getId().equals(comment)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean doesPostHaveComments(UUID post) {
        return this.comments.containsKey(post) && !this.comments.get(post).isEmpty();
    }

    @Override
    public void saveChanges() {
        JsonDatabase.save(new File(FilePathUtil.POST_DATA_FILEPATH), this.comments);
    }

    @Override
    public void load() {
        File f = new File(FilePathUtil.COMMENT_DATA_FILEPATH);

        if (!f.exists()){
            try {
                f.createNewFile();
                this.comments = new HashMap<>();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            Type commentsTypeToken = new TypeToken<HashMap<UUID, List<Comment>>>() {}.getType();

            this.comments = new Gson().fromJson(br, commentsTypeToken);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.comments = new HashMap<>();
        }
    }
}
