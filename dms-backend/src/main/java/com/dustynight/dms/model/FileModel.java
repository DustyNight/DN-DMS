package com.dustynight.dms.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @className: FileModel
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@Component
@Data
public class FileModel {
    private String fileName;
    private String author;
    private String fileId;
    private Long uploadedTime;
    private Long modifiedTime;
    private String type;
    private String tags;
    private Long size;
}
