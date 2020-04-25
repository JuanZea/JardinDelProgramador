package Modelo.Personas;

/**
 * Esta clase es la representacion de una persona como molde para los integrantes
 * de la institucion.
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Persona {

    private String nombre;
    private String tipoDeDocumento;
    private int id;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String tipoDeDocumento, int id, int edad) {
        this.nombre = nombre;
        this.tipoDeDocumento = tipoDeDocumento;
        this.id = id;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
