/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Modelo.Personas.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Esta clase se encargara de controlar toda la logica detras del programa. Es
 * una de las clases vitales.
 *
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.0
 */
public class Programa {

    public static void main(String[] args) {

        Institucion ins1 = new Institucion(null, null,
                null, null, null, 0);

        ArrayList<Profesor> profesores = new ArrayList<Profesor>();

        Ventana ven1 = new Ventana();
        ven1.setVisible(true);

        ins1.setNombre(ven1.getjTextFieldNombre().getText());
        ins1.setCaracter(ven1.getjTextFieldCaracter().getText());
        ins1.setAñoFundacion(ven1.getjTextFieldAño().getText());
        ins1.setDireccion(ven1.getjTextFieldDireccion().getText());
        ins1.setNit(ven1.getjTextFieldNit().getText());

        ven1.getjButtonAñadirProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Añadir Profesor");
                Profesor p1 = añadirProfesor();
                if (p1 != null) {
                    profesores.add(p1);
                        String[] listaTemp = new String[profesores.size()];
                        for (int i = 0; i < profesores.size(); i++) {
                            listaTemp[i] = profesores.get(i).getNombre();
                        }
                        ven1.getjListProfesores().setListData(listaTemp);
                    }
                }
            }
        );

    }

    public static Profesor añadirProfesor() {
        AñadirProfesor v1 = new AñadirProfesor(new javax.swing.JFrame(), true);
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Profesor p1 = new Profesor(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            return p1;
        }
        return null;
    }
}
