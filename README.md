# DN-DMS
DustyNight's Document Management System.

## Description
This project is developed for meeting the requirement of graduation of my B.S degree in Computer Science. 

## Tech Stack
[Spring](http://spring.io), [Vue.js](https://vuejs.org/), [Solr](https://solr.apache.org/), etc.

## How to Run

1. Clone this project.

2. Set up a `MySQL` Service and a `Solr` Service.

3. Set up [IK Analyzer Solr](https://github.com/magese/ik-analyzer-solr) for Chinese word segmentation, or just skip it if you don't need.

4. Edit`field` in `managed-scheme` of Solr

   ~~~
       <field name="file_id" type="string" indexed="true" stored="true" required="true" multiValued="false" />
       <field name="file_name" type="text_ik" indexed="true" stored="true"  multiValued="false" />
       <field name="author" type="text_ik" indexed="true" stored="true"  multiValued="false" />
       <field name="file_path" type="text_ik" indexed="true" stored="true"  multiValued="false" />
       <field name="type" type="text_ik" indexed="true" stored="true"  multiValued="false" />
       <field name="tags" type="text_ik" indexed="true" stored="true"  multiValued="false" />
       <field name="file_content" type="text_ik" indexed="true" stored="true"  multiValued="false" />
   ~~~

   If you don't use IK Analyzer, remember replace `text_ik` to any type you want, for example, `string`, and you should also replace it in `SolrFileDTO.java` 

5. For the backend part, in `dms-backend`, type `mvn install`, and `mvn flyway:migrate`(or you can go check files in `dms-backend/src/main/resources/db.migration`, and set up tables for MySQL by yourself). Then edit `application.properties`and `pom.xml`, replace things like `jdbc url`and`user name`to yours.

6. For the frontend part, in `dms-vue`, type`npm install`(yes you need a node.js environment).

7. Now everything is ready!

8. To start the backend part, type `mvn spring-boot:run` in `dms-backend`, or use IDE like `JetBrains IDEA` to run it. To start the frontend part, type `npm run serve` in `dms-vue`.

   Now you can visit `localhost:7913` (or you can edit the port in `application.properties`) to check this projects.

