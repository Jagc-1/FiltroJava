
-- -----------------------------------------------------
-- Database cinecampus
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS cinecampus;
USE cinecampus;

-- -----------------------------------------------------
-- Table tipoactor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipoactor (
  id INT NOT NULL,
  description VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table formato
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS formato (
  id INT NOT NULL,
  description VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pais
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pais (
  id INT NOT NULL,
  description VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table genero
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS genero (
  id INT NOT NULL,
  description VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pelicula
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pelicula (
  id INT NOT NULL,
  codinterno VARCHAR(5) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  duracion VARCHAR(20) NOT NULL,
  sinopsis TEXT NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table peliculaformato
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS peliculaformato (
  idpelicula INT NOT NULL,
  idformato INT NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (idpelicula,idformato),
  CONSTRAINT fk_peliculaformato_pelicula
    FOREIGN KEY (idpelicula)
    REFERENCES pelicula (id),
  CONSTRAINT fk_peliculaformato_formato
    FOREIGN KEY (idformato)
    REFERENCES formato (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table actor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS actor (
  id INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  idnacionalidad INT NOT NULL,
  edad INT NOT NULL,
  idgenero INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_actor_genero
    FOREIGN KEY (idgenero)
    REFERENCES genero (id),
  CONSTRAINT fk_actor_pais
    FOREIGN KEY (idnacionalidad)
    REFERENCES pais (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table peliculaprotagonista
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS peliculaprotagonista (
  idpelicula INT NOT NULL,
  idprotagonista INT NOT NULL,
  idtipoactor INT NOT NULL,
    PRIMARY KEY (idpelicula,idprotagonista),
  CONSTRAINT fk_peliculaprotagonista_pelicula
    FOREIGN KEY (idpelicula)
    REFERENCES pelicula (id),
  CONSTRAINT fk_peliculaprotagonista_actor
    FOREIGN KEY (idprotagonista)
    REFERENCES actor (id),
   CONSTRAINT fk_peliculaformato_tipoactor
    FOREIGN KEY (idtipoactor)
    REFERENCES tipoactor (id))
ENGINE = InnoDB;

