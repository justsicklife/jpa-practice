package com.example.board2.service;

import com.example.board2.entity.Study_member;
import com.example.board2.entity.Study_record;
import com.example.board2.repository.StudyMemberRepo;
import com.example.board2.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    /* 전체 Row Select */
    public List<Study_member> doSelectAll() {
        return studyMemberRepo.findAll();
    }

    /* One Row Select */
    public Study_member doSelectOne(int key_id) {
        return studyMemberRepo.findById(key_id).get();
    }


    /* Insert */
    public void doInsert(Study_member study_member) {
        studyMemberRepo.save(study_member);
    }

    /* Update */
    public void doUpdate(Study_member study_member) {
        studyMemberRepo.save(study_member);
    }


    /* Delete */
    public void doDelete(int key_id) {
        studyMemberRepo.deleteById(key_id);
    }


}
