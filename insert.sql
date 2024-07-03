-- Inserts para la tabla tipoactor
INSERT INTO tipoactor (id, description) VALUES
(1, 'Principal'),
(2, 'Secundario'),
(3, 'Reparto');

-- Inserts para la tabla formato
INSERT INTO formato (id, description) VALUES
(1, 'DVD'),
(2, 'Blu-ray'),
(3, 'Digital');

-- Inserts para la tabla pais
INSERT INTO pais (id, description) VALUES
(1, 'Estados Unidos'),
(2, 'Reino Unido'),
(3, 'Francia');

-- Inserts para la tabla genero
INSERT INTO genero (id, description) VALUES
(1, 'Acción'),
(2, 'Comedia'),
(3, 'Drama'),
(4, 'Ciencia Ficción');

-- Inserts para la tabla pelicula
INSERT INTO pelicula (id, codinterno, nombre, duracion, sinopsis) VALUES
(1, '00001', 'Titanic', '195 minutos', 'Pelicula del Titanic.'),
(2, '00002', 'Jurassic Park', '127 minutos', 'Parque con dinosaurios.');

-- Inserts para la tabla peliculaformato
INSERT INTO peliculaformato (idpelicula, idformato, cantidad) VALUES
(1, 1, 50),   
(1, 2, 30),   
(2, 1, 40),   
(2, 3, 20);  

-- Inserts para la tabla actor
INSERT INTO actor (id, nombre, idnacionalidad, edad, idgenero) VALUES
(1, 'Leonardo DiCaprio', 1, 47, 1),  
(2, 'Kate Winslet', 2, 46, 3),       
(3, 'Sam Neill', 3, 75, 1);          

-- Inserts para la tabla peliculaprotagonista
INSERT INTO peliculaprotagonista (idpelicula, idprotagonista, idtipoactor) VALUES
(1, 1, 1),  
(1, 2, 1),  
(2, 3, 1);   

