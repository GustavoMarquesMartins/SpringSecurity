create table medico
(
    id     int primary key auto_increment not null,
    nome   varchar(45) not null,
    email  varchar(45) not null unique,
    status TINYINT(1)
)