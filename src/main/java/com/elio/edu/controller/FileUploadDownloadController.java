package com.elio.edu.controller;

import com.elio.edu.entity.FileEntity;
import com.elio.edu.exception.FileException;
import com.elio.edu.service.FileUploadDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/file")
public class FileUploadDownloadController {

    @Autowired
    private FileUploadDownloadService fileService;

    @GetMapping("/allList")
    @ResponseBody
    public Map<String, Object> allFileList() {
        List<FileEntity> fileList = fileService.getAllFileList();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("fileList", fileList);

        return responseMap;
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("title") String title, @RequestParam("contents") String contents,
                                          @RequestParam("fileImage") MultipartFile fileImage, @RequestParam("fileData") MultipartFile fileData) {
        log.info("title >> " + title);
        log.info("contents >> " + contents);
        log.info("fileImage >> " + fileImage.getOriginalFilename());
        log.info("fileData >> " + fileData.getOriginalFilename());

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result_code", "0");
        try {
            fileService.uploadFile(title, contents, fileImage, fileData);
        } catch (FileException e) {
            responseMap.put("result_code", "-1");
            responseMap.put("result_msg", e.getMessage());
        }



        //responseMap.put("FILE_NAME", fileName);


        //String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
         //       .path("/downloadFile/")
        //        .path(fileName)
         //       .toUriString();

        //return new FileUploadResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        return responseMap;
    }

    @GetMapping("/detail/{fileNo}")
    public String fileDetail(@PathVariable("fileNo") long fileNo, Model model) {
        FileEntity fileDetail = fileService.getFileDetail(fileNo);
        model.addAttribute("fileUrl", fileDetail.getFileUrl());
        return "detail_page";
    }

    /*@PostMapping("/uploadMultiple")
    @ResponseBody
    public Map<String, Object> uploadMultipleFiles(@RequestBody MultipartFile[] files) {
        Map<String, Object> responseMap = new HashMap<>();
        List<FileEntity> fileList = new ArrayList<>();
        responseMap.put("RESULT_CODE", "0");

        for (MultipartFile file : files) {
            String fileName = fileService.uploadFile(file);
            // TODO

        }

        responseMap.put("FILE_LIST", fileList);

        return responseMap;

        //return Arrays.asList(files)
        //        .stream()
        //        .map(file -> uploadFile(file))
        //        .collect(Collectors.toList());
    }*/

    /*@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        // Load file as Resource
        Resource resource = service.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }*/

}
