SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Vehiculo;
Create table Vehiculo(
	VehiculoId int(11) PRIMARY KEY auto_increment not NULL,
	Denominacion VARCHAR(255) not NULL,
	Capacidad INT(11) not NULL,
	placa VARCHAR(255) not NULL,
	Marca VARCHAR(255) not NULL,
  UsuarioId INT(11) NOT NULL,
	FOREIGN KEY(UsuarioId) REFERENCES User(UsuarioId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS DetalleVehiculo;
Create table DetalleVehiculo(
	DetalleVehiculoId int(11) PRIMARY KEY auto_increment not NULL,
	NumeroAsiento INT(11) not NULL,
	Denominacion VARCHAR(255) not NULL,
  VehiculoId int(11),
  FOREIGN KEY(VehiculoId) REFERENCES Vehiculo(VehiculoId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS Pago;
Create table Pago(
	PagoId int(11) PRIMARY KEY auto_increment not NULL,
	Denominacion VARCHAR(255) not NULL,
	Valor decimal(6,2) not NULL
);


DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente(
  ClienteId INT(11)PRIMARY KEY auto_increment not NULL,
  PersonaId INT(11) NOT NULL,
	FOREIGN KEY(PersonaId) REFERENCES Persona(PersonaId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS Salida;
Create table Salida(
	SalidaId int(11) PRIMARY KEY auto_increment not NULL,
	Denominacion VARCHAR(255) not NULL,
	fecha date not null,
	hora time  not null ,
	VehiculoId int(11),
  FOREIGN KEY(VehiculoId) REFERENCES Vehiculo(VehiculoId) on DELETE no action on UPDATE CASCADE
);


DROP TABLE IF EXISTS Pasaje;
Create table Pasaje(
	PasajeId int(11) PRIMARY KEY auto_increment not NULL,
	FechaPasaje date not null,
	ClienteId INT(11) NOT NULL,
	FOREIGN KEY(ClienteId) REFERENCES Cliente(ClienteId) on DELETE no action on UPDATE CASCADE,
	UsuarioId INT(11) NOT NULL,
	FOREIGN KEY(UsuarioId) REFERENCES User(UsuarioId) on DELETE no action on UPDATE CASCADE,
	SalidaId INT(11) NOT NULL,
	FOREIGN KEY(SalidaId) REFERENCES Salida(SalidaId) on DELETE no action on UPDATE CASCADE,
	Abono decimal(5,2) not NULL,
	Saldo decimal(5,2) not NULL,
	TipoVenta VARCHAR(255) not null,
  NumeroAsiento int (3) not null,
	VehiculoId int(11),
  FOREIGN KEY(VehiculoId) REFERENCES Vehiculo(VehiculoId) on DELETE no action on UPDATE CASCADE
);

INSERT INTO menu VALUES (60, 'Reservacion', 'Reservacion', 'fa fa-taxi', 1, null);
INSERT INTO menu VALUES (61, 'Pasaje', 'Reservacion', null, 0, 60);
INSERT INTO menu VALUES (63, 'Mantenimiento', 'MantenimientoReservacion', null, 0, 60);
INSERT INTO menu VALUES (64, 'Vehiculo', 'Vehiculo', null, 0, 60);


INSERT INTO rol_menu(MenuId,RolId) VALUES (60, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (61, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (63, 1);
INSERT INTO rol_menu(MenuId,RolId) VALUES (64, 1);