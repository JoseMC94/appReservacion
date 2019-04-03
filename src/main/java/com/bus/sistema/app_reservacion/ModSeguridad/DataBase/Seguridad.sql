SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Persona;
CREATE TABLE Persona (
  PersonaId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Nombres varchar(60) NOT NULL,
  Paterno varchar(60) ,
  Materno varchar(60) ,
  NombreCompleto varchar(255) NOT NULL,
  DNI varchar(8) NOT NULL,
  Celular varchar(10) ,
  Correo varchar(100) ,
  Sexo enum('F','M') DEFAULT 'F',
  FechaNacimiento date,
  Direccion varchar(512),
  Referencia varchar(512)
);
INSERT INTO persona VALUES ('1', 'Administrador', 'Administrador', 'Administrador', 'Administrador', '99999999', null, null, 'M', null,null,null);


DROP TABLE IF EXISTS Usuario;
create table Usuario(
	UsuarioId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PersonaId int(11) NULL,
	Nombre varchar(60) NOT NULL,
	Clave varchar(60) NOT NULL,
	Activo bit(1) NOT NULL DEFAULT b'1',
    IndCambio bit(1) NOT NULL DEFAULT b'1',
	FOREIGN KEY(PersonaId) REFERENCES Persona(PersonaId) on DELETE no action on UPDATE CASCADE,
    CargoId int(11) ,
    FOREIGN KEY(CargoId) REFERENCES Cargo(CargoId) on DELETE no action on UPDATE CASCADE,
    OficinaId int(11) ,
    FOREIGN KEY(OficinaId) REFERENCES Oficina(OficinaId) on DELETE no action on UPDATE CASCADE
);
INSERT INTO usuario VALUES ('1', '1', 'ADMIN', '202cb962ac59075b964b07152d234b70', 1, 0,1,2);

DROP TABLE IF EXISTS rol;
create table rol(
	RolId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Denominacion VARCHAR(100) NOT NULL 
);
INSERT INTO rol VALUES (1, 'ADMINISTRADOR');
INSERT INTO rol VALUES (2, 'SEGURIDAD');
INSERT INTO rol VALUES (3, 'MEDICO');
INSERT INTO rol VALUES (4, 'CAJERO');

DROP TABLE IF EXISTS Usuario_Rol;
CREATE TABLE Usuario_Rol(
	Id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	UsuarioId int(11) NOT NULL ,
  FOREIGN KEY(UsuarioId) REFERENCES Usuario(UsuarioId) on DELETE no action on UPDATE CASCADE,
	RolId INT(11) NOT NULL ,
  FOREIGN KEY(RolId) REFERENCES Rol(RolId) on DELETE no action on UPDATE CASCADE
	
);
INSERT INTO usuario_rol VALUES (1,1,1);

DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
  MenuId int(11) PRIMARY KEY,
  Denominacion varchar(50) DEFAULT NULL,
  Modulo varchar(50) DEFAULT NULL,
  Icono varchar(200) DEFAULT NULL,
  IndPadre bit(1) DEFAULT NULL,  
  Referencia int(11) DEFAULT NULL
);
INSERT INTO menu VALUES (1, 'Mantenimientos', 'Oficina', 'mdi-action-settings', 1, null);
INSERT INTO menu VALUES (2, 'PersonaRepository', 'PersonaRepository', 			null, 0, 1);
INSERT INTO menu VALUES (3, 'Mantenimiento', 'Mantenimiento',null, 0, 1);
INSERT INTO menu VALUES (4, 'Articulo', 'Articulo', 			null, 0, 1);

INSERT INTO menu VALUES (10, 'Seguridad', 'UsuarioController','mdi-hardware-security', 1, null);
INSERT INTO menu VALUES (11, 'Usuarios', 'UsuarioController', 	null,0, 10);
INSERT INTO menu VALUES (12, 'Roles', 'Rol', 			null,0, 10);

INSERT INTO menu VALUES (20, 'Clinica', 'Citas', 'mdi-action-book', 1, null);
INSERT INTO menu VALUES (21, 'Cita', 'Cita', null, 0, 20);
INSERT INTO menu VALUES (22, 'Atencion', 'Atencion', null, 0, 20);
INSERT INTO menu VALUES (23, 'Topico', 'Topico', 	null, 0, 20);
INSERT INTO menu VALUES (24, 'Reportes', 'Informe', 		null, 0, 20);
INSERT INTO menu VALUES (25, 'Medico', 'Medico', 		null, 0, 20);
INSERT INTO menu VALUES (26, 'Paciente', 'Paciente', 		null, 0, 20);
INSERT INTO menu VALUES (27, 'Configuracion', 'Config', 		null, 0, 20);
INSERT INTO menu VALUES (28, 'Programacion', 'Programacion', 		null, 0, 20);


INSERT INTO menu VALUES (30, 'Caja', 		'Cajadiario', 	'mdi-action-book', 	1, null);
INSERT INTO menu VALUES (31, 'Diario', 		'Diario', 		null, 0, 30);
INSERT INTO menu VALUES (32, 'Caja Diario', 'Cajadiario', 	null, 0, 30);

INSERT INTO menu VALUES (40, 'Oficina', 		'Oficina', 	'mdi-action-book', 	1, null);
INSERT INTO menu VALUES (41, 'Bandeja', 		'Bandeja', 		null, 0, 40);

DROP TABLE IF EXISTS rol_menu;
CREATE TABLE rol_menu(
	Id int(11) primary key AUTO_INCREMENT,	
	RolId int(11) NOT NULL ,
	FOREIGN KEY(RolId) REFERENCES Rol(RolId) on DELETE no action on UPDATE CASCADE,
    MenuId int(11) NOT NULL ,
	FOREIGN KEY(MenuId) REFERENCES Menu(MenuId) on DELETE no action on UPDATE CASCADE
);
INSERT INTO rol_menu(MenuId,RolId) VALUES (1, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (2, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (3, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (4, 1);


INSERT INTO rol_menu(MenuId,RolId) VALUES (10, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (11, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (12, 1);

INSERT INTO rol_menu(MenuId,RolId) VALUES (20, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (21, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (22, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (23, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (24, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (25, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (26, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (27, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (28, 1);

INSERT INTO rol_menu(MenuId,RolId) VALUES (30, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (31, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (32, 1);

INSERT INTO rol_menu(MenuId,RolId) VALUES (40, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (41, 1);

-- rol medico
INSERT INTO rol_menu(MenuId,RolId) VALUES (20, 3);
INSERT INTO rol_menu(MenuId,RolId) VALUES (22, 3);

/*
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO user(username,enabled,password) VALUES ('admin',1,'$2a$10$Bs6brtlLYJULigF57keOaOiMotCfCDlfYic3FxYZLSESopEmtL.c2');
INSERT INTO user(username,enabled,password) VALUES ('user',1,'$$2a$10$2uTgaREu0gAEIJooAkVG8ep5ByPRbOPPNhNVek7n3QqgUG3T7TTJG');

DROP TABLE IF EXISTS user_role;
CREATE TABLE `user_role` (
  `user_role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role`),
  UNIQUE KEY `UKadnyt6agwl65jnnokuvnskhn2` (`role`,`username`),
  KEY `FKnircs1pyebpo0eucojumm0aed` (`username`),
  CONSTRAINT `FKnircs1pyebpo0eucojumm0aed` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT  INTO user_role(user_role,role,username)VALUES(1,'ROLE_ADMIN','admin');
INSERT  INTO user_role(user_role,role,username)VALUES(2,'ROLE_USER','user')
*/

DROP TABLE IF EXISTS `user`;
create table `user`(
	UsuarioId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PersonaId int(11) NULL,
	username varchar(60) NOT NULL,
	password varchar(60) NOT NULL,
	Activo bit(1) NOT NULL DEFAULT b'1',
    IndCambio bit(1) NOT NULL DEFAULT b'1',
	FOREIGN KEY(PersonaId) REFERENCES Persona(PersonaId) on DELETE no action on UPDATE CASCADE,
    CargoId int(11) ,
    FOREIGN KEY(CargoId) REFERENCES Cargo(CargoId) on DELETE no action on UPDATE CASCADE,
    OficinaId int(11) ,
    FOREIGN KEY(OficinaId) REFERENCES Oficina(OficinaId) on DELETE no action on UPDATE CASCADE
);
INSERT INTO `user` VALUES ('1', '1', 'admin', '$2a$10$Bs6brtlLYJULigF57keOaOiMotCfCDlfYic3FxYZLSESopEmtL.c2', 1, 0,1,2);


DROP TABLE IF EXISTS user_role;
CREATE TABLE `user_role` (
Id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	UsuarioId int(11) NOT NULL ,
  FOREIGN KEY(UsuarioId) REFERENCES `user`(UsuarioId) on DELETE no action on UPDATE CASCADE,
	RolId INT(11) NOT NULL ,
  FOREIGN KEY(RolId) REFERENCES Rol(RolId) on DELETE no action on UPDATE CASCADE,
  `user_role` int(11) NOT NULL ,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL
);
INSERT INTO user_role VALUES (1,1,1,1,'ROLE_ADMIN','admin');






SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Oficina;
Create table Oficina(
	OficinaId int(11) PRIMARY KEY auto_increment not NULL,
	Denominacion VARCHAR(255) not NULL
);
INSERT INTO `oficina` VALUES ('1', 'DIRECCION EJECUTIVA');
INSERT INTO `oficina` VALUES ('2', 'ADMINISTRACION');
INSERT INTO `oficina` VALUES ('3', 'ABASTECIMIENTO');
INSERT INTO `oficina` VALUES ('4', 'ALMACEN');
INSERT INTO `oficina` VALUES ('5', 'PERSONAL');


DROP TABLE IF EXISTS usuario_oficina;
/*CREATE TABLE usuario_oficina (
  OficinaId int(11) NOT NULL,
		FOREIGN KEY(OficinaId) REFERENCES Oficina(OficinaId) on DELETE no action on UPDATE CASCADE,
  UsuarioId int(11) NOT NULL,
		FOREIGN KEY(UsuarioId) REFERENCES UsuarioController(UsuarioId) on DELETE no action on UPDATE CASCADE,
  PRIMARY KEY (`UsuarioId`,`OficinaId`)
);
INSERT INTO `usuario_oficina` VALUES ('1', '1');
*/
DROP TABLE IF EXISTS Cargo;
Create table Cargo(
	CargoId int(11) PRIMARY KEY auto_increment not NULL,
	Denominacion VARCHAR(255) not NULL
);
INSERT INTO `Cargo` VALUES ('1', 'DIRECTOR EJECUTIVO');
INSERT INTO `Cargo` VALUES ('2', 'ADMINISTRADOR');
INSERT INTO `Cargo` VALUES ('3', 'JEFE ABASTECIMIENTO');
INSERT INTO `Cargo` VALUES ('4', 'JEFE ALMACEN');
INSERT INTO `Cargo` VALUES ('5', 'JEFE PERSONAL');
