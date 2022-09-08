package beans.models;

import java.util.UUID;

public class Comment {

	private UUID id;
	private UUID postId;
	private String user;
	private String text;
	private Long timeStamp;
	private Long editTimeStamp;
	private Boolean deleted;



	public Comment() {
	}

	public Comment(UUID id, UUID postId, String user, String text, Long timeStamp, Long editTimeStamp, Boolean deleted) {
		this.id = id;
		this.postId = postId;
		this.user = user;
		this.text = text;
		this.timeStamp = timeStamp;
		this.editTimeStamp = editTimeStamp;
		this.deleted = deleted;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getPostId() {
		return postId;
	}

	public void setPostId(UUID postId) {
		this.postId = postId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getEditTimeStamp() {
		return editTimeStamp;
	}

	public void setEditTimeStamp(Long editTimeStamp) {
		this.editTimeStamp = editTimeStamp;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
