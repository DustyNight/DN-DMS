package com.dustynight.dms.service;

import com.dustynight.dms.dto.HighlightFileDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @className: SolrServiceTest
 * @description: TODO
 * @author: DustyNight
 * @date: 4/20/2021
 **/
@SpringBootTest
class SolrServiceTest {
    @Autowired
    SolrService solrService;

    @Test
    void fileIndex() {
    }

    @Test
    void getHighlightFile() {
        Pageable pageable = PageRequest.of(0, 10);
        List<HighlightFileDTO> list = solrService.getHighlightFile("nobody", pageable);
        System.out.println(list.get(0).toString());
    }
}