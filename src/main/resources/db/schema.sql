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

CREATE TABLE multas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_infracao VARCHAR(150) NOT NULL,
    data DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    local_ocorrido VARCHAR(200) NOT NULL,

    id_carro INT NOT NULL,
    CONSTRAINT fk_multa_carro
        FOREIGN KEY (id_carro)
        REFERENCES carros(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE cores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE carro_cor (
    id_carro INT NOT NULL,
    id_cor INT NOT NULL,

    PRIMARY KEY (id_carro, id_cor),

    CONSTRAINT fk_carro_cor_carro
        FOREIGN KEY (id_carro)
        REFERENCES carros(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_carro_cor_cor
        FOREIGN KEY (id_cor)
        REFERENCES cores(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

select * from usuarios;