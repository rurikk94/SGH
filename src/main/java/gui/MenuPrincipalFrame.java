package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.sgh.Hospital;

public class MenuPrincipalFrame extends javax.swing.JFrame {

    private Hospital hospi;

    public MenuPrincipalFrame() {
        initComponents();
    }

    public MenuPrincipalFrame(ActionEvent evt, Hospital hospi) {
        initComponents();
        setHospital(hospi);
    }

    public MenuPrincipalFrame(Hospital hospi) {
        initComponents();
        setHospital(hospi);
    }

    public void setHospital(Hospital hospi) {
        this.hospi = hospi;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPaciente = new javax.swing.JButton();
        botonSala = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonPaciente.setBackground(new java.awt.Color(0, 0, 0));
        botonPaciente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonPaciente.setForeground(new java.awt.Color(0, 255, 51));
        botonPaciente.setText("Personas");
        botonPaciente.setMaximumSize(new java.awt.Dimension(109, 37));
        botonPaciente.setMinimumSize(new java.awt.Dimension(109, 37));
        botonPaciente.setPreferredSize(new java.awt.Dimension(109, 37));
        botonPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPacienteActionPerformed(evt);
            }
        });

        botonSala.setBackground(new java.awt.Color(204, 204, 204));
        botonSala.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSala.setForeground(new java.awt.Color(0, 51, 255));
        botonSala.setText("Habitaciones");
        botonSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalaActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(0, 0, 0));
        botonSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(255, 0, 0));
        botonSalir.setText("Salir");
        botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSalirMouseClicked(evt);
            }
        });
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        botonSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonSalirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(botonPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonSala, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPacienteActionPerformed

        PersonasListadoFrame personas = new PersonasListadoFrame();
        //muestra la ventana de carga
        personas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonPacienteActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch (final Exception excep) {
                    System.exit(0);
                }
            }
        });
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalaActionPerformed

        HabitacionesListadoFrame habitaciones = new HabitacionesListadoFrame();
        //muestra la ventana de carga
        habitaciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonSalaActionPerformed

    private void botonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_botonSalirMouseClicked

    private void botonSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonSalirKeyPressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_botonSalirKeyPressed

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
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipalFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPaciente;
    private javax.swing.JButton botonSala;
    private javax.swing.JButton botonSalir;
    // End of variables declaration//GEN-END:variables
}
