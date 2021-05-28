/*

	Procedimiento consulta general

*/

CREATE PROCEDURE consultarelaciones()
BEGIN

	SELECT id_cancion, titulo, genero, lanzamiento, visualizaciones, precio, ELT(explicito +1, "No", "Si"), group_concat(id_artista," - ", artista separator", ") AS artistas, id_discografica, discografica, id_ceo, ceo
	FROM artistas NATURAL JOIN lanzamientos NATURAL JOIN canciones NATURAL JOIN contratos NATURAL JOIN discograficas NATURAL JOIN ceos
	GROUP BY id_cancion;

END ;

/* Procedimientos para insertar en las interrelaciones desde java */
CREATE PROCEDURE ins_lanzamientos(IN song VARCHAR (80),IN art VARCHAR (80))
BEGIN
	
	DECLARE idart INT (15);
	DECLARE idsong INT (15);

	SELECT id_artista INTO idart FROM artistas WHERE artista = art;
	SELECT id_cancion INTO idsong FROM canciones WHERE titulo = song;
	
	INSERT INTO lanzamientos VALUES (idsong,idart);

END ;

CREATE PROCEDURE ins_contratos(IN song VARCHAR (80),IN disc VARCHAR (80))
BEGIN
	
	DECLARE iddisc INT (15);
	DECLARE idsong INT (15);

	SELECT id_discografica INTO iddisc FROM discograficas WHERE discografica = disc;
	SELECT id_cancion INTO idsong FROM canciones WHERE titulo = song;
	
	INSERT INTO contratos VALUES (idsong,iddisc);

END ;

/*

	Artistas

*/

/* Procedimiento para actualizar las visualizaciones y canciones de un artista y llamarlo en un trigger */
CREATE PROCEDURE calcular_artista(IN art INT(15))
BEGIN

	UPDATE artistas
	SET 
		vis_artista = (SELECT visualizaciones_artista(art)),
		total_canc_a = (SELECT canciones_artista(art))
	WHERE id_artista = art;

END ;

/* Procedimiento para comprobar si existe un artista y crearlo */
CREATE PROCEDURE comprobar_artista(IN art VARCHAR (80))
BEGIN

	DECLARE idart INT (15);
	SELECT id_artista INTO idart FROM artistas WHERE artista = art;
	IF idart IS NULL THEN
		
		INSERT INTO artistas (artista) VALUES (art);
	
	END IF;

END ;

/*	Funcion para calcular las canciones de cada artista */
CREATE FUNCTION canciones_artista (id INT(15)) RETURNS INT (15)
BEGIN

	DECLARE cant INT (15);
	
	SELECT COUNT(*) INTO cant
	FROM lanzamientos NATURAL JOIN artistas
	WHERE id_artista = id;
	
	RETURN cant;
	
END ;

/*	Funcion para calcular las visualizaciones de cada artista */
CREATE FUNCTION visualizaciones_artista (id INT(15)) RETURNS BIGINT(80)
BEGIN

	DECLARE vis BIGINT (80);
	
	SELECT SUM(visualizaciones) INTO vis
	FROM canciones NATURAL JOIN lanzamientos NATURAL JOIN artistas
	WHERE canciones.id_cancion = lanzamientos.id_cancion AND lanzamientos.id_artista = id
	GROUP BY id_artista;
	
	IF vis IS NULL THEN
		SET VIS=0;
	END IF;
	
	RETURN vis;

END ;

/*

	Discograficas

*/

/* Procedimiento para actualizar las visualizaciones y canciones de una discografica y llamarlo en un trigger */
CREATE PROCEDURE calcular_discografica(IN disc INT(15))
BEGIN

	UPDATE discograficas
	SET 
		vis_discografica = (SELECT visualizaciones_discografica(disc)),
		total_canc_d = (SELECT canciones_discografica(disc))
	WHERE id_discografica = disc;

END ;

/* Procedimiento para comprobar si existe una discografica y crearla */
CREATE PROCEDURE comprobar_discografica(IN disc VARCHAR (80))
BEGIN

	DECLARE iddisc INT (15);
	SELECT id_discografica INTO iddisc FROM discograficas WHERE discografica = disc;
	IF iddisc IS NULL THEN
		
		INSERT INTO discograficas (discografica) VALUES (disc);
	
	END IF;

END ;

/*	Funcion para calcular las canciones de cada Discografica llamada en un Trigger */
CREATE FUNCTION canciones_discografica (id INT(15)) RETURNS INT (15)
BEGIN

	DECLARE cant INT (15);
	
	SELECT COUNT(*) INTO cant
	FROM contratos NATURAL JOIN discograficas
	WHERE id_discografica = id;
	
	RETURN cant;
	
END ;

/*	Funcion para calcular las visualizaciones de cada discografica llamada en un Trigger */
CREATE FUNCTION visualizaciones_discografica (id INT(15)) RETURNS BIGINT(80)
BEGIN

	DECLARE vis BIGINT (80);
	
	SELECT SUM(visualizaciones) INTO vis
	FROM canciones NATURAL JOIN contratos NATURAL JOIN discograficas
	WHERE canciones.id_cancion = contratos.id_cancion AND contratos.id_discografica = id
	GROUP BY id_discografica;
	
	IF(ISNULL(vis))THEN
		SET VIS=0;
	END IF;

	RETURN vis;

END ;

/*

	TRIGGERS

*/

/* Prueba */
CREATE TRIGGER tr_update_cancion AFTER UPDATE ON canciones FOR EACH ROW
BEGIN

	DECLARE art int;
	DECLARE disc int;
	
	SET art = (SELECT id_artista FROM lanzamientos WHERE id_cancion = NEW.id_cancion GROUP BY id_cancion);
	
	SET disc = (SELECT id_discografica FROM contratos WHERE id_cancion = NEW.id_cancion GROUP BY id_cancion);
	
	UPDATE artistas
	SET 
		vis_artista = (SELECT visualizaciones_artista(art))
	WHERE id_artista = art;
	
	UPDATE discograficas
	SET 
		vis_discografica = (SELECT visualizaciones_discografica(disc))
	WHERE id_discografica = disc;
	
END ;

/* TRIGGERS Artistas */

CREATE TRIGGER tr_insert_artista AFTER INSERT ON lanzamientos FOR EACH ROW
BEGIN

	DECLARE art int;
	SET art = (SELECT id_artista FROM artistas WHERE id_artista = NEW.id_artista);
	
	CALL calcular_artista(art);

END ;

/* Actualizar el artista nuevo y viejo */
CREATE TRIGGER tr_update_artista AFTER UPDATE ON lanzamientos FOR EACH ROW
BEGIN

	DECLARE art int;
	
	SET art = (SELECT id_artista FROM artistas WHERE id_artista = OLD.id_artista);
	CALL calcular_artista(art);
	
	SET art = (SELECT id_artista FROM artistas WHERE id_artista = NEW.id_artista);
	CALL calcular_artista(art);

END ;

/* Actualizar la discografica despues de borrar */
CREATE TRIGGER tr_delete_artista AFTER DELETE ON lanzamientos FOR EACH ROW
BEGIN

	DECLARE art INT(15);
	
	SET art = (SELECT id_artista FROM artistas WHERE id_artista = OLD.id_artista);
	
	CALL calcular_artista(art);

END ;

/* TRIGGERS Discograficas */
CREATE TRIGGER tr_insert_discografica AFTER INSERT ON contratos FOR EACH ROW
BEGIN

	DECLARE disc int;
	SET disc = (SELECT id_discografica FROM discograficas WHERE id_discografica = NEW.id_discografica);
	
	CALL calcular_discografica(disc);

END ;

/* Actualizar la discografica nueva y vieja */
CREATE TRIGGER tr_update_discografica AFTER UPDATE ON contratos FOR EACH ROW
BEGIN

	DECLARE disc INT(15);
	
	SET disc = (SELECT id_discografica FROM discograficas WHERE id_discografica = OLD.id_discografica);
	
	CALL calcular_discografica(disc);
	
	SET disc = (SELECT id_discografica FROM discograficas WHERE id_discografica = NEW.id_discografica);
	
	CALL calcular_discografica(disc);
	
END ;

/* Actualizar la discografica despues de borrar */
CREATE TRIGGER tr_delete_discografica AFTER DELETE ON contratos FOR EACH ROW
BEGIN

	DECLARE disc INT(15);
	
	SET disc = (SELECT id_discografica FROM discograficas WHERE id_discografica = OLD.id_discografica);
	
	CALL calcular_discografica(disc);

END ;

/*

	FUNCIONES Extra

*/

/* Calcular todas las canciones explicitas comprendidas entre un rango de visualizaciones */
CREATE FUNCTION calc_explicitos (minim BIGINT(80),maxim BIGINT(80),explicit BOOLEAN) RETURNS INT (5)
BEGIN
	
	DECLARE cant INT (5);
	SELECT COUNT(*) INTO cant
	FROM canciones
	WHERE visualizaciones>=minim AND visualizaciones<=maxim AND explicito=explicit;
	RETURN cant;

END ;

/* Calcular cuantas canciones de un genero se lanzaron en una franja de tiempo */
CREATE FUNCTION calc_anuales (inicio DATE, fin DATE, genere VARCHAR (80)) RETURNS INT (5)
BEGIN

	DECLARE cant INT (5);
	SELECT COUNT(*) INTO cant
	FROM canciones
	WHERE lanzamiento >= inicio AND lanzamiento <= fin AND genero=genere;
	RETURN cant;

END ;