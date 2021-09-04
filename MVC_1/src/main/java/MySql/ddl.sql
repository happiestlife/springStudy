create table spring5fs.customer(
        ID int auto_increment primary key,
        name varchar(100),
        age int,
        phoneNum varchar(11),
        email varchar(100),
        unique key(EMAIL)
)engine=InnoDB character set = utf8;