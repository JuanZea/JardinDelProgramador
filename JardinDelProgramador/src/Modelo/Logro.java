package Modelo;

/**
 * La clase que representa los logros de cada estudiante.
 * La clase logro tiene 3 atributos: Nombre - Un String que indica el nombre del logro.
 * Categoria - Un String que indica la categoria del 
 * logro, este puede ser: 
 * Desarrollo de pensamiento lógico matemático, Desarrollo de habilidades de análisis, 
 * Desarrollo de pensamiento sistemico, o Desarrollo de pensamiento creativo.
 * Calificacion - Un double indica la nota del estudiante que puede estar entre 0.0 y 5.0.
 * Objetivo - Un booleano que indica si el objetivo se cumplio o no. 
 * @author JuanZea
 * @version 1.0.2
 * @since Jardin 1.0.0
 */
public class Logro {
    private String nombre;
    private String categoria;
    private boolean objetivo;

    public Logro() {
    }

    public Logro(String nombre, String categoria, boolean objetivo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.objetivo = objetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isObjetivo() {
        return objetivo;
    }

    public void setObjetivo(boolean objetivo) {
        this.objetivo = objetivo;
    }
    
    
}
