package Modelo;

import Modelo.Personas.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta clase representa un bloque de registro bimensual.
 *
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.3
 */
public class Registro {

    private Calendar fecha;
    private Profesor profesor;
    private Niño niño;
    private Logro logro;
    private int valoracion;

    public Registro() {
    }

    /**
     *
     * @param fecha Indica la fecha en la que se hizo el registro.
     * @param profesor Indica el profesor que hizo el registro.
     * @param niño Indica el niño al cual se le hizo el registro.
     * @param logro Indica el logro del registro.
     * @param valoracion Indica la valoracion del logro del registro. Solo puede
     * ser (Incapaz, Medianamente competente, Competente, Capaz, Crack)
     */
    public Registro(Calendar fecha, Profesor profesor, Niño niño, Logro logro, int valoracion) {
        this.fecha = fecha;
        this.profesor = profesor;
        this.niño = niño;
        this.logro = logro;
        this.valoracion = valoracion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Niño getNiño() {
        return niño;
    }

    public void setNiño(Niño niño) {
        this.niño = niño;
    }

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

}
