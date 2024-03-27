package com.example.board2.service;

import com.example.board2.entity.Study_member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyMemberServiceTest {
    @Autowired
    StudyMemberService studyMemberService;
    
    @Test
    public void 멤버모두가져오기() {
        List<Study_member> studyMembers = studyMemberService.doSelectAll();
        System.out.println("studyMembers = " + studyMembers);
    }
}