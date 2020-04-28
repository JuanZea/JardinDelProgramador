package Modelo;

/**
 * Esta clase representa un logro que es asignado a un niño.
 *
 * @author JuanZea
 * @version 1.0.3
 * @since Jardin 1.0.0
 */
public class Logro {

    private String nombre;
    private String categoria;
    private boolean objetivo;

    public Logro() {
    }

    /**
     *
     * @param nombre Indica el nombre del logro.
     * @param categoria Indica la categoria del logro. Solo puede ser:(Desarrollo de
     * pensamiento lógico matematico, Desarrolo de habilidades de análisis,
     * Desarrolo de habilidades de pensamiento sistémico, Desarrolo de
     * pensamiento creativo).
     * @param objetivo Indica si el logro se concidera como cumplido.
     */
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
