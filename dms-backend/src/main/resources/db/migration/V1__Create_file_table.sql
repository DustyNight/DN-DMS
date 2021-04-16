create table file
(
    id int auto_increment,
    file_name varchar(200) null,
    author varchar(50) null,
    file_id varchar(100) not null,
    filePath varchar(500) not null,
    type varchar(20) not null,
    tags varchar(100) null,
    size long not null,
    uploaded_time long null,
    modified_time long null,
    constraint file_pk
        primary key (id)
);