package mx.uam.cua;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = ConexionBD.conectar();
        
        if(conn != null){
            System.out.println("La conexión se realizó correctamente.");
        }else{
            System.out.println("No se pudo conectar.");
        }
    }
}