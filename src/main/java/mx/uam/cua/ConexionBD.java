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

    public Connection conectar(){
        this.conexion = null;
        try {
            String stringConnection = generateStringConnection(this.ip, this.port, this.db);
            conexion = DriverManager.getConnection(stringConnection, this.user, this.password);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
        }
        return conexion;
    }
    public void desconectar(){

    }
}
