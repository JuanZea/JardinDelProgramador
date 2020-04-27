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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Esta clase se encargara de controlar toda la logica detras del programa. Es
 * una de las clases vitales.
 *
 * @author JuanZea
 * @version 1.0.2
 * @since Jardin 1.0.0
 */
public class Programa {

    static ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    static DefaultListModel listaProfesores = new DefaultListModel();
    static ArrayList<Niño> niños = new ArrayList<Niño>();
    static DefaultListModel listaNiños = new DefaultListModel();
    static ArrayList<Acudiente> acudientes = new ArrayList<Acudiente>();
    static DefaultListModel listaAcudientes = new DefaultListModel();
    static ArrayList<Logro> logros = new ArrayList<Logro>();
    static Boolean isConfigurado = false;

    /**
     * El metodo principal del programa, donde reside la mayor parte de la
     * logica.
     *
     * @param args Por default
     */
    public static void main(String[] args) {

        //Se crea una institución y un conjunto de ArrayLists para cada tipo de persona
        Institucion ins1 = new Institucion(null, null,
                null, null, null, 0);

        //Se crea una ventana principal para la interaccion con el usuario
        Ventana ven1 = new Ventana();
        ven1.setVisible(true);

        //Eventos y variables de la pestaña Menu Principal|--------------------------------
        ven1.getjButtonAsignarLogro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsignarLogro v1 = new AsignarLogro(null, true);
                v1.rellenarEstudiantes(niños);
                v1.setVisible(true);
                if (v1.isSeñal()) {
                    Logro l1 = v1.getLogro();
                    logros.add(l1);
                    int dueño = v1.getDueño();
                    niños.get(dueño).añadirLogro(l1);
                }
            }
        });

        ven1.getjButtonGenerarReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerarReporte v1 = new GenerarReporte(null, true);
                v1.setArrays(niños, profesores, logros);
                v1.rellenarBoxes();
                v1.setVisible(true);
                if (v1.isSeñal()) {
                    Registro r1 = v1.getRegistro();
                    registrar(r1);
                    boolean[] pos = r1.getNiño().buscarDesempeño();
                    for (boolean po : pos) {
                        System.out.println(po);
                    }
                }
            }
        });
        //---------------------------------------------------------------------------------

        //Eventos y variables de la pestaña Configuracion|---------------------------------
        ven1.getjButtonGuardarConfiguracion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si hay algo en blanco
                if (ven1.getjTextFieldNombre().getText().isBlank() || ven1.getjTextFieldCaracter().getText().isBlank() || ven1.getjTextFieldAño().getText().isBlank() || ven1.getjTextFieldDireccion().getText().isBlank() || ven1.getjTextFieldNit().getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Hacen uno o varios datos");
                } else {
                    //Desactiva la edicion
                    ven1.getjTextFieldNombre().setEnabled(false);
                    ven1.getjTextFieldCaracter().setEnabled(false);
                    ven1.getjTextFieldAño().setEnabled(false);
                    ven1.getjTextFieldDireccion().setEnabled(false);
                    ven1.getjTextFieldNit().setEnabled(false);
                    //Guardamos los datos
                    ins1.setNombre(ven1.getjTextFieldNombre().getText());
                    ins1.setCaracter(ven1.getjTextFieldCaracter().getText());
                    ins1.setAñoFundacion(ven1.getjTextFieldAño().getText());
                    ins1.setDireccion(ven1.getjTextFieldDireccion().getText());
                    ins1.setNit(ven1.getjTextFieldNit().getText());
                    setIsConfigurado(true);
                }
            }
        });

        ven1.getjButtonLimpiarConfiguracion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Activa la edicion
                ven1.getjTextFieldNombre().setEnabled(true);
                ven1.getjTextFieldCaracter().setEnabled(true);
                ven1.getjTextFieldAño().setEnabled(true);
                ven1.getjTextFieldDireccion().setEnabled(true);
                ven1.getjTextFieldNit().setEnabled(true);
                //Limpia los cuadros
                ven1.getjTextFieldNombre().setText("");
                ven1.getjTextFieldCaracter().setText("");
                ven1.getjTextFieldAño().setText("");
                ven1.getjTextFieldDireccion().setText("");
                ven1.getjTextFieldNit().setText("");
                setIsConfigurado(false);
            }
        });
        //---------------------------------------------------------------------------------

        //Eventos la pestaña Profesores|---------------------------------------------------
        ven1.getjListProfesores().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!ven1.getjListProfesores().isSelectionEmpty()) {
                    int index = ven1.getjListProfesores().getSelectedIndex();
                    ven1.getjTextAreaProfesor().setText(describirProfesor(index));
                } else {
                    ven1.getjTextAreaProfesor().setText("");
                }
            }
        });

        ven1.getjButtonAñadirProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profesor p1 = añadirProfesor();
                if (p1 != null) {
                    profesores.add(p1);
                    listaProfesores.addElement(p1.getNombre());
                    ven1.getjListProfesores().setModel(listaProfesores);
                }
            }
        }
        );

        ven1.getjButtonEditarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListProfesores().getSelectedIndex() != -1) {
                    int index = ven1.getjListProfesores().getSelectedIndex();
                    Profesor p1 = editarProfesor(index);
                    if (p1 != null) {
                        profesores.set(index, p1);
                        listaProfesores.set(index, p1.getNombre());
                        ven1.getjListProfesores().setModel(listaProfesores);
                    }
                }
            }
        });

        ven1.getjButtonEliminarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListProfesores().getSelectedIndex() != -1) {
                    int index = ven1.getjListProfesores().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este profesor?");
                    if (ans == 0) {
                        profesores.remove(index);
                        listaProfesores.remove(index);
                    }

                }
            }
        });
        //---------------------------------------------------------------------------------

        //Eventos la pestaña Niños|--------------------------------------------------------
        ven1.getjListNiños().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!ven1.getjListNiños().isSelectionEmpty()) {
                    int index = ven1.getjListNiños().getSelectedIndex();
                    ven1.getjTextAreaNiños().setText(describirNiño(index));
                } else {
                    ven1.getjTextAreaNiños().setText("");
                }
            }
        });

        ven1.getjButtonAñadirNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Niño n1 = añadirNiño();
                if (n1 != null) {
                    niños.add(n1);
                    listaNiños.addElement(n1.getNombre());
                    ven1.getjListNiños().setModel(listaNiños);
                    ins1.setMatriculados(ins1.getMatriculados() + 1);
                    ven1.getjTextFieldMatriculados().setText(String.valueOf(ins1.getMatriculados()));
                }
            }
        }
        );

        ven1.getjButtonEditarNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListNiños().getSelectedIndex() != -1) {
                    int index = ven1.getjListNiños().getSelectedIndex();
                    Niño n1 = editarNiño(index);
                    if (n1 != null) {
                        niños.set(index, n1);
                        listaNiños.set(index, n1.getNombre());
                        ven1.getjListNiños().setModel(listaNiños);
                    }
                }
            }
        });

        ven1.getjButtonEliminarNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListNiños().getSelectedIndex() != -1) {
                    int index = ven1.getjListNiños().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este niño?");
                    if (ans == 0) {
                        niños.remove(index);
                        listaNiños.remove(index);
                        ins1.setMatriculados(ins1.getMatriculados() - 1);
                        ven1.getjTextFieldMatriculados().setText(String.valueOf(ins1.getMatriculados()));
                    }

                }
            }
        });
        //---------------------------------------------------------------------------------

        //Eventos la pestaña Acudiente|-----------------------------------------------------
        ven1.getjListAcudientes().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!ven1.getjListAcudientes().isSelectionEmpty()) {
                    int index = ven1.getjListAcudientes().getSelectedIndex();
                    ven1.getjTextAreaAcudientes().setText(describirAcudiente(index));
                } else {
                    ven1.getjTextAreaAcudientes().setText("");
                }
            }
        });

        ven1.getjButtonAñadirAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acudiente a1 = añadirAcudiente();
                if (a1 != null) {
                    acudientes.add(a1);
                    listaAcudientes.addElement(a1.getNombre());
                    ven1.getjListAcudientes().setModel(listaAcudientes);
                }
            }
        }
        );

        ven1.getjButtonEditarAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListAcudientes().getSelectedIndex() != -1) {
                    int index = ven1.getjListAcudientes().getSelectedIndex();
                    Acudiente a1 = editarAcudiente(index);
                    if (a1 != null) {
                        acudientes.set(index, a1);
                        listaAcudientes.set(index, a1.getNombre());
                        ven1.getjListAcudientes().setModel(listaAcudientes);
                    }
                }
            }
        });

        ven1.getjButtonEliminarAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ven1.getjListAcudientes().getSelectedIndex() != -1) {
                    int index = ven1.getjListAcudientes().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este profesor?");
                    if (ans == 0) {
                        acudientes.remove(index);
                        listaAcudientes.remove(index);
                    }

                }
            }
        });
        //---------------------------------------------------------------------------------
    }

    public static void registrar(Registro r) {
        boolean ag = false;
        Registro[] registros = r.getNiño().getRegistros();
        if (registros[r.getMes()] == null || registros[r.getMes()].getAño() < r.getAño() || (registros[r.getMes()].getDia() < r.getDia() && registros[r.getMes()].getAño() <= r.getAño())) {
            registros[r.getMes()] = r;
        } else {
            for (int i = 0; i < registros[r.getMes()].getLogros().size(); i++) {
                if (r.getLogros().get(0) != registros[r.getMes()].getLogros().get(i)) {
                    ag = true;
                }
            }
            if (ag) {
                registros[r.getMes()].getLogros().add(r.getLogros().get(0));
            }
        }
        r.getNiño().setRegistros(registros);
    }

    public static void setIsConfigurado(boolean b) {
        isConfigurado = b;
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

    public static Profesor editarProfesor(int i) {
        AñadirProfesor v1 = new AñadirProfesor(new javax.swing.JFrame(), true);
        v1.setTitle("Editar Profesor");
        v1.getjTextFieldNombre().setText(profesores.get(i).getNombre());
        v1.getjTextFieldUniversidad().setText(profesores.get(i).getUniversidad());
        v1.getjTextFieldEdad().setText(profesores.get(i).getEdad());
        v1.getjTextFieldTipoDocumento().setText(profesores.get(i).getTipoDeDocumento());
        v1.getjTextFieldId().setText(profesores.get(i).getId());
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Profesor p1 = new Profesor(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            return p1;
        }
        return null;
    }

    public static String describirProfesor(int i) {
        String nombre = profesores.get(i).getNombre();
        String edad = profesores.get(i).getEdad();
        String universidad = profesores.get(i).getUniversidad();
        String tipoDoc = profesores.get(i).getTipoDeDocumento();
        String id = profesores.get(i).getId();
        String especialidad = profesores.get(i).getEspecialidad();
        String semestre = String.valueOf(profesores.get(i).getSemestre());
        String desc = "El profesor " + nombre + " de " + edad + " años de edad,\n"
                + "estudia en la " + universidad + " y esta en el semestre #" + semestre
                + ",\nesta identificado con " + tipoDoc + ": " + id + "\ny se especializa en lo " + especialidad;
        return desc;
    }

    public static Niño añadirNiño() {
        AñadirNiño v1 = new AñadirNiño(new javax.swing.JFrame(), true);
        v1.setAcudientes(acudientes);
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Niño n1 = new Niño(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], acudientes.get(Integer.parseInt(datos[7])));
            return n1;
        }
        return null;
    }

    public static Niño editarNiño(int i) {
        AñadirNiño v1 = new AñadirNiño(new javax.swing.JFrame(), true);
        v1.setTitle("Editar Niño");
        v1.getjTextFieldNombre().setText(niños.get(i).getNombre());
        v1.getjTextFieldPeso().setText(niños.get(i).getPeso());
        v1.getjTextFieldEdad().setText(niños.get(i).getEdad());
        v1.getjTextFieldTipoDocumento().setText(niños.get(i).getTipoDeDocumento());
        v1.getjTextFieldId().setText(niños.get(i).getId());
        v1.getjTextFieldTalla().setText(niños.get(i).getTalla());
        v1.getjTextFieldSituacion().setText(niños.get(i).getSituacionEspecial());
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Niño n1 = new Niño(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], acudientes.get(Integer.parseInt(datos[7])));
            return n1;
        }
        return null;
    }

    public static String describirNiño(int i) {
        String nombre = niños.get(i).getNombre();
        String edad = niños.get(i).getEdad();
        String Situacion = niños.get(i).getSituacionEspecial();
        String tipoDoc = niños.get(i).getTipoDeDocumento();
        String id = niños.get(i).getId();
        String peso = niños.get(i).getPeso();
        String talla = niños.get(i).getTalla();
        String desc = "El niño " + nombre + " de " + edad + " años de edad,\n"
                + "tiene un peso de " + peso + " y una talla de " + talla
                + ",\nesta identificado con " + tipoDoc + ": " + id
                + "\ny su situacion especial es: " + Situacion;
        return desc;
    }

    public static Acudiente añadirAcudiente() {
        AñadirAcudiente v1 = new AñadirAcudiente(new javax.swing.JFrame(), true);
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Acudiente a1 = new Acudiente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[6]);
            return a1;
        }
        return null;
    }

    public static Acudiente editarAcudiente(int i) {
        AñadirAcudiente v1 = new AñadirAcudiente(new javax.swing.JFrame(), true);
        v1.setTitle("Editar Acudiente");
        v1.getjTextFieldNombre().setText(acudientes.get(i).getNombre());
        v1.getjTextFieldCelular().setText(acudientes.get(i).getCelular());
        v1.getjTextFieldDireccion().setText(acudientes.get(i).getDireccion());
        v1.getjTextFieldHorario().setText(acudientes.get(i).getHorarioDeRecogida());
        v1.getjTextFieldEdad().setText(acudientes.get(i).getEdad());
        v1.getjTextFieldTipoDocumento().setText(acudientes.get(i).getTipoDeDocumento());
        v1.getjTextFieldId().setText(acudientes.get(i).getId());
        v1.setVisible(true);
        if (v1.isSeñal()) {
            String[] datos = v1.getDatos();
            Acudiente a1 = new Acudiente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
            return a1;
        }
        return null;
    }

    public static String describirAcudiente(int i) {
        String nombre = acudientes.get(i).getNombre();
        String edad = acudientes.get(i).getEdad();
        String tipoDoc = acudientes.get(i).getTipoDeDocumento();
        String id = acudientes.get(i).getId();
        String celular = acudientes.get(i).getCelular();
        String direccion = acudientes.get(i).getDireccion();
        String horario = acudientes.get(i).getHorarioDeRecogida();
        String desc = "El acudiente " + nombre + " de " + edad + " años de edad,\n"
                + "reside en " + direccion + " y su celular es " + celular
                + ",\nesta identificado con " + tipoDoc + ": " + id + "\ny su horario de recogida es " + horario;
        return desc;
    }
}
