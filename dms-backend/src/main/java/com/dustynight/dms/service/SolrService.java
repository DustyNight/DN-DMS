package com.dustynight.dms.service;

import com.dustynight.dms.dto.SolrFileDTO;
import com.dustynight.dms.model.FileModel;
import com.dustynight.dms.repository.SolrFileRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: SolrService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/15/2021
 **/
@Service
public class SolrService {
    @Autowired
    TikaService tikaService;

    @Autowired
    SolrFileRepository solrFileRepository;

    @Autowired
    SolrClient solrClient;

    public void fileIndex(FileModel fileModel) {
        SolrFileDTO solrFileDTO = new SolrFileDTO();
        solrFileDTO.setFileId(fileModel.getFileId());
        solrFileDTO.setFileName(fileModel.getFileName());
        solrFileDTO.setFilePath(fileModel.getFilePath());
        solrFileDTO.setAuthor(fileModel.getAuthor());
        solrFileDTO.setTags(fileModel.getTags());
        solrFileDTO.setType(fileModel.getType());
        solrFileDTO.setFileContent(tikaService.parseToString(fileModel.getFilePath()));
        solrFileRepository.save(solrFileDTO);
    }
}
