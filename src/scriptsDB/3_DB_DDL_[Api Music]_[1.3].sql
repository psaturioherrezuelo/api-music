/*	Angel	*/
INSERT INTO artistas (id_artista, artista) VALUES

	(1, 'Suite Soprano'),
	(2, 'Cheb Rüben'),
	(3, 'Cecilio G'),
	(4, 'Cruz Cafuné'),
	(5, 'Recycled J'),
	(6, 'Juancho Marqués'),
	(7, 'Estopa'),
	(8, 'Extremoduro'),
	(9, 'Delaossa'),
	(10, 'Costa')

;

INSERT INTO canciones (id_cancion, titulo, genero, lanzamiento, visualizaciones, precio, explicito) VALUES 

	(1, 'Por los siglos', 'Rap', '2012-05-05', 236866, 0.99, 0),
	(2, 'Empireo', 'Rap', '2014-05-05', 519219, 0.99, 0),
	(3, 'Love u mama', 'Rap', '2014-05-05', 507567, 0.99, 0),
	(4, 'Se joda la simbiosis', 'Rap', '2014-10-24', 625515, 0.99, 1),
	(5, 'El hortelano', 'Rap', '2018-02-06', 489616, 0.99, 0),
	(6, 'Tristeza', 'Rap', '2021-01-15', 72181, 0.99, 0),
	(7, 'NUM83RS', 'Drill', '2020-09-23', 425555, 0.99, 1),
	(8, '24 7', 'Trap', '2020-06-19', 1551348, 0.99, 1),
	(9, 'Gato', 'Trap', '2016-06-24', 34796, 0.99, 1),
	(10, 'Lo pues intentar', 'Rap', '2020-04-13', 1189352, 0.99, 1),
	(11, 'GuaGuancó', 'Guaguancó', '2019-07-12', 2124025, 0.99, 0),
	(12, 'Issey Miyake', 'Rap', '2020-12-05', 297999, 0.99, 1),
	(13, 'StoryFeeling', 'Rap', '2016-04-03', 938558, 0.99, 1),
	(14, 'Ven a pudrirte conmigo', 'Rap', '2012-06-03', 2919290, 0.99, 0),
	(15, 'Principe de nada', 'Rap', '2015-11-17', 258369, 0.99, 0),
	(16, 'Love', 'Rap', '2016-10-23', 1179030, 0.99, 1),
	(17, 'Cuando fue la ultima vez', 'Pop', '2019-05-10', 349862, 0.99, 0),
	(18, 'Rueda', 'Rap', '2017-09-17', 1242727, 0.99, 0),
	(19, 'Fuego', 'Pop Rock', '2019-05-31', 9486374, 0.99, 0),
	(20, 'Penas con rumba', 'Rumba', '2016-02-06', 8100639, 0.99, 0),
	(21, 'Vacaciones', 'Pop Rock', '2009-10-25', 7844646, 0.99, 0),
	(22, 'So payaso', 'Hard Rock', '1996-02-23', 14806548, 1.29, 1),
	(23, 'Si te vas', 'Hard Rock', '2011-05-24', 36251300, 11.99, 0),
	(24, 'Locura transtoria', 'Hard Rock', '2013-11-08', 2948868, 1.29, 0),
	(25, 'El Estanco', 'Rap', '2017-10-15', 1069789, 0.99, 1),
	(26, 'Venus', 'Rap', '2015-09-08', 261266, 0.99, 0),
	(27, 'Mirame asi', 'Rap', '2019-02-06', 1458511, 0.99, 1),
	(28, 'Maradona', 'Rap', '2015-11-12', 2764130, 0.99, 1),
	(29, 'Mi yemayá', 'Rap', '2014-11-12', 3428491, 0.99, 1),
	(30, 'Inadaptados', 'Rap', '2013-10-22', 3389053, 0.99, 1)

;
    
INSERT INTO discograficas (id_discografica, discografica) VALUES

	(1, 'Altafonte Network S.L.'),
	(2, 'The Orchard Music'),
	(3, 'TDPS'),
	(4, 'Poland Music'),
	(5, 'MÉCÈN Ent.'),
	(6, 'Recycled J'),
	(7, 'Suite Soprano'),
	(8, 'Warner Chappell'),
	(9, 'Peermusic'),
	(10, 'Sony Music'),
	(11, 'Warner Music Group'),
	(12, 'Spacehammu Records'),
	(13, 'Grimey Music')

;

INSERT INTO lanzamientos (id_cancion, id_artista) VALUES 

	(1, 1),
	(2, 1),
	(3, 1),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 3),
	(8, 3),
	(9, 3),
	(10, 4),
	(11, 4),
	(12, 4),
	(13, 5),
	(14, 5),
	(15, 5),
	(16, 6),
	(17, 6),
	(18, 6),
	(19, 7),
	(20, 7),
	(21, 7),
	(22, 8),
	(23, 8),
	(24, 8),
	(25, 9),
	(26, 9),
	(27, 9),
	(28, 10),
	(29, 10),
	(30, 10)

;

INSERT INTO contratos (id_cancion, id_discografica) VALUES 
    (1, 1),
    (2, 2),
    (3, 1),
    (4, 2),
    (5, 2),
    (6, 2),
    (7, 3),
    (8, 4),
    (9, 3),
    (10, 5),
    (11, 5),
    (12, 5),
    (13, 6),
    (14, 6),
    (15, 6),
    (16, 7),
    (17, 8),
    (18, 9),
    (19, 10),
    (20, 10),
    (21, 10),
    (22, 11),
    (23, 11),
    (24, 11),
    (25, 12),
    (26, 12),
    (27, 12),
    (28, 13),
    (29, 13),
    (30, 13)
	
;

INSERT INTO ceos (id_ceo, ceo, id_discografica) VALUES

	( 1, 'Mario Pato', 1),
	( 2, 'Brad Navin', 2),
	( 3, 'Joan Cecilia Ruiz', 3),
	( 4, 'Ethan Diamond', 4),
	( 5, 'Lex Luthorz', 5),
	( 6, 'Jorge Escorial', 6),
	( 7, 'Juancho Marques', 7),
	( 8, 'Guy Moot', 8),
	( 9, 'Ralph Iverson', 9),
	( 10, 'Rob Stringer',10),
	( 11, 'Stephen Cooper', 11),
	( 12, 'Daniel Martinez', 12),
	( 13, 'Pablo Moreno', 13)
	
;

/*	Ivan	*/
INSERT INTO canciones(id_cancion,titulo,genero,lanzamiento,visualizaciones,precio,explicito) VALUES 
	
	(31,"Dakiti","Reggaeton","2020-10-30",735032082,1.29,1),
	(32,"Callaita","Reggaeton","2020-05-31",698198801,1.29,1),
	(33,"La Dificil","Reggaeton","2020-02-29",177235493,1.29,1),
	(34,"Hey Mama","Electronica","2015-03-16",23000000,1.29,1),
	(35,"Titanium","Electro House-pop","2011-09-05",1440549445,1.29,0),
	(36,"Say My Name","Electronica-Dance","2018-10-26",812603922,1.29,1),
	(37,"Wake Me Up","Electronica-Dance","2013-06-28",2049651057,1.29,0),
	(38,"Levels","House Progresivo","2011-10-28",535384323,1.29,0),
	(39,"Hey Brother","Electronica","2013-10-09",222224875,1.29,0),
	(40,"Drop It Like It's Hot","Hip-Hop-rap","2004-09-12",181291000,1.29,1),
	(41,"Sexual Eruption","Hip-Hop-rap","2007-11-20",1589442,1.29,1),
	(42,"Sweat","Electronica-House","2011-03-19",195023382,1.29,0),
	(43,"Ella No Sigue Modas","Electronica","2012-03-13",17271653,1.29,0),
	(44,"Bailando Por Ahi","Electronica","2011-06-22",55083235,0.99,0),
	(45,"Mal De Amores","Pop","2013-06-17",110056051,1.29,0),
	(46,"Yummy","Pop","2020-01-04",603897867,1.29,0),
	(47,"Baby","Pop","2010-02-19",2471435759,1.29,0),
	(48,"Lonely","Pop","2020-10-16",113622995,1.29,1),
	(49,"Alone","Electro-Pop","2016-06-02",2027471672,1.29,0),
	(50,"Happier","Electro-Pop","2018-09-24",799153805,1.29,0),
	(51,"Friends","Electronica","2018-02-09",876877931,1.29,1),
	(52,"Con Calma","Pop","2019-01-24",2249198461,1.29,0),
	(53,"Dura","Reggaeton","2018-01-18",1734466722,1.29,0),
	(54,"Despacito","Reggaeton","2017-01-13",7308661032,1.29,0),
	(55,"Morado","Reggaeton","2020-01-10",202170827,1.29,0),
	(56,"Amarillo","Reggaeton","2020-03-20",154049482,1.29,0),
	(57,"Rojo","Reggaeton","2020-02-28",283152146,1.29,0),
	(58,"Baila Conmigo","Reggaeton","2021-01-29",86040915,1.29,0),
	(59,"Wolves","Electro-Pop","2017-11-18",427661750,1.29,0),
	(60,"Lose You to Love Me","Pop","2019-10-23",346132011,1.29,0)
	
;
		
INSERT INTO artistas(id_artista,artista) VALUES
	
	(11,"Bad Bunny"),
	(12,"David Guetta"),
	(13,"Avicii"),
	(14,"Snoop Dogg"),
	(15,"Juan magan"),
	(16,"Justin Bieber"),
	(17,"Marshmello"),
	(18,"Daddy Yankee"),
	(19,"JBalvin"),
	(20,"Selena Gomez")
	
;
		
INSERT INTO discograficas(id_discografica,discografica) VALUES

	(14,"Rimas Entertainment"), /*3 canciones bad bunny*/
	(15,"What A Music"), /*1 david guetta*/
	(16,"F*** ME I'M FAMOUS"),/*2 david guetta*/
	(17,"ParloPhone"),/*3 david guetta*/
	(18,"DIGITAL DISTRIBUTION PALESTINIAN TERRITORY OCCUPIED"),/*1 -3 avicii*/
	(19,"PINKSTAR RECORDS"),/*2 avicii*/
	(20,"Geffen Records"),/*1 -2 snoop dog*/
	(21,"Doggystyle Records"),/*3 snoop dog*/
	(22,"Columbia"), /*1-2 juan magan*/
	(23,"Universal Music Mexico"), /*3 juan magan*/
	(24,"Def Jam Recordings"), /*1 justin bieber*/
	(25,"Island Def Jam Music Group"),/*2 justin bieber*/
	(26,"Interscope Records"),/*3 justin bieber*/
	(27,"MONSTERCAT"), /*1 marshmellow*/
	(28,"Astralwerks"), /*2 marshmellow*/
	(29,"Atlantic Records UK"),/*3 marshmellow*/
	(30,"El Cartel Records"),/*1-2 daddy yankee*/
	(31,"Universal Music Group")/*3 daddy yankee - jbalvin*/
		
;		
		
INSERT INTO contratos (id_cancion,id_discografica) VALUES

	(31,14),/*bad bunny */
	(32,14),/*bad bunny */
	(33,14), /*bad bunny */
	(34,15),/*david guetta */
	(35,16),/*david guetta */
	(36,17),/*david guetta */
	(37,18),/*avicii */
	(38,19),/*avicii */
	(39,18),/*avicii */
	(40,20),/*snoop dog */
	(41,20),/*snoop dog */
	(42,21),/*snoop dog */
	(43,22),/*juan magan */
	(44,22),/*juan magan */
	(45,23),/*juan magan */
	(46,24), /*justin bieber*/
	(47,25),/*justin bieber*/
	(48,26),/*justin bieber*/
	(49,27), /*Marshmello*/
	(50,28),/*Marshmello */
	(51,29),/*Marshmello*/
	(52,30),/*Daddy Yankee*/
	(53,30),/*Daddy Yankee*/
	(54,31),/*Daddy Yankee*/
	(55,31),/*JBalvin*/
	(56,31),/*JBalvin*/
	(57,31),/*JBalvin*/
	(58,26),/*Selena Gomez*/
	(59,26),/*Selena Gomez*/
	(60,26)/*Selena Gomez*/
		
;

INSERT INTO lanzamientos (id_cancion,id_artista) VALUES
	
	(31,11),
	(32,11),
	(33,11),
	(34,12),
	(35,12),
	(36,12),
	(37,13),
	(38,13),
	(39,13),
	(40,14),
	(41,14),
	(42,14),
	(43,15),
	(44,15),
	(45,15),
	(46,16),
	(47,16),
	(48,16),
	(49,17),
	(50,17),
	(51,17),
	(52,18),
	(53,18),
	(54,18),
	(55,19),
	(56,19),
	(57,19),
	(58,20),
	(59,20),
	(60,20)
	
;

INSERT INTO ceos (id_ceo,ceo,id_discografica) VALUES
	
	(14,'Noah Assad',14),
	(15,'Eric Berglund',15),
	(16,'David Guetta',16),
	(17,'Carl Lindström',17),
	(18,'Ash',18),
	(19,'Federico Scavo',19),
	(20,'David Geffen',20),
	(21,'Snoop Dogg',21),
	(22,'Rob Stringer',22),
	(23,'Alfredo Delgadillo',23),
	(24,'Paul Rosenberg',24),
	(25,'Antonio Reid',25),
	(26,'John Janick',26),
	(27,'Mike Darlington',27),
	(28,'Brian Long',28),
	(29,'Ben Cook',29),
	(30,'Mireddys Gonzalez',30),
	(31,'Lucian Grainge',31)
	
;	

/*	Pablo	*/
		
INSERT INTO artistas (id_artista,artista) VALUES

	(21,"Imanbek"),
	(22,"Goodboys"),
	(23,"Martin Jensen"),
	(24,"Don Diablo"),
	(25,"Zonderling"),
	(26,"KSHMR"),
	(27,"Brooks"),
	(28,"Martin Garrix"),
	(29,"Mesto"),
	(30,"The Prodigy"),
	(31,"Headhunterz"),
	(32,"Oliver Heldens"),
	(33,"R3hab"),
	(34,"Morten")

;

INSERT INTO canciones (id_cancion, titulo, genero, lanzamiento, visualizaciones, precio , explicito) VALUES 

	(61,"Goodbye","Slap House","2020-12-18",3555768,1.29,0),
	(62,"I'm Just Feelin' (Du Du Du)","Slap House","2020-05-01",1991545,1.29,1),
	(63,"Dope","Electro House","2020-02-28",578125,1.29,0),
	(64,"Louder","Electro Pop","2019-09-13",37478,1.29,0),
	(65,"Mr. Brightside","Future House","2020-08-21",749667,1.29,0),
	(66,"Tunnel Vision (Don Diablo Edit)","Future House","2017-01-27",10799242,1.29,0),
	(67,"Inside My Head (Voices)","Future House","2020-05-01",1366911,1.29,0),
	(68,"Spannend","Future House","2021-02-12",34317,1.29,0),
	(69,"Imaginary","Dance / Electronica","2019-04-26",82689,1.29,0),
	(70,"Dhoom","Electro House","2016-05-27",1058219,1.29,0),
	(71,"Magic","Big Room","2018-11-02",903976,1.29,0),
	(72,"Dharma","Big Room","2017-12-01",35915052,1.29,0),
	(73,"Long Time","Future House","2020-07-24",459665,1.29,0),
	(74,"Byte","Future House","2017-04-07",111608004,1.29,0),
	(75,"Like I Do","Future House","2018-02-22",116491817,1.29,1),
	(76,"Animals","Big Room","2013-07-01",1487650213,1.29,1),
	(77,"Yottabyte","Big Room","2018-10-16",35635024,1.29,0),
	(78,"Step Up Your Game","Drum & Bass","2017-03-17",922021,1.29,0),
	(79,"The G.O.A.T.","Future House","2020-01-10",1148911,1.29,0),
	(80,"Smack My Bitch Up","UK Bass","2012-12-03",22051145,1.29,1),
	(81,"Voodoo People","Drum & Bass","1994-04-04",10937860,1.29,0),
	(82,"Omen","Drum & Bass","2009-02-16",42815579,1.29,0),
	(83,"Home","Hardstyle","2019-09-12",3731121,1.29,0),
	(84,"Won't Stop Rocking","Big Room","2015-11-06",70179954,1.29,0),
	(85,"Flamingo","Future House","2018-01-22",13702164,1.29,0),
	(86,"Melody","Future House","2015-04-13",33474296,1.29,0),
	(87,"Samurai (Go Hard)","Electro House","2014-02-21",48603334,1.29,0),
	(88,"All Comes Back To You","Future House","2019-10-25",2352126,1.29,1),
	(89,"Kill Me Slow","Big Room","2020-07-16",8839109,1.29,0),
	(90,"Bombardment","Big Room","2020-07-16",224408,1.29,0)

;

INSERT INTO lanzamientos (id_cancion,id_artista) VALUES
	
	/*Cancion*/
	(61,21),
	(61,22),
	/*Cancion*/
	(62,21),
	(62,23),
	/*Cancion*/
	(63,21),
	/*Cancion*/
	(64,23),
	/*Cancion*/
	(65,24),
	/*Cancion*/
	(66,24),
	(66,25),
	/*Cancion*/
	(67,24),
	/*Cancion*/
	(68,25),
	/*Cancion*/
	(69,25),
	/*Cancion*/
	(70,26),
	/*Cancion*/
	(71,26),
	/*Cancion*/
	(72,26),
	(72,31),
	/*Cancion*/
	(73,27),
	(73,29),
	/*Cancion*/
	(74,27),
	(74,28),
	/*Cancion*/
	(75,27),
	(75,28),
	(75,12),
	/*Cancion*/
	(76,28),
	/*Cancion*/
	(77,28),
	/*Cancion*/
	(78,29),
	/*Cancion*/
	(79,29),
	(79,32),
	/*Cancion*/
	(80,30),
	/*Cancion*/
	(81,30),
	/*Cancion*/
	(82,30),
	/*Cancion*/
	(83,31),
	/*Cancion*/
	(84,31),
	(84,33),
	/*Cancion*/
	(85,32),
	/*Cancion*/
	(86,32),
	/*Cancion*/
	(87,33),
	/*Cancion*/
	(88,33),
	/*Cancion*/
	(89,12),
	(89,34),
	/*Cancion*/
	(90,12),
	(90,34)

;

INSERT INTO discograficas (id_discografica,discografica) VALUES
	
	(32,"Positiva"),
	(33,"DHARMA (WMG)"),
	(34,"Virgin"),
	(35,"Hexagon"),
	(36,"Mau5trap"),
	(37,"Armada Music"),
	(38,"Spinnin' Records"),
	(39,"Epic Amsterdam"),
	(40,"Heldeep Records"),
	(41,"XL Recordings"),
	(42,"Take Me To The Hospital"),
	(43,"Art of Creation"),
	(44,"CYB3RPVNK")
	
;

INSERT INTO contratos (id_cancion,id_discografica) VALUES

	(61,32),
	(62,22),
	(63,33),
	(64,34),
	(65,35),
	(66,35),
	(67,35),
	(68,36),
	(69,37),
	(70,38),
	(71,33),
	(72,38),
	(73,38),
	(74,39),
	(75,17),
	(76,38),
	(77,39),
	(78,38),
	(79,40),
	(80,41),
	(81,41),
	(82,42),
	(83,43),
	(84,38),
	(85,40),
	(86,38),
	(87,38),
	(88,44),
	(89,17),
	(90,17)
	
;

INSERT INTO ceos (id_ceo,ceo,id_discografica) VALUES

	(32,"Nick Halkes",32),
	(33,"KSHMR",33),
	(34,"Richard Branson",34),
	(35,"Don Diablo",35),
	(36,"DeadMau5",36),
	(37,"Maykel Piron",37),
	(38,"Eelko van Kooten",38),
	(39,"Sylvia Rhone",39),
	(40,"Oliver Heldens",40),
	(41,"Richard Russell",41),
	(42,"The Prodigy",42),
	(43,"Headhunterz",43),
	(44,"R3hab",44)
	
;