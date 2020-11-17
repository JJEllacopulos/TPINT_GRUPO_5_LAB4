use Banco;

-- Tipo de usuario

CALL PRO_ingresar_datos_tipo_usuario 
(
	'ADMIN',
	'Usuario administrador'
);


 CALL PRO_ingresar_datos_tipo_usuario 
 (
	'user',
	'Usuario cliente'
);

-- Usuario

CALL PRO_ingresar_datos_usuario
(
	'JJEllacipulos',
    '79832790',
    'Jonathan',
    'Ellacupulos',
    'ADMIN',
    'Comida_de_emergencia',
    '47846376823',
    'MASC',
    'Argentino',
    '1994-05-22',
    1
);

CALL PRO_ingresar_datos_usuario
(
	'Cacceres',
    '54779894',
    'Pedro',
    'Cacceres',
    'ADMIN',
    'CuarentayCincuenta',
    '35766846073',
    'MASC',
    'Argentino',
    '1992-11-04',
    1
);

CALL PRO_ingresar_datos_usuario
(
	'ChristianJD',
    '46357854',
    'Christian',
    'Degraf',
    'ADMIN',
    'OnFire',
    '54463578549',
    'MASC',
    'Argentino',
    '1996-03-14',
    1
);

CALL PRO_ingresar_datos_usuario
(
	'JoseHernandes',
    '46433466',
    'Jose',
    'Hernandes',
    'user',
    'Comida_de_emergencia',
    '47846376823',
    'MASC',
    'Argentino',
    '1994-05-22',
    1
);

CALL PRO_ingresar_datos_usuario
(
	'Adrianabanana',
    '60495866',
    'Adriana',
    'Meskal',
    'user',
    'DriveRealFast',
    '34604958667',
    'FEMN',
    'Benesuela',
    '1990-03-07',
    1
);

CALL PRO_ingresar_datos_usuario
(
	'Tomaska',
    '78664743',
    'Tomas',
    'kalaka',
    'user',
    'iwannadie',
    '57786647437',
    'MASC',
    'Benesuela',
    '1990-03-07',
    1
);

-- Direccion

CALL PRO_ingresar_direccion
(
    'JJEllacipulos',
    '343',
    'Artigas',
    'Providens',
    'tires on fire',
    'Kekistan'
);

CALL PRO_ingresar_direccion
(
    'Cacceres',
    '356',
    'Brasil',
    'Providens',
    'lalala',
    'Kekistan'
);

CALL PRO_ingresar_direccion
(
    'ChristianJD',
    '5363',
    'beee',
    'sheep',
    'sky',
    'Kekistan'
);

CALL PRO_ingresar_direccion
(
    'JoseHernandes',
    '343',
    'Artigas',
    'Providens',
    'tires on fire',
    'Kekistan'
);

CALL PRO_ingresar_direccion
(
    'Adrianabanana',
    '5475',
    'Tomska',
    'puebla',
    'McKree',
    'Kekistan'
);

CALL PRO_ingresar_direccion
(
    'Tomaska',
    '6345',
    'Wassup',
    'vervo',
    '4ever',
    'Kekistan'
);

-- Contacto

CALL PRO_ingresar_contacto 
(
    'JJEllacipulos',
    'e-mail',
    '000'
);

CALL PRO_ingresar_contacto 
(
    'Cacceres',
    'e-mail',
    '567676456'
);

CALL PRO_ingresar_contacto 
(
    'ChristianJD',
    'e-mail',
    '000'
);

CALL PRO_ingresar_contacto 
(
    'JoseHernandes',
    'e-mail',
    '567676456'
);

CALL PRO_ingresar_contacto 
(
    'Adrianabanana',
    'e-mail',
    '000'
);

CALL PRO_ingresar_contacto 
(
    'Tomaska',
    'e-mail',
    '567676456'
);

-- Tipo de cuenta

CALL PRO_ingresar_tipo_cuenta 
(
    'CORRI',
    'Cuenta corriente'
);

CALL PRO_ingresar_tipo_cuenta 
(
    'AHORR',
    'Cuenta remunerada'
);

CALL PRO_ingresar_tipo_cuenta 
(
    'NOMIN',
    'Cuenta nómina'
);

CALL PRO_ingresar_tipo_cuenta 
(
    'VALOR',
    'Cuenta de valor'
);

CALL PRO_ingresar_tipo_cuenta 
(
    'EMPRE',
    'Cuenta para empresa'
);

-- Cuentas

CALL PRO_ingresar_cuenta 
(
    '582461493628608',
    'JoseHernandes',
    'CORRI',
    '2020-11-12',
    1000.00
    
);

CALL PRO_ingresar_cuenta 
(
    '248917267180968',
    'JoseHernandes',
    'VALOR',
    '2020-11-12',
    1000.00
    
);

CALL PRO_ingresar_cuenta 
(
    '8612772756330675',
    'Adrianabanana',
    'NOMIN',
    '2020-11-12',
    1000.00
    
);

CALL PRO_ingresar_cuenta 
(
    '720716748347099',
    'Adrianabanana',
    'AHORR',
    '2020-11-12',
    1000.00
    
);

CALL PRO_ingresar_cuenta 
(
    '549218310983198',
    'Tomaska',
    'EMPRE',
    '2020-11-12',
    1000.00
    
);

CALL PRO_ingresar_cuenta 
(
    '417214834307091',
    'Tomaska',
    'EMPRE',
    '2020-11-12',
    1000.00
    
);