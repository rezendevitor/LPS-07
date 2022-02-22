CREATE DATABASE cadastro; 

USE cadastro;

CREATE TABLE administrador (
  nome varchar(255) NOT NULL,
  cpf varchar(45) NOT NULL,
  telefone varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  sexo varchar(45) NOT NULL,
  data_nasc date NOT NULL,
  salario float NOT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE cliente (
  nome varchar(255) NOT NULL,
  cpf varchar(45) NOT NULL,
  telefone varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  sexo varchar(45) NOT NULL,
  data_nasc date NOT NULL,
  endereco varchar(255) NOT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE leiturista (
  nome varchar(255) NOT NULL,
  cpf varchar(45) NOT NULL,
  telefone varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  sexo varchar(45) NOT NULL,
  data_nasc date NOT NULL,
  salario float NOT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE rede (
  id int NOT NULL AUTO_INCREMENT,
  tipo varchar(45) NOT NULL,
  bairro varchar(45) NOT NULL,
  alcance int NOT NULL,
  consumo float NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE servico (
  id int NOT NULL AUTO_INCREMENT,
  tipo varchar(45) NOT NULL,
  valor float NOT NULL,
  data date NOT NULL,
  contratante varchar(45) NOT NULL,
  local int NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE unidade_consumidora (
  id int NOT NULL AUTO_INCREMENT,
  tipo varchar(45) NOT NULL,
  endereco varchar(255) NOT NULL,
  proprietario varchar(45) NOT NULL,
  consumo float NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO cadastro.administrador
(nome, cpf, telefone, email, senha, sexo, data_nasc, salario)
VALUES('Marcos', '838.181.860-57', '(32) 91234-5678', 'marquin@email.com', '123456789', 'Masculino', '2000-01-01', '400');

INSERT INTO cadastro.administrador
(nome, cpf, telefone, email, senha, sexo, data_nasc, salario)
VALUES('Laura', '914.424.360-00', '(32) 91122-3344', 'laurinha@email.com', '87654321', 'Feminino', '2000-05-03', '600');

INSERT INTO cadastro.administrador
(nome, cpf, telefone, email, senha, sexo, data_nasc, salario)
VALUES('Glória', '744.187.690-72', '(32) 91111-2222', 'glorinha@email.com', 'a1b2c3d4', 'Feminino', '1945-02-02', '2000');

INSERT INTO cadastro.administrador
(nome, cpf, telefone, email, senha, sexo, data_nasc, salario)
VALUES('Geraldo', '563.428.380-97', '(32) 97777-8888', 'geraldin@email.com', 'x16y32z64', 'Masculino', '1938-04-04', '3000');