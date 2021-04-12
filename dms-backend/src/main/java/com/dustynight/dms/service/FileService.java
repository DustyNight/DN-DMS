package com.dustynight.dms.service;

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

    public void saveFile(FileModel fileModel, File file) {

    }
}
