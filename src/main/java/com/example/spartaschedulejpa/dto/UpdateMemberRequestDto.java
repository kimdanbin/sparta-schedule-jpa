package com.example.spartaschedulejpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberRequestDto {
    private String username;

    public UpdateMemberRequestDto() {}

    public UpdateMemberRequestDto(String username) {
        this.username = username;
    }
}
