package com.example.board2.service;

import com.example.board2.comm.Cm_encrypt;
import com.example.board2.entity.Study_member;
import com.example.board2.entity.Study_record;
import com.example.board2.repository.StudyMemberRepo;
import com.example.board2.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    @Value("${encrypt.key16}")
    private String strKey16;


    /* 전체 Row Select */
    public List<Study_member> doSelectAll() throws Exception {

        String strKey16= "ABCdefg123456plm";


        List<Study_member> list = studyMemberRepo.findAll();

        /* 복호화 */
        for (Study_member study_member : list) {
            study_member.setEmail(Cm_encrypt.decryptAes(study_member.getEmail(),strKey16));
        }

        return  list;
    }

    /* One Row Select */
    public Study_member doSelectOne(int key_id) {
        return studyMemberRepo.findById(key_id).get();
    }


    /* Insert */
    public void doInsert(Study_member study_member) throws Exception {

//        String strKey16= "ABCdefg123456plm";

        study_member.setPassword(Cm_encrypt.encryptSha256(study_member.getPassword()));
        study_member.setEmail(Cm_encrypt.encryptAes(study_member.getEmail(),strKey16));

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
