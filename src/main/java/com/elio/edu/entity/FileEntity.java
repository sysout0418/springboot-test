package com.elio.edu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_FILE")
public class FileEntity {

    @Id
    @Column(name = "FILE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileNo;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_IMAGE_URL")
    private String fileImageUrl;

    @Column(name = "FILE_URL")
    private String fileUrl;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Column(name = "FILE_SIZE")
    private long fileSize;

    @Column(name = "DELETE_YN")
    private String deleteYn;

    @Column(name = "INSERTED_ID")
    private String insertedId;

    @Column(name = "INSERTED_DATE")
    private LocalDateTime insertedDate;

    @Column(name = "UPDATED_ID")
    private String updatedId;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    public FileEntity() {}

}
