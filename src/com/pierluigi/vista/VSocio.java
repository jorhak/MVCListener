/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pierluigi.vista;

import com.pierluigi.utilidades.IVista;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carmen
 */
public class VSocio extends javax.swing.JFrame implements IVista {

    /**
     * Creates new form VSocio
     */
    public VSocio() {
        initComponents();
        Bloquear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        textID = new javax.swing.JTextField();
        tituloSocio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSocios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        textBuscar = new javax.swing.JTextField();
        btnRefrescar = new javax.swing.JButton();
        btnObtener = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Socio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));

        labelNombre.setText("Nombre:");

        labelApellido.setText("Apellido:");

        labelDireccion.setText("Direccion:");

        labelTelefono.setText("Telefono:");

        btnNuevo.setText("Nuevo");

        btnRegistrar.setText("Registrar");

        btnModificar.setText("Modificar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(98, 98, 98)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelApellido)
                                        .addComponent(labelDireccion))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelTelefono)
                                    .addGap(20, 20, 20)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(textDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(textApellido)
                            .addComponent(textTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textID))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tituloSocio.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        tituloSocio.setText("Socio");

        tablaSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaSocios);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        btnRefrescar.setText("Refrescar");

        btnObtener.setText("Obtener");

        btnEliminar.setText("Eliminar");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(32, 32, 32)
                .addComponent(btnRefrescar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObtener)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar)
                    .addComponent(btnObtener)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(tituloSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(tituloSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VSocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnObtener;
    public static javax.swing.JButton btnRefrescar;
    public static javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    public static javax.swing.JTable tablaSocios;
    public static javax.swing.JTextField textApellido;
    public static javax.swing.JTextField textBuscar;
    public static javax.swing.JTextField textDireccion;
    public static javax.swing.JTextField textID;
    public static javax.swing.JTextField textNombre;
    public static javax.swing.JTextField textTelefono;
    private javax.swing.JLabel tituloSocio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Actualizar(List<Map<String, String>> datos) {
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("Codigo");
        mode.addColumn("Nombre");
        mode.addColumn("Apellido");
        mode.addColumn("direccion");
        mode.addColumn("Telefono");
        tablaSocios.setModel(mode);

        String dato[] = new String[5];

        for (int i = 0; i < datos.size(); i++) {
            Map<String, String> row = datos.get(i);

            dato[0] = row.getOrDefault("codigo", "0");
            dato[1] = row.getOrDefault("nombre", "");
            dato[2] = row.getOrDefault("apellido", "");
            dato[3] = row.getOrDefault("direccion", "");
            dato[4] = row.getOrDefault("telefono", "");
            mode.addRow(dato);
            
        }

    }

    public void Bloquear() {
        textNombre.setEnabled(false);
        textApellido.setEnabled(false);
        textDireccion.setEnabled(false);
        textTelefono.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
}