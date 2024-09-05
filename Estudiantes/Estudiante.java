package Estudiantes;

import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private int id;
    private String nombre;
    private List<Integer> calificaciones;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public class CalificacionInvalidaException extends Exception {
        public CalificacionInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public void agregarCalificacion(int calificacion) {
        try {
            if (calificacion > 100) {
                throw new CalificacionInvalidaException("La calificacion no puede ser superior a 100");
            }
            this.calificaciones.add(calificacion);
        } catch (CalificacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return (double) suma / calificaciones.size();
    }
}

class SistemaGestionEstudiantes {
    private List<Estudiante> estudiantes;

    public SistemaGestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre());
        }
    }

    public Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public void calcularPromedioDeEstudiante(int id) {
        Estudiante estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            System.out.println("Promedio de " + estudiante.getNombre() + ": " + estudiante.calcularPromedio());
        } else {
            System.out.println("Estudiante con ID " + id + " no encontrado.");
        }
    }

}
