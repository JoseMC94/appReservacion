SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS Vehiculo;
Create table Vehiculo
(
  VehiculoId   int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       not NULL,
  Capacidad    INT(11)                            not NULL,
  placa        VARCHAR(255)                       not NULL,
  Marca        VARCHAR(255)                       not NULL,
  UsuarioId    INT(11)                            NOT NULL,
  FOREIGN KEY (UsuarioId) REFERENCES User (UsuarioId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS DetalleVehiculo;
Create table DetalleVehiculo
(
  DetalleVehiculoId int(11) PRIMARY KEY auto_increment not NULL,
  NumeroAsiento     INT(11)                            not NULL,
  Denominacion      VARCHAR(255)                       not NULL,
  VehiculoId        int(11),
  FOREIGN KEY (VehiculoId) REFERENCES Vehiculo (VehiculoId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS Pago;
Create table Pago
(
  PagoId       int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       not NULL,
  Valor        decimal(6, 2)                      not NULL
);


DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente
(
  ClienteId INT(11) PRIMARY KEY auto_increment not NULL,
  PersonaId INT(11)                            NOT NULL,
  FOREIGN KEY (PersonaId) REFERENCES Persona (PersonaId) on DELETE no action on UPDATE CASCADE
);

DROP TABLE IF EXISTS Salida;
Create table Salida
(
  SalidaId     int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       not NULL,
  fecha        date                               not null,
  hora         time                               not null,
  VehiculoId   int(11),
  FOREIGN KEY (VehiculoId) REFERENCES Vehiculo (VehiculoId) on DELETE no action on UPDATE CASCADE
);


DROP TABLE IF EXISTS Pasaje;
Create table Pasaje
(
  PasajeId      int(11) PRIMARY KEY auto_increment not NULL,
  FechaPasaje   date                               not null,
  PersonaId     INT(11)                            NOT NULL,
  FOREIGN KEY (PersonaId) REFERENCES Persona (PersonaId) on DELETE no action on UPDATE CASCADE,
  UsuarioId     INT(11)                            NOT NULL,
  FOREIGN KEY (UsuarioId) REFERENCES User (UsuarioId) on DELETE no action on UPDATE CASCADE,
  SalidaId      INT(11)                            NOT NULL,
  FOREIGN KEY (SalidaId) REFERENCES Salida (SalidaId) on DELETE no action on UPDATE CASCADE,
  Abono         decimal(5, 2)                      not NULL,
  Saldo         decimal(5, 2)                      not NULL,
  NumeroAsiento int(3)                             not null
);

INSERT INTO menu
VALUES (60, 'Reservacion', 'Reservacion', 'fa fa-taxi', 1, null);
INSERT INTO menu
VALUES (61, 'Pasaje', 'Reservacion', null, 0, 60);
INSERT INTO menu
VALUES (63, 'Mantenimiento', 'MantenimientoReservacion', null, 0, 60);
INSERT INTO menu
VALUES (64, 'Vehiculo', 'Vehiculo', null, 0, 60);


INSERT INTO rol_menu(MenuId, RolId)
VALUES (60, 1);
INSERT INTO rol_menu(MenuId, RolId)
VALUES (61, 1);
INSERT INTO rol_menu(MenuId, RolId)
VALUES (63, 1);
INSERT INTO rol_menu(MenuId, RolId)
VALUES (64, 1);


-- tablas endoces

DROP TABLE IF EXISTS Endoce;
Create table Endoce
(
  EndoceId     int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       not NULL,
  Descripcion  VARCHAR(255)                       not NULL
);

DROP TABLE IF EXISTS EndoceDetalle;
Create table EndoceDetalle
(
  EndoceDetalleId int(11) PRIMARY KEY auto_increment not NULL,
  EndoceId        INT(11)                            NOT NULL,
  FOREIGN KEY (EndoceId) REFERENCES Endoce (EndoceId) on DELETE no action on UPDATE CASCADE,
  PersonaId       INT(11)                            NOT NULL,
  FOREIGN KEY (PersonaId) REFERENCES Persona (PersonaId) on DELETE no action on UPDATE CASCADE,
  Estado          VARCHAR(255)                       not NULL,
  FechaPasaje     date                               not null
);


DROP TABLE IF EXISTS SalidaDiaria;
Create table EntradaDiaria
(
  EntradaId    int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       NULL,
  Valor        decimal(6, 2)                      null,
  FechaEntrada date                               not null
);

DROP TABLE IF EXISTS SalidaDiaria;
Create table SalidaDiaria
(
  SalidaId     int(11) PRIMARY KEY auto_increment not NULL,
  Denominacion VARCHAR(255)                       NULL,
  Valor        decimal(6, 2)                      null,
  FechaSalida  date                               not null
);


DROP TABLE IF EXISTS ConfigEndoce;
Create table ConfigEndoce
(
  ConfigEndoceId   int(11) PRIMARY KEY auto_increment not NULL,
  Nombre           VARCHAR(255)                       not NULL,
  Movilidad        decimal(6, 2)                      not NULL,
  Guia             decimal(5, 2)                      not NULL,
  CantidadPasajero decimal(6, 2)                      not NULL,
  CostoEndoce      decimal(6, 2)                      not NULL
);


DROP TABLE IF EXISTS Venta;
Create table Venta
(
  VentaId     int(11) PRIMARY KEY auto_increment not NULL,
  Fecha       date                               not NULL,
  Monto       decimal(6, 2)                      not NULL,
  Descripcion varchar(6255)                      not NULL,
  PersonaId   INT(11)                            NOT NULL,
  FOREIGN KEY (PersonaId) REFERENCES Persona (PersonaId) on DELETE no action on UPDATE CASCADE
);


DROP TABLE IF EXISTS Producto;
Create table Producto
(
  ProductoId  int(11) PRIMARY KEY auto_increment not NULL,
  Nombre      varchar(6255)                      not NULL,
  Descripcion varchar(6255)                      not NULL,
  Precio      decimal(6, 2)                      not NULL,
  cantidad    int(6)                      not NULL
);