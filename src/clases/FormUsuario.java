package clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utils.HeaderTable;
import utils.PlaceHolder;

/**
 * @author alfreding0
 */
public class FormUsuario extends javax.swing.JFrame {
    private PlaceHolder placeholder;
    private final Class formularioEmisor;
    
    public FormUsuario(Component component) {
        initComponents();
        this.formularioEmisor = component.getClass();
        this.setLocationRelativeTo(component); //Mostrar esta ventana centrado al formulario principal
        this.mostrarDatos();
        this.repintarHeaderTabla();
        this.ponerPlaceHolders();      
//        this.habilitarBotonEnviarDatos();
    }
    
    private void ponerPlaceHolders(){
        placeholder = new PlaceHolder("Buscar por CI", jTextFielBuscarPorCI, Color.GRAY);
    }
    
    private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTable1.setTableHeader(jtableHeader);
    }
    
    private void fijarAnchoColumnasTabla(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);//ID
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);//username
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);//creadoen
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);//nombremedico
    }
    
    private void nuevo(){
        this.limpiarTodo();
        jTextFielID.requestFocus();
    }
    
    private void guardar() {
        if (this.validarCamposLlenos()){
            String username = jTextFieldUsername.getText();
            String password = jPasswordField.getText();
            String privilegio = jComboBoxPrivilegio.getSelectedItem().toString().substring(0, 1);
            String id_medico = jTextFieldIdMedico.getText();

            Usuario user = new Usuario(username, password, privilegio, id_medico);

            boolean registroSatisfactorio = user.guardarUsuario(jTextFielID.getText());

            if (registroSatisfactorio) {
                JOptionPane.showMessageDialog(null, "Se guardó correctamente :)");
                this.limpiarCampos();
                this.mostrarDatos();
            }else
                JOptionPane.showMessageDialog(null, "No se pudo guardar, verifique que los datos sean correctos!");
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
    }

    private void mostrarDatos() {
        Usuario usuario = new Usuario();
        usuario.mostrarUsuario(jTable1);
        this.fijarAnchoColumnasTabla();
    }
    
    private void eliminar(){
        if(!jTextFielID.getText().equals("0")){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
            if (res == JOptionPane.YES_OPTION) {
                Usuario usuario = new Usuario();
                boolean estadoEjecucion = usuario.eliminarUsuario(jTextFielID.getText());
                if (estadoEjecucion)
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente!");
                else
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, pruebe más tarde.");

                this.mostrarDatos();
            }
        }
    }
    
    private void buscarPorCI(){
        Paciente pac = new Paciente();
        pac.mostrarDatosEnTabla(jTable1, jTextFielBuscarPorCI.getText());
        this.fijarAnchoColumnasTabla();
    }
    
    private void limpiarTodo(){
        this.limpiarCampos();
        this.limpiarTabla();
    }
    
    private void limpiarCampos(){
        jTextFielID.setText("0");
        jTextFieldUsername.setText("");
        jPasswordField.setText("");
        jTextFieldNombreMedico.setText("");
        jTextFieldIdMedico.setText("");
        jComboBoxPrivilegio.setSelectedIndex(0);
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("USERNAME");
        model.addColumn("CREADO EN");
        model.addColumn("MEDICO");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
    private boolean validarCamposLlenos(){
        if(jCheckBox1.isSelected())
            return !jTextFieldUsername.getText().isEmpty() && !jTextFieldIdMedico.getText().isEmpty() && jComboBoxPrivilegio.getSelectedIndex()!=0 && !jPasswordField.getText().isEmpty();
        else
            return !jTextFieldUsername.getText().isEmpty() && !jTextFieldIdMedico.getText().isEmpty() && jComboBoxPrivilegio.getSelectedIndex()!=0;
    }
    
    private void buscarMedicoPorCI(){
        Medico med = new Medico();
        med.buscarMedicoPorCI(jTextFieldNombreMedico, jTextFieldIdMedico.getText());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFielID = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFielBuscarPorCI = new javax.swing.JTextField();
        jButtonBuscarPorCI = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldNombreMedico = new javax.swing.JTextField();
        jTextFieldIdMedico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBoxPrivilegio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 50, 47));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 122, 163)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(21, 150, 203));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/guardar-20.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 120, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 150, 203));
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(21, 150, 203));
        jLabel2.setText("PASSWORD:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 90, 28));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 150, 203));
        jLabel5.setText("USERNAME:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, 28));

        jTextFielID.setEditable(false);
        jTextFielID.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielID.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTextFielID.setForeground(new java.awt.Color(21, 150, 203));
        jTextFielID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielID.setText("0");
        jTextFielID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 150, 203)));
        jTextFielID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFielID.setName(""); // NOI18N
        jTextFielID.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielID.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFielID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielIDKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFielID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 50, 30));

        jTextFieldUsername.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldUsername.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldUsername.setName(""); // NOI18N
        jTextFieldUsername.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldUsername.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 210, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 150, 203));
        jLabel4.setText("USUARIOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 360, 30));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/salir-20.png"))); // NOI18N
        jButton2.setText("Cerrar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 120, -1));

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 102, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/eliminar-20.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 120, -1));

        jButton5.setBackground(new java.awt.Color(21, 150, 203));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 204, 204));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/mostrar-20.png"))); // NOI18N
        jButton5.setText("Mostrar");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        jButton6.setBackground(new java.awt.Color(21, 150, 203));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(204, 204, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/limpiar-20.png"))); // NOI18N
        jButton6.setText("Limpiar");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(63, 63, 63));
        jScrollPane1.setForeground(new java.awt.Color(63, 63, 63));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(21, 150, 203));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setFocusable(false);
        jTable1.setRowHeight(21);
        jTable1.setSelectionBackground(new java.awt.Color(21, 150, 203));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 670, 190));

        jTextFielBuscarPorCI.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielBuscarPorCI.setForeground(new java.awt.Color(21, 150, 203));
        jTextFielBuscarPorCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielBuscarPorCI.setBorder(null);
        jTextFielBuscarPorCI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFielBuscarPorCI.setName(""); // NOI18N
        jTextFielBuscarPorCI.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielBuscarPorCI.setSelectionColor(new java.awt.Color(102, 255, 102));
        jTextFielBuscarPorCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielBuscarPorCIKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFielBuscarPorCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 170, 30));

        jButtonBuscarPorCI.setBackground(new java.awt.Color(21, 150, 203));
        jButtonBuscarPorCI.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonBuscarPorCI.setForeground(new java.awt.Color(51, 51, 51));
        jButtonBuscarPorCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/buscarBlue-25.png"))); // NOI18N
        jButtonBuscarPorCI.setBorderPainted(false);
        jButtonBuscarPorCI.setContentAreaFilled(false);
        jButtonBuscarPorCI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarPorCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPorCIActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarPorCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 40, 30));

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/nuevo-20.png"))); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 470, 10));

        jTextFieldNombreMedico.setEditable(false);
        jTextFieldNombreMedico.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldNombreMedico.setForeground(new java.awt.Color(21, 150, 203));
        jPanel1.add(jTextFieldNombreMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 270, 30));

        jTextFieldIdMedico.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldIdMedico.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldIdMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdMedicoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIdMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 110, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(21, 150, 203));
        jLabel8.setText("MEDICO POR CI:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, 30));

        jPasswordField.setEditable(false);
        jPasswordField.setBackground(new java.awt.Color(63, 63, 63));
        jPasswordField.setForeground(new java.awt.Color(21, 150, 203));
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 250, 30));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        jComboBoxPrivilegio.setBackground(new java.awt.Color(63, 63, 63));
        jComboBoxPrivilegio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Privilegio:", "Administrador", "Secretaria" }));
        jComboBoxPrivilegio.setToolTipText("");
        jPanel1.add(jComboBoxPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.eliminar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.mostrarDatos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.limpiarTodo();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButtonBuscarPorCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCIActionPerformed
        this.buscarPorCI();
    }//GEN-LAST:event_jButtonBuscarPorCIActionPerformed

    private void jTextFielBuscarPorCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielBuscarPorCIKeyTyped
        this.buscarPorCI();
    }//GEN-LAST:event_jTextFielBuscarPorCIKeyTyped

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if( jTable1.getSelectedRowCount()>0 ){
            String ci = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            Usuario medi = new Usuario();
            medi.buscarParaEdicion(ci);
            
            jTextFielID.setText( medi.getId() );
            jTextFieldIdMedico.setText(medi.getId_medico());
            jTextFieldUsername.setText(medi.getUsername());
            jTextFieldNombreMedico.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            if(medi.getPrivilegio().equals("A")) jComboBoxPrivilegio.setSelectedIndex(1); else jComboBoxPrivilegio.setSelectedIndex(2);
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.nuevo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9') && c!='_'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyTyped

    private void jTextFielIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielIDKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9') && c!='#' && c!='%' && c!='&' && c!='-'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFielIDKeyTyped

    private void jTextFieldIdMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdMedicoActionPerformed
        this.buscarMedicoPorCI();
    }//GEN-LAST:event_jTextFieldIdMedicoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
            jPasswordField.setEditable(true);
        else
            jPasswordField.setEditable(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonBuscarPorCI;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxPrivilegio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFielBuscarPorCI;
    private javax.swing.JTextField jTextFielID;
    public static javax.swing.JTextField jTextFieldIdMedico;
    public static javax.swing.JTextField jTextFieldNombreMedico;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
/**
     * @author alfreding0
     */
}
