package com.example.spartaschedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Member() { }

    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        // lv3 비밀번호 추가
        this.password = password;
    }

    public void update(String username) {
        this.username = username;
    }
}