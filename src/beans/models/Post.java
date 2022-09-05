package beans.models;

import java.util.*;

public class Post {

	UUID id;
	String user;



	private String picture;
	private String text;
	private List<Comment> comments;
	private Long timestamp;
	private Boolean deleted;
	
	public Post() {
		this.comments = new ArrayList<>();
		this.deleted = false;
	}

	public Post(UUID id, String user, String picture, String text, List<Comment> comments, Long timestamp) {
		this.id = id;
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = false;
	}

	public Post(String user, String picture, String text, List<Comment> comments, Long timestamp) {
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = false;
	}

	public Post(String picture, String text) {
		this.picture = picture;
		this.text = text;
		this.deleted = false;
	}

	public Post(UUID id, String picture, String text) {
		this.id = id;
		this.picture = picture;
		this.text = text;
	}

	public Post(UUID id, String user, String picture, String text, List<Comment> comments) {
		this.id = id;
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.deleted = false;
	}

	public Post(String user, String picture, String text) {
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.deleted = false;
	}

	public Post(String user, String picture, String text, List<Comment> comments) {
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.deleted = false;
	}

	public Post(String picture, String text, List<Comment> comments) {
		
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.deleted = false;
	}

	public Post(UUID id, String picture, String text, List<Comment> comments) {
		this.id = id;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.deleted = false;
	}

	public Post(UUID id, String user, String picture, String text, List<Comment> comments,
				Long timestamp, Boolean deleted) {
		this.id = id;
		this.user = user;
		this.picture = picture;
		this.text = text;
		this.comments = comments;
		this.timestamp = timestamp;
		this.deleted = deleted;
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
}
