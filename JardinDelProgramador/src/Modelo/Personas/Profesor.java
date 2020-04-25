package Modelo.Personas;

/**
 * Esta clase representa a un profesor del jardin, tendra como atributos: el semestre
 * y universidad respectivas ya que el profesor es un estudiante universitario de hasta
 * quinto semetre, ademas tendra una especialidad ligada a una categoria de la clase
 * logro.
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Profesor extends Persona {

    private int semestre;
    private String especialidad;
    private String universidad;

    public Profesor(int semestre, String especialidad, String universidad, String nombre, String tipoDeDocumento, int id, int edad) {
        super(nombre, tipoDeDocumento, id, edad);
        this.semestre = semestre;
        this.especialidad = especialidad;
        this.universidad = universidad;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}
