package Modelo.Personas;

import Modelo.*;
import java.util.ArrayList;

/**
 * Esta clase representa a el niño matriculado en la institucion, con
 * informacion relevante como la talla y el peso, para aplicaciones de salud, y
 * ademas una descripcion de su situacion especial si tiene alguna, en caso
 * contrario este atributo sera un NA.
 *
 * @author JuanZea
 * @version 1.0.2
 * @since Jardin 1.0.0
 */
public class Niño extends Persona {

    private String talla;
    private String peso;
    private String situacionEspecial;
    private ArrayList<Logro> logros = new ArrayList<Logro>();
    private ArrayList<Acudiente> acudientes = new ArrayList<Acudiente>();
    private Desempeño[] desempeños = new Desempeño[6];
    private Registro[] registros = {null, null, null, null, null, null, null, null, null, null, null, null};
    private int cantDes = 0;

    public Niño() {
    }

    public Niño(String talla, String peso, String situacionEspecial, String nombre, String tipoDeDocumento, String id, String edad, Acudiente acudiente) {
        super(nombre, tipoDeDocumento, id, edad);
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.acudientes.add(acudiente);
    }

    public boolean[] buscarDesempeño() {
        boolean[] posibles = new boolean[6];
        for (int i = 0; i < 6; i++) {
            posibles[i] = false;
        }
        for (int i = 0; i < 12; i=i+2) {
            if((registros[0+i] != null && registros[1+i]!= null)&&(registros[0+i].getAño() == registros[1+i].getAño())){
                posibles[i/2] = true;
            }
        }
        return posibles;
        
        
//        if (mes1 == null || mes2 == null) {
//            return 1;
//        }
//        if (mes1.getAño() != mes2.getAño()) {
//            return 2;
//        }
//        int sum = mes1.getMes() + mes2.getMes();
//        if (sum != 1 || sum != 5 || sum != 9 || sum != 13 || sum != 17 || sum != 21) {
//            return 3;
//        }
//        //if
//        cantDes++;
//        return 0;
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

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }

    public void añadirLogro(Logro l1) {
        this.logros.add(l1);
    }

    public Desempeño[] getDesempeños() {
        return desempeños;
    }

    public void setDesempeños(Desempeño[] desempeños) {
        this.desempeños = desempeños;
    }

    public Registro[] getRegistros() {
        return registros;
    }

    public void setRegistros(Registro[] registros) {
        this.registros = registros;
    }

    public int getCantDes() {
        return cantDes;
    }

    public void setCantDes(int cantDes) {
        this.cantDes = cantDes;
    }
}
