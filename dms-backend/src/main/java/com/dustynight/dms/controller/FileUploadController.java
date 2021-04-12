package com.dustynight.dms.controller;

import cn.hutool.core.util.IdUtil;
import com.dustynight.dms.dto.FileDTO;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @className: FileUploadController
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@RestController
public class FileUploadController {
    @Autowired
    FileService fileService;

    @PostMapping(value = "/upload", consumes = { "multipart/form-data"})
    public void upload(@RequestPart("file") MultipartFile multipartFile,
                       @RequestPart("fileDTO") FileDTO fileDTO) throws IOException {
        //Create a file model and set values
        FileModel fileModel = new FileModel();
        fileModel.setFileName(multipartFile.getOriginalFilename());
        fileModel.setSize(multipartFile.getSize());
        fileModel.setType(multipartFile.getContentType());
        fileModel.setAuthor(fileDTO.getAuthor());
        fileModel.setTags(fileDTO.getTags());
        fileModel.setUploadedTime(System.currentTimeMillis());
        fileModel.setModifiedTime(fileModel.getUploadedTime());
        fileModel.setFileId(IdUtil.randomUUID());

        //Create temp file
        File tmpFile = new File("./dms/tmp/", fileModel.getFileId());
        try {
            multipartFile.transferTo(tmpFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Save file
        fileService.saveFile(fileModel, tmpFile);
    }
}
