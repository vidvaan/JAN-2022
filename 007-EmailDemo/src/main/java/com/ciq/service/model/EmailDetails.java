package com.ciq.service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EmailDetails {

	// Class data members
	@NotEmpty(message = "Recipient is missing!")
	@Email(message = "Please provide valid email!")
	private String recipient;
	@NotEmpty(message = "Msg Body is missing!")
	@Size(message = "Msg Body should be more then 10 char!",min = 10)
	private String msgBody;
	@NotEmpty(message = "Subject is missing!")
	private String subject;
	private String attachment;

	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDetails(String recipient, String msgBody, String subject, String attachment) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
		this.attachment = attachment;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject
				+ ", attachment=" + attachment + "]";
	}

}