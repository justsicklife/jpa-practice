package com.example.board2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "STUDY_MEMBER")
@AllArgsConstructor
@NoArgsConstructor
public class Study_member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "login_id")
    private String loginId;

    private String password;
    private String name;
    private String role;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    private LocalDateTime reg_day;
    private String email;


}
