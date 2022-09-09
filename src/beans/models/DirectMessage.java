package beans.models;


import java.util.UUID;

public class DirectMessage {
	private UUID id;
	private String from;
	private String to;
	private String messageContent;
	private Long timeStamp;
	public DirectMessage() {
		super();
	}

	public DirectMessage(UUID id, String from, String to, String messageContent, Long timeStamp) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.messageContent = messageContent;
		this.timeStamp = timeStamp;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
}
