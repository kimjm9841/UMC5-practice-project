package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.dto.CommentWriteRequest;
import com.example.demo.dto.MemberUpdateResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private MemberRepository memberRepository;

    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    // 댓글 작성
    @Transactional
    public Long writeComment(CommentWriteRequest commentWriteRequest) {
        return commentRepository.save(Comment.builder()
                        .member(memberRepository.findById(commentWriteRequest.getMemberId()).get())
                        .body(commentWriteRequest.getBody())
                        .image(commentWriteRequest.getImage())
                        .build()
        ).getId();
    }

    // 댓글 수정
    @Transactional
    public CommentUpdateResponse updateComment(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getId()).get();

        comment.setBody(commentUpdateRequest.getBody());
        comment.setImage(commentUpdateRequest.getImage());

        return CommentUpdateResponse.builder()
                .body(comment.getBody())
                .image(comment.getImage())
                .build();
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
