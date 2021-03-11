package clases;

import java.util.Date;
import javax.swing.JOptionPane;
import lu.tudor.santec.jtimechooser.JTimeChooser;

/** @author alfreding0 */


public class FormConsulta extends javax.swing.JFrame {

    public FormConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTimeChooserHoraini.setTime(new Date());
        this.ponerHoraMas(jTimeChooserHorafin);
        jLabelFechahoy.setText(new Date().toString());
    }
    
    
    private void ponerHoraMas(JTimeChooser jtimechooser){
        Date date2 = new Date();
        int year = date2.getYear();
        int month = date2.getMonth();
        int day = date2.getDay();
        int hour = date2.getHours();
        int minute = date2.getMinutes();
        int second = date2.getSeconds();
        jtimechooser.setTime(new Date(year, month, day, hour+1, minute, second));

//        JOptionPane.showMessageDialog(null, (Calendar.getInstance()).get(Calendar.HOUR_OF_DAY));
    }
    
    private void guardar(){
        if(this.validarCamposLlenos()){
            int status = JOptionPane.showConfirmDialog(this, "Confirme que desea guardar la Consulta!");
            if(status == JOptionPane.YES_OPTION){
                Consulta c = new Consulta(
                        jTextArea1.getText(), 
                        jTimeChooserHoraini.getFormatedTime(), 
                        jTimeChooserHorafin.getFormatedTime(), 
                        jSpinnerPrecio.getValue().toString(), 
                        jTextFieldIdPaciente.getText(), 
                        FormPrincipal.jLabelIdMedico.getText()
                );
                boolean estado = c.registrarConsulta();
                if(estado){
                    JOptionPane.showMessageDialog(null, "Se ha guardado satisfactoriamente!");
                    this.limpiarCampos();
                }else
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente nuevamente!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos!");
    }
    
    private boolean validarCamposLlenos(){
        return (!jTextArea1.getText().isEmpty()
                && !jTimeChooserHoraini.getFormatedTime().isEmpty()
                && !jTimeChooserHorafin.getFormatedTime().isEmpty()
                && !jSpinnerPrecio.getValue().toString().equals("0.0")
                && !jTextFieldIdPaciente.getText().isEmpty()
                && !FormPrincipal.jLabelIdMedico.getText().isEmpty())
                ;
    }
    
    private void limpiarCampos(){
        jTextArea1.setText("");
        jTimeChooserHoraini.setTime(new Date());
        this.ponerHoraMas(jTimeChooserHorafin);
        jSpinnerPrecio.setValue(0.00f);
        jTextFieldIdPaciente.setText("");
        jTextFieldNombrePaciente.setText("");
    }
    
    private void buscarPacientePorCI(){
        jTextFieldNombrePaciente.setText("");//primero limpiar
        Paciente pac = new Paciente();
        pac.buscarPacientePorCI(jTextFieldNombrePaciente, jTextFieldIdPaciente.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerPrecio = new javax.swing.JSpinner();
        jTextFieldIdPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTimeChooserHoraini = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jTimeChooserHorafin = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelFechahoy = new javax.swing.JLabel();
        jTextFieldNombrePaciente = new javax.swing.JTextField();
        jButtonBuscarPorCI = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 560, 109));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("MOTIVO O RAZÓN:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("Precio (Bs.):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 160, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("HORA FIN:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 90, 30));

        jSpinnerPrecio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jSpinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.00f, 0.00f, null, 0.01f));
        jSpinnerPrecio.setToolTipText("");
        jSpinnerPrecio.setName(""); // NOI18N
        jPanel1.add(jSpinnerPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 160, 40));

        jTextFieldIdPaciente.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIdPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 110, 30));

        jButton1.setBackground(new java.awt.Color(21, 150, 203));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/guardar-20.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 120, -1));

        jTimeChooserHoraini.setBackground(new java.awt.Color(63, 63, 63));
        jTimeChooserHoraini.setForeground(new java.awt.Color(21, 150, 203));
        jPanel1.add(jTimeChooserHoraini, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 92, 30));

        jTimeChooserHorafin.setBackground(new java.awt.Color(63, 63, 63));
        jTimeChooserHorafin.setForeground(new java.awt.Color(21, 150, 203));
        jPanel1.add(jTimeChooserHorafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 92, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 150, 203));
        jLabel5.setText("NUEVA CONSULTA");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("HORA INICIO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 90, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("PACIENTE:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 30));

        jLabelFechahoy.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelFechahoy.setForeground(new java.awt.Color(51, 51, 51));
        jLabelFechahoy.setText("FECHA ACTUAL");
        jPanel1.add(jLabelFechahoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 300, 30));

        jTextFieldNombrePaciente.setEditable(false);
        jTextFieldNombrePaciente.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextFieldNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 320, 30));

        jButtonBuscarPorCI.setBackground(new java.awt.Color(21, 150, 203));
        jButtonBuscarPorCI.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonBuscarPorCI.setForeground(new java.awt.Color(51, 51, 51));
        jButtonBuscarPorCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/nuevo-20.png"))); // NOI18N
        jButtonBuscarPorCI.setBorderPainted(false);
        jButtonBuscarPorCI.setContentAreaFilled(false);
        jButtonBuscarPorCI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarPorCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPorCIActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarPorCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 30, 30));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 410, 110, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("FECHA:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 90, 30));

        jButton3.setBackground(new java.awt.Color(21, 150, 203));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/mostrar-20.png"))); // NOI18N
        jButton3.setText("Ver Consultas Anteriores");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBuscarPorCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCIActionPerformed
        /**
         * En el parámetro se está Enviando como argumento, el objeto de esta misma clase, que
         * al momento de abrirse el formulario de FormPaciente se va utilizar para dos cosas:
         * 1. Para centrar la ventana paciente de acuerto a esta ventana.
         * 2. Para verificar si que el FormPaciente se abrió desde este FormConsulta, para que desde allí, dependiendo,
         * se puede enviar datos del cliente hasta aquí: el CI y su nombre.
         */
        FormPaciente pac = new FormPaciente(this);
        pac.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarPorCIActionPerformed

    private void jTextFieldIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteActionPerformed
        this.buscarPacientePorCI();
    }//GEN-LAST:event_jTextFieldIdPacienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormConsultaLista lista = new FormConsultaLista();
        lista.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscarPorCI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFechahoy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerPrecio;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField jTextFieldIdPaciente;
    public static javax.swing.JTextField jTextFieldNombrePaciente;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooserHorafin;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooserHoraini;
    // End of variables declaration//GEN-END:variables

}
