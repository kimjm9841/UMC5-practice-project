package com.example.demo.controller;

import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.dto.CommentWriteRequest;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 1. Comment 작성
    @PostMapping("/comments")
    public Long write(
            @RequestBody CommentWriteRequest request
    ) {
        return commentService.writeComment(request);
    }

    // 2. Comment 수정
    @PatchMapping("/comments")
    public CommentUpdateResponse edit(
            @RequestBody CommentUpdateRequest request
    ) {
        return commentService.updateComment(request);
    }

    // 3. Comment 삭제
    @DeleteMapping("/comments")
    public void delete(Long commentId) {
        commentService.deleteComment(commentId);
    }
}
