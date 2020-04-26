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
    private String id;
    private String edad;

    public Persona() {
    }

    public Persona(String nombre, String tipoDeDocumento, String id, String edad) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
