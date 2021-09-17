    package clases;


/** @author alfreding0 */


public class FormPrincipal extends javax.swing.JFrame {

    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(FormPrincipal.this); //ventana centrado
        jLabelBackground.requestFocus(); //para el foco quede aquí, y no en el boton medico
//        this.setOpacity(0.5f);

    }
    
    //si es secretaria, va a mostrar todo expecto usuarios. y de la misma manera al revés.
    public void mostrarBotonesSegunTipoUsuario(boolean val){
        jButtonMedicos.setVisible(true); //esto siempre va estar visible, para medico y secretaria
        jButtonPacientes.setVisible(val);
        jButtonConsultas.setVisible(val);
        jButtonTratamientos.setVisible(val);
        jButtonUsuarios.setVisible(!val);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNombreMedico = new javax.swing.JLabel();
        jLabelIdMedico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonConsultas = new javax.swing.JButton();
        jButtonMedicos = new javax.swing.JButton();
        jButtonPacientes = new javax.swing.JButton();
        jButtonTratamientos = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA PRIVADO CLINICA GENERAL LAS VEGAS");

        jPanel1.setBackground(new java.awt.Color(21, 59, 84));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("\"LAS VEGAS\"");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 170, 66));

        jLabel2.setFont(new java.awt.Font("Chilanka", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLINICA GENERAL");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 477, 66));

        jLabel3.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/logotipo.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, 70));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 40, 220, 20));

        jLabelNombreMedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreMedico.setText("Alfredo Gonzales Quiucha");
        jPanel1.add(jLabelNombreMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 60, 150, 20));

        jLabelIdMedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdMedico.setText("8611859");
        jPanel1.add(jLabelIdMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 70, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/conf.png"))); // NOI18N
        jLabel5.setText("Configuración");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel5.setIconTextGap(0);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, -1, 30));

        jPanel2.setBackground(new java.awt.Color(21, 59, 84));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonConsultas.setBackground(new java.awt.Color(153, 204, 255));
        jButtonConsultas.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButtonConsultas.setForeground(new java.awt.Color(51, 51, 51));
        jButtonConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/consulta.png"))); // NOI18N
        jButtonConsultas.setText("CONSULTAS");
        jButtonConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultasActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 190, 40));

        jButtonMedicos.setBackground(new java.awt.Color(153, 204, 255));
        jButtonMedicos.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButtonMedicos.setForeground(new java.awt.Color(51, 51, 51));
        jButtonMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/doctor.png"))); // NOI18N
        jButtonMedicos.setText("GESTIONAR MEDICOS");
        jButtonMedicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedicosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonMedicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 40));

        jButtonPacientes.setBackground(new java.awt.Color(153, 204, 255));
        jButtonPacientes.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButtonPacientes.setForeground(new java.awt.Color(51, 51, 51));
        jButtonPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/paciente.png"))); // NOI18N
        jButtonPacientes.setText("GESTIONAR PACIENTES");
        jButtonPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacientesActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, 40));

        jButtonTratamientos.setBackground(new java.awt.Color(153, 204, 255));
        jButtonTratamientos.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButtonTratamientos.setForeground(new java.awt.Color(51, 51, 51));
        jButtonTratamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/tratamiento.png"))); // NOI18N
        jButtonTratamientos.setText("TRATAMIENTOS");
        jButtonTratamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTratamientosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 190, 40));

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/salir-20.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 560, 120, -1));

        jButtonUsuarios.setBackground(new java.awt.Color(153, 204, 255));
        jButtonUsuarios.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButtonUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/doctor.png"))); // NOI18N
        jButtonUsuarios.setText("USUARIOS");
        jButtonUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 40));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/img-background-2.jpg"))); // NOI18N
        jPanel2.add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacientesActionPerformed
        FormPaciente pac = new FormPaciente(FormPrincipal.this);
        pac.setVisible(true);
    }//GEN-LAST:event_jButtonPacientesActionPerformed

    private void jButtonMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedicosActionPerformed
        FormMedico medico = new FormMedico(FormPrincipal.this);
        medico.setVisible(true);
    }//GEN-LAST:event_jButtonMedicosActionPerformed

    private void jButtonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultasActionPerformed
        FormConsulta cons = new FormConsulta();
        cons.setVisible(true);
    }//GEN-LAST:event_jButtonConsultasActionPerformed

    private void jButtonTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTratamientosActionPerformed
        FormTratamiento trat = new FormTratamiento(FormPrincipal.this);
        trat.setVisible(true);
    }//GEN-LAST:event_jButtonTratamientosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        FormUsuario form = new FormUsuario(FormPrincipal.this);
        form.setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new FormCambiarPassword(FormPrincipal.this).setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonConsultas;
    private javax.swing.JButton jButtonMedicos;
    private javax.swing.JButton jButtonPacientes;
    private javax.swing.JButton jButtonTratamientos;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBackground;
    public static javax.swing.JLabel jLabelIdMedico;
    public static javax.swing.JLabel jLabelNombreMedico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
/** @author alfreding0 */
}