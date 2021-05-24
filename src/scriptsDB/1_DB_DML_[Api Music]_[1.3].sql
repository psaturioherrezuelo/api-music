DROP DATABASE IF EXISTS apimusic;

CREATE DATABASE apimusic CHARACTER SET utf8 COLLATE utf8_spanish2_ci;

USE apimusic;

CREATE TABLE canciones (

	id_cancion INT (15) PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR (80),
	genero VARCHAR (80),
	lanzamiento DATE NOT NULL,
	visualizaciones BIGINT (80),
	precio DEC (5,2),
	explicito BOOLEAN,
	CONSTRAINT precio CHECK (precio >= 0.00 AND precio <= 11.99),
	CONSTRAINT visualizaciones CHECK (visualizaciones >= 0),
	CONSTRAINT lanzamiento CHECK (lanzamiento >= "1900-01-01"),
	CHECK (explicito >= 0 AND explicito <=1)

);

CREATE TABLE artistas (
	
	id_artista INT (15) PRIMARY KEY AUTO_INCREMENT,
	artista VARCHAR (80),
	vis_artista BIGINT (80) DEFAULT 0,
	total_canc_a INT (15) DEFAULT 0
	
);

CREATE TABLE discograficas (

	id_discografica INT (15) PRIMARY KEY AUTO_INCREMENT,
	discografica VARCHAR (80),
	vis_discografica BIGINT (80) DEFAULT 0,
	total_canc_d INT (15) DEFAULT 0

);

CREATE TABLE contratos (

	id_cancion INT (15),
	id_discografica INT (15),
	PRIMARY KEY (id_cancion,id_discografica),
	FOREIGN KEY (id_cancion) REFERENCES canciones (id_cancion) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (id_discografica) REFERENCES discograficas (id_discografica) ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE lanzamientos (

	id_cancion INT (15),
	id_artista INT (15),
	PRIMARY KEY (id_cancion, id_artista),
	FOREIGN KEY (id_cancion) REFERENCES canciones (id_cancion) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (id_artista) REFERENCES artistas (id_artista) ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE ceos (

	id_ceo INT (15) PRIMARY KEY AUTO_INCREMENT,
	ceo VARCHAR (80),
	id_discografica INT (15),
	FOREIGN KEY (id_discografica) REFERENCES discograficas (id_discografica) ON UPDATE CASCADE,
	UNIQUE KEY (id_discografica)
	
);

CREATE TABLE usuarios (

	usuario VARCHAR (50) NOT NULL,
	password VARCHAR (50) NOT NULL,
	nombre VARCHAR (50) DEFAULT "",
	apellidos VARCHAR (50) DEFAULT "",
	email VARCHAR (50) NOT NULL,
	direccion VARCHAR (50) DEFAULT "",
	fregistro DATE NOT NULL,
	administrador BOOLEAN DEFAULT 0
	
);