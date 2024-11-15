package com.example.spartaschedulejpa.service;

import com.example.spartaschedulejpa.dto.ScheduleResponseDto;
import com.example.spartaschedulejpa.entity.Member;
import com.example.spartaschedulejpa.entity.Schedule;
import com.example.spartaschedulejpa.repository.MemberRepository;
import com.example.spartaschedulejpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    // lv1 일정 생성
    public ScheduleResponseDto save(String title, String contents, String username) {
        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setMember(findMember);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
    }

    // lv1 전체 일정 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // lv1 특정 일정 조회
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents());
    }

    // lv1 특정 일정 수정
    @Transactional
    public void updateSchedule(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.update(title, contents);
    }

    // lv1 특정 일정 삭제
    public void delete(Long id) {

        Schedule findBoard = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findBoard);
    }
}
