-- Creación del esquema y selección de base de datos
CREATE SCHEMA trattoria;
USE trattoria;

-- Creación de la tabla 'mesas'
CREATE TABLE mesas (
                       id_mesa INT,
                       numero_mesa INT UNIQUE NOT NULL,
                       cantidad_persona INT NOT NULL,
                       disponible BOOLEAN NOT NULL,
                       CONSTRAINT pk_mesas PRIMARY KEY (id_mesa)
);

-- Creación de la tabla 'comunas'
CREATE TABLE comunas (
                         id_comuna INT,
                         nombre VARCHAR(255) NOT NULL,
                         CONSTRAINT pk_comunas PRIMARY KEY (id_comuna)
);

-- Creación de la tabla 'garzones'
CREATE TABLE garzones (
                          id_garzon INT,
                          rut VARCHAR(50) UNIQUE NOT NULL,
                          nombre VARCHAR(255) NOT NULL,
                          apellido VARCHAR(255) NOT NULL,
                          correo VARCHAR(255) UNIQUE NOT NULL,
                          direccion VARCHAR(255) NOT NULL,
                          id_comuna INT,
                          CONSTRAINT pk_garzones PRIMARY KEY (id_garzon),
                          CONSTRAINT fk_garzones_comunas FOREIGN KEY (id_comuna) REFERENCES comunas(id_comuna)
);

-- Creación de la tabla 'comandas'
CREATE TABLE comandas (
                          id_comanda INT,
                          fecha_emision DATE NOT NULL,
                          estado BOOLEAN NOT NULL,
                          propina_sugerida INT NOT NULL,
                          id_garzon INT,
                          id_mesa INT,
                          CONSTRAINT pk_comandas PRIMARY KEY (id_comanda),
                          CONSTRAINT fk_comandas_garzones FOREIGN KEY (id_garzon) REFERENCES garzones(id_garzon),
                          CONSTRAINT fk_comandas_mesas FOREIGN KEY (id_mesa) REFERENCES mesas(id_mesa)
);

-- Creación de la tabla 'categorias'
CREATE TABLE categorias (
                            id_categoria INT,
                            nombre_categoria VARCHAR(255) NOT NULL,
                            CONSTRAINT pk_categorias PRIMARY KEY (id_categoria)
);

-- Creación de la tabla 'productos'
CREATE TABLE productos (
                           id_producto INT,
                           codigo_producto VARCHAR(50) UNIQUE NOT NULL,
                           nombre_producto VARCHAR(255) NOT NULL,
                           stock INT NOT NULL,
                           precio_unitario INT NOT NULL,
                           id_categoria INT,
                           CONSTRAINT pk_productos PRIMARY KEY (id_producto),
                           CONSTRAINT fk_productos_categorias FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Inserciones de datos en la tabla 'mesas'
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (1, 1, 5, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (2, 2, 10, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (3, 3, 10, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (4, 4, 15, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (5, 5, 15, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (6, 6, 2, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (7, 7, 2, false);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (8, 8, 4, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (9, 9, 4, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (10, 10, 4, false);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (11, 11, 4, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (12, 12, 6, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (13, 13, 6, true);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (14, 14, 6, false);
INSERT INTO mesas (id_mesa, numero_mesa, cantidad_persona, disponible) VALUES (15, 15, 6, true);

-- Inserciones de datos en la tabla 'comunas'
INSERT INTO comunas (id_comuna, nombre) VALUES (1, 'Cerrillos');
INSERT INTO comunas (id_comuna, nombre) VALUES (2, 'Cerro Navia');
INSERT INTO comunas (id_comuna, nombre) VALUES (3, 'Conchalí');
INSERT INTO comunas (id_comuna, nombre) VALUES (4, 'El Bosque');
INSERT INTO comunas (id_comuna, nombre) VALUES (5, 'Estación Central');
INSERT INTO comunas (id_comuna, nombre) VALUES (6, 'Huechuraba');
INSERT INTO comunas (id_comuna, nombre) VALUES (7, 'Independencia');
INSERT INTO comunas (id_comuna, nombre) VALUES (8, 'La Cisterna');
INSERT INTO comunas (id_comuna, nombre) VALUES (9, 'La Florida');
INSERT INTO comunas (id_comuna, nombre) VALUES (10, 'La Granja');
INSERT INTO comunas (id_comuna, nombre) VALUES (11, 'La Pintana');
INSERT INTO comunas (id_comuna, nombre) VALUES (12, 'La Reina');
INSERT INTO comunas (id_comuna, nombre) VALUES (13, 'Las Condes');
INSERT INTO comunas (id_comuna, nombre) VALUES (14, 'Lo Barnechea');
INSERT INTO comunas (id_comuna, nombre) VALUES (15, 'Lo Espejo');
INSERT INTO comunas (id_comuna, nombre) VALUES (16, 'Lo Prado');
INSERT INTO comunas (id_comuna, nombre) VALUES (17, 'Macul');
INSERT INTO comunas (id_comuna, nombre) VALUES (18, 'Maipú');
INSERT INTO comunas (id_comuna, nombre) VALUES (19, 'Ñuñoa');
INSERT INTO comunas (id_comuna, nombre) VALUES (20, 'Pedro Aguirre Cerda');
INSERT INTO comunas (id_comuna, nombre) VALUES (21, 'Peñalolén');
INSERT INTO comunas (id_comuna, nombre) VALUES (22, 'Providencia');
INSERT INTO comunas (id_comuna, nombre) VALUES (23, 'Pudahuel');
INSERT INTO comunas (id_comuna, nombre) VALUES (24, 'Quilicura');
INSERT INTO comunas (id_comuna, nombre) VALUES (25, 'Quinta Normal');
INSERT INTO comunas (id_comuna, nombre) VALUES (26, 'Recoleta');
INSERT INTO comunas (id_comuna, nombre) VALUES (27, 'Renca');
INSERT INTO comunas (id_comuna, nombre) VALUES (28, 'San Joaquín');
INSERT INTO comunas (id_comuna, nombre) VALUES (29, 'San Miguel');
INSERT INTO comunas (id_comuna, nombre) VALUES (30, 'San Ramón');
INSERT INTO comunas (id_comuna, nombre) VALUES (31, 'Santiago');
INSERT INTO comunas (id_comuna, nombre) VALUES (32, 'Vitacura');
INSERT INTO comunas (id_comuna, nombre) VALUES (33, 'Puente Alto');
INSERT INTO comunas (id_comuna, nombre) VALUES (34, 'San José de Maipo');
INSERT INTO comunas (id_comuna, nombre) VALUES (35, 'Pirque');
INSERT INTO comunas (id_comuna, nombre) VALUES (36, 'San Bernardo');
INSERT INTO comunas (id_comuna, nombre) VALUES (37, 'Calera de Tango');
INSERT INTO comunas (id_comuna, nombre) VALUES (38, 'Buin');
INSERT INTO comunas (id_comuna, nombre) VALUES (39, 'Paine');
INSERT INTO comunas (id_comuna, nombre) VALUES (40, 'Colina');
INSERT INTO comunas (id_comuna, nombre) VALUES (41, 'Lampa');
INSERT INTO comunas (id_comuna, nombre) VALUES (42, 'Til-Til');
INSERT INTO comunas (id_comuna, nombre) VALUES (43, 'Alhué');
INSERT INTO comunas (id_comuna, nombre) VALUES (44, 'Curacaví');
INSERT INTO comunas (id_comuna, nombre) VALUES (45, 'María Pinto');
INSERT INTO comunas (id_comuna, nombre) VALUES (46, 'Melipilla');
INSERT INTO comunas (id_comuna, nombre) VALUES (47, 'San Pedro');

-- Inserciones de datos en la tabla 'garzones'
INSERT INTO garzones (id_garzon, rut, nombre, apellido, correo, direccion, id_comuna) VALUES (1, '11111111-1', 'Francisca', 'Cruz', 'fcruz@mail.com', 'Pasaje quellón 4567', 1);
INSERT INTO garzones (id_garzon, rut, nombre, apellido, correo, direccion, id_comuna) VALUES (2, '22222222-2', 'Carolina', 'Vazquez', 'cvazquez@mail.com', 'San Carlos 5665', 2);
INSERT INTO garzones (id_garzon, rut, nombre, apellido, correo, direccion, id_comuna) VALUES (3, '33333333-3', 'Catalina', 'Molina', 'cmolina@mail.com', 'Avenida Gabriela 7654', 3);
INSERT INTO garzones (id_garzon, rut, nombre, apellido, correo, direccion, id_comuna) VALUES (4, '55555555-5', 'Felipe', 'Palleres', 'fpalleres@mail.com', 'Creta sur 6543', 4);
INSERT INTO garzones (id_garzon, rut, nombre, apellido, correo, direccion, id_comuna) VALUES (5, '66666666-6', 'Leonardo', 'Olivares', 'lolivares@mail.com', 'Luis Matte 8742', 5);

-- Inserciones de datos en la tabla 'comandas'
INSERT INTO comandas (id_comanda, fecha_emision, estado, propina_sugerida, id_garzon, id_mesa) VALUES (1, '2024-08-07', true, 10, 1, 1);
INSERT INTO comandas (id_comanda, fecha_emision, estado, propina_sugerida, id_garzon, id_mesa) VALUES (2, '2024-08-07', true, 10, 1, 2);
-- (Más filas de inserción para comandas según sea necesario)

ALTER TABLE comandas MODIFY id_comanda INT AUTO_INCREMENT;

-- Inserciones de datos en la tabla 'categorias'
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (1, 'platos');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (2, 'bebestibles');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (3, 'postres');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (4, 'ensaladas');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (5, 'entradas');

-- Inserciones de datos en la tabla 'productos'
INSERT INTO productos (id_producto, codigo_producto, nombre_producto, stock, precio_unitario, id_categoria) VALUES (1, '123', 'Fettuchini Alfredo', 50, 15000, 1);
INSERT INTO productos (id_producto, codigo_producto, nombre_producto, stock, precio_unitario, id_categoria) VALUES (2, '234', 'Fettuchini Boloñesa', 50, 15000, 1);
-- (Más filas de inserción para productos según sea necesario)

-- Creación de la tabla 'detalles_comandas'
CREATE TABLE detalles_comandas (
                                   id_detalle INT,
                                   id_comanda INT,
                                   id_producto INT,
                                   cantidad_producto INT NOT NULL,
                                   precio_unitario INT NOT NULL,
                                   CONSTRAINT pk_detalles_comandas PRIMARY KEY (id_detalle),
                                   CONSTRAINT fk_detalles_comandas_comandas FOREIGN KEY (id_comanda) REFERENCES comandas(id_comanda),
                                   CONSTRAINT fk_detalles_comandas_productos FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Inserciones de datos en la tabla 'detalles_comandas'
INSERT INTO detalles_comandas (id_detalle, id_comanda, id_producto, cantidad_producto, precio_unitario) VALUES (1, 1, 1, 1, 15000);
INSERT INTO detalles_comandas (id_detalle, id_comanda, id_producto, cantidad_producto, precio_unitario) VALUES (2, 1, 2, 1, 15000);
-- (Más filas de inserción para detalles_comandas según sea necesario)

ALTER TABLE detalles_comandas MODIFY id_detalle INT AUTO_INCREMENT;
