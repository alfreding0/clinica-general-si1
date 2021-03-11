package clases;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/** @author alfreding0 */


public class FormHistorialClinico extends javax.swing.JFrame {

    JCheckBox[] jchecksBoxsArray;
    JTextArea[] jtextAreaArray;
    
    public FormHistorialClinico(String ci, Component component) {
        initComponents();
        this.setLocationRelativeTo(component);
        jLabelIDpaciente.requestFocus(); //para que el foco quede ahí y no en el boton guardar
        
        this.jchecksBoxsArray = new JCheckBox[]{jCheckBoxEpilepsia, jCheckBoxAnemia, jCheckBoxDiabetes, jCheckBoxHepatitis, jCheckBoxHipertension, jCheckBoxAsma, jCheckBoxTuberculosis, jCheckBoxVihsida, jCheckBoxGastritis, jCheckBoxCancer, jCheckBoxMenopausia};
        this.jtextAreaArray = new JTextArea[]{jTextAreaEpilepsia, jTextAreaAnemia, jTextAreaDiabetes, jTextAreaHepatitis, jTextAreaHipertension, jTextAreaAsma, jTextAreaTuberculosis, jTextAreaVihsida, jTextAreaGastritis, jTextAreaCancer};
        
        HistorialClinico h = new HistorialClinico();
        h.mostrarDatosHistorialClinico(jchecksBoxsArray, jtextAreaArray, ci);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBoxAsma = new javax.swing.JCheckBox();
        jCheckBoxHipertension = new javax.swing.JCheckBox();
        jCheckBoxHepatitis = new javax.swing.JCheckBox();
        jCheckBoxDiabetes = new javax.swing.JCheckBox();
        jCheckBoxAnemia = new javax.swing.JCheckBox();
        jCheckBoxEpilepsia = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEpilepsia = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAnemia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDiabetes = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaHepatitis = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaHipertension = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaAsma = new javax.swing.JTextArea();
        jCheckBoxMenopausia = new javax.swing.JCheckBox();
        jCheckBoxCancer = new javax.swing.JCheckBox();
        jCheckBoxGastritis = new javax.swing.JCheckBox();
        jCheckBoxVihsida = new javax.swing.JCheckBox();
        jCheckBoxTuberculosis = new javax.swing.JCheckBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaTuberculosis = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaVihsida = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextAreaGastritis = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaCancer = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNombrepaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelIDpaciente = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 50, 47));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxAsma.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxAsma.setText("Asma");
        jPanel1.add(jCheckBoxAsma, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 120, 55));

        jCheckBoxHipertension.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxHipertension.setText("Hipertension");
        jPanel1.add(jCheckBoxHipertension, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 160, 55));

        jCheckBoxHepatitis.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxHepatitis.setText("Hepatitis");
        jPanel1.add(jCheckBoxHepatitis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 160, 55));

        jCheckBoxDiabetes.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxDiabetes.setText("Diabetes");
        jPanel1.add(jCheckBoxDiabetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 55));

        jCheckBoxAnemia.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxAnemia.setText("Anemia");
        jPanel1.add(jCheckBoxAnemia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, 55));

        jCheckBoxEpilepsia.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxEpilepsia.setText("Epilepsia/Convulsiones");
        jPanel1.add(jCheckBoxEpilepsia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 55));

        jTextAreaEpilepsia.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaEpilepsia.setColumns(20);
        jTextAreaEpilepsia.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaEpilepsia.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEpilepsia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 308, 55));

        jTextAreaAnemia.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaAnemia.setColumns(20);
        jTextAreaAnemia.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaAnemia.setRows(5);
        jScrollPane2.setViewportView(jTextAreaAnemia);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 308, 55));

        jTextAreaDiabetes.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaDiabetes.setColumns(20);
        jTextAreaDiabetes.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaDiabetes.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDiabetes);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 308, 55));

        jTextAreaHepatitis.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaHepatitis.setColumns(20);
        jTextAreaHepatitis.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaHepatitis.setRows(5);
        jScrollPane5.setViewportView(jTextAreaHepatitis);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 308, 55));

        jTextAreaHipertension.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaHipertension.setColumns(20);
        jTextAreaHipertension.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaHipertension.setRows(5);
        jScrollPane6.setViewportView(jTextAreaHipertension);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 308, 55));

        jTextAreaAsma.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaAsma.setColumns(20);
        jTextAreaAsma.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaAsma.setRows(5);
        jScrollPane4.setViewportView(jTextAreaAsma);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 308, 55));

        jCheckBoxMenopausia.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxMenopausia.setText("Menopausia");
        jPanel1.add(jCheckBoxMenopausia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 160, 55));

        jCheckBoxCancer.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxCancer.setText("Cancer");
        jPanel1.add(jCheckBoxCancer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 120, 55));

        jCheckBoxGastritis.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxGastritis.setText("Gastritis");
        jPanel1.add(jCheckBoxGastritis, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 120, 55));

        jCheckBoxVihsida.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxVihsida.setText("VIH/SIDA");
        jPanel1.add(jCheckBoxVihsida, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 120, 55));

        jCheckBoxTuberculosis.setForeground(new java.awt.Color(21, 150, 203));
        jCheckBoxTuberculosis.setText("Tuberculosis");
        jPanel1.add(jCheckBoxTuberculosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 120, 55));

        jTextAreaTuberculosis.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaTuberculosis.setColumns(20);
        jTextAreaTuberculosis.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaTuberculosis.setRows(5);
        jScrollPane7.setViewportView(jTextAreaTuberculosis);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 311, 55));

        jTextAreaVihsida.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaVihsida.setColumns(20);
        jTextAreaVihsida.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaVihsida.setRows(5);
        jScrollPane10.setViewportView(jTextAreaVihsida);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 308, 55));

        jTextAreaGastritis.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaGastritis.setColumns(20);
        jTextAreaGastritis.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaGastritis.setRows(5);
        jScrollPane12.setViewportView(jTextAreaGastritis);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 308, 55));

        jTextAreaCancer.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaCancer.setColumns(20);
        jTextAreaCancer.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaCancer.setRows(5);
        jScrollPane8.setViewportView(jTextAreaCancer);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 308, 55));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 150, 203));
        jLabel1.setText("PACIENTE:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 70, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 150, 203));
        jLabel4.setText("HISTORIAL CLINICO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, -1));

        jLabelNombrepaciente.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabelNombrepaciente.setForeground(new java.awt.Color(21, 150, 203));
        jLabelNombrepaciente.setText("paciente x");
        jPanel1.add(jLabelNombrepaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 360, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(21, 150, 203));
        jLabel3.setText("CI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

        jLabelIDpaciente.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabelIDpaciente.setForeground(new java.awt.Color(21, 150, 203));
        jLabelIDpaciente.setText("ci x");
        jPanel1.add(jLabelIDpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 110, 30));

        jButton2.setBackground(new java.awt.Color(21, 150, 203));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/guardar-20.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/salir-20.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    private void guardar(){
        HistorialClinico h = new HistorialClinico(
                jCheckBoxEpilepsia.isSelected(), 
                jTextAreaEpilepsia.getText(), 
                jCheckBoxAnemia.isSelected(), 
                jTextAreaAnemia.getText(), 
                jCheckBoxDiabetes.isSelected(), 
                jTextAreaDiabetes.getText(), 
                jCheckBoxHepatitis.isSelected(), 
                jTextAreaHepatitis.getText(), 
                jCheckBoxHipertension.isSelected(), 
                jTextAreaHipertension.getText(), 
                jCheckBoxAsma.isSelected(), 
                jTextAreaAsma.getText(), 
                jCheckBoxTuberculosis.isSelected(), 
                jTextAreaTuberculosis.getText(), 
                jCheckBoxVihsida.isSelected(), 
                jTextAreaVihsida.getText(), 
                jCheckBoxGastritis.isSelected(), 
                jTextAreaGastritis.getText(), 
                jCheckBoxCancer.isSelected(), 
                jTextAreaCancer.getText(), 
                jCheckBoxMenopausia.isSelected(),
                jLabelIDpaciente.getText()
        );
        
        boolean respuesta = h.actualizarHistorialClinico();
        if(respuesta)
            JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente!");
        else
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intente nuevamente!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBoxAnemia;
    private javax.swing.JCheckBox jCheckBoxAsma;
    private javax.swing.JCheckBox jCheckBoxCancer;
    private javax.swing.JCheckBox jCheckBoxDiabetes;
    private javax.swing.JCheckBox jCheckBoxEpilepsia;
    private javax.swing.JCheckBox jCheckBoxGastritis;
    private javax.swing.JCheckBox jCheckBoxHepatitis;
    private javax.swing.JCheckBox jCheckBoxHipertension;
    private javax.swing.JCheckBox jCheckBoxMenopausia;
    private javax.swing.JCheckBox jCheckBoxTuberculosis;
    private javax.swing.JCheckBox jCheckBoxVihsida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabelIDpaciente;
    public static javax.swing.JLabel jLabelNombrepaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextAreaAnemia;
    private javax.swing.JTextArea jTextAreaAsma;
    private javax.swing.JTextArea jTextAreaCancer;
    private javax.swing.JTextArea jTextAreaDiabetes;
    private javax.swing.JTextArea jTextAreaEpilepsia;
    private javax.swing.JTextArea jTextAreaGastritis;
    private javax.swing.JTextArea jTextAreaHepatitis;
    private javax.swing.JTextArea jTextAreaHipertension;
    private javax.swing.JTextArea jTextAreaTuberculosis;
    private javax.swing.JTextArea jTextAreaVihsida;
    // End of variables declaration//GEN-END:variables

}
