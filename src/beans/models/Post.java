package beans.models;

import java.util.*;

public class Post {

	private UUID id;
	private String username;
	private User user;
	private String photo;
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

	public Post(UUID id, String username, String photo, String text, List<Comment> comments, Long timestamp,
				Boolean deleted, PostType type) {
		this.id = id;
		this.username = username;
		this.photo = photo;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = deleted;
		this.type = type;
	}

	public Post(UUID id, String username, User user, String photo, String text, List<Comment> comments,
				Long timestamp, Boolean deleted, PostType type) {
		this.id = id;
		this.username = username;
		this.user = user;
		this.photo = photo;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = deleted;
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getUsername() {
		return username;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setType(PostType type) {
		this.type = type;
	}

	public void addComment(Comment c) {this.comments.add(c);}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
