package com.example.demo.helper;

import java.io.Serializable;

public class Message implements Serializable {

    private String content;
    private String type;

    public Message(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

	@Override
	public String toString() {
		return "Message [content=" + content + ", type=" + type + "]";
	}
    
    
}