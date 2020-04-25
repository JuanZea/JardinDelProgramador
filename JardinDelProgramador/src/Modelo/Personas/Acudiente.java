package Modelo.Personas;

/**
 * Esta clase representa a el acudiente de un niño, el cual puede ser un pariente,
 * tendra una hora de recogida definida por seguridad y orden, tendra la direccion de
 * residencia que puede ser la del niño si vive con el, y como medio de comunicacion
 * un numero de celular.
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Acudiente extends Persona {

    private String horarioDeRecogida;
    private String parentesco;
    private String direccion;
    private String celular;

    public Acudiente() {
    }

    public Acudiente(String horarioDeRecogida, String parentesco, String direccion, String celular, String nombre, String tipoDeDocumento, int id, int edad) {
        super(nombre, tipoDeDocumento, id, edad);
        this.horarioDeRecogida = horarioDeRecogida;
        this.parentesco = parentesco;
        this.direccion = direccion;
        this.celular = celular;
    }

    public String getHorarioDeRecogida() {
        return horarioDeRecogida;
    }

    public void setHorarioDeRecogida(String horarioDeRecogida) {
        this.horarioDeRecogida = horarioDeRecogida;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
