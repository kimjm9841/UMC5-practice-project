package com.example.demo.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequest {

    private Long id;

    private String body;

    private String image;
}
