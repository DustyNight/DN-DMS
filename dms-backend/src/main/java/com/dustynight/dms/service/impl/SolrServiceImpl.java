package com.dustynight.dms.service.impl;

import cn.hutool.core.convert.Convert;
import com.dustynight.dms.dto.HighlightFileDTO;
import com.dustynight.dms.dto.SolrFileDTO;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.repository.SolrFileRepository;
import com.dustynight.dms.service.SolrService;
import com.dustynight.dms.service.TikaService;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SolrServiceImpl
 * @description: TODO
 * @author: DustyNight
 * @date: 5/14/2021
 **/
@Service
public class SolrServiceImpl implements SolrService {
    @Autowired
    TikaService tikaService;

    @Autowired
    SolrFileRepository solrFileRepository;

    @Autowired
    SolrClient solrClient;

    public void fileIndex(FileModel fileModel) {
        SolrFileDTO solrFileDTO = new SolrFileDTO();
        solrFileDTO.setFileId(fileModel.getFileId().toString());
        solrFileDTO.setFileName(fileModel.getFileName());
        solrFileDTO.setFilePath(fileModel.getFilePath());
        solrFileDTO.setAuthor(fileModel.getAuthor());
        solrFileDTO.setTags(fileModel.getTags());
        solrFileDTO.setType(fileModel.getType());
        solrFileDTO.setFileContent(tikaService.parseToString(fileModel.getFilePath()));
        solrFileRepository.save(solrFileDTO);
    }

    public List<HighlightFileDTO> getHighlightFile(String searchTerm, Pageable pageable) {
        List<HighlightFileDTO> resList = new ArrayList<HighlightFileDTO>();
        HighlightPage<SolrFileDTO> highlightPage = solrFileRepository.findByCustomQuery(searchTerm, pageable);
        for(HighlightEntry<SolrFileDTO> entry : highlightPage.getHighlighted()) {
            HighlightFileDTO temp = new HighlightFileDTO();
            if(entry.getHighlights().size() != 0) {
                temp.setHighlightContent(entry.getHighlights().get(0).getSnipplets().get(0));
            } else {
                temp.setHighlightContent("");
            }
            temp.setFileId(Convert.toLong(entry.getEntity().getFileId()));
            temp.setFileName(entry.getEntity().getFileName());
            temp.setAuthor(entry.getEntity().getAuthor());
            temp.setFilePath(entry.getEntity().getFilePath());
            temp.setTags(entry.getEntity().getTags());
            resList.add(temp);
        }

        return resList;
    }

    public void deleteIndex(FileModel fileModel) {
        solrFileRepository.deleteById(fileModel.getFileId().toString());
    }
}
