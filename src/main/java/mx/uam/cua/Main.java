package mx.uam.cua;


public class Main {
    public static void main(String[] args) {
        ControladorQueries controller = new ControladorQueries("localhost", "3306", "escuela", "usr_escuela", "p455W0rd!");

        controller.execQuery("SELECT * from estudiantes");
        System.out.println("====================================");

        controller.execQuery("SELECT e.nombre, e.apellido, c.nombre as 'nombre del curso' FROM estudiantes e INNER JOIN inscripciones i ON e.id = i.id_estudiante INNER JOIN cursos c ON c.id = i.id_curso WHERE c.nombre ="+ "'Álgebra'");

        System.out.println("====================================");

        controller.getEstudiantesByCurso("Álgebra");




    }
}