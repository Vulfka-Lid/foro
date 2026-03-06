-- 1. Crear la tabla de usuarios primero
create table usuarios(
                         id bigint not null auto_increment,
                         nombre varchar(100) not null,
                         email varchar(100) not null unique,
                         contrasena varchar(300) not null,
                         primary key(id)
);

create table topicos(
                        id bigint not null auto_increment,
                        titulo varchar(100) not null unique,
                        mensaje varchar(500) not null,
                        fecha date not null,
                        estado boolean not null,
                        usuario_id bigint not null,
                        curso varchar(100) not null,

                        primary key(id),
                        constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
);