package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 500)
    private String body;

    @Column(length = 200)
    private String image;

    @Builder
    public Comment(Member member, String body, String image) {
        this.member = member;
        this.body = body;
        this.image = image;
    }

    protected Comment() {
    }
}
