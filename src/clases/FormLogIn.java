package clases;
/**@author Alfredo Gonzales */
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import utils.PlaceHolder;

public class FormLogIn extends javax.swing.JFrame {
    private final Usuario usuario;
    
    public FormLogIn() {
        initComponents();
        usuario=new Usuario();
        this.inicioEnConstructor();
    }
    
    private void inicioEnConstructor(){
        if(!usuario.esConexionNull()){
            this.setLocationRelativeTo(null);
            jTextFieldUsername.requestFocus();
            
            PlaceHolder placeholder = new PlaceHolder("Nombre usuario", jTextFieldUsername, new Color(251,160,130));
                        placeholder = new PlaceHolder("Contraseña", jPasswordField, new Color(251,160,130));
                       
            this.mostrarAlertaBloqMayusActivado();
        }else
            System.exit(0);  //si hubiera problemas con la conexion a la base de datos, entonces se va cerrar el programma
    }
    
    
    
    private void mostrarAlertaBloqMayusActivado(){
        if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
            jLabelBlockMayusActivado.setVisible(true);
        else
            jLabelBlockMayusActivado.setVisible(false);
    }
    
    private void ingresarAlSistema(){
        //La existencia de un usuario en la BD se verifica en el JTUsuario, ni bien se da ENTER lo verifica y el cursor no llega al campo de contraseña si el usuario no existe
        if(!jPasswordField.getText().isEmpty() && !jTextFieldUsername.getText().isEmpty()){
            String [] usuarioLogueado = usuario.validarIngresoAlSistema(jTextFieldUsername.getText(), jPasswordField.getText());
            
            if(usuarioLogueado != null){
                
                FormPrincipal form = new FormPrincipal();
                FormPrincipal.jLabelIdMedico.setText(usuarioLogueado[0]);
                FormPrincipal.jLabelNombreMedico.setText(usuarioLogueado[1]);
                
                form.mostrarBotonesSegunTipoUsuario( usuarioLogueado[2].equals("S") ); //si es secretaria.
                form.setVisible(true);
            }else
                JOptionPane.showMessageDialog(null, "Estos credenciales no existen!\nRevise bien y vuelva a intentarlo.", "Información", JOptionPane.WARNING_MESSAGE);
            
        }else if(jTextFieldUsername.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "LOS CAMPOS ESTÁN VACÍOS !!!", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(rootPane, "INTRODUZCA SU CONTRASEÑA !!!", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBack = new javax.swing.JPanel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonIngresar = new javax.swing.JButton();
        jLabelBlockMayusActivado = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jButtonSalir = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBack.setBackground(new java.awt.Color(39, 81, 124));
        jPanelBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 115, 255), 2, true));
        jPanelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField.setBackground(new java.awt.Color(63, 63, 63));
        jPasswordField.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(255, 102, 51));
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyReleased(evt);
            }
        });
        jPanelBack.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 200, 30));

        jButtonIngresar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/login-entrar.png"))); // NOI18N
        jButtonIngresar.setText("LogIn");
        jButtonIngresar.setBorderPainted(false);
        jButtonIngresar.setContentAreaFilled(false);
        jButtonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanelBack.add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, 30));

        jLabelBlockMayusActivado.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabelBlockMayusActivado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBlockMayusActivado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBlockMayusActivado.setText("¡Bloq Mayus activado!");
        jPanelBack.add(jLabelBlockMayusActivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 190, -1));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/LogInIcon.png"))); // NOI18N
        jPanelBack.add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, 70));

        jTextFieldUsername.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldUsername.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(255, 102, 51));
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldUsername.setName(""); // NOI18N
        jTextFieldUsername.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldUsername.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyReleased(evt);
            }
        });
        jPanelBack.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, 30));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/login-cerrar.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanelBack.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 20, 20));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/LogIngBackground.gif"))); // NOI18N
        jPanelBack.add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 230));

        getContentPane().add(jPanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        this.ingresarAlSistema();
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jTextFieldUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9') && c!='_'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyTyped

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        this.ingresarAlSistema();
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jTextFieldUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyReleased
        this.mostrarAlertaBloqMayusActivado();
    }//GEN-LAST:event_jTextFieldUsernameKeyReleased

    private void jPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyReleased
        this.mostrarAlertaBloqMayusActivado();
    }//GEN-LAST:event_jPasswordFieldKeyReleased

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        this.ingresarAlSistema();
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelBlockMayusActivado;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JPanel jPanelBack;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
