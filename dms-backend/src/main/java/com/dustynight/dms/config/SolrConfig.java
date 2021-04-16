package com.dustynight.dms.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @className: SolrConfig
 * @description: TODO
 * @author: DustyNight
 * @date: 4/16/2021
 **/
@Configuration
@EnableSolrRepositories(
        basePackages = "com.dustynight.dms.repository"
)
@ComponentScan
public class SolrConfig {
    @Value("${spring.data.solr.host}")
    String solrUrl;

    @Bean
    public SolrClient solrClient() throws IOException, SAXException, ParserConfigurationException {
        return new HttpSolrClient.Builder(solrUrl).build();

    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
