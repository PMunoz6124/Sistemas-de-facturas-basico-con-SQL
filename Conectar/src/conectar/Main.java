/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectar;

/**
 *
 * @author alejandro
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    
    public static void main(String[] args) {
        
      Connection conexion = Conectar.obtenerConexion(); 
       try {
            String consulta = "SELECT * FROM factura ";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
              
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conectar.cerrarConexion(conexion);
        }
    }
    
}
