create table member (
    id bigint not null auto_increment,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    created_at datetime(6),
    modified_at datetime(6),
    primary key (id)
);

create table schedule (
    id bigint not null auto_increment,
    title varchar(255) not null,
    contents longtext,
    member_id bigint,
    created_at datetime(6),
    modified_at datetime(6),
    primary key (id)
)