package beans.models;

import java.util.List;

public class Photo {
	
	private String photo;
	private String description;
	private List<Comment> comments;
	
	public Photo() {
		
	}

	public Photo(String photo, String description, List<Comment> comments) {
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

	
}
