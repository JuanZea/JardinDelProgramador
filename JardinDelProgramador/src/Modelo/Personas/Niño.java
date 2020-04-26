package Modelo.Personas;

import java.util.ArrayList;

/**
 * Esta clase representa a el niño matriculado en la institucion, con informacion relevante
 * como la talla y el peso, para aplicaciones de salud, y ademas una descripcion de
 * su situacion especial si tiene alguna, en caso contrario este atributo sera un NA.
 * @author JuanZea
 * @version 1.0.1
 * @since Jardin 1.0.0
 */
public class Niño extends Persona {

    private String talla;
    private String peso;
    private String situacionEspecial;
    private ArrayList<Acudiente> acudientes = new ArrayList<Acudiente>();

    public Niño() {
    }

    public Niño(String talla, String peso, String situacionEspecial, String nombre, String tipoDeDocumento, String id, String edad, Acudiente acudiente) {
        super(nombre, tipoDeDocumento, id, edad);
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.acudientes.add(acudiente);
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSituacionEspecial() {
        return situacionEspecial;
    }

    public void setSituacionEspecial(String situacionEspecial) {
        this.situacionEspecial = situacionEspecial;
    }

    public ArrayList<Acudiente> getAcudientes() {
        return acudientes;
    }

    public void setAcudientes(ArrayList<Acudiente> acudientes) {
        this.acudientes = acudientes;
    }
}
