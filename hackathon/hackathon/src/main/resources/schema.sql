CREATE TABLE Programa (
    idPrograma INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Ubigeo (
    idUbigeo INT PRIMARY KEY IDENTITY(1,1),
    departamento VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL
);

CREATE TABLE Estudiante (
    idEstudiante INT PRIMARY KEY IDENTITY(1,1),
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(9),
    idUbigeo INT NOT NULL,
    idPrograma INT NOT NULL,
    estado CHAR(1) NOT NULL CHECK (estado IN ('A', 'I')), -- actualizado
    fechaRegistro DATETIME NOT NULL DEFAULT GETDATE(),

    FOREIGN KEY (idUbigeo) REFERENCES Ubigeo(idUbigeo),
    FOREIGN KEY (idPrograma) REFERENCES Programa(idPrograma)
);