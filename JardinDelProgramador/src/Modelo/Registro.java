/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Personas.*;
import java.util.ArrayList;

/**
 * Esta clase representa un bloque de registro bimensual.
 *
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.2
 */
public class Registro {

    private int dia;
    private int mes;
    private int año;
    private Profesor profesor;
    private Niño niño;
    private ArrayList<Logro> logros = new ArrayList<Logro>();
    private int valoracion;

    public Registro(int dia, int mes, int año, Profesor profesor, Niño niño, Logro logro, int valoracion) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.profesor = profesor;
        this.niño = niño;
        this.logros.add(logro);
        this.valoracion = valoracion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
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

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }

    
    
}
