package org.webscoket;

public class Message {
    private String type;
    private String content;
    private String recipient;
    private String sender;

    public Message() {
    }

    public Message(String type, String content, String recipient, String sender) {
        this.type = type;
        this.content = content;
        this.recipient = recipient;
        this.sender = sender;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}