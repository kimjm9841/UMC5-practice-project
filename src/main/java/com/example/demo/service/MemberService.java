package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.*;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

// 	1. 엔티티 저장하는 방법 -> repository.save() 호출
	@Transactional
	public Long signup(SignUpRequest signUpRequest) {
		return memberRepository.save(new Member(
				signUpRequest.getName(),
				signUpRequest.getNickname(),
				signUpRequest.getAge(),
				signUpRequest.getGender()
		)).getId();
	}

// 	2. 엔티티를 ID로 조회하는 방법 -> repository.findById() 호출
	@Transactional
	public MemberDto getMember(Long id) {
		Member member = memberRepository.findById(id).get();
		return new MemberDto(
				member.getId(),
				member.getName(),
				member.getNickname(),
				member.getAge(),
				member.getGender()
		);
	}

// 	3. 엔티티를 업데이트하는 방법 -> repository.findById()를 호출한 뒤 setter로 필드값들을 변경해준다.
	@Transactional
	public MemberUpdateResponse updateMember(MemberUpdateRequest memberUpdateRequest) {
		Member member = memberRepository.findById(memberUpdateRequest.getId()).get();

		member.setName(memberUpdateRequest.getName());
		member.setNickname(memberUpdateRequest.getNickname());
		member.setAge(memberUpdateRequest.getAge());
		member.setGender(memberUpdateRequest.getGender());

		return new MemberUpdateResponse(
				member.getName(),
				member.getNickname(),
				member.getAge(),
				member.getGender()
		);
	}
}
