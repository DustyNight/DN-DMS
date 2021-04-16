package com.dustynight.dms.service;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @className: TikaService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Service
public class TikaService {
    public String parseToString(String filePath) {
        Tika tika = new Tika();
        InputStream inputStream = null;
        String content = "";
        try {
            inputStream = new FileInputStream(filePath);
            content = tika.parseToString(inputStream);
        } catch (IOException | TikaException e) {
            e.printStackTrace();
        }
        return content;
    }
}
