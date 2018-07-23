package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.sgh.Hospital;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.io.IOException;

public class MenuPrincipalFrame extends javax.swing.JFrame {

    private Hospital hospi;

    public MenuPrincipalFrame(Hospital hospi) throws IOException{
    	setTitle("Menu");        
        initComponents();
        this.hospi=hospi;
        
        System.out.println(hospi.personasToString());   //muestra los datos por consola
        System.out.println(hospi.habitacionesToString());   //muestra los datos por consola
        hospi.informeMedicos();
        hospi.informePacientes();
        hospi.informeEnfermeros();
        
    }

    /**
     * @wbp.parser.constructor
     */
    public MenuPrincipalFrame(ActionEvent evt, Hospital hospi) {
        initComponents();
        setHospital(hospi);
    }

    //public MenuPrincipalFrame(Hospital hospi) {
      //  initComponents();
        //setHospital(hospi);
    //}

    public void setHospital(Hospital hospi) {
        this.hospi = hospi;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPaciente = new javax.swing.JButton();
        botonSala = new javax.swing.JButton();
        botonSala.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HabitacionesListadoFrame hab=new HabitacionesListadoFrame(hospi);
        		hab.setVisible(true);
        		hide();
        		
        	}
        });
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
        /*botonSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalaActionPerformed(evt);
            }
        });*/

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
        
        JLabel lblSgh = new JLabel("SGH");
        lblSgh.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(100)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(botonSala, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(botonPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(botonSalir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(100, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(148, Short.MAX_VALUE)
        			.addComponent(lblSgh)
        			.addGap(145))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSgh)
        			.addGap(24)
        			.addComponent(botonPaciente, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        			.addGap(34)
        			.addComponent(botonSala, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        			.addGap(27)
        			.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addGap(32))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPacienteActionPerformed

        PersonasListadoFrame personas = new PersonasListadoFrame(hospi);
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

        HabitacionesListadoFrame habitaciones = new HabitacionesListadoFrame(hospi);
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

    public static void main(String args[]) throws IOException{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	Hospital hospi=null;
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
            public void run(){
                try {                    
                    new MenuPrincipalFrame(hospi).setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton botonPaciente;
    private javax.swing.JButton botonSala;
    private javax.swing.JButton botonSalir;
}
