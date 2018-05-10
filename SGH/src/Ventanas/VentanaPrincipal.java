
package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import principal.Hospital;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private JButton botonIngresar;
    private Hospital hospi;

    public VentanaPrincipal(Hospital hospi) {
        initComponents();
        setHospital(hospi);
    }
    
    public VentanaPrincipal(ActionEvent evt,Hospital hospi)
    {
        initComponents();
        setHospital(hospi);
    }
    
    public VentanaPrincipal(ActionEvent evt) {
       initComponents();
    }
    
    public void setHospital(Hospital hospi){
        this.hospi = hospi;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonIngresar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        final VentanaMenuOpciones vr ;
        vr = new VentanaMenuOpciones(evt, hospi);
        botonIngresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vr.setVisible(true);
                vr.setLocationRelativeTo(null);
                VentanaPrincipal.this.dispose(); 
            } catch (final Exception excep) {
                System.exit(0);
            }
        }
     });
    }//GEN-LAST:event_botonIngresarActionPerformed
    /*public void cerrarAplicacion()
    {
        try{
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
               @Override
               public void windowClosing(WindowEvent e){
                   confirmarSalida();
               }
            });
            this.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //confirmar salida
    public void confirmarSalida()
    {
        int valor=JOptionPane.showConfirmDialog(this,"¿Está seguro de querer cerrar esta aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
           if(valor==JOptionPane.YES_OPTION)
           {
                JOptionPane.showMessageDialog(null,"Gracias por su visita, Hasta pronto","Gracias",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
           }
    }*/
    }
    /*   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    // End of variables declaration//GEN-END:variables

    private void acceder(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

