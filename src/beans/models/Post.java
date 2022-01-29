package beans.models;

import java.util.List;

public class Post {
	
	private String picture;
	private String text;
	private List<Comment> comments;
	
	public Post() {
	
	}

	public Post(String picture, String text, List<Comment> comments) {
		
		this.picture = picture;
		this.text = text;
		this.comments = comments;
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
	
	

}
