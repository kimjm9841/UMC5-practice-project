package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Getter;

@Getter
public class CommentWriteRequest {

    private Long memberId;

    private String body;

    private String image;
}
