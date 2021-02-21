package clases;

import sql.Conexion;

/** @author alfreding0 */


public class FormMedico extends javax.swing.JFrame {

    public FormMedico() {
        initComponents();
    }
    
    
    
    //Funciones y procedimientos
    private void guardar(){
        String ci = jTextFieldCI.getText();
        String nombre = jTextFieldNombreCompleto.getText();
        String celular = jTextFieldcelular.getText();
        String email = jTextFieldEmail.getText();
        String fecha_nac = jTextFieldFechaNac.getText();
        String genero = jTextFieldgenero.getText();
        String direccion = jTextFielddireccion.getText();
        String ocupacion = jTextFielocupacion.getText();
        String experiencia = jTextFieldexperiencia.getText();
        String trabajos_ant = jTextFieldtrabajosante.getText();
        
        Medico med = new Medico(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion, experiencia, trabajos_ant);
        
        med.insertarMedico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFielocupacion = new javax.swing.JTextField();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jTextFieldcelular = new javax.swing.JTextField();
        jTextFieldtrabajosante = new javax.swing.JTextField();
        jTextFieldFechaNac = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldgenero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldexperiencia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFielddireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CI:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 30));

        jLabel2.setText("NOMBRE COMPLETO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 28));

        jLabel3.setText("TRABAJOS ANTERIORES:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 127, 28));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("GESTIONAR MÉDICOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 460, 28));

        jLabel5.setText("CELULAR:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 127, 28));

        jLabel6.setText("EMAIL:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 127, 28));

        jLabel7.setText("GENERO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 127, 28));

        jLabel8.setText("FECHA NACIMIENTO:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 127, 28));
        getContentPane().add(jTextFielocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 170, 30));
        getContentPane().add(jTextFieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 170, 30));
        getContentPane().add(jTextFieldNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, 30));
        getContentPane().add(jTextFieldcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 170, 30));
        getContentPane().add(jTextFieldtrabajosante, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 170, 30));
        getContentPane().add(jTextFieldFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 170, 30));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 170, 30));
        getContentPane().add(jTextFieldgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, 30));

        jLabel9.setText("OCUPACION:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 127, 28));

        jLabel10.setText("EXPERIENCIA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 127, 28));
        getContentPane().add(jTextFieldexperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 170, 30));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));
        getContentPane().add(jTextFielddireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 170, 30));

        jLabel11.setText("DIRECCION:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 127, 28));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFechaNac;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldcelular;
    private javax.swing.JTextField jTextFielddireccion;
    private javax.swing.JTextField jTextFieldexperiencia;
    private javax.swing.JTextField jTextFieldgenero;
    private javax.swing.JTextField jTextFieldtrabajosante;
    private javax.swing.JTextField jTextFielocupacion;
    // End of variables declaration//GEN-END:variables
/** @author alfreding0 */
}