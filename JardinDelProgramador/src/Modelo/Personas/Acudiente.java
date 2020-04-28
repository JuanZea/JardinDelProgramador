package Modelo.Personas;

import java.util.ArrayList;

/**
 * Esta clase representa a el acudiente de un niño.
 *
 * @author JuanZea
 * @version 1.0.1
 * @since Jardin 1.0.0
 */
public class Acudiente extends Persona {

    ArrayList<Niño> niños;
    private String horarioDeRecogida;
    private String parentesco;
    private String direccion;
    private String celular;

    public Acudiente() {
    }

    public Acudiente(String horarioDeRecogida, String parentesco, String direccion, String celular, String nombre, String edad, String tipoDeDocumento, String id) {
        super(nombre, edad, tipoDeDocumento, id);
        this.horarioDeRecogida = horarioDeRecogida;
        this.parentesco = parentesco;
        this.direccion = direccion;
        this.celular = celular;
    }
    
    public void asignarNiño(Niño niño){
        this.niños.add(niño);
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
