create database SistemaMVC;
use SistemaMVC;

create table usuarios(
  id int auto_increment,
  nombre varchar(20) not null,
  apellido varchar(20) not null,
  telefono varchar(8) not null,
  domicilio varchar(20) not null,
  edad varchar(3) not null,
  primary key(id)
);

create table socio(
  codigo int auto_increment,
  nombre varchar(20) not null,
  apellido varchar(20) not null,
  direccion varchar(20) not null,
  telefono varchar(8) not null,
  primary key(codigo)
);

create table consumo(
  id int auto_increment,
  fecha varchar(10) not null,
  hora varchar(8) not null,
  cantidad double not null,
  codigoSocio int not null,
  primary key(id),
  foreign key (codigoSocio) references socio(codigo)
);

create table factura(
  id int auto_increment,
  fecha varchar(10) not null,
  hora varchar(8) not null,
  monto double not null,
  codigoSocio int not null,
  primary key(id),
  foreign key (codigoSocio) references socio(codigo)
);

create table detalle_factura(
  id int auto_increment,
  idFactura int,
  precio double not null,
  idConsumo int not null,
  primary key(id, idFactura),
  foreign key(idFactura) references factura(id),
  foreign key(idConsumo) references consumo(id)
);