package com.example.spartaschedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    // lv1 작성유저명
//    @Column(nullable = false)
//    private String username;

    // lv2 유저 고유 식별자
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Schedule() {}

    // lv1
//    public Schedule(String title, String contents, String username) {
//        this.title = title;
//        this.contents = contents;
//        this.username = username;
//    }

    // lv2
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
