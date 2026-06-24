package mx.uam.cua;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ControladorQueries controller = new ControladorQueries("localhost", "3306", "escuela", "usr_escuela", "p455W0rd!");

        controller.execQuery("SELECT * from estudiantes");
        

    }
}