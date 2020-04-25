package Modelo;

/**
 * La clase que representa los logros de cada estudiante.
 * La clase logro tiene 3 atributos: Tipo -> Un String que se determina basado en el
 * atributo calificacion de manera automatica, el tipo puede ser:
 * Dificultad, Aceptable, Capaz, o Muy Capaz.
 * Categoria -> Un String que indica la categoria del 
 * logro, este puede ser: 
 * Desarrollo de pensamiento lógico matemático, Desarrollo de habilidades de análisis, 
 * Desarrollo de pensamiento sistemico, o Desarrollo de pensamiento creativo.
 * Calificacion -> Un double indica la nota del estudiante que puede estar entre 0.0 y 5.0.
 * Objetivo -> Un booleano que indica si el objetivo se cumplio o no. 
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Logro {
    private String tipo;
    private String categoria;
    private double calificacion;
    private boolean objetivo;

    public Logro() {
    }

    public Logro(String tipo, String categoria, double calificacion, boolean objetivo) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.objetivo = objetivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isObjetivo() {
        return objetivo;
    }

    public void setObjetivo(boolean objetivo) {
        this.objetivo = objetivo;
    }
    
    
}
