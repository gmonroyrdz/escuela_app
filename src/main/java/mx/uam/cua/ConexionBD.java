package mx.uam.cua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private String user;
    private String password;
    private String port;
    private String ip;
    private String db;
    private Connection conexion;

    public ConexionBD(String ip, String port, String db, String user, String password){
        this.user = user;
        this.ip = ip;
        this.port = port;
        this.db = db;
        this.password = password;
    }

    public Connection getConexion() {
        return conexion;
    }

    private String generateStringConnection(String ip, String port, String db){
        StringBuilder str = new StringBuilder();
        str.append("jdbc:mysql://");
        str.append(ip);
        str.append(":");
        str.append(port);
        str.append("/");
        str.append(db);
        str.append("?useSSL=false&serverTimezone=UTC");
        return str.toString();
    }

    public void conectar(){
        this.conexion = null;
        try {
            String stringConnection = generateStringConnection(this.ip, this.port, this.db);
            this.conexion = DriverManager.getConnection(stringConnection, this.user, this.password);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
        }
    }
    public void desconectar(){
        if(this.conexion != null){
            try {
                this.conexion.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
