package clases;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utils.HeaderTable;

/** @author alfreding0 */


public class FormHistorialTratamiento extends javax.swing.JFrame {

    private String id_historial_tratamiento="0";
    
    public FormHistorialTratamiento(Component component) {
        initComponents();
        this.setLocationRelativeTo(component);
        this.repintarHeaderTabla();
        this.mostrarDatos(FormTratamiento.jLabelSelectedID.getText());
    }
    
    private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTable1.setTableHeader(jtableHeader);
    }    
    
    private void fijarAnchoColumnasTabla(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);//ID
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);//detalle
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);//fecha_hora
    }
    
    private void mostrarDatos(String id_tratamiento){
        HistorialTratamiento historial = new HistorialTratamiento();
        historial.mostrarDatosHistorial(jTable1, id_tratamiento);
        this.fijarAnchoColumnasTabla();
    }
    
    private void guardar(){
        if(this.validarCamposLlenos()){
            HistorialTratamiento hist = new HistorialTratamiento(
                jTextAreaDetalle.getText(), 
                jLabelIdTratamiento.getText()
            );

            boolean estado = hist.registrarHistorialTratamiento( id_historial_tratamiento );
            if(estado){
                JOptionPane.showMessageDialog(null, "Se ha guardado satisfactoriamente!");
                this.mostrarDatos(jLabelIdTratamiento.getText());
                this.limpiarCampos();
            }else
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente nuevamente!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos!");
    }
    
    private void nuevo(){
        this.limpiarCampos();
        jTextAreaDetalle.requestFocus();
    }
        
    private boolean validarCamposLlenos(){
        return !jTextAreaDetalle.getText().isEmpty();
    }
    
    private void limpiarCampos(){
        jTextAreaDetalle.setText("");
        id_historial_tratamiento = "0";
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("DETALLE");
        model.addColumn("FECHA Y HORA");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
    private void limpiarTodo(){
        this.limpiarCampos();
        this.limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabelIdTratamiento = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDetalle = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelTratPagado = new javax.swing.JLabel();
        jLabelTratDuracionDias = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelTratCosto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelTratRestante = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaTratDescripcion = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabelTratPaciente = new javax.swing.JLabel();

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 120, -1));

        jLabelIdTratamiento.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelIdTratamiento.setForeground(new java.awt.Color(21, 150, 203));
        jLabelIdTratamiento.setText("0");
        jPanel1.add(jLabelIdTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 150, 30));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 580, 120, -1));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

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
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

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
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 860, 190));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 470, 10));

        jTextAreaDetalle.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaDetalle.setColumns(20);
        jTextAreaDetalle.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaDetalle.setRows(5);
        jTextAreaDetalle.setBorder(null);
        jTextAreaDetalle.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextAreaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaDetalleKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaDetalleKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaDetalle);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 760, 60));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 860, 10));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 150, 203));
        jLabel5.setText("HISTORIAL TRATAMIENTO ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 400, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(21, 150, 203));
        jLabel11.setText("DETALLE:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 28));

        jPanel2.setBackground(new java.awt.Color(63, 63, 63));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTratPagado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelTratPagado.setForeground(new java.awt.Color(255, 102, 51));
        jLabelTratPagado.setText("70");
        jPanel2.add(jLabelTratPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 80, 28));

        jLabelTratDuracionDias.setForeground(new java.awt.Color(21, 150, 203));
        jLabelTratDuracionDias.setText("50");
        jPanel2.add(jLabelTratDuracionDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 80, 28));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(21, 150, 203));
        jLabel14.setText("DURACION DIAS:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 110, 28));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(21, 150, 203));
        jLabel15.setText("COSTO TOTAL (Bs):");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 28));

        jLabelTratCosto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelTratCosto.setForeground(new java.awt.Color(255, 102, 51));
        jLabelTratCosto.setText("120");
        jPanel2.add(jLabelTratCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 80, 28));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(21, 150, 203));
        jLabel17.setText("PAGADO (Bs):");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 100, 28));

        jLabelTratRestante.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelTratRestante.setForeground(new java.awt.Color(255, 102, 51));
        jLabelTratRestante.setText("50");
        jPanel2.add(jLabelTratRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 80, 28));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(21, 150, 203));
        jLabel19.setText("X COBRAR (Bs):");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 110, 28));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(21, 150, 203));
        jLabel21.setText("DESCRIPCION:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 28));

        jTextAreaTratDescripcion.setEditable(false);
        jTextAreaTratDescripcion.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaTratDescripcion.setColumns(20);
        jTextAreaTratDescripcion.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaTratDescripcion.setRows(5);
        jTextAreaTratDescripcion.setBorder(null);
        jTextAreaTratDescripcion.setSelectionColor(new java.awt.Color(21, 150, 203));
        jScrollPane3.setViewportView(jTextAreaTratDescripcion);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 740, 60));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(21, 150, 203));
        jLabel13.setText("PACIENTE:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 28));

        jLabelTratPaciente.setForeground(new java.awt.Color(21, 150, 203));
        jLabelTratPaciente.setText("987396 - JUNIOR CASTELLOS");
        jPanel2.add(jLabelTratPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 450, 28));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 860, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.mostrarDatos(jLabelIdTratamiento.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.limpiarTodo();
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if( jTable1.getSelectedRowCount()>0 ){
            String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            HistorialTratamiento historial = new HistorialTratamiento();
            historial.buscarParaEdicion(id);

            jTextAreaDetalle.setText(historial.getDetalle());
            id_historial_tratamiento = historial.getId();
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.nuevo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextAreaDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDetalleKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' && c!='-' && (c<'0' || c>'9') && c!='ñ' && c!='Ñ'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextAreaDetalleKeyTyped

    private void jTextAreaDetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDetalleKeyReleased
        jTextAreaDetalle.setText(jTextAreaDetalle.getText().toUpperCase());
    }//GEN-LAST:event_jTextAreaDetalleKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabelIdTratamiento;
    public static javax.swing.JLabel jLabelTratCosto;
    public static javax.swing.JLabel jLabelTratDuracionDias;
    public static javax.swing.JLabel jLabelTratPaciente;
    public static javax.swing.JLabel jLabelTratPagado;
    public static javax.swing.JLabel jLabelTratRestante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaDetalle;
    public static javax.swing.JTextArea jTextAreaTratDescripcion;
    // End of variables declaration//GEN-END:variables

}
