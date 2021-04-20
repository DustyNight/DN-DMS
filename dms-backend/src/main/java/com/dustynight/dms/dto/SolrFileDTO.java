package com.dustynight.dms.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.stereotype.Component;

/**
 * @className: SolrFileDTO
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Component
@Data
@SolrDocument(solrCoreName = "dms")
public class SolrFileDTO {
    @Id
    @Indexed(name = "file_id", type = "string")
    private String fileId;

    @Indexed(name = "file_name", type = "text_ik")
    private String fileName;

    @Indexed(name = "author", type = "text_ik")
    private String author;

    @Indexed(name = "file_path", type = "text_ik")
    private String filePath;

    @Indexed(name = "type", type = "text_ik")
    private String type;

    @Indexed(name = "tags", type = "text_ik")
    private String tags;

    @Indexed(name = "file_content", type = "text_ik")
    private String fileContent;
}
