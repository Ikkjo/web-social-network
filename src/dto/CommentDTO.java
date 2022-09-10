package dto;

import beans.models.User;

import java.util.UUID;

public class CommentDTO {
    private UUID postId;
    private String username;
    private String text;

    public CommentDTO() {
    }

    public CommentDTO(UUID postId, String username, String text) {
        this.postId = postId;
        this.username = username;
        this.text = text;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
