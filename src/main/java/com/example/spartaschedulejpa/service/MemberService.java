package com.example.spartaschedulejpa.service;

import com.example.spartaschedulejpa.dto.MemberResponseDto;
import com.example.spartaschedulejpa.dto.SignUpResponseDto;
import com.example.spartaschedulejpa.entity.Member;
import com.example.spartaschedulejpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String email, String password) {

        Member member = new Member(username, email, password);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername());
    }

    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        // NPE 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername());
    }

    // lv1 특정 일정 수정
    @Transactional
    public void updateUser(Long id, String username) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.update(username);
    }

    // lv1 특정 일정 삭제
    public void deleteUser(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);
    }

//    public LoginResponseDto login(String email, String password) {
//
//    }

}