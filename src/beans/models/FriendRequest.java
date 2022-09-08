package beans.models;


public class FriendRequest {
	
	private String from;
	private String to;
	private FriendRequestStatus status;
	private Long creationTimeStamp;
	private Long editTimeStamp;
	private transient User sender;
	private transient User receiver;
	
	public FriendRequest() {
		super();
	}

	public FriendRequest(String from, String to, Long creationTimeStamp) {
		this.from = from;
		this.to = to;
		this.creationTimeStamp = creationTimeStamp;
		this.status = FriendRequestStatus.CREATED;
	}

	public FriendRequest(String from, String to, FriendRequestStatus status, Long timeStamp) {
		super();
		this.from = from;
		this.to = to;
		this.status = status;
		this.creationTimeStamp = timeStamp;
	}

	public FriendRequest(String from, String to, FriendRequestStatus status, Long creationTimeStamp, Long editTimeStamp) {
		this.from = from;
		this.to = to;
		this.status = status;
		this.creationTimeStamp = creationTimeStamp;
		this.editTimeStamp = editTimeStamp;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public FriendRequestStatus getStatus() {
		return status;
	}
	public void setStatus(FriendRequestStatus status) {
		this.status = status;
	}

	public Long getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(Long creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

	public Long getEditTimeStamp() {
		return editTimeStamp;
	}

	public void setEditTimeStamp(Long editTimeStamp) {
		this.editTimeStamp = editTimeStamp;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
}
