package beans.models;

import java.time.LocalDateTime;

public class FriendRequest {
	
	private User from;
	private User to;
	private FriendRequestStatus status;
	private LocalDateTime timeStamp;
	
	public FriendRequest() {
		super();
	}

	public FriendRequest(User from, User to, FriendRequestStatus status, LocalDateTime timeStamp) {
		super();
		this.from = from;
		this.to = to;
		this.status = status;
		this.timeStamp = timeStamp;
	}
	
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public FriendRequestStatus getStatus() {
		return status;
	}
	public void setStatus(FriendRequestStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
