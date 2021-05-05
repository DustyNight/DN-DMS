package com.dustynight.dms.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dustynight.dms.mapper.FileMapper;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.service.FileService;
import com.dustynight.dms.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @className: FileServiceImpl
 * @description: TODO
 * @author: DustyNight
 * @date: 4/26/2021
 **/
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileModel> implements FileService {
    @Autowired
    FileMapper fileMapper;

    @Autowired
    SolrService solrService;

    public void saveFile(FileModel fileModel, File file) {
        String path = "D:\\Clarence\\dms\\files\\";
        fileModel.setFilePath(path + fileModel.getFileId().toString() + "." + fileModel.getFileName().substring(fileModel.getFileName().lastIndexOf(".") + 1));
        FileUtil.copy(file.getPath(), path + file.getName(), true);
        FileUtil.del(file.getPath());

        //FileMapper
        fileMapper.insert(fileModel);

        //Solr index
        solrService.fileIndex(fileModel);
    }

}
