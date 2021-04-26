package com.dustynight.dms.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @className: FileUploadController
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping(value = "/file/upload", consumes = {"multipart/form-data"})
    public void upload(@RequestPart("file") MultipartFile multipartFile,
                       @RequestPart("tags") String tags,
                       @RequestPart("author") String author) throws IOException {
        //Create a file model and set values
        FileModel fileModel = new FileModel();
        fileModel.setFileName(multipartFile.getOriginalFilename());
        fileModel.setSize(multipartFile.getSize());
        fileModel.setType(multipartFile.getContentType());
        fileModel.setAuthor(author);
        fileModel.setTags(tags);
        fileModel.setUploadedTime(System.currentTimeMillis());
        fileModel.setModifiedTime(fileModel.getUploadedTime());
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        fileModel.setFileId(snowflake.nextId());

        //Create temp file
        File tmpFile =
                FileUtil.touch("E:\\dms\\tmp\\" + fileModel.getFileId() + "." + fileModel.getType().split("/")[1]);
        try {
            multipartFile.transferTo(tmpFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Save file
        fileService.saveFile(fileModel, tmpFile);
    }

    @GetMapping(value = "/file")
    public List<FileModel> showAll() {
        return fileService.list();
    }
}
