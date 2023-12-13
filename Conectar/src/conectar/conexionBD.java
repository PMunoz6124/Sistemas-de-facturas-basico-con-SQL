package conectar;

import conectar.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class conexionBD {

    private static Connection obtenerConexion() {
        return (Connection) Conectar.obtenerConexion();
    }

    private static void insertarDatosDeEjemplo() {
        try (Connection conexion = obtenerConexion();
             Scanner scanner = new Scanner(System.in)) {

            // Insertar datos en la tabla Factura
            String insertFacturaQuery = "INSERT INTO factura (n°_de_factura, Fecha, Cliente) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(insertFacturaQuery)) {
                // Get user input for Factura table
                System.out.print("Ingrese el número de factura: ");
                String numeroFactura = scanner.next();
                System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
                String fecha = scanner.next();
                System.out.print("Ingrese el nombre del cliente: ");
                String cliente = scanner.next();

                pstmt.setString(1, numeroFactura);
                pstmt.setString(2, fecha);
                pstmt.setString(3, cliente);
                pstmt.executeUpdate();
            }

            // Insertar datos en la tabla Detalle
            String insertDetalleQuery = "INSERT INTO detalles_de_facturas (ID_factura, Producto, Cantidad, Precio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(insertDetalleQuery)) {
                // Get user input for Detalle table
                System.out.print("Ingrese el ID de la factura: ");
                int idFactura = scanner.nextInt();
                System.out.print("Ingrese el nombre del producto: ");
                String producto = scanner.next();
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                System.out.print("Ingrese el precio: ");
                double precio = scanner.nextDouble();

                pstmt.setInt(1, idFactura);
                pstmt.setString(2, producto);
                pstmt.setInt(3, cantidad);
                pstmt.setDouble(4, precio);
                pstmt.executeUpdate();
            }

            // Commit the transaction
            conexion.commit();
            System.out.println("Datos ingresados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertarDatosDeEjemplo();
    }
}
