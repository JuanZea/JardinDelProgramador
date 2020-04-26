/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author JuanZea
 */
public class Ventana extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuPrincipal
     */
    public Ventana() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanePrincipal = new javax.swing.JTabbedPane();
        jPanelMenuPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelFondo3 = new javax.swing.JLabel();
        jPanelProfesores = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNombreLista = new javax.swing.JLabel();
        jLabelNombreDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProfesores = new javax.swing.JList<>();
        jButtonAñadirProfesor = new javax.swing.JButton();
        jButtonEliminarProfesor = new javax.swing.JButton();
        jButtonEditarProfesor1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelFondo2 = new javax.swing.JLabel();
        jPanelConfiguracion = new javax.swing.JPanel();
        jPanelConfiguracion1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCaracter = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelNit = new javax.swing.JLabel();
        jLabelMatriculados = new javax.swing.JLabel();
        jTextFieldCaracter = new javax.swing.JTextField();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldNit = new javax.swing.JTextField();
        jTextFieldMatriculados = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JARDIN");
        setIconImage(new ImageIcon(getClass().getResource("/Vista/img/Icono.png")).getImage());
        setName("MenuPrincipal"); // NOI18N
        setResizable(false);

        jTabbedPanePrincipal.setBackground(new java.awt.Color(255, 255, 110));
        jTabbedPanePrincipal.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPanePrincipal.setOpaque(true);
        jTabbedPanePrincipal.setPreferredSize(new java.awt.Dimension(800, 400));

        jPanelMenuPrincipal.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanelMenuPrincipal.setLayout(null);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jPanelMenuPrincipal.add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 390);

        jLabelFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Fondo3.png"))); // NOI18N
        jPanelMenuPrincipal.add(jLabelFondo3);
        jLabelFondo3.setBounds(0, 0, 660, 400);

        jTabbedPanePrincipal.addTab("Menu Principal", new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Icono1.png")), jPanelMenuPrincipal); // NOI18N

        jPanelProfesores.setLayout(null);

        jPanel2.setOpaque(false);

        jLabelNombreLista.setBackground(java.awt.Color.orange);
        jLabelNombreLista.setForeground(java.awt.Color.black);
        jLabelNombreLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreLista.setText("LISTA DE PROFESORES");
        jLabelNombreLista.setOpaque(true);

        jLabelNombreDescripcion.setBackground(java.awt.Color.orange);
        jLabelNombreDescripcion.setForeground(java.awt.Color.black);
        jLabelNombreDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreDescripcion.setText("LISTA DE PROFESORES");
        jLabelNombreDescripcion.setOpaque(true);

        jListProfesores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListProfesoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListProfesores);

        jButtonAñadirProfesor.setText("Añadir");

        jButtonEliminarProfesor.setText("Eliminar");

        jButtonEditarProfesor1.setText("Editar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabelNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEliminarProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditarProfesor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAñadirProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabelNombreDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNombreDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAñadirProfesor)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEditarProfesor1)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEliminarProfesor)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelProfesores.add(jPanel2);
        jPanel2.setBounds(0, 0, 660, 390);

        jLabelFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Fondo2.png"))); // NOI18N
        jPanelProfesores.add(jLabelFondo2);
        jLabelFondo2.setBounds(0, 0, 660, 400);

        jTabbedPanePrincipal.addTab("Profesores      ", new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Icono3.png")), jPanelProfesores); // NOI18N

        jPanelConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelConfiguracion.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanelConfiguracion.setLayout(null);

        jPanelConfiguracion1.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanelConfiguracion1.setOpaque(false);

        jButton1.setText("Acerca De");

        jLabelNombre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelNombre.setForeground(java.awt.Color.black);
        jLabelNombre.setText("Nombre:");

        jLabelCaracter.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCaracter.setForeground(java.awt.Color.black);
        jLabelCaracter.setText("Carácter:");

        jLabelAño.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelAño.setForeground(java.awt.Color.black);
        jLabelAño.setText("Año de fundación:");

        jLabelDireccion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelDireccion.setForeground(java.awt.Color.black);
        jLabelDireccion.setText("Dirección:");

        jLabelNit.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelNit.setForeground(java.awt.Color.black);
        jLabelNit.setText("NIT:");

        jLabelMatriculados.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelMatriculados.setForeground(java.awt.Color.black);
        jLabelMatriculados.setText("Matriculados:");

        jTextFieldCaracter.setToolTipText("Público/Privado");

        jTextFieldAño.setToolTipText("Ejemplo: 2000");

        jTextFieldDireccion.setToolTipText("Ejemplo: Cl 46 # 85 - 23");

        jTextFieldNit.setToolTipText("Ejemplo: 830047819");

        jTextFieldMatriculados.setEditable(false);
        jTextFieldMatriculados.setText("0");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Limpiar");

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Guardar");

        jTextFieldNombre.setText("El jardín de los programadores");

        javax.swing.GroupLayout jPanelConfiguracion1Layout = new javax.swing.GroupLayout(jPanelConfiguracion1);
        jPanelConfiguracion1.setLayout(jPanelConfiguracion1Layout);
        jPanelConfiguracion1Layout.setHorizontalGroup(
            jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracion1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelConfiguracion1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConfiguracion1Layout.createSequentialGroup()
                        .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAño)
                            .addComponent(jLabelDireccion)
                            .addComponent(jLabelNit)
                            .addComponent(jLabelMatriculados)
                            .addComponent(jLabelCaracter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMatriculados)
                            .addComponent(jTextFieldNit)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCaracter)
                            .addComponent(jTextFieldNombre))))
                .addGap(15, 15, 15))
        );
        jPanelConfiguracion1Layout.setVerticalGroup(
            jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracion1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCaracter, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabelCaracter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAño)
                    .addComponent(jTextFieldAño))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNit)
                    .addComponent(jTextFieldNit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMatriculados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldMatriculados))
                .addGap(18, 18, 18)
                .addGroup(jPanelConfiguracion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        jTextFieldMatriculados.getAccessibleContext().setAccessibleDescription("");

        jPanelConfiguracion.add(jPanelConfiguracion1);
        jPanelConfiguracion1.setBounds(0, 0, 660, 390);

        jLabelFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Fondo1.png"))); // NOI18N
        jPanelConfiguracion.add(jLabelFondo1);
        jLabelFondo1.setBounds(0, 0, 660, 400);

        jTabbedPanePrincipal.addTab("Configuración  ", new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Icono2.png")), jPanelConfiguracion); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jListProfesoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListProfesoresValueChanged
        
    }//GEN-LAST:event_jListProfesoresValueChanged

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAñadirProfesor;
    private javax.swing.JButton jButtonEditarProfesor1;
    private javax.swing.JButton jButtonEliminarProfesor;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelCaracter;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFondo1;
    private javax.swing.JLabel jLabelFondo2;
    private javax.swing.JLabel jLabelFondo3;
    private javax.swing.JLabel jLabelMatriculados;
    private javax.swing.JLabel jLabelNit;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreDescripcion;
    private javax.swing.JLabel jLabelNombreLista;
    private javax.swing.JList<String> jListProfesores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelConfiguracion;
    private javax.swing.JPanel jPanelConfiguracion1;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JPanel jPanelProfesores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPanePrincipal;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldCaracter;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldMatriculados;
    private javax.swing.JTextField jTextFieldNit;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getjTextFieldAño() {
        return jTextFieldAño;
    }

    public javax.swing.JTextField getjTextFieldCaracter() {
        return jTextFieldCaracter;
    }

    public javax.swing.JTextField getjTextFieldDireccion() {
        return jTextFieldDireccion;
    }

    public javax.swing.JTextField getjTextFieldNit() {
        return jTextFieldNit;
    }

    public javax.swing.JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public javax.swing.JButton getjButtonAñadirProfesor() {
        return jButtonAñadirProfesor;
    }

    public javax.swing.JList<String> getjListProfesores() {
        return jListProfesores;
    }
}
