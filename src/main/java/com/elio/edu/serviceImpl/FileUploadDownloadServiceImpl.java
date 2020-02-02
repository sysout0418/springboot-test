package com.elio.edu.serviceImpl;

import com.elio.edu.entity.FileEntity;
import com.elio.edu.exception.FileException;
import com.elio.edu.repository.FileRepository;
import com.elio.edu.service.FileUploadDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadDownloadServiceImpl implements FileUploadDownloadService {

    @Value("${custom.upload-path}")
    private String fileUploadPath;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    ServletContext servletContext;

    /*@Autowired
    public FileUploadDownloadServiceImpl(FileUploadConfig con) {
        //this.fileLocation = Paths.get(con.getUploadDir()).toAbsolutePath().normalize();
        this.fileLocation = Paths.get(con.getUploadDir());

        try {
            Files.createDirectories(this.fileLocation);
        } catch(Exception e) {
            throw new FileException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }*/

    @Override
    public List<FileEntity> getAllFileList() {
        return fileRepository.findAllByOrderByFileNoDesc();
    }

    @Override
    @Transactional
    public void uploadFile(String title, String contents, MultipartFile fileImage, MultipartFile fileData) {
        log.info("upload start");
        log.info("fileUploadPath : " + fileUploadPath);
        String fileImageName = StringUtils.cleanPath(fileImage.getOriginalFilename());
        String fileName = StringUtils.cleanPath(fileData.getOriginalFilename());
        log.info("fileImageName : " + fileImageName);
        log.info("fileName : " + fileName);

        // 확장자 체크
        String fileImageExtension = FilenameUtils.getExtension(fileImageName).toLowerCase();
        String fileExtension = FilenameUtils.getExtension(fileName).toLowerCase();
        if (!"jpg".equals(fileImageExtension) && !"jpeg".equals(fileImageExtension) && !"png".equals(fileImageExtension)) {
            throw new FileException(fileImageName + " 파일 업로드에 실패하였습니다. jpg(jpeg), png만 업로드 가능합니다.");
        }
        if (!"pdf".equals(fileExtension) && !"ppt".equals(fileExtension)) {
            throw new FileException(fileName + " 파일 업로드에 실패하였습니다. 확장자를 확인하세요.");
        }

        String copyFileImageName = UUID.randomUUID().toString() + "." + fileImageExtension;
        String copyFileName = UUID.randomUUID().toString() + "." + fileExtension;

        try {
            // 업로드 경로에 파일 복사
            File uploadFileImage = new File(fileUploadPath + copyFileImageName);
            File uploadFile = new File(fileUploadPath + copyFileName);
            FileUtils.copyInputStreamToFile(fileImage.getInputStream(), uploadFileImage);
            FileUtils.copyInputStreamToFile(fileData.getInputStream(), uploadFile);

            //Path fileImageTargetPath = this.fileLocation.resolve(UUID.randomUUID().toString() + "." + fileImageExtension);
            //Path fileTargetPath = this.fileLocation.resolve(UUID.randomUUID().toString() + "." + fileExtension);
            //log.info("fileImageTargetPath : " + fileImageTargetPath.toString());
            //log.info("fileTargetPath : " + fileTargetPath.toString());
            //Files.copy(fileImage.getInputStream(), fileImageTargetPath, StandardCopyOption.REPLACE_EXISTING);
            //Files.copy(fileData.getInputStream(), fileTargetPath, StandardCopyOption.REPLACE_EXISTING);

            // DB입력
            FileEntity file = new FileEntity();
            file.setTitle(title);
            file.setContents(contents);
            file.setFileName(fileName);
            file.setFileImageUrl("/upload/" + copyFileImageName);
            file.setFileUrl("/upload/" + copyFileName);
            file.setFileType(fileExtension);
            file.setFileSize(fileData.getSize());
            file.setDeleteYn("N");
            file.setInsertedId("system");
            file.setInsertedDate(LocalDateTime.now());
            file.setUpdatedId("system");
            file.setUpdatedDate(LocalDateTime.now());
            fileRepository.save(file);

        } catch (Exception e) {
            throw new FileException(fileName + " 파일 업로드에 실패하였습니다. 나중에 다시 시도하십시오.", e);
        }


        /*File tmp = new File(tempPath + UUID.randomUUID().toString());
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), tmp);
        } catch (IOException e) {
            log.error("Error while copying.", e);
            throw e;
        }*/



        log.info("upload end");


        //try {
            // 파일명에 부적합 문자가 있는지 확인한다.
            //if (fileName.contains(".."))
            //    throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);

            //Path targetLocation = this.fileLocation.resolve(fileName);

            //Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


        //} catch (Exception e) {
        //    throw new FileException(fileName + " 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
        //}
    }

    @Override
    public FileEntity getFileDetail(long fileNo) {
        return fileRepository.findById(fileNo).orElse(new FileEntity());
    }

    @Override
    public Resource downloadFile(String fileNo) {
        return null;
    }

    /*@Override
    public Resource downloadFile(String fileNo) {
        try {
            //Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()) {
                return resource;
            }else {
                throw new FileException(fileName + " 파일을 찾을 수 없습니다.");
            }
        } catch (MalformedURLException e) {
            throw new FileException(fileName + " 파일을 찾을 수 없습니다.", e);
        }
    }*/

}
