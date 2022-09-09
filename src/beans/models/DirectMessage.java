package beans.models;


import java.util.UUID;

public class DirectMessage {
	private UUID id;
	private String sender;
	private String recipient;
	private String messageContent;
	private Long timeStamp;

	private transient User senderUser;
	private transient User recipientUser;
	public DirectMessage() {
		super();
	}

	public DirectMessage(UUID id, String sender, String recipient, String messageContent, Long timeStamp) {
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.messageContent = messageContent;
		this.timeStamp = timeStamp;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public User getSenderUser() {
		return senderUser;
	}

	public void setSenderUser(User senderUser) {
		this.senderUser = senderUser;
	}

	public User getRecipientUser() {
		return recipientUser;
	}

	public void setRecipientUser(User recipientUser) {
		this.recipientUser = recipientUser;
	}
}
