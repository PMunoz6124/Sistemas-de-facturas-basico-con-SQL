# Sistemas-de-facturas-basico-con-SQL
Un sistema bastante basico en el cual se ingresan los datos de la factura por consola y al terminar se agregan al SQL
si usas Xampp crea una tabla o usa la siguiente


CREATE DATABASE IF NOT EXISTS Ventas;
USE Ventas;

-- Crear la tabla Factura
CREATE TABLE IF NOT EXISTS Factura (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    numero_factura VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    cliente VARCHAR(50) NOT NULL
);

-- Crear la tabla Detalle
CREATE TABLE IF NOT EXISTS Detalle (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT,
    producto VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura)
);

