package homework;

public class Email extends Document {
	private String sender, recipient, title;

	public String toString() {
		return "From: " + sender + "\nTo: " + recipient + "\nTitle: " + title + "\n" + text;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender() {
		return sender;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
