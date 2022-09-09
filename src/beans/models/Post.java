package beans.models;

import java.util.*;

public class Post {

	private UUID id;
	private String user;
	private String picture;
	private String text;
	private List<Comment> comments;
	private Long timestamp;
	private Boolean deleted;
	private PostType type;



	public Post() {
		this.id = UUID.randomUUID();
		this.comments = new ArrayList<>();
		this.deleted = false;
		this.type = PostType.TEXT;
		this.timestamp = new Date().getTime();
	}

	public Post(UUID id, String user, String picture, String text, List<Comment> comments, Long timestamp,
				Boolean deleted, PostType type) {
		this.id = id;
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = deleted;
		this.type = type;
	}
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public UUID getId() {
		return id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public PostType getType() {
		return type;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setType(PostType type) {
		this.type = type;
	}

	public void addComment(Comment c) {this.comments.add(c);}
}
