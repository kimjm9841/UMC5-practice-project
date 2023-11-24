package com.example.demo.domain;


import com.example.demo.domain.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Member의 구성요소 - id, 이름, 닉네임, 나이, 성별
// 각 필드의 타입은 본인이 원하는대로 하면됩니다.
// 여기에 뭐가 들어갈까요?
@Entity
@Getter
@Setter
public class Member {

	// 여기에 뭐가 들어갈까요?
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 나머지 필드를 선언해주세요
	@Column(nullable = false, length = 10)
	private String name;

	@Column(nullable = false, length = 10)
	private String nickname;

	private Integer age;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(10)")
	private Gender gender;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Comment> commentList = new ArrayList<>();

	// 생성자와 Getter, Setter 도 필요합니다
	// Setter 는 안쓰는것이 좋지만 예제의 복잡도를 줄이기 위해 그냥 과제에서는 쓰는것으로 합니다
	public Member(String name, String nickname, Integer age, Gender gender) {
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * 이건 지우지말고 냅두세요
	 */
	protected Member() {
	}

}
