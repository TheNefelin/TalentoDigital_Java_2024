-- Crear la tabla Pacientes
CREATE TABLE Pacientes (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Fecha_Nacimiento DATE
);

-- Crear la tabla Especialidades
CREATE TABLE Especialidades (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(100)
);

-- Crear la tabla Doctores
CREATE TABLE Doctores (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Especialidad_ID INT,
    Experiencia INT,
    FOREIGN KEY (Especialidad_ID) REFERENCES Especialidades(ID)
);

-- Crear la tabla Facturas
CREATE TABLE Facturas (
    ID INT PRIMARY KEY,
    Monto DECIMAL(8, 2),
    Fecha_Pago DATE
);

-- Crear la tabla Citas
CREATE TABLE Citas (
    ID INT PRIMARY KEY,
    Paciente_ID INT,
    Doctor_ID INT,
    Fecha DATE,
    Factura_ID INT,
    FOREIGN KEY (Paciente_ID) REFERENCES Pacientes(ID),
    FOREIGN KEY (Doctor_ID) REFERENCES Doctores(ID),
    FOREIGN KEY (Factura_ID) REFERENCES Facturas(ID)
);
CREATE TABLE Historia_Clinica (
    ID INT PRIMARY KEY,
    Paciente_ID INT,
    Doctor_ID INT,
    Fecha_Cita DATE,
    Sintomas TEXT,
    Diagnostico TEXT,
    Tratamiento TEXT,
    FOREIGN KEY (Paciente_ID) REFERENCES Pacientes(ID),
    FOREIGN KEY (Doctor_ID) REFERENCES Doctores(ID)
);


-- Rellenar la tabla Pacientes
INSERT INTO Pacientes (ID, Nombre, Fecha_Nacimiento) VALUES
(1, 'Juan Pérez', '1985-03-15'),
(2, 'María López', '1990-07-25'),
(3, 'José García', '1978-05-10'),
(4, 'Marta González', '2001-01-20'),
(5, 'Luisa Fernández', '1995-12-30');

-- Rellenar la tabla Especialidades
INSERT INTO Especialidades (ID, Nombre) VALUES
(1, 'Cardiología'),
(2, 'Dermatología'),
(3, 'Neurología'),
(4, 'Endocrinología'),
(5, 'Oncología');

-- Rellenar la tabla Doctores
INSERT INTO Doctores (ID, Nombre, Experiencia, Especialidad_ID) VALUES
(1, 'Dr. Ramírez', 5, 1),
(2, 'Dra. Rodríguez', 5, 2),
(3, 'Dr. Fernández', 10, 3),
(4, 'Dra. González', 15, 4),
(5, 'Dr. Sánchez', 20, 5);

-- Rellenar la tabla Facturas
INSERT INTO Facturas (ID, Monto, Fecha_Pago) VALUES
(1, 100.00, '2023-07-26'),
(2, 150.00, NULL),
(3, 200.00, '2023-07-27'),
(4, 250.00, '2023-07-28'),
(5, 300.00, NULL),
(6, 350.00, '2023-07-29'),
(7, 400.00, NULL),
(8, 450.00, '2023-07-30'),
(9, 500.00, NULL),
(10, 550.00, '2023-07-31');

-- Rellenar la tabla Citas
INSERT INTO Citas (ID, Paciente_ID, Doctor_ID, Fecha, Factura_ID) VALUES
(1, 1, 1, '2023-07-25', 1),
(2, 2, 2, '2023-07-26', 2),
(3, 3, 3, '2023-07-27', 3),
(4, 4, 4, '2023-07-28', 4),
(5, 5, 5, '2023-07-29', 5),
(6, 1, 2, '2023-07-30', 6),
(7, 2, 3, '2023-07-31', 7),
(8, 3, 4, '2023-08-01', 8),
(9, 4, 5, '2023-08-02', 9),
(10, 5, 1, '2023-08-03', 10);

-- Rellenar la tabla Historia_Clinica
INSERT INTO Historia_Clinica (ID, Paciente_ID, Doctor_ID, Fecha_Cita, Sintomas, Diagnostico, Tratamiento) VALUES
(1, 1, 1, '2023-07-25', 'Dolor en el pecho', 'Angina de pecho', 'Medicación y reposo'),
(2, 2, 2, '2023-07-26', 'Erupción cutánea', 'Alergia', 'Antihistamínicos'),
(3, 3, 3, '2023-07-27', 'Dolor de cabeza', 'Migraña', 'Medicación y reposo'),
(4, 4, 4, '2023-07-28', 'Aumento de peso', 'Hipotiroidismo', 'Medicación'),
(5, 5, 5, '2023-07-29', 'Fatiga', 'Anemia', 'Suplementos de hierro'),
(6, 1, 2, '2023-07-30', 'Acné', 'Acné común', 'Antibióticos tópicos'),
(7, 2, 3, '2023-07-31', 'Pérdida de memoria', 'Estrés', 'Terapia y relajación'),
(8, 3, 4, '2023-08-01', 'Sed excesiva', 'Diabetes', 'Dieta y medicación'),
(9, 4, 5, '2023-08-02', 'Pérdida de peso', 'Cáncer', 'Quimioterapia'),
(10, 5, 1, '2023-08-03', 'Palpitaciones', 'Arritmia', 'Medicación');