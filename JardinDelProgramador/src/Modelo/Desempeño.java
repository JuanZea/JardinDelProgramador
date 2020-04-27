/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Esta clase representa el desempeño de un bimestre del año para un niño
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.2
 */
public class Desempeño {
    
    private Registro mes1;
    private Registro mes2;

    public Desempeño(Registro mes1, Registro mes2) {
        this.mes1 = mes1;
        this.mes2 = mes2;
    }

    public Registro getMes2() {
        return mes2;
    }

    public void setMes2(Registro mes2) {
        this.mes2 = mes2;
    }

    public Registro getMes1() {
        return mes1;
    }

    public void setMes1(Registro mes1) {
        this.mes1 = mes1;
    }
    
    
}
