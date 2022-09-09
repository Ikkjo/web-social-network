package dao;

import beans.models.Comment;

import java.util.*;

public interface CommentDAO {

    List<Comment> getComments();

    List<Comment> getCommentsByUser(String username);

    List<Comment> getPostComments(UUID postId);

    Comment getComment(UUID commentId);

    void addComment(Comment c);

    void deleteComment(UUID comment);

    void load();

    void saveChanges();

}
