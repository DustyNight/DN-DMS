package com.dustynight.dms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dustynight.dms.model.FileModel;

import java.io.File;

/**
 * @className: FileService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
public interface FileService extends IService<FileModel> {
    void saveFile(FileModel fileModel, File tmpFile);

    void deleteFile(FileModel fileModel);
}
