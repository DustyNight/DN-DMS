package com.dustynight.dms.service;


import com.dustynight.dms.dto.HighlightFileDTO;
import com.dustynight.dms.model.FileModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @className: SolrService
 * @description: TODO
 * @author: DustyNight
 * @date: 4/15/2021
 **/
public interface SolrService {
    void fileIndex(FileModel fileModel);

    List<HighlightFileDTO> getHighlightFile(String searchTerm, Pageable pageable);

    void deleteIndex(FileModel fileModel);
}
