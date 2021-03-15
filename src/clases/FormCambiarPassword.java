package clases;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * @author alfreding0
 */
public class FormCambiarPassword extends javax.swing.JFrame {
    private String id_user;
    
    public FormCambiarPassword(Component component) {
        initComponents();
        this.setLocationRelativeTo(component); //Mostrar esta ventana centrado al formulario principal
    }
    
    private void verificarUsuarioCambiarContra(){
        String pass = JOptionPane.showInputDialog("Introduzca su contraseña actual para verificar!");
        if(pass != null){ //si en caso da en cancelar
            this.id_user = new Usuario().verificarUsuarioCambiarPassword(FormPrincipal.jLabelIdMedico.getText(), pass);
            if(this.id_user != null){
                JOptionPane.showMessageDialog(null, "Se ha verificado que es el propietario de esta cuenta,\nahora puede cambiar su contraseña.");
                jPasswordFieldNueva.setEditable(true);
                jPasswordFieldRepetirNueva.setEditable(true);
            }else
                JOptionPane.showMessageDialog(null, "Su contraseña no coincide con nuestro registro!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void guardarCambioContra(){
        String pass1 = jPasswordFieldNueva.getText();
        String pass2 = jPasswordFieldRepetirNueva.getText();
        
        if( !pass1.isEmpty() && !pass2.isEmpty() ){
            if(pass1.equals(pass2)){
                boolean resultado = new Usuario().cambiarPasswordUsuario(this.id_user, pass1);
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Se ha cambiado la contraseña satisfactoriamente!");
                    this.dispose();
                }else
                    JOptionPane.showMessageDialog(null, "No se ha podido cambiar la contraseña, intente más tarde!!!");
            }else
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!");
        }else
            JOptionPane.showMessageDialog(null, "Complete ambos campos!!!", null, JOptionPane.WARNING_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonCambairContra = new javax.swing.JButton();
        jPasswordFieldNueva = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldRepetirNueva = new javax.swing.JPasswordField();
        jButtonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 50, 47));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 122, 163)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(21, 150, 203));
        jLabel2.setText("NUEVA CONTRASEÑA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, 28));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 150, 203));
        jLabel4.setText("OPCIONES DE CONFIGURACIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 570, 30));

        jButtonCambairContra.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCambairContra.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonCambairContra.setForeground(new java.awt.Color(255, 102, 102));
        jButtonCambairContra.setText("Cambiar Contraseña");
        jButtonCambairContra.setBorderPainted(false);
        jButtonCambairContra.setContentAreaFilled(false);
        jButtonCambairContra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCambairContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambairContraActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCambairContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 190, -1));

        jPasswordFieldNueva.setEditable(false);
        jPasswordFieldNueva.setBackground(new java.awt.Color(63, 63, 63));
        jPasswordFieldNueva.setForeground(new java.awt.Color(21, 150, 203));
        jPasswordFieldNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jPasswordFieldNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 250, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(21, 150, 203));
        jLabel3.setText("REPETIR CONTRASEÑA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 160, 30));

        jPasswordFieldRepetirNueva.setEditable(false);
        jPasswordFieldRepetirNueva.setBackground(new java.awt.Color(63, 63, 63));
        jPasswordFieldRepetirNueva.setForeground(new java.awt.Color(21, 150, 203));
        jPasswordFieldRepetirNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jPasswordFieldRepetirNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 250, 30));

        jButtonSend.setBackground(new java.awt.Color(255, 102, 102));
        jButtonSend.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonSend.setForeground(new java.awt.Color(0, 204, 0));
        jButtonSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/login-entrar.png"))); // NOI18N
        jButtonSend.setText("Enviar y Guardar cambios");
        jButtonSend.setBorderPainted(false);
        jButtonSend.setContentAreaFilled(false);
        jButtonSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 250, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCambairContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambairContraActionPerformed
        this.verificarUsuarioCambiarContra();
    }//GEN-LAST:event_jButtonCambairContraActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        this.guardarCambioContra();
    }//GEN-LAST:event_jButtonSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambairContra;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldNueva;
    private javax.swing.JPasswordField jPasswordFieldRepetirNueva;
    // End of variables declaration//GEN-END:variables
/**
     * @author alfreding0
     */
}
