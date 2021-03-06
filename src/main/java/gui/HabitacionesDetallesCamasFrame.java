/*
 * Copyright (C) 2018 Rurikk
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.gui;

import main.java.sgh.Hospital;
import main.java.sgh.Hospitalizados;

import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Rurikk
 */
public class HabitacionesDetallesCamasFrame extends javax.swing.JFrame {

    /**
     * Creates new form HabitacionesMostrarFrame
     */
	private Hospital hospi;
    public HabitacionesDetallesCamasFrame(Hospital hospi) {
        initComponents();
        this.hospi=hospi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jScrollPaneCama = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAgregarCama = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        
        jButtonAsignarCama = new javax.swing.JButton();
        jButtonModNumCama = new javax.swing.JButton();
        jButtonEliminarCama = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Detalles");

        jLabel2.setText("Consulta/Hospitalizados");

        jTextFieldID.setText("ID");

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"numero Cama", "Disponible", "Rut Paciente"
        	}
        ));
        jScrollPaneCama.setViewportView(jTable1);
        jButtonMostrar = new javax.swing.JButton();
        jButtonMostrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(hospi.mostrarHabitacionPorId(jTextFieldID.getText()) instanceof Hospitalizados)
        		{
        			for(int i=0;i< ((Hospitalizados)(hospi.mostrarHabitacionPorId(jTextFieldID.getText()))).getCapacidad();i++)
        			{
        				jTable1.setValueAt(((Hospitalizados)(hospi.mostrarHabitacionPorId(jTextFieldID.getText()))).mostrarCamaPorPosicion(i).getNumeroCama(), i, 0);
        				jTable1.setValueAt(((Hospitalizados)(hospi.mostrarHabitacionPorId(jTextFieldID.getText()))).mostrarCamaPorPosicion(i).getCamaDisponible(),i,1);
        				jTable1.setValueAt(((Hospitalizados)(hospi.mostrarHabitacionPorId(jTextFieldID.getText()))).mostrarCamaPorPosicion(i).getRutPaciente(),i,2);
        			}
        		}
        			
        	}
        });
        jButtonAgregarCama.setText("Agregar Cama");
        jButtonAgregarCama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Camas");

        jButtonMostrar.setText("Mostrar");

        jButtonAsignarCama.setText("Asignar Cama");
        jButtonAsignarCama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonModNumCama.setText("Modificar Numero Cama");

        jButtonEliminarCama.setText("Eliminar Cama");
        jButtonEliminarCama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel2)
        					.addGap(184))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        					.addGap(74)
        					.addComponent(jLabel3))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jButtonAgregarCama)
        						.addComponent(jButtonEliminarCama))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jButtonVolver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jButtonMostrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(18)
        					.addComponent(jButtonAsignarCama)
        					.addGap(83))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPaneCama, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(71, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonModNumCama)
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jLabel2))
        			.addGap(18)
        			.addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel3)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jScrollPaneCama, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addGap(41)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonAgregarCama)
        				.addComponent(jButtonMostrar)
        				.addComponent(jButtonAsignarCama))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonEliminarCama)
        				.addComponent(jButtonVolver))
        			.addGap(18)
        			.addComponent(jButtonModNumCama)
        			.addContainerGap(58, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        HabitacionesListadoFrame personas = new HabitacionesListadoFrame(hospi);
        //muestra la ventana de carga
        personas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        CamasAgregarModificarFrame personas = new CamasAgregarModificarFrame(hospi);
        //muestra la ventana de carga
        personas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        CamasEliminarFrame personas = new CamasEliminarFrame(hospi);
        //muestra la ventana de carga
        personas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CamasAsignarFrame personas = new CamasAsignarFrame(hospi);
        //muestra la ventana de carga
        personas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	Hospital hospi=null;
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
            java.util.logging.Logger.getLogger(HabitacionesDetallesCamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDetallesCamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDetallesCamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDetallesCamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabitacionesDetallesCamasFrame(hospi).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCama;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonAsignarCama;
    private javax.swing.JButton jButtonModNumCama;
    private javax.swing.JButton jButtonEliminarCama;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPaneCama;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
