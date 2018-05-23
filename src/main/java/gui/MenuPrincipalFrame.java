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
    
    public void setHospital(Hospital hospi){
        this.hospi = hospi;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPaciente = new javax.swing.JButton();
        botonFuncionario = new javax.swing.JButton();
        botonSala = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonPaciente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        botonPaciente.setText("Paciente");
        botonPaciente.setMaximumSize(new java.awt.Dimension(109, 37));
        botonPaciente.setMinimumSize(new java.awt.Dimension(109, 37));
        botonPaciente.setPreferredSize(new java.awt.Dimension(109, 37));
        botonPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPacienteActionPerformed(evt);
            }
        });

        botonFuncionario.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        botonFuncionario.setText("Funcionario");
        botonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFuncionarioActionPerformed(evt);
            }
        });

        botonSala.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        botonSala.setText("Sala");
        botonSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalaActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonFuncionario)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(botonPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(botonSala, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFuncionarioActionPerformed
//        final VentanaMenuFuncionarios vr ;
//        vr = new VentanaMenuFuncionarios(evt,hospi);
//        botonFuncionario.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    vr.setVisible(true);
//                    vr.setLocationRelativeTo(null);
//                    MenuPrincipalFrame.this.dispose();
//                } catch (final Exception excep) {
//                    System.exit(0);
//                }
//            }
//        });
    }//GEN-LAST:event_botonFuncionarioActionPerformed

    private void botonPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPacienteActionPerformed
//        final VentanaMenuPaciente vr ;
//        vr = new VentanaMenuPaciente(evt,hospi);
//        botonPaciente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    vr.setVisible(true);
//                    vr.setLocationRelativeTo(null);
//                    MenuPrincipalFrame.this.dispose();
//                } catch (final Exception excep) {
//                    System.exit(0);
//                } 
//            } 
//        });
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
//        final VentanaMenuSala vr ;
//        vr = new VentanaMenuSala(evt,hospi);
//        botonSala.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    vr.setVisible(true);
//                    vr.setLocationRelativeTo(null);
//                    MenuPrincipalFrame.this.dispose();
//                } catch (final Exception excep) {
//                    System.exit(0);
//                }
//            }
//        });
    }//GEN-LAST:event_botonSalaActionPerformed

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
    private javax.swing.JButton botonFuncionario;
    private javax.swing.JButton botonPaciente;
    private javax.swing.JButton botonSala;
    private javax.swing.JButton botonSalir;
    // End of variables declaration//GEN-END:variables
}
