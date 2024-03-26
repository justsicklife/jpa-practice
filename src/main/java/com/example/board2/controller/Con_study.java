package com.example.board2.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.board2.entity.Study_record;
import com.example.board2.service.StudyRecordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/study")
public class Con_study {

    @Autowired
    StudyRecordService recordService;

    @GetMapping("/list")
    public String doStudyList(Model model) {
        List<Study_record> list = recordService.doSelectAll();

        model.addAttribute("list",list);

        return "/study/study_list";
    }

    @GetMapping("/insert")
    public String doIns() {
        return "/study/study_ins";
    }

    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Study_record study_record) {
        study_record.setReg_day(LocalDateTime.now());
        recordService.doInsert(study_record);

        return "redirect:/study/list";
    }

    @GetMapping("/modify")
    public String doMod(HttpServletRequest request, Model model) {
        String strKeyId = request.getParameter("key_id");

        System.out.println("strKeyId = " + strKeyId);
        Study_record study_recode = recordService.doSelectOne(Integer.parseInt(strKeyId));

        request.setAttribute("vo_study",study_recode);

        return "/study/study_mod";
    }

    @PostMapping("/modify_exe")
    public String doModExe(Study_record study_record) {
        recordService.doUpdate(study_record);

        return "redirect:/study/list";
    }

}