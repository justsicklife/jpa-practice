package com.example.board2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study_record {
    @Id
    private int key_id;
    private String Study_day;
    private String contents;
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column
    private LocalDateTime reg_day;
}
