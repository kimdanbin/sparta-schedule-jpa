package com.example.spartaschedulejpa.controller;

import com.example.spartaschedulejpa.common.Const;
import com.example.spartaschedulejpa.dto.*;
import com.example.spartaschedulejpa.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // lv2 유저 생성
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // lv2 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // lv2 특정 유저 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateMemberRequestDto requestDto) {
        memberService.updateUser(id, requestDto.getUsername());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // lv2 특정 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        memberService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        LoginResponseDto responseDto = memberService.login(dto.getEmail(), dto.getPassword());
        Long userId = responseDto.getId();

        // 실패시 예외처리
        if (userId == null) {
            return "로그인 실패";
        }

        HttpSession session = request.getSession();

        // 회원 정보 조회
        MemberResponseDto loginUser = memberService.findById(userId);

        // Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, loginUser);

        return "로그인 성공";
    }


}
