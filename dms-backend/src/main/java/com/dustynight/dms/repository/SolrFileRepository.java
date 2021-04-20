package com.dustynight.dms.repository;

import com.dustynight.dms.dto.SolrFileDTO;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;


/**
 * @className: SolrFileRepository
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Repository
public interface SolrFileRepository extends SolrCrudRepository<SolrFileDTO, String> {
    @Highlight(prefix = "<b>", postfix = "</b>", fields = "file_content")
    @Query("file_name:?0 OR author:?0 OR file_path:?0 OR type:?0 OR tags:?0 OR file_content:?0")
    HighlightPage<SolrFileDTO> findByCustomQuery(String searchTerm, Pageable pageable);
}
