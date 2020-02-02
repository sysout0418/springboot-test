package com.elio.edu.service;

import com.elio.edu.entity.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadDownloadService {

    List<FileEntity> getAllFileList();

    void uploadFile(String title, String contents, MultipartFile fileImage, MultipartFile fileData);

    FileEntity getFileDetail(long fileNo);

    Resource downloadFile(String fileNo);

}
