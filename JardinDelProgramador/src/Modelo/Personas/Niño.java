package Modelo.Personas;

import Modelo.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta clase representa a un niño matriculado en la institución.
 *
 * @author JuanZea
 * @version 1.0.3
 * @since Jardin 1.0.0
 */
public class Niño extends Persona {

    private String talla;
    private String peso;
    private String situacionEspecial = "NA";
    private ArrayList<Logro> logros = new ArrayList<Logro>();
    private ArrayList<Acudiente> acudientes = new ArrayList<Acudiente>();
    private ArrayList<Registro> registros = new ArrayList<Registro>();
    private boolean desempeñoActualizado = false;

    public Niño() {
    }

    /**
     *
     * @param talla Indica la alura del niño en metros.
     * @param peso Indica el peso del niño en Kilogramos.
     * @param situacionEspecial Indica la situacion especial que el niño tenga.
     * Si no tiene ninguna su valor es NA.
     * @param acudiente Indica el acudiente que debe tener el niño como mínimo.
     */
    public Niño(String talla, String peso, String situacionEspecial, String nombre, String tipoDeDocumento, String id, String edad, Acudiente acudiente) {
        super(nombre, tipoDeDocumento, id, edad);
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.acudientes.add(acudiente);
    }

    /**
     * Actualiza los atributos de cada logro del niño basandose en los registros
     * que posea en el momento.
     */
    public void actualizarDesempeño() {
        for (int i = 0; i < this.registros.size() - 1; i++) {
            int añoI = registros.get(i).getFecha().get(Calendar.YEAR);
            int mesI = registros.get(i).getFecha().get(Calendar.MONTH);
            int diaI = registros.get(i).getFecha().get(Calendar.DAY_OF_MONTH);
            for (int j = i + 1; j < this.registros.size(); j++) {
                int añoJ = registros.get(j).getFecha().get(Calendar.YEAR);
                int mesJ = registros.get(j).getFecha().get(Calendar.MONTH);
                int diaJ = registros.get(j).getFecha().get(Calendar.DAY_OF_MONTH);
                if (añoI == añoJ && mesesCompatibles(mesI, mesJ)) {
                    generarDesempeño(registros.get(i), registros.get(j));
                }
            }

        }
        this.desempeñoActualizado = true;
    }

    /**
     * Compara los logros de dos registros de meses compatibles y determina si
     * ese logro fue alcanzado por el niño.
     *
     * @param r1 Indica le primer registro a comparar.
     * @param r2 Indica le segundo registro a comparar.
     */
    private void generarDesempeño(Registro r1, Registro r2) {
        if (r1.getLogro() == r2.getLogro()) {
            if (r1.getValoracion() + r2.getValoracion() >= 4) {
                for (Logro logro : this.logros) {
                    if (logro.equals(r1.getLogro())) {
                        logro.setObjetivo(true);
                    }
                }
            }
        }
    }

    /**
     * Determina si dos meses son compatibles para extraer un desempeño entre
     * ellos. Dos meses seran compatibles si pertenecen al mismo bimestre. En el
     * año se presentan 6 bimestres, el primero es enero-febrero, el segundo es
     * marzo-abril, y asi sucesivamente.
     *
     * @param mes1 Indica el primer mes a comparar.
     * @param mes2 Indica el segundo mes a comparar.
     * @return
     */
    public boolean mesesCompatibles(int mes1, int mes2) {
        int zea = mes1 + mes2;
        if (zea == 1 || zea == 5 || zea == 9 || zea == 13 || zea == 17 || zea == 21) {
            return true;
        }
        return false;
    }

    public void asignarAcudiente(Acudiente acudiente) {
        this.desempeñoActualizado = false;
        acudientes.add(acudiente);
    }

    public void asignarLogro(Logro logro) {
        this.desempeñoActualizado = false;
        this.logros.add(logro);
    }
    
    public void asignarRegistro(Registro registro) {
        this.desempeñoActualizado = false;
        this.registros.add(registro);
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.desempeñoActualizado = false;
        this.talla = talla;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.desempeñoActualizado = false;
        this.peso = peso;
    }

    public String getSituacionEspecial() {
        return situacionEspecial;
    }

    public void setSituacionEspecial(String situacionEspecial) {
        this.desempeñoActualizado = false;
        this.situacionEspecial = situacionEspecial;
    }

    public ArrayList<Acudiente> getAcudientes() {
        return acudientes;
    }

    public void setAcudientes(ArrayList<Acudiente> acudientes) {
        this.desempeñoActualizado = false;
        this.acudientes = acudientes;
    }

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.desempeñoActualizado = false;
        this.logros = logros;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.desempeñoActualizado = false;
        this.registros = registros;
    }

    public boolean isDesempeñoActualizado() {
        return desempeñoActualizado;
    }

    public void setDesempeñoActualizado(boolean desempeñoActualizado) {
        this.desempeñoActualizado = desempeñoActualizado;
    }
}
