package org.netty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 聊天消息实体类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {
    private String content;
    private long timestamp;
    private String sender;
    private String type; // 消息类型: CHAT, JOIN, LEAVE

    public ChatMessage() {}

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = System.currentTimeMillis();
        this.type = "CHAT";
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", sender='" + sender + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}