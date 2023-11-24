package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CommentUpdateResponse {

    private String body;

    private String image;
}
