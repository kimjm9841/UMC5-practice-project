package com.example.demo.dto;

import com.example.demo.domain.enums.Gender;
import lombok.Getter;

@Getter
public class SignUpRequest {

    private String name;

    private String nickname;

    private Integer age;

    private Gender gender;

}
