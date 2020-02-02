package com.elio.edu.repository;

import com.elio.edu.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findAllByOrderByFileNoDesc();

    //List<FileEntity> getFileList();

    //FileEntity getFileInfo(String fileNo);

}
