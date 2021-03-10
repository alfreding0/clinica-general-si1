package clases;
/** @author alfreding0 */


public class ProbandoInterfazPrincipal extends javax.swing.JFrame {

    public ProbandoInterfazPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);//el formulario sale al centro
        this.setExtendedState(ProbandoInterfazPrincipal.MAXIMIZED_BOTH); //maximizar ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encabezado.setBackground(new java.awt.Color(64, 94, 123));
        encabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("C059", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLINICA GENERAL");
        encabezado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 520, 60));

        jLabel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("\"LAS VEGAS\"");
        encabezado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 180, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/hospital.png"))); // NOI18N
        encabezado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 180, 80));

        getContentPane().add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 939, 100));

        cuerpo.setBackground(new java.awt.Color(64, 94, 123));
        cuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/usuario.png"))); // NOI18N
        jButton1.setText("USUARIOS");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cuerpo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/fondo.png"))); // NOI18N
        cuerpo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 430));

        getContentPane().add(cuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 940, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormMedico med = new FormMedico();
        med.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProbandoInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProbandoInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProbandoInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProbandoInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProbandoInterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cuerpo;
    private javax.swing.JPanel encabezado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
/** @author alfreding0 */
}