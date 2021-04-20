package com.dustynight.dms.repository;

import com.dustynight.dms.dto.SolrFileDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @className: SolrFileRepositoryTest
 * @description: TODO
 * @author: DustyNight
 * @date: 4/19/2021
 **/
@SpringBootTest
class SolrFileRepositoryTest {
    @Autowired
    SolrFileRepository solrFileRepository;

    @Test
    public void getByAllTest() {
        Pageable pageable = PageRequest.of(0, 10);
        HighlightPage<SolrFileDTO> highlightPage = solrFileRepository.findByCustomQuery ("甘凯丰", pageable);
        System.out.println(highlightPage.getHighlighted().get(0).getEntity().getAuthor());
    }

}