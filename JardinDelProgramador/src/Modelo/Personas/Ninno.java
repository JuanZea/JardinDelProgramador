package Modelo.Personas;

/**
 * Esta clase representa a el niño matriculado en la institucion, con informacion relevante
 * como la talla y el peso, para aplicaciones de salud, y ademas una descripcion de
 * su situacion especial si tiene alguna, en caso contrario este atributo sera un NA.
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Ninno extends Persona {

    private Double talla;
    private Double peso;
    private String situacionEspecial;

    public Ninno() {
    }

    public Ninno(Double talla, Double peso, String situacionEspecial, String nombre, String tipoDeDocumento, String id, String edad) {
        super(nombre, tipoDeDocumento, id, edad);
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getSituacionEspecial() {
        return situacionEspecial;
    }

    public void setSituacionEspecial(String situacionEspecial) {
        this.situacionEspecial = situacionEspecial;
    }
}
