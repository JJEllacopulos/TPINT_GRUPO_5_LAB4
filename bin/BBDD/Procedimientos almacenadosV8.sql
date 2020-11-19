use Banco;


-- Tipo_usuario

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_datos_tipo_usuario(

		Tipo_usuario VARCHAR(5),
		Descripcion VARCHAR(150)
        
        )
		
	BEGIN

		INSERT INTO tipo_usuario (tipo_usuario, descripcion)
		SELECT Tipo_usuario, Descripcion;
		
	END$$


-- Usuario

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_datos_usuario(

		Nombre_usuario VARCHAR(25),
        Dni_usuario VARCHAR(8),
        Nombre_real VARCHAR(50),
        Apellido_real VARCHAR(50),
        Tipo_usuario VARCHAR(5),
        Contraseña_usuario VARCHAR(25),
        Cuil_usuario VARCHAR(11),
        Sexo VARCHAR(4),
        Nacionalidad VARCHAR(50),
        Fecha_nacimiento DATE,
        estado bit
		
        )
        
	BEGIN

		INSERT INTO usuario (nombre_usuario, dni_usuario, nombre_real, apellido_real, tipo_usuario, contraseña_usuario, cuil_usuario, sexo, nacionalidad, fecha_nacimiento)
		SELECT Nombre_usuario, Dni_usuario, Nombre_real, Apellido_real, Tipo_usuario, Contraseña_usuario, Cuil_usuario, Sexo, Nacionalidad, Fecha_nacimiento;
		
	END$$
    
DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_usuario(
	
		 Nombre_usuario VARCHAR(25)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM usuario WHERE usuario.nombre_usuario = Nombre_usuario AND estado = 1) THEN
		
		Update usuario Set estado = 0 Where usuario.nombre_usuario = Nombre_usuario;
        
	END IF;

END$$
    
DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_usuario(
	
		Nombre_usuario VARCHAR(25),
        Dni_usuario VARCHAR(8),
        Nombre_real VARCHAR(50),
        Apellido_real VARCHAR(50),
        Tipo_usuario VARCHAR(5),
        Contraseña_usuario VARCHAR(25),
        Cuil_usuario VARCHAR(11),
        Sexo VARCHAR(4),
        Nacionalidad VARCHAR(50),
        Fecha_nacimiento DATE
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM usuario WHERE nombre_usuario = Nombre_usuario AND estado = 1) THEN
		
		Update usuario Set usuario.dni_usuario = Dni_usuario, usuario.nombre_real = Nombre_real, usuario.Apellido_real = apellido_real, usuario.tipo_usuario = Tipo_usuario, usuario.contraseña_usuario = Contraseña_usuario, usuario.cuil_usuario = Cuil_usuario, usuario.sexo = Sexo, usuario.nacionalidad = Nacionalidad, usuario.fecha_nacimiento = Fecha_nacimiento  Where usuario.nombre_usuario = Nombre_usuario;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_usuario(
	
		Nombre_usuario VARCHAR(25)
        
		)
    
	BEGIN
	
		SELECT * FROM usuario WHERE usuario.nombre_usuario = Nombre_usuario AND usuario.estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_usuario(
        
		)
    
	BEGIN
	
		SELECT * FROM usuario;
	

END$$


-- Direccion

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_direccion(
		
		ing_Nombre_usuario VARCHAR(25),
		ing_Altura VARCHAR(30),
		ing_Calle VARCHAR(30),
		ing_Localidad VARCHAR(30),
		ing_Provincia VARCHAR(30),
		ing_Pais VARCHAR(30)
		
        )
        
	BEGIN

		INSERT INTO direccion (nombre_usuario, altura, calle, localidad, provincia, pais)
		SELECT ing_Nombre_usuario, ing_Altura, ing_Calle, ing_Localidad, ing_Provincia, ing_Pais;
		
	END$$    


DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_direccion(
	
		 ing_Nombre_usuario VARCHAR(25)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM direccion WHERE nombre_usuario = ing_Nombre_usuario AND estado = 1) THEN
		
		Update direccion Set estado = 0 Where nombre_usuario = ing_Nombre_usuario;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_direccion(
	
		ing_nombre_usuario VARCHAR(25),
		ing_altura VARCHAR(30),
		ing_calle VARCHAR(30),
		ing_localidad VARCHAR(30),
		ing_provincia VARCHAR(30),
		ing_pais VARCHAR(30)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM direccion WHERE nombre_usuario = ing_nombre_usuario AND estado = 1) THEN
		
		Update direccion Set altura = ing_altura, calle = ing_calle, localidad = ing_localidad, provincia = ing_provincia, pais = ing_pais Where nombre_usuario = ing_nombre_usuario;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_direccion(
	
		ing_nombre_usuario VARCHAR(25)
        
		)
    
	BEGIN
	
		SELECT * FROM direccion WHERE nombre_usuario = ing_nombre_usuario AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_direccion(
        
		)
    
	BEGIN
	
		SELECT * FROM direccion;
	

END$$

-- Contacto

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_contacto(
		
		ing_nombre_usuario VARCHAR(25),
		ing_email VARCHAR(50),
		ing_telefono VARCHAR(25)
		
        )
        
	BEGIN

		INSERT INTO  contacto(nombre_usuario, email, telefono)
		SELECT ing_nombre_usuario, ing_email, ing_telefono;
		
	END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_contacto(
	
		 ing_Nombre_usuario VARCHAR(25)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM contacto WHERE nombre_usuario = ing_Nombre_usuario AND estado = 1) THEN
		
		Update contacto Set estado = 0 Where nombre_usuario = ing_Nombre_usuario;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_contacto(
	
		ing_nombre_usuario VARCHAR(25),
		ing_email VARCHAR(50),
		ing_telefono VARCHAR(25)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM contacto WHERE nombre_usuario = ing_nombre_usuario AND estado = 1) THEN
		
		Update contacto Set email = ing_email, telefono = ing_telefono Where nombre_usuario = ing_nombre_usuario;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_contacto(
	
		ing_nombre_usuario VARCHAR(25)
        
		)
    
	BEGIN
	
		SELECT * FROM contacto WHERE nombre_usuario = ing_nombre_usuario AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_contacto(
        
		)
    
	BEGIN
	
		SELECT * FROM contacto;
	

END$$

-- Tipo_cuenta

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_tipo_cuenta(
		
		ing_tipo_cuenta VARCHAR(5) ,
		ing_descripcion VARCHAR(150)
		
        )
        
	BEGIN

		INSERT INTO tipo_cuenta(tipo_cuenta, descripcion)
		SELECT ing_tipo_cuenta, ing_descripcion;
		
	END$$
    
-- Cuenta

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_cuenta(
		
		ing_cbu_cuenta VARCHAR(22),
		ing_nombre_usuario VARCHAR(22),
		ing_tipo_cuenta VARCHAR(5),
		ing_fecha_creacion DATE,
		ing_saldo FLOAT
		
        )
        
	BEGIN

		INSERT INTO  cuenta(cbu_cuenta, nombre_usuario, tipo_cuenta, fecha_creacion, saldo)
		SELECT ing_cbu_cuenta, ing_nombre_usuario, ing_tipo_cuenta, ing_fecha_creacion, ing_saldo;
		
	END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_cuenta(
	
		 ing_cbu_cuenta VARCHAR(22)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM cuenta WHERE cbu_cuenta = ing_cbu_cuenta AND estado = 1) THEN
		
		Update cuenta Set estado = 0 Where cbu_cuenta = ing_cbu_cuenta;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_cuenta(
		
        ing_cbu_cuenta VARCHAR(22),
		ing_nombre_usuario VARCHAR(22),
		ing_tipo_cuenta VARCHAR(5),
		ing_fecha_creacion DATE,
		ing_saldo FLOAT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM cuenta WHERE cbu_cuenta = ing_cbu_cuenta AND estado = 1) THEN
		
		Update cuenta Set nombre_usuario = ing_nombre_usuario, tipo_cuenta = ing_tipo_cuenta, fecha_creacion = ing_fecha_creacion, saldo = ing_saldo Where cbu_cuenta = ing_cbu_cuenta;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_cuenta(
	
		ing_cbu_cuenta VARCHAR(22)
        
		)
    
	BEGIN
	
		SELECT * FROM cuenta WHERE cbu_cuenta = ing_cbu_cuenta AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_cuenta(
        
		)
    
	BEGIN
	
		SELECT * FROM cuenta;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_Datos_cuenta(
	
		ing_nombre_usuario VARCHAR(22)
        
		)
    
	BEGIN
	
		SELECT * FROM cuenta WHERE nombre_usuario = "Adrianabanana" AND estado = 1;
	

END$$

-- tipo_movimiento

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_tipo_movimiento(
		
		ing_tipo_movimiento VARCHAR(5),
		ing_descripcion VARCHAR(150)
		
        )
        
	BEGIN

		INSERT INTO tipo_movimiento(tipo_movimiento, descripcion)
		SELECT ing_tipo_movimiento, ing_descripcion;
		
	END$$

-- Movimiento

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_movimiento(
		
		ing_cbu_cuenta VARCHAR(22),
		ing_tipo_movimiento VARCHAR(5),
		ing_detalles VARCHAR(22),
		ing_importe FLOAT
		
        )
        
	BEGIN

		INSERT INTO  movimiento(cbu_cuenta, tipo_movimiento, fecha_creacion, detalles, importe)
		SELECT ing_cbu_cuenta, ing_tipo_movimiento, CURDATE(), ing_detalles, ing_importe;
		
	END$$
    
DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_movimiento(
	
		 ing_id_movimiento INT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM movimiento WHERE id_movimiento = ing_id_movimiento AND estado = 1) THEN
		
		Update movimiento Set estado = 0 Where id_movimiento = ing_id_movimiento;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_movimiento(
		
        ing_id_movimiento INT,
		ing_cbu_cuenta VARCHAR(22),
		ing_tipo_movimiento VARCHAR(5),
		ing_fecha_creacion DATE,
		ing_detalles VARCHAR(22),
		ing_importe FLOAT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM movimiento WHERE id_movimiento = ing_id_movimiento AND estado = 1) THEN
		
		Update movimiento Set id_movimiento = ing_id_movimiento, cbu_cuenta = ing_cbu_cuenta, tipo_movimiento = ing_tipo_movimiento, fecha_creacion = ing_fecha_creacion, detalles = ing_detalles, importe = ing_importe Where id_movimiento = ing_id_movimiento;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_movimiento(
	
		ing_id_movimiento INT
        
		)
    
	BEGIN
	
		SELECT * FROM movimiento WHERE id_movimiento = ing_id_movimiento AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_movimiento(
    cbuCuenta VARCHAR(22)

        )

    BEGIN

        SELECT * FROM movimiento where cbu_cuenta = cbuCuenta ;


END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Obtener_Ultimo_Id_Movimiento(
        
		)
    
	BEGIN
	
		SELECT MAX(id_movimiento) as id_movimiento FROM movimiento;
	

END$$

-- Transferencia

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_transferencia(
		
		ing_id_movimiento INT,
		ing_cbu_cuenta_destino VARCHAR(22)
		
        )
        
	BEGIN

		INSERT INTO  transferencia(id_movimiento, cbu_cuenta_destino)
		SELECT ing_id_movimiento, ing_cbu_cuenta_destino;
		
	END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_transferencia(
	
		 ing_id_tranferencia INT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM transferencia WHERE id_tranferencia = ing_id_tranferencia AND estado = 1) THEN
		
		Update transferencia Set estado = 0 Where id_tranferencia = ing_id_tranferencia;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_transferencia(
		
        ing_id_tranferencia INT,
		ing_id_movimiento INT,
		ing_cbu_cuenta_destino VARCHAR(22)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM transferencia WHERE id_tranferencia = ing_id_tranferencia AND estado = 1) THEN
		
		Update transferencia Set id_movimiento = ing_id_movimiento, cbu_cuenta_destino = ing_cbu_cuenta_destino Where id_tranferencia = ing_id_tranferencia;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_transferencia(
	
		ing_id_movimiento INT
        
		)
    
	BEGIN
	
		SELECT * FROM transferencia WHERE id_tranferencia = ing_id_tranferencia AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_transferencia(
        
		)
    
	BEGIN
	
		SELECT * FROM transferencia;
	

END$$

-- Prestamo

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_prestamo(
		
		ing_cbu_cuenta_deudor VARCHAR(22),
		ing_importe_pedido float,
		ing_importe_con_intereses float,
		ing_plazo_de_pago DATE,
		ing_pago_x_mes float,
		ing_cantidad_cuotas INT,
        ing_cuotas_restantes INT,
        ing_monto_actual float
		
        )
        
	BEGIN

		INSERT INTO  prestamo(cbu_cuenta_deudor, importe_pedido, importe_con_intereses, plazo_de_pago, pago_x_mes, cantidad_cuotas, cuotas_restantes, monto_actual)
		SELECT ing_cbu_cuenta_deudor, ing_importe_pedido, ing_importe_con_intereses, ing_plazo_de_pago, ing_pago_x_mes, ing_cantidad_cuotas, ing_cuotas_restantes, ing_monto_actual;
		
	END$$
    
DELIMITER $$
    CREATE PROCEDURE PRO_Desabilitar_prestamo(
	
		 ing_id_prestamo INT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM prestamo WHERE id_prestamo = ing_id_prestamo AND estado = 1) THEN
		
		Update prestamo Set estado = 0 Where id_prestamo = ing_id_prestamo;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Alterar_prestamo(
		
        ing_id_prestamo INT,
		ing_cbu_cuenta_deudor VARCHAR(22),
		ing_importe_pedido float,
		ing_importe_con_intereses float,
		ing_plazo_de_pago DATE,
		ing_pago_x_mes float,
		ing_cantidad_cuotas INT,
        ing_monto_actual float
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM prestamo WHERE id_prestamo = ing_id_prestamo AND estado = 1) THEN
		
		Update prestamo Set cbu_cuenta_deudor = ing_cbu_cuenta_deudor, importe_pedido = ing_importe_pedido, importe_con_intereses = ing_importe_con_intereses, plazo_de_pago = ing_plazo_de_pago, pago_x_mes = ing_pago_x_mes, cantidad_cuotas = ing_cantidad_cuotas, monto_actual = ing_monto_actual Where id_prestamo = ing_id_prestamo;
        
	END IF;

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Buscar_prestamo(
	
		ing_id_prestamo INT
        
		)
    
	BEGIN
	
		SELECT * FROM prestamo WHERE id_prestamo = ing_id_prestamo AND estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_prestamo(
        
		)
    
	BEGIN
	
		SELECT * FROM prestamo;
	

END$$

-- movimiento_x_prestamo

DELIMITER $$
	CREATE PROCEDURE PRO_ingresar_movimiento_x_prestamo(
		
		ing_id_movimiento INT,
		ing_id_prestamo INT 
		
        )
        
	BEGIN

		INSERT INTO  movimiento_x_prestamo(id_movimiento, id_prestamo)
		SELECT ing_id_movimiento, ing_id_prestamo;
		
	END$$
    
   DELIMITER $$
    CREATE PROCEDURE PRO_Listar_usuario_full(
        
		)
    
	BEGIN
	
		select u.nombre_usuario, u.dni_usuario, nombre_real, u.apellido_real, u.contraseña_usuario, u.cuil_usuario,
u.sexo, u.nacionalidad, u.fecha_nacimiento, d.calle, d.altura, d.localidad, d.provincia, d.pais, c.email, c.telefono  from usuario as u
inner join direccion as d on d.nombre_usuario = u.nombre_usuario
inner join contacto as c on c.nombre_usuario = u.nombre_usuario
where u.estado = 1 and u.tipo_usuario like 'user';
	

END$$

DELIMITER $$
	CREATE PROCEDURE PRO_Obtener_usuario(
		Nombre_usuario VARCHAR(25)
		)

	BEGIN

		select u.nombre_usuario, u.dni_usuario, nombre_real, u.apellido_real, u.contraseña_usuario, u.cuil_usuario,
		u.sexo, u.nacionalidad, u.fecha_nacimiento, d.calle, d.altura, d.localidad, d.provincia, d.pais, c.email, c.telefono, u.tipo_usuario from usuario as u
		inner join direccion as d on d.nombre_usuario = u.nombre_usuario
		inner join contacto as c on c.nombre_usuario = u.nombre_usuario
		where u.nombre_usuario = Nombre_usuario;


END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Confirmar_usuario(
	
		 ing_nombre_usuario VARCHAR(25),
         ing_contraseña_usuario VARCHAR(25)
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM usuario WHERE nombre_usuario = ing_nombre_usuario AND contraseña_usuario = ing_contraseña_usuario AND estado = 1) THEN
		BEGIN
			select true as resultado;
		END;
		ELSE
		BEGIN
			select false as resultado;
		END;
	END IF;

END$$

-- Prestamos

DELIMITER $$
	CREATE PROCEDURE PRO_Nuevo_prestamo(
		
		ing_cbu_cuenta_deudor VARCHAR(22),
		ing_importe_pedido float,
		ing_pago_x_mes float,
		ing_cantidad_cuotas INT
		
        )
        
	BEGIN

		INSERT INTO  prestamo(cbu_cuenta_deudor, importe_pedido, importe_con_intereses, plazo_de_pago, pago_x_mes, cantidad_cuotas, monto_actual)
		SELECT ing_cbu_cuenta_deudor, ing_importe_pedido, (ing_importe_pedido * 1.1), CURDATE(), ing_pago_x_mes, ing_cantidad_cuotas, (ing_importe_pedido * 1.1);
		
	END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_prestamos_administradores(
        
		)
    
	BEGIN
	
		SELECT * FROM prestamo where aprobacion = 0 and estado = 1;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_Listar_prestamos_clientes(
        
        ing_nombre_usuario VARCHAR(25)
        
		)
    
	BEGIN
	
		SELECT prestamo.id_prestamo, prestamo.cbu_cuenta_deudor, prestamo.importe_pedido, prestamo.importe_con_intereses, prestamo.cantidad_cuotas, prestamo.pago_x_mes, prestamo.monto_actual, prestamo.cuotas_restantes, prestamo.plazo_de_pago FROM prestamo
        inner join cuenta on prestamo.cbu_cuenta_deudor = cuenta.cbu_cuenta
        inner join usuario on cuenta.nombre_usuario = usuario.nombre_usuario
        where prestamo.aprobacion = 1 and prestamo.estado = 1 and usuario.nombre_usuario = ing_nombre_usuario;
	

END$$

DELIMITER $$
    CREATE PROCEDURE PRO_abilitar_prestamo(
	
		 ing_id_prestamo INT
		
		)
    
	BEGIN
	
	IF EXISTS(SELECT * FROM prestamo WHERE id_prestamo = ing_id_prestamo AND aprobacion = 0 and estado = 1) THEN
		
		Update prestamo Set aprobacion = 1 Where id_prestamo = ing_id_prestamo;
        
	END IF;

END$$
