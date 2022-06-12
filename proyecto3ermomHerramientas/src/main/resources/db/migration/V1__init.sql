CREATE TABLE IF NOT EXISTS promocion(
   id SERIAL,
   nombre VARCHAR (100) NOT NULL,
   precio VARCHAR (100) NULL,
   PRIMARY KEY (id)
   );
CREATE TABLE IF NOT EXISTS tienda(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS usuario(
  id SERIAL,
  username VARCHAR (100) NOT NULL,
  password VARCHAR (100) NOT NULL,
  precios VARCHAR (100) NULL,
  inventario INT  NOT NULL,
  promocion_id INT NOT NULL,
  tienda_id INT NOT NULL,
  PRIMARY KEY (id)
  FOREIGN KEY(promocion_id) references promocion(id),
  FOREIGN KEY (representante_id) references representante(id)
);

CREATE TABLE IF NOT EXISTS producto(
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  precios VARCHAR (100) NULL,
  inventario INT  NOT NULL,
  promocion_id INT NOT NULL,
  tienda_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(promocion_id) references promocion(id),
  FOREIGN KEY (representante_id) references representante(id)
  );

CREATE TABLE IF NOT EXISTS futbol(
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    hora VARCHAR (100) NOT NULL,
    cancha VARCHAR (100) NOT NULL,

    PRIMARY KEY (id)

    );




