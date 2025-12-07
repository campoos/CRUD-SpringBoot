CREATE DATABASE spring_api;

USE spring_api;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    idade INT NOT NULL
);

CREATE TABLE carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    id_usuario INT NOT NULL,

    CONSTRAINT fk_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


select * from usuarios;