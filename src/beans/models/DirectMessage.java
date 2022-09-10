package beans.models;


import dto.MessageDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class DirectMessage {
	private UUID id;
	private String from;
	private String to;
	private String message;
	private Long timeStamp;
	public DirectMessage() {
		super();
	}

	public DirectMessage(UUID id, String from, String to, String message, Long timeStamp) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public DirectMessage(MessageDTO messageDTO) {
		this.id = UUID.randomUUID();
		this.from = messageDTO.getFrom();
		this.to = messageDTO.getTo();
		this.message = messageDTO.getMessage();
		this.timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.MIN);
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
