package mx.uam.cua;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD("localhost", "3306", "escuela", "usr_escuela", "p455W0rd!");

        Statement sentencia = null;
        ResultSet resultado = null;
        conexion.conectar();

        try {
            sentencia = conexion.getConexion().createStatement();
            String sql = "SELECT id, nombre, apellido FROM estudiantes";
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                
                System.out.println(id + " - "+ nombre+ " - "+ apellido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(resultado != null){
                    resultado.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            try{
                if(sentencia != null){
                    sentencia.close();
                }
            }catch(SQLException e){
                System.err.println(e.getMessage());          
            }
            try {
                if(conexion != null){
                    conexion.getConexion().close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }



        
        


    }
}