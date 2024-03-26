package com.example.board2.service;

import com.example.board2.entity.Study_record;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService studyRecordService;

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .Study_day("2022.08.23")
                .contents("Test Insert 진행")
                .reg_day(LocalDateTime.now())
                .build();

        studyRecordService.doInsert(study_record);
    }


    @Test
    void doUpdate() {
        /*
        Study_record study_record = new Study_record();

        study_record.setKey_id(3);
        study_record.setStudy_day("2022.08.23");
        study_record.setContents("Test Insert 진행-수정");
        study_record.setReg_day(LocalDateTime.now());

        */

        Study_record study_record = studyRecordService.doSelectOne(3);
        study_record.setContents("Test Insert 진행-수정3");

        studyRecordService.doUpdate(study_record);

    }

    @Test
    @Transactional
    void doDelete() {
        studyRecordService.doDelete(3);
    }

}