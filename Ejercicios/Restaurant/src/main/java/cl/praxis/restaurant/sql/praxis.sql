
CREATE TABLE Mesa (
                                                                         ID INT PRIMARY KEY,
                                                                         Numero INT,
                                                                         Capacidad INT,
                                                                         Ubicacion VARCHAR(255)
                                                   );

CREATE TABLE Camarero (
                          ID INT PRIMARY KEY,
                          Nombre VARCHAR(255),
                          Edad INT,
                          Fecha_Inicio DATE
);

CREATE TABLE Plato (
                       ID INT PRIMARY KEY,
                       Nombre VARCHAR(255),
                       Descripción VARCHAR(255),
                       Precio DECIMAL(5,2),
                       Categoría VARCHAR(255)
);

CREATE TABLE Pedido (
                        ID INT PRIMARY KEY,
                        Mesa_ID INT,
                        Camarero_ID INT,
                        Fecha DATE,
                        Total DECIMAL(5,2),
                        FOREIGN KEY (Mesa_ID) REFERENCES Mesa(ID),
                        FOREIGN KEY (Camarero_ID) REFERENCES Camarero(ID)
);

CREATE TABLE Detalle_Pedido (
                                Pedido_ID INT,
                                Plato_ID INT,
                                Cantidad INT,
                                Subtotal DECIMAL(5,2),
                                PRIMARY KEY (Pedido_ID, Plato_ID),
                                FOREIGN KEY (Pedido_ID) REFERENCES Pedido(ID),
                                FOREIGN KEY (Plato_ID) REFERENCES Plato(ID)
);

-- Insertar mesas
INSERT INTO Mesa VALUES (1, 10, 5, 'Interior');
INSERT INTO Mesa VALUES (2, 11, 3, 'Terraza');
INSERT INTO Mesa VALUES (3, 12, 8, 'Exterior');
INSERT INTO Mesa VALUES (4, 13, 2, 'Balcon');
INSERT INTO Mesa VALUES (5, 14, 6, 'Interior');

-- Insertar camareros
INSERT INTO Camarero VALUES (1, 'Eduardo', 28, '2021-05-15');
INSERT INTO Camarero VALUES (2, 'Rosa', 31, '2021-03-12');
INSERT INTO Camarero VALUES (3, 'Alfonso', 26, '2020-10-10');
INSERT INTO Camarero VALUES (4, 'Berta', 29, '2019-09-01');
INSERT INTO Camarero VALUES (5, 'Oscar', 33, '2018-11-20');

-- Insertar platos
INSERT INTO Plato VALUES (1, 'Salpicón de mariscos', 'Mariscos mixtos con pimientos, cebolla y salsa vinagreta', 15.00, 'Entrada');
INSERT INTO Plato VALUES (2, 'Chuleta de cerdo', 'Chuleta de cerdo a la parrilla con hierbas', 12.00, 'Plato principal');
INSERT INTO Plato VALUES (3, 'Brownie con helado', 'Brownie de chocolate con bola de helado de fresa', 6.00, 'Postre');
INSERT INTO Plato VALUES (4, 'Crema de zanahoria', 'Crema de zanahoria con un toque de jengibre', 7.00, 'Entrada');
INSERT INTO Plato VALUES (5, 'Lasaña de carne', 'Lasaña con carne de res, salsa bechamel y queso', 11.00, 'Plato principal');

-- Insertar pedidos
INSERT INTO Pedido VALUES (1, 1, 4, '2023-07-07', 27.00);
INSERT INTO Pedido VALUES (2, 2, 3, '2023-07-08', 18.00);
INSERT INTO Pedido VALUES (3, 3, 2, '2023-07-09', 33.00);
INSERT INTO Pedido VALUES (4, 4, 5, '2023-07-10', 18.00);
INSERT INTO Pedido VALUES (5, 5, 1, '2023-07-11', 32.00);

-- Insertar detalles de los pedidos
INSERT INTO Detalle_Pedido VALUES (1, 1, 1, 15.00);
INSERT INTO Detalle_Pedido VALUES (1, 2, 1, 12.00);
INSERT INTO Detalle_Pedido VALUES (2, 4, 1, 7.00);
INSERT INTO Detalle_Pedido VALUES (2, 5, 1, 11.00);
INSERT INTO Detalle_Pedido VALUES (3, 1, 2, 30.00);
INSERT INTO Detalle_Pedido VALUES (3, 3, 1, 6.00);
INSERT INTO Detalle_Pedido VALUES (4, 2, 1, 12.00);
INSERT INTO Detalle_Pedido VALUES (4, 3, 1, 6.00);
INSERT INTO Detalle_Pedido VALUES (5, 1, 1, 15.00);
INSERT INTO Detalle_Pedido VALUES (5, 4, 1, 7.00);
INSERT INTO Detalle_Pedido VALUES (5, 5, 1, 11.00);
