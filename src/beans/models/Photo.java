package beans.models;

import java.util.*;

public class Photo {

	private UUID id;
	private String user;
	private String photo;
	private String description;
	private List<Comment> comments;



	public Photo() {
		this.comments = new ArrayList<>();
	}

	public Photo(String photo, String description) {
		this.photo = photo;
		this.description = description;
	}

	public Photo(UUID id, String photo, String description) {
		this.id = id;
		this.photo = photo;
		this.description = description;
	}

	public Photo(String user, String photo, String description) {
		this.user = user;
		this.photo = photo;
		this.description = description;
	}

	public Photo(String user, String photo, String description, List<Comment> comments) {
		this.user = user;
		this.photo = photo;
		this.description = description;
		this.comments = comments;
	}

	public Photo(UUID id, String user, String photo, String description, List<Comment> comments) {
		this.id = id;
		this.user = user;
		this.photo = photo;
		this.description = description;
		this.comments = comments;
	}

	public Photo(String photo, String description, List<Comment> comments) {
		this.photo = photo;
		this.description = description;
		this.comments = comments;
	}

	public Photo(UUID id, String photo, String description, List<Comment> comments) {
		this.id = id;
		this.photo = photo;
		this.description = description;
		this.comments = comments;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUser() {
		return user;
	}
	
}
