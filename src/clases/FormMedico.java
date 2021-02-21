package clases;
/** @author alfreding0 */


public class FormMedico extends javax.swing.JFrame {

    public FormMedico() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jTextFielddireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(95, 23, 23));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GESTIONAR MÉDICOS");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 20, 460, 28);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CI:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 70, 150, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE COMPLETO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 100, 150, 28);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TRABAJOS ANTERIORES:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 340, 150, 28);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CELULAR:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 130, 150, 28);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMAIL:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 160, 150, 28);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GENERO:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 220, 150, 28);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FECHA NACIMIENTO:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 190, 150, 28);
        jPanel1.add(jTextFielocupacion);
        jTextFielocupacion.setBounds(180, 250, 170, 30);
        jPanel1.add(jTextFieldCI);
        jTextFieldCI.setBounds(180, 70, 170, 30);
        jPanel1.add(jTextFieldNombreCompleto);
        jTextFieldNombreCompleto.setBounds(180, 100, 170, 30);
        jPanel1.add(jTextFieldcelular);
        jTextFieldcelular.setBounds(180, 130, 170, 30);
        jPanel1.add(jTextFieldtrabajosante);
        jTextFieldtrabajosante.setBounds(180, 340, 170, 30);
        jPanel1.add(jTextFieldFechaNac);
        jTextFieldFechaNac.setBounds(180, 190, 170, 30);
        jPanel1.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(180, 160, 170, 30);
        jPanel1.add(jTextFieldgenero);
        jTextFieldgenero.setBounds(180, 220, 170, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("OCUPACION:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 250, 150, 28);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("EXPERIENCIA:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 310, 150, 28);
        jPanel1.add(jTextFieldexperiencia);
        jTextFieldexperiencia.setBounds(180, 310, 170, 30);
        jPanel1.add(jTextFielddireccion);
        jTextFielddireccion.setBounds(180, 280, 170, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DIRECCION:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 280, 150, 28);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 70, 100, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 380));

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
    private javax.swing.JPanel jPanel1;
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