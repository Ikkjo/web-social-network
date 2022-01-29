package beans.models;

import java.time.LocalDateTime;

public class Comment {
	
	private User user;
	private LocalDateTime timeStamp;
	private LocalDateTime editTimeStamp;
	
	public Comment() {
		super();
	}

	public Comment(User user, LocalDateTime timeStamp, LocalDateTime editTimeStamp) {
		super();
		this.user = user;
		this.timeStamp = timeStamp;
		this.editTimeStamp = editTimeStamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public LocalDateTime getEditTimeStamp() {
		return editTimeStamp;
	}

	public void setEditTimeStamp(LocalDateTime editTimeStamp) {
		this.editTimeStamp = editTimeStamp;
	}
		
}
