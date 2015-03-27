DROP TABLE comptes;
DROP TABLE utilisateurs;
DROP TABLE adherents;
DROP TABLE transporteurs;

CREATE TABLE adherents(
	noAdh INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	prenomAdh CHAR(32) NOT NULL,
	nomAdh CHAR(32) NOT NULL,
	adrAdh CHAR(64) NOT NULL UNIQUE,
	MdPAdh CHAR(32),
	IORAdh CHAR(128)
);

CREATE TABLE transporteurs(
	noTransp INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	raisonSocialeTransp CHAR(64) NOT NULL,
	MdPTransp CHAR(64) NOT NULL
);

CREATE TABLE utilisateurs(
	noUtilisateur INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	noAdh INTEGER,
	noTransp INTEGER,
	RIB CHAR(32) NOT NULL UNIQUE,
	
	CONSTRAINT fk_noAdh FOREIGN KEY (noAdh) REFERENCES adherents(noAdh),
	CONSTRAINT fk_noTransp FOREIGN KEY (noTransp) REFERENCES transporteurs(noTransp)
);

CREATE TABLE comptes(
	noCompte INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	noUtilisateur INTEGER NOT NULL,
	solde DECIMAL(10, 2) NOT NULL,
);

/* Insertion des adherents */
INSERT INTO adherents VALUES (null, "Jean", "Moulin", "Sandrine Cabrole;1;chemin des lilas;1;1", "jeamou", "");
INSERT INTO adherents VALUES (null, "Pierre", "Didiou", "Pierre Didiou;5;chemin de la rosette;1;2", "piedid", "");
INSERT INTO adherents VALUES (null, "Sophie ", "Fran", "Sophie Fran;12;rue des hommes;3;2", "sohfra", "");

/* Insertion des transporteurs */
INSERT INTO transporteurs VALUES (null, "Maurice", "ricemau");
INSERT INTO transporteurs VALUES (null, "Brienne de Thorn", "stannis");
INSERT INTO transporteurs VALUES (null, "DeliTransp", "transpdeli");

/* Insertion des utilisateurs */
/* bind id utilisateurs et id adhérent */
INSERT INTO utilisateurs VALUES(null, 1, null, "132");
INSERT INTO utilisateurs VALUES(null, 2, null, "456");
INSERT INTO utilisateurs VALUES(null, 3, null, "5647");
/* bind id utilisateurs et id transporteurs */
INSERT INTO utilisateurs VALUES(null, null, 1, "1857");
INSERT INTO utilisateurs VALUES(null, null, 2, "598");
INSERT INTO utilisateurs VALUES(null, null, 3, "9267");

/* Insertion des comptes bancaires */
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noAdh = 1), 200);
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noAdh = 2), 0);
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noAdh = 3), 0);
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noTransp = 1), 0);
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noTransp = 2), 0);
INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noTransp = 3), 0);
