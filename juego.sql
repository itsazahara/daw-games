CREATE TABLE juego(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	genero VARCHAR(100) NOT NULL,
	compania VARCHAR(100) NOT NULL,
	plataforma VARCHAR(100) NOT NULL,
	precio DECIMAL(6,2) NOT NULL,
	descargas INT NOT NULL,
	fecha_lanzamiento DATE,
	tipo ENUM('BASE', 'EXPANSION', 'DLC') DEFAULT 'BASE',
	completado BOOLEAN DEFAULT FALSE
);

INSERT INTO juegos (nombre, genero, compañia, plataforma, precio, numero_descargas, fecha_lanzamiento, tipo_juego, completado) VALUES 
	('Elden Ring', 'RPG', 'FromSoftware', 'PS5', 69.99, 1200000, '2022-02-25', 'BASE', FALSE),
	('World of Warcraft: Shadowlands', 'MMORPG', 'Blizzard Entertainment', 'PC', 39.99, 3000000, '2020-11-23', 'EXPANSION', TRUE),
	('Horizon Zero Dawn: The Frozen Wilds', 'Acción-Aventura', 'Guerrilla Games', 'PS4', 19.99, 800000, '2017-11-07', 'DLC', TRUE),
	('Fortnite', 'Battle Royale', 'Epic Games', 'PC', 0.00, 35000000, '2017-07-25', 'BASE', FALSE);