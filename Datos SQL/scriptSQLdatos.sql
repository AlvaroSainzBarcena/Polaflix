use esquema_polaflix;

insert into usuario values('alvaro','root','Cuenta-Bancaria-Alvaro',false);

insert into categoria values(1,0.50,'Estandar');
insert into categoria values(2,0.75,'Silver');
insert into categoria values(3,1.50,'Gold');

insert into serie values(1,'P','Prison Break',3);
insert into serie values(2,'B','Breaking Bad',2);
insert into serie values(3,'V','Vikings',1);

#Se me olvido el atributo SINOPSIS
UPDATE `esquema_polaflix`.`serie` SET `sinopsis`='Sinopsis de Prison Break' WHERE `id`='1';
UPDATE `esquema_polaflix`.`serie` SET `sinopsis`='Sinopsis de Breaking Bad' WHERE `id`='2';
UPDATE `esquema_polaflix`.`serie` SET `sinopsis`='Sinopsis de Vikings' WHERE `id`='3';

insert into creador values(1,'Scheuring','Paul'); #Creador de Prison Break
insert into creador values(2,'Gilligan','Vince'); #Creador de Breaking Bad
insert into creador values(3,'Hirst','Michael'); #Creador de Vikings

insert into actor values(1,'Earl Miller','Wentworth'); #Actor de Prison Break
insert into actor values(2,'Haakon Myrtvedt Purcell','Dominic'); #Actor de Prison Break
insert into actor values(3,'Lee Cranston','Bryan'); #Actor de Breaking Bad
insert into actor values(4,'Paul Sturtevant','Aaron'); #Actor de Breaking Bad
insert into actor values(5,'Fimmel','Travis'); #Actor de Vikings
insert into actor values(6,'Winnick','Katheryn'); #Actriz de Vikings

insert into serie_actores_principales values(1,1);
insert into serie_actores_principales values(1,2);
insert into serie_actores_principales values(2,3);
insert into serie_actores_principales values(2,4);
insert into serie_actores_principales values(3,5);
insert into serie_actores_principales values(3,6);

insert into serie_creadores values(1,1);
insert into serie_creadores values(2,2);
insert into serie_creadores values(3,3);

insert into temporada values(1,1,1);
insert into temporada values(2,2,1);
insert into temporada values(3,3,1);
insert into temporada values(4,4,1);
insert into temporada values(5,5,1);
insert into temporada values(6,1,2);
insert into temporada values(7,2,2);
insert into temporada values(8,3,2);
insert into temporada values(9,4,2);
insert into temporada values(10,5,2);
insert into temporada values(11,1,3);
insert into temporada values(12,2,3);
insert into temporada values(13,3,3);
insert into temporada values(14,4,3);
insert into temporada values(15,5,3);

insert into serie_temporadas values(1,1);
insert into serie_temporadas values(1,2);
insert into serie_temporadas values(1,3);
insert into serie_temporadas values(1,4);
insert into serie_temporadas values(1,5);
insert into serie_temporadas values(2,6);
insert into serie_temporadas values(2,7);
insert into serie_temporadas values(2,8);
insert into serie_temporadas values(2,9);
insert into serie_temporadas values(2,10);
insert into serie_temporadas values(3,11);
insert into serie_temporadas values(3,12);
insert into serie_temporadas values(3,13);
insert into serie_temporadas values(3,14);
insert into serie_temporadas values(3,15);

insert into capitulo values(1,'Descripción del capítulo 1, temporada 1 de Prison Break','http://www.enlace.com',1,'Pilot',1,1);
insert into capitulo values(2,'Descripción del capítulo 2, temporada 1 de Prison Break','http://www.enlace.com',2,'Allen',1,1);
insert into capitulo values(3,'Descripción del capítulo 3, temporada 1 de Prison Break','http://www.enlace.com',3,'Cell Test',1,1);
insert into capitulo values(4,'Descripción del capítulo 1, temporada 2 de Prison Break','http://www.enlace.com',1,'Manhunt',1,2);
insert into capitulo values(5,'Descripción del capítulo 2, temporada 2 de Prison Break','http://www.enlace.com',2,'Otis',1,2);
insert into capitulo values(6,'Descripción del capítulo 3, temporada 2 de Prison Break','http://www.enlace.com',3,'Scan',1,2);
insert into capitulo values(7,'Descripción del capítulo 1, temporada 3 de Prison Break','http://www.enlace.com',1,'Orientation',1,3);
insert into capitulo values(8,'Descripción del capítulo 2, temporada 3 de Prison Break','http://www.enlace.com',2,'Fire/Water',1,3);
insert into capitulo values(9,'Descripción del capítulo 3, temporada 3 de Prison Break','http://www.enlace.com',3,'Call Waiting',1,3);

insert into capitulo values(10,'Descripción del capítulo 1, temporada 1 de Breaking Bad','http://www.enlace.com',1,'Pilot',2,1);
insert into capitulo values(11,'Descripción del capítulo 2, temporada 1 de Breaking Bad','http://www.enlace.com',2,'Cat in the Bag...',2,1);
insert into capitulo values(12,'Descripción del capítulo 3, temporada 1 de Breaking Bad','http://www.enlace.com',3,'...And the Bag in the River',2,1);
insert into capitulo values(13,'Descripción del capítulo 1, temporada 2 de Breaking Bad','http://www.enlace.com',1,'Seven Thrity-Seven',2,2);
insert into capitulo values(14,'Descripción del capítulo 2, temporada 2 de Breaking Bad','http://www.enlace.com',2,'Grilled',2,2);
insert into capitulo values(15,'Descripción del capítulo 3, temporada 2 de Breaking Bad','http://www.enlace.com',3,'Bit by a Dead Bee',2,2);
insert into capitulo values(16,'Descripción del capítulo 1, temporada 3 de Breaking Bad','http://www.enlace.com',1,'No more',2,3);
insert into capitulo values(17,'Descripción del capítulo 2, temporada 3 de Breaking Bad','http://www.enlace.com',2,'Horse without name',2,3);
insert into capitulo values(18,'Descripción del capítulo 3, temporada 3 de Breaking Bad','http://www.enlace.com',3,'I.F.T.',2,3);

insert into capitulo values(19,'Descripción del capítulo 1, temporada 1 de Vikings','http://www.enlace.com',1,'Rites of Passage',3,1);
insert into capitulo values(20,'Descripción del capítulo 2, temporada 1 de Vikings','http://www.enlace.com',2,'Wrath of the Northmen',3,1);
insert into capitulo values(21,'Descripción del capítulo 3, temporada 1 de Vikings','http://www.enlace.com',3,'Dispossessed',3,1);
insert into capitulo values(22,'Descripción del capítulo 1, temporada 2 de Vikings','http://www.enlace.com',1,'Brothers War',3,2);
insert into capitulo values(23,'Descripción del capítulo 2, temporada 2 de Vikings','http://www.enlace.com',2,'Invasion',3,2);
insert into capitulo values(24,'Descripción del capítulo 3, temporada 2 de Vikings','http://www.enlace.com',3,'Treachery',3,2);
insert into capitulo values(25,'Descripción del capítulo 1, temporada 3 de Vikings','http://www.enlace.com',1,'Mercenary',3,3);
insert into capitulo values(26,'Descripción del capítulo 2, temporada 3 de Vikings','http://www.enlace.com',2,'The Wanderer',3,3);
insert into capitulo values(27,'Descripción del capítulo 3, temporada 3 de Vikings','http://www.enlace.com',3,'Warriors Fate',3,3);

insert into serie_capitulos values(1,1);
insert into serie_capitulos values(1,2);
insert into serie_capitulos values(1,3);
insert into serie_capitulos values(1,4);
insert into serie_capitulos values(1,5);
insert into serie_capitulos values(1,6);
insert into serie_capitulos values(1,7);
insert into serie_capitulos values(1,8);
insert into serie_capitulos values(1,9);
insert into serie_capitulos values(2,10);
insert into serie_capitulos values(2,11);
insert into serie_capitulos values(2,12);
insert into serie_capitulos values(2,13);
insert into serie_capitulos values(2,14);
insert into serie_capitulos values(2,15);
insert into serie_capitulos values(2,16);
insert into serie_capitulos values(2,17);
insert into serie_capitulos values(2,18);
insert into serie_capitulos values(3,19);
insert into serie_capitulos values(3,20);
insert into serie_capitulos values(3,21);
insert into serie_capitulos values(3,22);
insert into serie_capitulos values(3,23);
insert into serie_capitulos values(3,24);
insert into serie_capitulos values(3,25);
insert into serie_capitulos values(3,26);
insert into serie_capitulos values(3,27);

insert into temporada_capitulos values(1,1);
insert into temporada_capitulos values(1,2);
insert into temporada_capitulos values(1,3);
insert into temporada_capitulos values(2,4);
insert into temporada_capitulos values(2,5);
insert into temporada_capitulos values(2,6);
insert into temporada_capitulos values(3,7);
insert into temporada_capitulos values(3,8);
insert into temporada_capitulos values(3,9);
insert into temporada_capitulos values(4,10);
insert into temporada_capitulos values(4,11);
insert into temporada_capitulos values(4,12);
insert into temporada_capitulos values(5,13);
insert into temporada_capitulos values(5,14);
insert into temporada_capitulos values(5,15);
insert into temporada_capitulos values(6,16);
insert into temporada_capitulos values(6,17);
insert into temporada_capitulos values(6,18);
insert into temporada_capitulos values(7,19);
insert into temporada_capitulos values(7,20);
insert into temporada_capitulos values(7,21);
insert into temporada_capitulos values(8,22);
insert into temporada_capitulos values(8,23);
insert into temporada_capitulos values(8,24);
insert into temporada_capitulos values(9,25);
insert into temporada_capitulos values(9,26);
insert into temporada_capitulos values(9,27);





