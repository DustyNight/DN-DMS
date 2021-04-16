package com.dustynight.dms.service;

import cn.hutool.core.io.FileUtil;
import com.dustynight.dms.mapper.FileMapper;
import com.dustynight.dms.model.FileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @className: FileService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@Service
public class FileService {
    @Autowired
    FileMapper fileMapper;

    @Autowired
    SolrService solrService;

    public void saveFile(FileModel fileModel, File file) {
        String path = "E:\\dms\\files\\";
        fileModel.setFilePath(path + fileModel.getFileId() + "." + fileModel.getType().split("/")[1]);
        FileUtil.copy(file.getPath(), path + file.getName(), true);
        FileUtil.del(file.getPath());

        //FileMapper

        //Solr index
        solrService.fileIndex(fileModel);
    }
}
