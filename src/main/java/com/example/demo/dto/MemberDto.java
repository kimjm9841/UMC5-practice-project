package com.example.demo.dto;

import com.example.demo.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String name;

    private String nickname;

    private Integer age;

    private Gender gender;

}
