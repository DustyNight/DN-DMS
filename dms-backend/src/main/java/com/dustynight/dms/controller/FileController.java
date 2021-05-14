package com.dustynight.dms.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/file/upload")
    public void upload(@RequestParam Map<String, String> map,
                       @RequestParam("file") MultipartFile file
    ) throws IOException {
        //Create a file model and set values
        FileModel fileModel = new FileModel();
        fileModel.setFileName(file.getOriginalFilename());
        fileModel.setSize(file.getSize());
        fileModel.setType(fileModel.getFileName().substring(fileModel.getFileName().lastIndexOf(".") + 1));
        fileModel.setAuthor(map.get("author"));
        fileModel.setTags(map.get("tags"));
        fileModel.setUploadedTime(System.currentTimeMillis());
        fileModel.setModifiedTime(fileModel.getUploadedTime());
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        fileModel.setFileId(snowflake.nextId());

        //Create temp file
        File tmpFile =
                FileUtil.touch("D:\\Clarence\\dms\\tmp\\" + fileModel.getFileId() + "." + fileModel.getFileName().substring(fileModel.getFileName().lastIndexOf(".") + 1));
        try {
            file.transferTo(tmpFile);
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

    @PostMapping(value = "/file/delete")
    public void delete(@RequestParam String fileId) {
        fileService.deleteFile(fileService.getById(fileId));
    }
}
