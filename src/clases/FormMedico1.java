package clases;
/** @author alfreding0 */


public class FormMedico1 extends javax.swing.JFrame {

    public FormMedico1() {
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
        jButton1 = new javax.swing.JButton();
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
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 50, 47));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 240, 110, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("CI:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 70, 160, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("NOMBRE COMPLETO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(390, 70, 160, 28);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("TRABAJOS ANTERIORES:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 190, 160, 28);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("CELULAR:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 100, 160, 28);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("EMAIL:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(390, 100, 160, 28);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("GENERO:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 130, 160, 28);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("FECHA NACIMIENTO:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 130, 160, 28);

        jTextFielocupacion.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielocupacion.setForeground(new java.awt.Color(0, 204, 0));
        jTextFielocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielocupacion.setBorder(null);
        jTextFielocupacion.setName(""); // NOI18N
        jTextFielocupacion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielocupacion.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFielocupacion);
        jTextFielocupacion.setBounds(190, 160, 170, 30);

        jTextFieldCI.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldCI.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCI.setBorder(null);
        jTextFieldCI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCI.setName(""); // NOI18N
        jTextFieldCI.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldCI.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldCI);
        jTextFieldCI.setBounds(190, 70, 170, 30);

        jTextFieldNombreCompleto.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldNombreCompleto.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldNombreCompleto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombreCompleto.setBorder(null);
        jTextFieldNombreCompleto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldNombreCompleto.setName(""); // NOI18N
        jTextFieldNombreCompleto.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldNombreCompleto.setSelectionColor(new java.awt.Color(102, 255, 102));
        jTextFieldNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNombreCompletoKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldNombreCompleto);
        jTextFieldNombreCompleto.setBounds(550, 70, 170, 30);

        jTextFieldcelular.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldcelular.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldcelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldcelular.setBorder(null);
        jTextFieldcelular.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldcelular.setName(""); // NOI18N
        jTextFieldcelular.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldcelular.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldcelular);
        jTextFieldcelular.setBounds(190, 100, 170, 30);

        jTextFieldtrabajosante.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldtrabajosante.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldtrabajosante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldtrabajosante.setBorder(null);
        jTextFieldtrabajosante.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldtrabajosante.setName(""); // NOI18N
        jTextFieldtrabajosante.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldtrabajosante.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldtrabajosante);
        jTextFieldtrabajosante.setBounds(550, 190, 170, 30);

        jTextFieldFechaNac.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldFechaNac.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldFechaNac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFechaNac.setBorder(null);
        jTextFieldFechaNac.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldFechaNac.setName(""); // NOI18N
        jTextFieldFechaNac.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldFechaNac.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldFechaNac);
        jTextFieldFechaNac.setBounds(190, 130, 170, 30);

        jTextFieldEmail.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldEmail.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldEmail.setName(""); // NOI18N
        jTextFieldEmail.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldEmail.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(550, 100, 170, 30);

        jTextFieldgenero.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldgenero.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldgenero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldgenero.setBorder(null);
        jTextFieldgenero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldgenero.setName(""); // NOI18N
        jTextFieldgenero.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldgenero.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldgenero);
        jTextFieldgenero.setBounds(550, 130, 170, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("OCUPACION:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 160, 160, 28);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("EXPERIENCIA:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 190, 160, 28);

        jTextFieldexperiencia.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldexperiencia.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldexperiencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldexperiencia.setBorder(null);
        jTextFieldexperiencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldexperiencia.setName(""); // NOI18N
        jTextFieldexperiencia.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldexperiencia.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFieldexperiencia);
        jTextFieldexperiencia.setBounds(190, 190, 170, 30);

        jTextFielddireccion.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielddireccion.setForeground(new java.awt.Color(0, 204, 0));
        jTextFielddireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielddireccion.setBorder(null);
        jTextFielddireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFielddireccion.setName(""); // NOI18N
        jTextFielddireccion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielddireccion.setSelectionColor(new java.awt.Color(102, 255, 102));
        jPanel1.add(jTextFielddireccion);
        jTextFielddireccion.setBounds(550, 160, 170, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 0));
        jLabel11.setText("DIRECCION:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(390, 160, 160, 28);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("GESTIONAR MÉDICOS");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 10, 460, 28);

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(580, 240, 110, 30);

        jButton3.setBackground(new java.awt.Color(0, 102, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Editar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(140, 240, 110, 30);

        jButton4.setBackground(new java.awt.Color(0, 102, 51));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Eliminar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(250, 240, 110, 30);

        jButton5.setBackground(new java.awt.Color(0, 102, 51));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Mostrar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(360, 240, 110, 30);

        jButton6.setBackground(new java.awt.Color(0, 102, 51));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Limpiar");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(470, 240, 110, 30);

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(0, 153, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"zcv", "zxcv", "zxcv", "zxcv"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(21);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 280, 700, 240);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFieldNombreCompletoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompletoKeyReleased
        jTextFieldNombreCompleto.setText( jTextFieldNombreCompleto.getText().toUpperCase() );
    }//GEN-LAST:event_jTextFieldNombreCompletoKeyReleased

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
            java.util.logging.Logger.getLogger(FormMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedico1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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