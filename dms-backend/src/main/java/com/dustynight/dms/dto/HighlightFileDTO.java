package com.dustynight.dms.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @className: HighlightFileDTO
 * @description: TODO
 * @author: DustyNight
 * @date: 4/20/2021
 **/
@Component
@Data
public class HighlightFileDTO {
    private String fileId;
    private String fileName;
    private String author;
    private String filePath;
    private String tags;
    private String highlightContent;
}
