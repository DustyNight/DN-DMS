package com.dustynight.dms.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @className: FileDto
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@Component
@Data
public class FileDTO {
    private String tags;
    private String author;
}
