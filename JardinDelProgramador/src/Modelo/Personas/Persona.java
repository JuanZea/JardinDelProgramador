package Modelo.Personas;

/**
 * Esta clase es la representacion de una persona y se usa para crear a los
 * integrantes de la insticutión.
 *
 * @author JuanZea
 * @version 1.0.1
 * @since Jardin 1.0.0
 */
public class Persona {

    private String nombre;
    private String edad;
    private String tipoDeDocumento;
    private String id;

    public Persona() {
    }
    
    /**
     * 
     * @param nombre Indica el nombre de la persona.
     * @param edad Indica la edad de una persona.
     * @param tipoDeDocumento Indica el tipo de documento de la persona.
     * @param id Indica el id del documento de identidad de la persona.
     */
    public Persona(String nombre, String edad, String tipoDeDocumento, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoDeDocumento = tipoDeDocumento;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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
}
