package com.elio.edu.controller;

import com.elio.edu.entity.FileEntity;
import com.elio.edu.service.FileUploadDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FileUploadDownloadService fileService;

    // 어드민 메인 페이지
    @GetMapping("/index")
    public String index(Model model) {
        List<FileEntity> fileList = fileService.getAllFileList();

        model.addAttribute("fileList", fileList);

        return "admin/index";
    }

    @GetMapping("/upload")
    public String upload() {
        return "admin/upload";
    }

}
