package com.example.spartaschedulejpa.controller;

import com.example.spartaschedulejpa.dto.MemberResponseDto;
import com.example.spartaschedulejpa.dto.SignUpRequestDto;
import com.example.spartaschedulejpa.dto.SignUpResponseDto;
import com.example.spartaschedulejpa.dto.UpdateMemberRequestDto;
import com.example.spartaschedulejpa.service.MemberService;
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

//    @PostMapping("/login")
//    public String login(
//            @RequestBody LoginRequestDto dto,
//            HttpServletRequest request
//    ) {
//        LoginResponseDto responseDto =
//
//
//        return "";
//    }


}
