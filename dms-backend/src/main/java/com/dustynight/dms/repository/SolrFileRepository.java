package com.dustynight.dms.repository;

import com.dustynight.dms.dto.FileDTO;
import com.dustynight.dms.dto.SolrFileDTO;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @className: SolrFileRepository
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Repository
public interface SolrFileRepository extends SolrCrudRepository<SolrFileDTO, String> {
    @Query("file_name:*?0* OR author:*?0* OR file_path:*?0* OR type:*?0* OR tags:*?0* OR file_content:*?0* ")
    public List<FileDTO> findByAll(String searchTerm, Pageable pageable);
}
