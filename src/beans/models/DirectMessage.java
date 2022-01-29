package beans.models;

import java.time.LocalDateTime;

public class DirectMessage {
	
	private User sender;
	private User recipient;
	private String messageContent;
	private LocalDateTime timeStamp;
		
	public DirectMessage() {
		super();
	}

	public DirectMessage(User sender, User recipient, String messageContent, LocalDateTime timeStamp) {
		this.sender = sender;
		this.recipient = recipient;
		this.messageContent = messageContent;
		this.timeStamp = timeStamp;
	}
	
	

}
