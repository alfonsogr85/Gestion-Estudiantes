package Estudiantes;
import javax.swing.JOptionPane;

public class Datos_estudiantes {
    public static void main(String[] args) {
        // Crear instancia del sistema de gestión
        SistemaGestionEstudiantes sistema = new SistemaGestionEstudiantes();

        Estudiante est1 = new Estudiante(1, "Cristina");

        est1.agregarCalificacion(75);
        est1.agregarCalificacion(42);
        est1.agregarCalificacion(94);

        Estudiante est2 = new Estudiante(2, "Alfonso");
        est2.agregarCalificacion(88);
        est2.agregarCalificacion(92);

        // Agregar estudiantes al sistema
        sistema.agregarEstudiante(est1);
        sistema.agregarEstudiante(est2);

        // Listar todos los estudiantes
        sistema.listarEstudiantes();


    }
}
