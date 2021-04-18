create table file
(
    file_id bigint(30) not null,
    file_name varchar(200) null,
    author varchar(50) null,
    filePath varchar(500) not null,
    type varchar(20) not null,
    tags varchar(100) null,
    size bigint not null,
    uploaded_time bigint null,
    modified_time bigint null,
    constraint file_pk
        primary key (file_id)
);