package com.dustynight.dms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.dustynight.dms.service.TikaService;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @className: TikaServiceImpl
 * @description: TODO
 * @author: DustyNight
 * @date: 5/14/2021
 **/
@Service
public class TikaServiceImpl implements TikaService {

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
        StrUtil.removeAllLineBreaks(content);
        StrUtil.removeAll(" ", content);
        return content;
    }
}
