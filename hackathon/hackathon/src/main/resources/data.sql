INSERT INTO Programa (nombre) VALUES
('Administración de Empresas'),
('Ingeniería de Sistemas'),
('Contabilidad'),
('Diseño Gráfico');


INSERT INTO Ubigeo (departamento, provincia, distrito) VALUES
('Lima', 'Lima', 'San Juan de Lurigancho'),
('Cusco', 'Cusco', 'Santiago'),
('Arequipa', 'Arequipa', 'Cayma'),
('La Libertad', 'Trujillo', 'Florencia de Mora');


INSERT INTO Estudiante (
    dni, nombres, apellidos, fechaNacimiento, correo, telefono,
    idUbigeo, idPrograma, estado, fechaRegistro
) VALUES
('12345678', 'Carlos', 'Ramírez Soto', '2001-05-10', 'carlos.ramirez@example.com', '987654321', 1, 1, 'A', '2025-07-10 10:30:00'),
('87654321', 'María', 'López García', '2002-11-20', 'maria.lopez@example.com', '912345678', 2, 2, 'A', '2025-07-11 09:15:00'),
('11223344', 'Jorge', 'Fernández Díaz', '2000-03-15', 'jorge.fernandez@example.com', '901122334', 3, 3, 'I', '2025-07-12 16:45:00'),
('44332211', 'Lucía', 'Mendoza Ruiz', '1999-08-25', 'lucia.mendoza@example.com', '908877665', 4, 4, 'A', '2025-07-13 08:20:00');
