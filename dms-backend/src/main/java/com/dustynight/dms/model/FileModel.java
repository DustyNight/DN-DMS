package com.dustynight.dms.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("file")
public class FileModel {
    @TableId
    private String fileId;
    private String fileName;
    private String author;
    private String filePath;
    private Long uploadedTime;
    private Long modifiedTime;
    private String type;
    private String tags;
    private Long size;
}
