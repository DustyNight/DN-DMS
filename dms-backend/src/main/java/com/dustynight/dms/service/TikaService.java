package com.dustynight.dms.service;

import org.springframework.stereotype.Service;

/**
 * @className: TikaService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Service
public interface TikaService {
    String parseToString(String filePath);
}
