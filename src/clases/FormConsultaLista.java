package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/** @author alfreding0 */


public class FormConsultaLista extends javax.swing.JFrame {

    public FormConsultaLista() {
        initComponents();
        this.setLocationRelativeTo(FormConsultaLista.this);
    }
    
    private void mostrarConsultasSoloHoy(){
        String fechaIni = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        String fechaFin = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        Consulta con = new Consulta();
        con.mostrarDatosConsulta(jTable1, fechaIni, fechaFin);
    }
    
    private void mostrarConsultasEntreFechas(){
        String fechaIni = (new SimpleDateFormat("yyyy-MM-dd")).format(jDateChooserFechaIni.getDate());
        String fechaFin = (new SimpleDateFormat("yyyy-MM-dd")).format(jDateChooserFechaFin.getDate());
        Consulta con = new Consulta();
        con.mostrarDatosConsulta(jTable1, fechaIni, fechaFin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonBuscarPorCI2 = new javax.swing.JButton();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaIni = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 150, 203));
        jLabel5.setText("CONSULTAS REGISTRADAS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 360, -1));

        jButtonBuscarPorCI2.setBackground(new java.awt.Color(21, 150, 203));
        jButtonBuscarPorCI2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonBuscarPorCI2.setForeground(new java.awt.Color(51, 51, 51));
        jButtonBuscarPorCI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/buscarBlue-25.png"))); // NOI18N
        jButtonBuscarPorCI2.setBorderPainted(false);
        jButtonBuscarPorCI2.setContentAreaFilled(false);
        jButtonBuscarPorCI2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarPorCI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPorCI2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarPorCI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 40, 30));
        jPanel1.add(jDateChooserFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, 30));
        jPanel1.add(jDateChooserFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 30));

        jButton3.setBackground(new java.awt.Color(21, 150, 203));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/mostrar-20.png"))); // NOI18N
        jButton3.setText("Solo hoy");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 130, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1030, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarPorCI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCI2ActionPerformed
        this.mostrarConsultasEntreFechas();
    }//GEN-LAST:event_jButtonBuscarPorCI2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.mostrarConsultasSoloHoy();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscarPorCI;
    private javax.swing.JButton jButtonBuscarPorCI1;
    private javax.swing.JButton jButtonBuscarPorCI2;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaIni;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
/** @author alfreding0 */
}