package com.example.demo.dto;

import lombok.Getter;

public class PostRequest {

	private String title;
	private String text;

	public PostRequest(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
}
