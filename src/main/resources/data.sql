-- Insertar rol Administrador
USE defaultdb;

INSERT IGNORE INTO rol (nombre) VALUES ('Administrador');
INSERT IGNORE INTO rol (nombre) VALUES ('Cliente');
-- Usuario administrador por defecto (contraseña: 123456, hash MD5: e10adc3949ba59abbe56e057f20f883e)
INSERT IGNORE INTO usuario (nombre, email, telefono, fecha_registro, id_rol, clave)
VALUES ('Admin', 'admin@vanjoeats.com', '03386948', '2025-08-01', 1, 'e10adc3949ba59abbe56e057f20f883e');