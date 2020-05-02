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
 * @version 1.0.3
 * @since Jardin 1.0.0
 */
public class Programa {

    //Se crea un conjunto de ArrayLists para cada tipo de persona.
    static boolean test = false;
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
     * @param args Los argumentos de la lista de comandos.
     */
    public static void main(String[] args) {

        //Se crea la institución protagonista.
        Institucion institucion = new Institucion(null, null, null, null, null, 0);

        //Se crea una ventana principal para la interaccion con el usuario
        Ventana v = new Ventana();
        v.setVisible(true);

        //Eventos de la ventana
        oyteMenuPrincipal(v, institucion);
        oyteConfiguracion(v, institucion);
        oyteProfesores(v);
        oyteNiños(v, institucion);
        oyteAcudientes(v);
    }

    //Eventos de la ventana|----------------------------------------------------------------
    public static void oyteMenuPrincipal(Ventana v, Institucion institucion) {
        oyteBtnAsignarMP(v);
        oyteBtnGenerarMP(v);
        oyteBtnImprimirMP(v, institucion);
    }

    public static void oyteBtnAsignarMP(Ventana v) {
        v.getjButtonAsignarLogro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsignarLogro v1 = new AsignarLogro(null, true);
                v1.rellenarEstudiantes(niños);
                v1.setVisible(true);
                if (v1.isSeñal()) {
                    Logro l1 = v1.getLogro();
                    logros.add(l1);
                    int dueño = v1.getDueño();
                    niños.get(dueño).asignarLogro(l1);
                }
            }
        });
    }

    public static void oyteBtnGenerarMP(Ventana v) {
        v.getjButtonGenerarReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerarRegistro v1 = new GenerarRegistro(null, true);
                v1.setArrays(niños, profesores, logros);
                v1.rellenarBoxes();
                v1.setVisible(true);
                if (v1.isSeñal()) {
                    Registro r1 = v1.getRegistro();
                    r1.getNiño().asignarRegistro(r1);
                }
            }
        });
    }

    public static void oyteBtnImprimirMP(Ventana v, Institucion institucion) {
        v.getjButtonImprimirReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isConfigurado) {
                    ImprimirPdf v1 = new ImprimirPdf(null, true);
                    for (int i = 0; i < niños.size(); i++) {
                        v1.getjComboBoxNiños().addItem(niños.get(i).getNombre());
                    }
                    v1.setVisible(true);
                    if (v1.isSeñal()) {
                        generarPdf(institucion, v1.getjComboBoxNiños().getSelectedIndex(), v1.getjTextFieldRuta().getText());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debe guardar datos en la configuración.");
                }
            }
        });
    }

    public static void oyteConfiguracion(Ventana v, Institucion institucion) {
        oyteBtnGuardarC(v, institucion);
        oyteBtnLimpiarC(v);
        oyteBtnTestearC(v, institucion);
    }

    public static void oyteBtnGuardarC(Ventana v, Institucion institucion) {
        v.getBtnGuardarC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si hay algo en blanco
                if (v.getTxtFNombre().getText().isBlank() || v.getTxtFCaracter().getText().isBlank() || v.getTxtFAño().getText().isBlank() || v.getTxtFDireccion().getText().isBlank() || v.getTxtFNit().getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Hacen falta uno o varios datos");
                } else {
                    //Desactiva la edicion
                    v.getTxtFNombre().setEditable(false);
                    v.getTxtFCaracter().setEditable(false);
                    v.getTxtFAño().setEditable(false);
                    v.getTxtFDireccion().setEditable(false);
                    v.getTxtFNit().setEditable(false);
                    //Guardamos los datos
                    institucion.setNombre(v.getTxtFNombre().getText());
                    institucion.setCaracter(v.getTxtFCaracter().getText());
                    institucion.setAñoFundacion(v.getTxtFAño().getText());
                    institucion.setDireccion(v.getTxtFDireccion().getText());
                    institucion.setNit(v.getTxtFNit().getText());
                    setIsConfigurado(true);
                }
            }
        });
    }

    public static void oyteBtnLimpiarC(Ventana v) {
        v.getBtnLimpiarC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Activa la edicion
                v.getTxtFNombre().setEditable(true);
                v.getTxtFCaracter().setEditable(true);
                v.getTxtFAño().setEditable(true);
                v.getTxtFDireccion().setEditable(true);
                v.getTxtFNit().setEditable(true);
                //Limpia los cuadros
                v.getTxtFNombre().setText("");
                v.getTxtFCaracter().setText("");
                v.getTxtFAño().setText("");
                v.getTxtFDireccion().setText("");
                v.getTxtFNit().setText("");
                setIsConfigurado(false);
            }
        });
    }

    public static void oyteBtnTestearC(Ventana v, Institucion institucion) {
        v.getBtnTestearC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test = true;
                rellenarConfiguracion(v, institucion);
                rellenarAcudientes(v);
                rellenarProfesores(v);
                rellenarNiños(v);
            }
        });
    }

    public static void rellenarConfiguracion(Ventana v, Institucion institucion) {
        v.getTxtFNombre().setText("El Jardín De Los Programadores");
        v.getTxtFCaracter().setText("Pública");
        v.getTxtFDireccion().setText("Cl 46 # 85 - 23");
        v.getTxtFAño().setText("2000");
        v.getTxtFNit().setText("2901001007238750");
        institucion.setMatriculados(5);
        v.getTxtFMatriculados().setText("5");
    }

    public static void rellenarAcudientes(Ventana v) {
        Acudiente a1 = new Acudiente("5:00pm - 6:00pm", "Padre", "Cra. 49 #49-55", "3218373455", "Nixon", "49", "Cédula", "9984736402");
        Acudiente a2 = new Acudiente("5:30pm - 6:30pm", "Madre", "Cl. 69 #77-29", "3204382743", "Camila", "44", "Cédula", "2938507454");
        Acudiente a3 = new Acudiente("5:45pm - 6:45pm", "Tio", "Cra. 63 #83-12", "3218403849", "Heyder", "54", "Cédula", "5457685667");
        Acudiente a4 = new Acudiente("6:00pm - 7:00pm", "Abuela", "Cra. 28 #65-53", "3198553075", "Patricia", "68", "Cédula", "9973625134");
        Acudiente a5 = new Acudiente("4:45pm - 6:00pm", "Hermano", "Cra. 20 #09-44", "3019485678", "Samuel", "23", "Cédula", "1040057986");
        listaAcudientes.add(0, a1.getNombre());
        listaAcudientes.add(1, a2.getNombre());
        listaAcudientes.add(2, a3.getNombre());
        listaAcudientes.add(3, a4.getNombre());
        listaAcudientes.add(4, a5.getNombre());
        acudientes.add(a1);
        acudientes.add(a2);
        acudientes.add(a3);
        acudientes.add(a4);
        acudientes.add(a5);
        v.getjListAcudientes().setModel(listaAcudientes);
    }

    public static void rellenarProfesores(Ventana v) {
        Profesor p1 = new Profesor(3, "Académico", "Universidad de Antioquia", "Juan David", "Cédula", "1007238750", "20");
        Profesor p2 = new Profesor(3, "Artístico", "Universidad de Nacional", "Andres Felipe", "TI", "1008463849", "21");
        Profesor p3 = new Profesor(3, "Motriz", "Universidad EAFIT", "Sebastian", "Cédula", "1009374835", "22");
        Profesor p4 = new Profesor(3, "Deportivo", "Universidad de Medellín", "Marinela", "Cédula", "9986465301", "25");
        Profesor p5 = new Profesor(3, "Social", "Harvard University", "Miguel Angel", "TI", "9874526309", "24");
        listaProfesores.add(0, p1.getNombre());
        listaProfesores.add(1, p2.getNombre());
        listaProfesores.add(2, p3.getNombre());
        listaProfesores.add(3, p4.getNombre());
        listaProfesores.add(4, p5.getNombre());
        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);
        profesores.add(p4);
        profesores.add(p5);
        v.getjListProfesores().setModel(listaProfesores);
    }

    public static void rellenarNiños(Ventana v) {
        Niño n1 = new Niño("1.33", "33.7", "NA", "Felipe", "TI", "2293847576", "8", acudientes.get(0));
        Niño n2 = new Niño("1.23", "36.7", "NA", "Santiago", "TI", "3822957476", "7", acudientes.get(1));
        Niño n3 = new Niño("1.43", "38.7", "NA", "Daniela", "TI", "3229857476", "9", acudientes.get(2));
        Niño n4 = new Niño("1.53", "49.7", "NA", "Marcelo", "TI", "3229845767", "8", acudientes.get(0));
        Niño n5 = new Niño("1.13", "39.7", "NA", "Jhonier", "TI", "2938427576", "7", acudientes.get(1));
        listaNiños.add(0, n1.getNombre());
        listaNiños.add(1, n2.getNombre());
        listaNiños.add(2, n3.getNombre());
        listaNiños.add(3, n4.getNombre());
        listaNiños.add(4, n5.getNombre());
        niños.add(n1);
        niños.add(n2);
        niños.add(n3);
        niños.add(n4);
        niños.add(n5);
        v.getjListNiños().setModel(listaNiños);
        rellenarLogros(n1, n2, n3, n4, n5);
    }

    public static void rellenarLogros(Niño n1, Niño n2, Niño n3, Niño n4, Niño n5) {
        Logro l1 = new Logro("Brinca y se para en un pie hasta por cinco segundos", "Desarrollo de pensamiento lógico matematico", true);
        Logro l2 = new Logro("Sube y baja las gradas sin apoyo", "Desarrolo de habilidades de análisis", true);
        Logro l3 = new Logro("Patea una pelota hacia adelante", "Desarrolo de pensamiento creativo", false);
        Logro l4 = new Logro("Lanza la pelota por encima del hombro", "Desarrollo de pensamiento lógico matematico", true);
        Logro l5 = new Logro("Atrapa la pelota en rebote la mayoría de las veces", "Desarrolo de habilidades de pensamiento sistémico", true);
        Logro l6 = new Logro("Se mueve hacia adelante y hacia atrás con agilidad", "Desarrolo de habilidades de análisis", false);
        Logro l7 = new Logro("Dibuja a una persona con dos a cuatro partes del cuerpo", "Desarrolo de pensamiento creativo", true);
        Logro l8 = new Logro("Se viste y se desviste", "Desarrollo de pensamiento lógico matematico", true);
        Logro l9 = new Logro("Nombra correctamente algunos colores", "Desarrollo de pensamiento lógico matematico", true);
        Logro l10 = new Logro("Se expresa con oraciones de cinco a seis palabras", "Desarrolo de habilidades de análisis", true);
        Logro l11 = new Logro("Habla lo suficientemente claro para que lo entiendan extraños", "Desarrolo de habilidades de análisis", false);
        Logro l12 = new Logro("Usa las tijeras", "Desarrollo de pensamiento lógico matematico", false);
        Logro l13 = new Logro("Sigue órdenes de tres partes", "Desarrolo de pensamiento creativo", true);

        n1.asignarLogro(l1);
        n1.asignarLogro(l2);
        n1.asignarLogro(l3);
        n1.asignarLogro(l4);
        n1.asignarLogro(l5);
        n2.asignarLogro(l6);
        n3.asignarLogro(l7);
        n3.asignarLogro(l8);
        n3.asignarLogro(l9);
        n3.asignarLogro(l10);
        n4.asignarLogro(l11);
        n5.asignarLogro(l12);
        n5.asignarLogro(l13);
    }

    public static void oyteProfesores(Ventana v) {
        oyteBtnAñadirP(v);
        oyteBtnEditarP(v);
        oyteBtnEliminarP(v);
        oyteLsP(v);
    }

    public static void oyteBtnAñadirP(Ventana v) {
        v.getjButtonAñadirProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profesor p1 = añadirProfesor();
                if (p1 != null) {
                    profesores.add(p1);
                    listaProfesores.addElement(p1.getNombre());
                    v.getjListProfesores().setModel(listaProfesores);
                }
            }
        }
        );
    }

    public static void oyteBtnEditarP(Ventana v) {
        v.getjButtonEditarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListProfesores().getSelectedIndex() != -1) {
                    int index = v.getjListProfesores().getSelectedIndex();
                    Profesor p1 = editarProfesor(index);
                    if (p1 != null) {
                        profesores.set(index, p1);
                        listaProfesores.set(index, p1.getNombre());
                        v.getjListProfesores().setModel(listaProfesores);
                    }
                }
            }
        });
    }

    public static void oyteBtnEliminarP(Ventana v) {
        v.getjButtonEliminarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListProfesores().getSelectedIndex() != -1) {
                    int index = v.getjListProfesores().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este profesor?");
                    if (ans == 0) {
                        profesores.remove(index);
                        listaProfesores.remove(index);
                    }

                }
            }
        });
    }

    public static void oyteLsP(Ventana v) {
        v.getjListProfesores().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!v.getjListProfesores().isSelectionEmpty()) {
                    int index = v.getjListProfesores().getSelectedIndex();
                    v.getjTextAreaProfesor().setText(describirProfesor(index));
                } else {
                    v.getjTextAreaProfesor().setText("");
                }
            }
        });
    }

    public static void oyteNiños(Ventana v, Institucion institucion) {
        oyteLsN(v);
        oyteBtnAñadirN(v, institucion);
        oyteBtnEditarN(v);
        oyteBtnEliminarN(v, institucion);
    }

    public static void oyteBtnAñadirN(Ventana v, Institucion institucion) {
        v.getjButtonAñadirNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Niño n1 = añadirNiño();
                if (n1 != null) {
                    niños.add(n1);
                    listaNiños.addElement(n1.getNombre());
                    v.getjListNiños().setModel(listaNiños);
                    institucion.setMatriculados(institucion.getMatriculados() + 1);
                    v.getTxtFMatriculados().setText(String.valueOf(institucion.getMatriculados()));
                }
            }
        }
        );
    }

    public static void oyteBtnEditarN(Ventana v) {
        v.getjButtonEditarNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListNiños().getSelectedIndex() != -1) {
                    int index = v.getjListNiños().getSelectedIndex();
                    Niño n1 = editarNiño(index);
                    if (n1 != null) {
                        niños.set(index, n1);
                        listaNiños.set(index, n1.getNombre());
                        v.getjListNiños().setModel(listaNiños);
                    }
                }
            }
        });
    }

    public static void oyteBtnEliminarN(Ventana v, Institucion institucion) {
        v.getjButtonEliminarNiño().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListNiños().getSelectedIndex() != -1) {
                    int index = v.getjListNiños().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este niño?");
                    if (ans == 0) {
                        niños.remove(index);
                        listaNiños.remove(index);
                        institucion.setMatriculados(institucion.getMatriculados() - 1);
                        v.getTxtFMatriculados().setText(String.valueOf(institucion.getMatriculados()));
                    }

                }
            }
        });
    }

    public static void oyteLsN(Ventana v) {
        v.getjListNiños().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!v.getjListNiños().isSelectionEmpty()) {
                    int index = v.getjListNiños().getSelectedIndex();
                    v.getjTextAreaNiños().setText(describirNiño(index));
                } else {
                    v.getjTextAreaNiños().setText("");
                }
            }
        });
    }

    public static void oyteAcudientes(Ventana v) {
        oyteBtnAñadirA(v);
        oyteBtnEditarA(v);
        oyteBtnEliminarA(v);
        oyteLsA(v);
    }

    public static void oyteBtnAñadirA(Ventana v) {
        v.getjButtonAñadirAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acudiente a1 = añadirAcudiente();
                if (a1 != null) {
                    acudientes.add(a1);
                    listaAcudientes.addElement(a1.getNombre());
                    v.getjListAcudientes().setModel(listaAcudientes);
                }
            }
        }
        );
    }

    public static void oyteBtnEditarA(Ventana v) {
        v.getjButtonEditarAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListAcudientes().getSelectedIndex() != -1) {
                    int index = v.getjListAcudientes().getSelectedIndex();
                    Acudiente a1 = editarAcudiente(index);
                    if (a1 != null) {
                        acudientes.set(index, a1);
                        listaAcudientes.set(index, a1.getNombre());
                        v.getjListAcudientes().setModel(listaAcudientes);
                    }
                }
            }
        });
    }

    public static void oyteBtnEliminarA(Ventana v) {
        v.getjButtonEliminarAcudiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getjListAcudientes().getSelectedIndex() != -1) {
                    int index = v.getjListAcudientes().getSelectedIndex();
                    int ans = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este profesor?");
                    if (ans == 0) {
                        acudientes.remove(index);
                        listaAcudientes.remove(index);
                    }

                }
            }
        });
    }

    public static void oyteLsA(Ventana v) {
        v.getjListAcudientes().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!v.getjListAcudientes().isSelectionEmpty()) {
                    int index = v.getjListAcudientes().getSelectedIndex();
                    v.getjTextAreaAcudientes().setText(describirAcudiente(index));
                } else {
                    v.getjTextAreaAcudientes().setText("");
                }
            }
        });
    }
    //-------------------------------------------------------------------------------------

    public static void setIsConfigurado(boolean b) {
        isConfigurado = b;
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

    public static void generarPdf(Institucion ins, int posicionNiño, String ruta) {
        GeneradorPdf pdf = new GeneradorPdf();
        Niño niño = niños.get(posicionNiño);
        if (!test) {
            niño.actualizarDesempeño();
        }
        String obj;
        if (niño.getLogros().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El niño no tiene logros asignados.");
            return;
        }
        String info = "El avance de " + niño.getNombre() + " representado en bimestres fue el siguiente:\n";
        for (int i = 0; i < niño.getLogros().size(); i++) {
            obj = "No cumplido\n";
            if (niño.getLogros().get(i).isObjetivo()) {
                obj = "Cumplido\n";
            }
            String plus = "Logro#" + (i + 1) + ":\n"
                    + niño.getLogros().get(i).getNombre() + ": " + obj;
            info = info + plus;
        }

        pdf.GenerarPdf(niño.getNombre(), info, "footer", "C:\\Users\\ASUS\\Downloads\\ryan-wallace-azA1hLbjBBo-unsplash.jpg", ruta + ".pdf");
    }
}
