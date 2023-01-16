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
