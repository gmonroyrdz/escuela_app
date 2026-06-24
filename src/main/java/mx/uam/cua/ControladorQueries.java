package mx.uam.cua;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorQueries {
    private ConexionBD conexion;

    public ControladorQueries(String ip, String port, String db, String user, String password){
        this.conexion = new ConexionBD(ip, port, db, user, password);
    }

    public void execQuery(String sqlSentence){
        Statement sentencia = null;
        ResultSet resultado = null;
        conexion.conectar();

        try {
            sentencia = conexion.getConexion().createStatement();
            String sql = sqlSentence;
            resultado = sentencia.executeQuery(sql);

            // Obtener el nombre de las columnas de la tabla(s) consultadas.
            ResultSetMetaData rsmd = resultado.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for(int i = 1; i <= columnsNumber; i++){
                System.out.print(rsmd.getColumnName(i)+ " | ");
            }
            System.out.println("\n==========================");
            while (resultado.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultado.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
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
