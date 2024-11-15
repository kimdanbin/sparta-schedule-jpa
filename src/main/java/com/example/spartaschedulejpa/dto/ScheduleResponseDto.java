package com.example.spartaschedulejpa.dto;

import com.example.spartaschedulejpa.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;

    private final String title;

    private final String contents;

    // lv1
//    private final String username;

//    public ScheduleResponseDto(Long id, String title, String contents, String username) {
//        this.id = id;
//        this.title = title;
//        this.contents = contents;
//        this.username = username;
//    }

    // lv2
    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
}
