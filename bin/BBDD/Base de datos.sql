create schema Banco;

use Banco;

create table tipo_usuario
(
    tipo_usuario VARCHAR(5) NOT NULL,
    CONSTRAINT PK_tipo_usuario PRIMARY KEY (tipo_usuario),
    
    descripcion VARCHAR(150) NOT NULL
    
);

create table pais
(
    id_pais INT NOT NULL,
    CONSTRAINT PK_pais PRIMARY KEY (id_pais),
    
    pais_nombre VARCHAR(250) NOT NULL
    
);

create table estado
(
    id_estado INT NOT NULL,
    CONSTRAINT PK_estado PRIMARY KEY (id_estado),
    
    id_pais INT NOT NULL,
    constraint PF_estado_x_pais foreign key (id_pais) 
	references pais(id_pais),
    
    estado_nombre VARCHAR(255) NOT NULL
    
);

create table usuario
(
	nombre_usuario VARCHAR(25) NOT NULL,
	CONSTRAINT PK_clientes PRIMARY KEY (nombre_usuario),

	dni_usuario VARCHAR(8) NOT NULL,
	nombre_real VARCHAR(50) NOT NULL,
	apellido_real VARCHAR(50) NOT NULL,
	CONSTRAINT UC_usuario UNIQUE (dni_usuario, nombre_real, apellido_real),
	
    tipo_usuario VARCHAR(5) NOT NULL,
    constraint PF_usuario_x_tipo_usuario foreign key (tipo_usuario) 
	references tipo_usuario(tipo_usuario),
    
	contraseña_usuario VARCHAR(25) NOT NULL,
	cuil_usuario VARCHAR(11) NOT NULL,
	sexo VARCHAR(4) NOT NULL,
    
	fecha_nacimiento DATE NOT NULL,
    estado bit NOT NULL DEFAULT 1

);

create table direccion
(
    nombre_usuario VARCHAR(25) NOT NULL,
	CONSTRAINT PK_direccion PRIMARY KEY (nombre_usuario),
	
    constraint PF_direccion_x_usuario foreign key (nombre_usuario) 
	references usuario(nombre_usuario),
    
	altura VARCHAR(30) NOT NULL,
    calle VARCHAR(30) NOT NULL,
    localidad VARCHAR(30) NOT NULL,
    provincia VARCHAR(30) NOT NULL,
	pais VARCHAR(30) NOT NULL,
	estado bit NOT NULL DEFAULT 1
);

create table contacto
(
    nombre_usuario VARCHAR(25) NOT NULL,
	CONSTRAINT PK_contacto PRIMARY KEY (nombre_usuario),
	
    constraint PF_contacto_x_usuario foreign key (nombre_usuario) 
	references usuario(nombre_usuario),
    
	email VARCHAR(50) NOT NULL,
	telefono VARCHAR(25) NOT NULL,
    estado bit NOT NULL DEFAULT 1

);

create table tipo_cuenta
(
    tipo_cuenta VARCHAR(5) NOT NULL,
    CONSTRAINT PK_tipo_cuenta PRIMARY KEY (tipo_cuenta),
    
    descripcion VARCHAR(150) NOT NULL
    
);

create table cuenta
(
	cbu_cuenta VARCHAR(22) NOT NULL,
	CONSTRAINT PK_cuenta PRIMARY KEY (cbu_cuenta),

	nombre_usuario VARCHAR(22) NOT NULL,
	constraint PF_cuenta_x_usuario foreign key (nombre_usuario) 
	references usuario(nombre_usuario),
    
    tipo_cuenta VARCHAR(5) NOT NULL,
    constraint PF_cuenta_x_tipo_cuenta foreign key (tipo_cuenta) 
	references tipo_cuenta(tipo_cuenta),
    
    fecha_creacion DATE NOT NULL,
    saldo FLOAT NOT NULL,
    estado bit NOT NULL DEFAULT 1,
    alias VARCHAR(22) NOT NULL

);

create table tipo_movimiento
(
    tipo_movimiento VARCHAR(5) NOT NULL,
    CONSTRAINT PK_tipo_movimiento PRIMARY KEY (tipo_movimiento),
    
    descripcion VARCHAR(150) NOT NULL
    
);

create table movimiento
(
	id_movimiento INT NOT NULL AUTO_INCREMENT,
	CONSTRAINT PK_movimiento PRIMARY KEY (id_movimiento),

	cbu_cuenta VARCHAR(22) NOT NULL,
	constraint PF_movimiento_x_cuenta foreign key (cbu_cuenta) 
	references cuenta(cbu_cuenta),
    
    tipo_movimiento VARCHAR(5) NOT NULL,
    constraint PF_movimiento_x_tipo_movimiento foreign key (tipo_movimiento) 
	references tipo_movimiento(tipo_movimiento),
    
    fecha_creacion DATE NOT NULL,
    detalles VARCHAR(22) NOT NULL,
    importe FLOAT NOT NULL,
    estado bit NOT NULL DEFAULT 1

);


create table transferencia
(
	id_tranferencia INT NOT NULL AUTO_INCREMENT,
	CONSTRAINT PK_transferencia PRIMARY KEY (id_tranferencia),

	id_movimiento INT NOT NULL,
	constraint PF_transferencia_x_movimiento foreign key (id_movimiento) 
	references movimiento(id_movimiento),
    
    cbu_cuenta_destino VARCHAR(22) NOT NULL,
    constraint PF_transferencia_x_cuenta foreign key (cbu_cuenta_destino) 
	references cuenta(cbu_cuenta),
    
    estado bit NOT NULL DEFAULT 1

);

create table prestamo
(
	id_prestamo INT NOT NULL AUTO_INCREMENT,
	CONSTRAINT PK_Prestamo PRIMARY KEY (id_prestamo),
	
    cbu_cuenta_deudor VARCHAR(22) NOT NULL,
    constraint PF_prestamo_x_cuenta foreign key (cbu_cuenta_deudor) 
	references cuenta(cbu_cuenta),
    
    importe_pedido float NOT NULL,
	importe_con_intereses float NOT NULL,
    plazo_de_pago DATE NOT NULL,
    pago_x_mes float NOT NULL,
    cantidad_cuotas INT NOT NULL,
    cuotas_restantes INT NOT NULL,
    monto_actual float NOT NULL,
    aprobacion bit NOT NULL DEFAULT 0,
    estado bit NOT NULL DEFAULT 1
    
);

create table movimiento_x_prestamo
(
	id_movimiento INT NOT NULL,
    id_prestamo INT NOT NULL,
	CONSTRAINT PK_movimiento_x_prestamo PRIMARY KEY (id_movimiento, id_prestamo),

	constraint PF_movimiento_x_prestamo_x_movimiento foreign key (id_movimiento) 
	references movimiento(id_movimiento),
    constraint PF_movimiento_x_prestamo_x_prestamo foreign key (id_prestamo) 
	references Prestamo(id_prestamo)

);


