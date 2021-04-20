package com.dustynight.dms.controller;

import com.dustynight.dms.dto.HighlightFileDTO;
import com.dustynight.dms.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: SolrController
 * @description: TODO
 * @author: DustyNight
 * @date: 4/20/2021
 **/
@RestController
public class SolrController {
    @Autowired
    SolrService solrService;

    @GetMapping(value = "search")
    public List<HighlightFileDTO> solrSearch(@RequestParam(value = "searchTerm") String searchTerm,
                                             @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return solrService.getHighlightFile(searchTerm, pageable);
    }
}
