BEGIN TRANSACTION;
DROP TABLE IF EXISTS `Pacientes`;
CREATE TABLE IF NOT EXISTS `Pacientes` (
	`rut`	INT NOT NULL,
	`dv`	CHAR ( 1 ) DEFAULT NULL COLLATE BINARY,
	`nombres`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`apellidos`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`fechaNac`	DATE DEFAULT NULL,
	`telefono`	INTEGER DEFAULT NULL,
	`nombreContacto`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`telefonoContacto`	INTEGER DEFAULT NULL,
	`sexo`	CHAR ( 1 ) DEFAULT NULL COLLATE BINARY,
	PRIMARY KEY(`rut`)
);
INSERT INTO `Pacientes` VALUES (1461946,'1','Donald','Trump','1946-06-14',666666,'Hija',4568785,'M');
INSERT INTO `Pacientes` VALUES (4567852,'0','Carla','Peña','1988-05-24',64587598,'Papá',4585789,'F');
DROP TABLE IF EXISTS `Medicos`;
CREATE TABLE IF NOT EXISTS `Medicos` (
	`rut`	INT NOT NULL,
	`dv`	CHAR ( 1 ) DEFAULT NULL COLLATE BINARY,
	`nombres`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`apellidos`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`fechaNac`	DATE DEFAULT NULL,
	`telefono`	INTEGER DEFAULT NULL,
	`email`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`especialidad`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	PRIMARY KEY(`rut`)
);
INSERT INTO `Medicos` VALUES (1234545,'3','Stephen','Strange','1963-12-24',4567896,'tiempo@wea.com','Neurocirujía');
INSERT INTO `Medicos` VALUES (4567888,'1','Gregory','House','1980-12-24',456789456,'emaiqk@gmail.comqwe','Carnicería');
INSERT INTO `Medicos` VALUES (7857895,'5','John','Watson','1955-12-24',55122419,'emailcito@akw.kr','General');
INSERT INTO `Medicos` VALUES (10101010,'4','Sara','Tancredi','1985-10-15',54685798,'sara@tra.cl','General');
INSERT INTO `Medicos` VALUES (12456785,'8','Derek','Shepherd','1966-12-24',13011966,'emailcito@akw.kr','Neurocirujía');
INSERT INTO `Medicos` VALUES (17456456,'6','Shaun','Murphy','1989-12-24',45454545,'emailcito@akw.kr','General');
INSERT INTO `Medicos` VALUES (12545656,'1','Julius','Hibbert','1975-10-15',54685798,'hibbert@weaq.com','Pediatría');
DROP TABLE IF EXISTS `ListaPacientes`;
CREATE TABLE IF NOT EXISTS `ListaPacientes` (
	`RutMedico`	INTEGER,
	`RutPaciente`	INTEGER,
	PRIMARY KEY(`RutMedico`,`RutPaciente`)
);
INSERT INTO `ListaPacientes` VALUES (10101010,1461946);
INSERT INTO `ListaPacientes` VALUES (10101010,4567852);
DROP TABLE IF EXISTS `Enfermeros`;
CREATE TABLE IF NOT EXISTS `Enfermeros` (
	`rut`	INT NOT NULL,
	`dv`	CHAR ( 1 ) DEFAULT NULL COLLATE BINARY,
	`nombres`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`apellidos`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	`fechaNac`	DATE DEFAULT NULL,
	`telefono`	INTEGER DEFAULT NULL,
	`email`	VARCHAR ( 50 ) DEFAULT NULL COLLATE BINARY,
	PRIMARY KEY(`rut`)
);
INSERT INTO `Enfermeros` VALUES (1000000,'9','Irena','Sendler','1910-01-05',0,'irena@sendler.com');
INSERT INTO `Enfermeros` VALUES (1000100,'5','Aribert','Heim','1914-01-05',0,'d@c.muerte');
INSERT INTO `Enfermeros` VALUES (12345678,'5','Ana','Mar','1978-05-24',45678912,'email2@tuemail.com');
INSERT INTO `Enfermeros` VALUES (78945612,'0','Juan Al','Perez','1958-05-24',12345678,'email@user.cl');
COMMIT;