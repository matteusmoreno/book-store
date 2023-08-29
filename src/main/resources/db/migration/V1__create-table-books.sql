create table books(

    id bigint not null auto_increment,
    title varchar(100) not null,
    author varchar(100) not null,
    synopsis varchar(300) not null,
    price double not null,
    image varchar(80),
    score varchar (20) not null,
    status tinyint not null,

    primary key(id)

);