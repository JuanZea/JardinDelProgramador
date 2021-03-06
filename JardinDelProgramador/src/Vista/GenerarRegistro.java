/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Logro;
import Modelo.Personas.Niño;
import Modelo.Personas.Profesor;
import Modelo.Registro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Esta clase representa una ventana que recolecta los datos necesarios para
 * generar un registro.
 *
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.4
 */
public class GenerarRegistro extends javax.swing.JDialog {

    private ArrayList<Niño> niños;
    private ArrayList<Profesor> profesores;
    private ArrayList<Logro> logros;
    private boolean señal = false;
    private Registro registro;

    /**
     * Esta clase representa una ventana para generar un objeto de la clase
     * reporte.
     *
     * @author JuanZea
     * @version 1.0.1
     * @since Jardin 1.0.2
     */
    public GenerarRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setArrays(ArrayList<Niño> niños, ArrayList<Profesor> profesores, ArrayList<Logro> logros) {
        this.profesores = profesores;
        this.niños = niños;
        this.logros = logros;
    }

    public void rellenarBoxes() {
        for (Profesor profe : profesores) {
            jComboBoxProfesor.addItem(profe.getNombre());
        }
        for (Niño niño : niños) {
            jComboEstudiante.addItem(niño.getNombre());
        }
    }

    public void rellenarLogros(int i) {
        DefaultComboBoxModel limpiar = new DefaultComboBoxModel();
        jComboLogro.setModel(limpiar);
        for (int j = 0; j < niños.get(i).getLogros().size(); j++) {
            jComboLogro.addItem(niños.get(i).getLogros().get(j).getNombre());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jPanelHoja = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboEstudiante = new javax.swing.JComboBox<>();
        jComboLogro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboLogroValoracion = new javax.swing.JComboBox<>();
        jButtonGenerar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        javax.swing.JLabel jLabelFondo6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Reporte");
        setIconImage(new ImageIcon(getClass().getResource("/Vista/img/Icono4.png")).getImage());

        jPanelBase.setLayout(null);

        jPanelHoja.setOpaque(false);

        jLabel1.setBackground(java.awt.Color.orange);
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Profesor:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(java.awt.Color.orange);
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Estudiante:");
        jLabel2.setOpaque(true);

        jComboEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstudianteActionPerformed(evt);
            }
        });

        jComboLogro.setEnabled(false);

        jLabel3.setBackground(java.awt.Color.orange);
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Logro:");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(java.awt.Color.orange);
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Valoracion:");
        jLabel4.setOpaque(true);

        jComboLogroValoracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Incapaz", "Medianamente competente", "Competente", "Capaz", "Crack" }));

        jButtonGenerar.setText("Generar");
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jCalendar1.setDecorationBackgroundColor(java.awt.Color.orange);

        javax.swing.GroupLayout jPanelHojaLayout = new javax.swing.GroupLayout(jPanelHoja);
        jPanelHoja.setLayout(jPanelHojaLayout);
        jPanelHojaLayout.setHorizontalGroup(
            jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboLogro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelHojaLayout.createSequentialGroup()
                        .addGroup(jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaLayout.createSequentialGroup()
                                    .addComponent(jButtonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCancelar))
                                .addComponent(jComboLogroValoracion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jComboEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanelHojaLayout.setVerticalGroup(
            jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHojaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboLogro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHojaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboLogroValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelHojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGenerar)
                            .addComponent(jButtonCancelar)))
                    .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelBase.add(jPanelHoja);
        jPanelHoja.setBounds(0, 0, 700, 400);

        jLabelFondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Fondo6.png"))); // NOI18N
        jPanelBase.add(jLabelFondo6);
        jLabelFondo6.setBounds(1, -4, 700, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstudianteActionPerformed
        rellenarLogros(jComboEstudiante.getSelectedIndex());
        if (jComboEstudiante.getSelectedIndex() != -1) {
            jComboLogro.setEnabled(true);
        }
    }//GEN-LAST:event_jComboEstudianteActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        señal = false;
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        if (jComboBoxProfesor.getSelectedIndex() == -1 || jComboEstudiante.getSelectedIndex() == -1 || jComboLogro.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Hacen falta uno o varios datos");
        } else {
            int dia = jCalendar1.getDayChooser().getDay();
            int mes = jCalendar1.getMonthChooser().getMonth();
            int año = jCalendar1.getYearChooser().getYear();
            Profesor profesor = profesores.get(jComboBoxProfesor.getSelectedIndex());
            Niño niño = niños.get(jComboEstudiante.getSelectedIndex());
            Logro logro = logros.get(jComboLogro.getSelectedIndex());
            int valoracion = jComboLogroValoracion.getSelectedIndex();
            Calendar calendar = new GregorianCalendar(año, mes, dia);
            registro = new Registro(calendar, profesor, niño, logro, valoracion);
            señal = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonGenerarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GenerarRegistro dialog = new GenerarRegistro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGenerar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBoxProfesor;
    private javax.swing.JComboBox<String> jComboEstudiante;
    private javax.swing.JComboBox<String> jComboLogro;
    private javax.swing.JComboBox<String> jComboLogroValoracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelHoja;
    // End of variables declaration//GEN-END:variables

    public boolean isSeñal() {
        return señal;
    }

    public Registro getRegistro() {
        return registro;
    }
}
