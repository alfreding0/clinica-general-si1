package clases;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utils.HeaderTable;

/** @author alfreding0 */


public class FormTratamiento extends javax.swing.JFrame {

    public FormTratamiento(Component component) {
        initComponents();
        this.setLocationRelativeTo(component);
        this.repintarHeaderTabla();
        this.mostrarDatos();
    }
    
    
    private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTable1.setTableHeader(jtableHeader);
    }    
    
    private void fijarAnchoColumnasTabla(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);//ID
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);//paciente
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);//duracion-dias
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(170);//descripcion
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);//costo
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);//medico
    }
    
    private void mostrarDatos(){
        Tratamiento trat = new Tratamiento();
        trat.mostrarDatosTratamiento(jTable1);
        this.fijarAnchoColumnasTabla();
    }
    
    private void guardar(){
        if(this.validarCamposLlenos()){
            int status = JOptionPane.showConfirmDialog(this, "Confirme que desea guardar!");
            if(status == JOptionPane.YES_OPTION){
                Tratamiento c = new Tratamiento(
                        jSpinnerDuracionDias.getValue().toString(), 
                        jTextAreaDescripcion.getText(), 
                        jSpinnerPrecio.getValue().toString().trim(), 
                        jTextFieldIdPaciente.getText(), 
                        FormPrincipal.jLabelIdMedico.getText()
                );
                
                boolean estado = c.registrarTratamiento(jLabelSelectedID.getText());
                if(estado){
                    JOptionPane.showMessageDialog(null, "Se ha guardado satisfactoriamente!");
                    this.mostrarDatos();
                    this.limpiarCampos();
                }else
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente nuevamente!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos!");
    }
    
    private void nuevo(){
        this.limpiarCampos();
        jTextFieldIdPaciente.requestFocus();
    }
    
    private void eliminar(){
        if( ! jLabelSelectedID.getText().equals("0") ){
            int res = JOptionPane.showConfirmDialog(this, "Confirme para eliminar!");
            if(res==JOptionPane.YES_OPTION){
                Tratamiento trat = new Tratamiento();
                trat.eliminarTratamiento(jLabelSelectedID.getText());
                this.mostrarDatos();
            }
        }   
    }
    
    private boolean validarCamposLlenos(){
        return (!jTextAreaDescripcion.getText().isEmpty()
                && !jSpinnerDuracionDias.getValue().toString().equals("0")
                && !jSpinnerPrecio.getValue().toString().equals("0.0")
                && !jTextFieldIdPaciente.getText().isEmpty()
                && !FormPrincipal.jLabelIdMedico.getText().isEmpty())
                ;
    }
    
    private void limpiarCampos(){
        jTextFieldIdPaciente.setText("");
        jTextFieldNombrePaciente.setText("");
        jTextAreaDescripcion.setText("");
        jSpinnerDuracionDias.setValue(0);
        jSpinnerPrecio.setValue(0.00f);
        jTextFielBuscarPorCI.setText("");
        jLabelSelectedID.setText("0");
        jTextFieldPagado.setText("0");
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("PACIENTE");
        model.addColumn("DURACION DIAS");
        model.addColumn("DESCRIPCION");
        model.addColumn("COSTO");
        model.addColumn("MEDICO");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
    private void limpiarTodo(){
        this.limpiarCampos();
        this.limpiarTabla();
    }
    
    private void buscarPacientePorCI(){
        jTextFieldNombrePaciente.setText("");//primero limpiar
        Paciente pac = new Paciente();
        pac.buscarPacientePorCI(jTextFieldNombrePaciente, jTextFieldIdPaciente.getText());
        jTextAreaDescripcion.requestFocus();
    }
    
    private void buscarTratamiendoPorCIPaciente(){
        Tratamiento t = new Tratamiento();
        t.buscarTratamientosPorCIPaciente(jTable1, jTextFielBuscarPorCI.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
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
        jButtonHistorialClinico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdPaciente = new javax.swing.JTextField();
        jLabelSelectedID = new javax.swing.JLabel();
        jTextFieldNombrePaciente = new javax.swing.JTextField();
        jButtonBuscarPorCI1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerDuracionDias = new javax.swing.JSpinner();
        jSpinnerPrecio = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPagado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelll = new javax.swing.JLabel();
        jButtonPagoTratamiento = new javax.swing.JButton();

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 120, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 150, 203));
        jLabel4.setText("GESTIÓN DE TRATAMIENTOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 880, 30));

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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, -1));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

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
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 860, 190));

        jTextFielBuscarPorCI.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielBuscarPorCI.setForeground(new java.awt.Color(21, 150, 203));
        jTextFielBuscarPorCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielBuscarPorCI.setBorder(null);
        jTextFielBuscarPorCI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFielBuscarPorCI.setName(""); // NOI18N
        jTextFielBuscarPorCI.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielBuscarPorCI.setSelectionColor(new java.awt.Color(102, 255, 102));
        jTextFielBuscarPorCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielBuscarPorCIKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFielBuscarPorCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 170, 30));

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
        jPanel1.add(jButtonBuscarPorCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 40, 30));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 470, 10));

        jButtonHistorialClinico.setBackground(new java.awt.Color(153, 204, 255));
        jButtonHistorialClinico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonHistorialClinico.setForeground(new java.awt.Color(51, 51, 51));
        jButtonHistorialClinico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/historial-clinico-32.png"))); // NOI18N
        jButtonHistorialClinico.setText("Ver historial");
        jButtonHistorialClinico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHistorialClinico.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonHistorialClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistorialClinicoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonHistorialClinico, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 160, 40));

        jTextAreaDescripcion.setBackground(new java.awt.Color(63, 63, 63));
        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setForeground(new java.awt.Color(21, 150, 203));
        jTextAreaDescripcion.setRows(5);
        jTextAreaDescripcion.setBorder(null);
        jTextAreaDescripcion.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextAreaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaDescripcionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaDescripcionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 430, 120));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(21, 150, 203));
        jLabel10.setText("DESCRIPCION:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 28));

        jTextFieldIdPaciente.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldIdPaciente.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldIdPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, 30));

        jLabelSelectedID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelSelectedID.setForeground(new java.awt.Color(255, 153, 102));
        jLabelSelectedID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSelectedID.setText("0");
        jPanel1.add(jLabelSelectedID, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 60, 30));

        jTextFieldNombrePaciente.setEditable(false);
        jTextFieldNombrePaciente.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldNombrePaciente.setForeground(new java.awt.Color(21, 150, 203));
        jPanel1.add(jTextFieldNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 310, 30));

        jButtonBuscarPorCI1.setBackground(new java.awt.Color(21, 150, 203));
        jButtonBuscarPorCI1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonBuscarPorCI1.setForeground(new java.awt.Color(51, 51, 51));
        jButtonBuscarPorCI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/nuevo-20.png"))); // NOI18N
        jButtonBuscarPorCI1.setBorderPainted(false);
        jButtonBuscarPorCI1.setContentAreaFilled(false);
        jButtonBuscarPorCI1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarPorCI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPorCI1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarPorCI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 30, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 860, 10));

        jPanel2.setBackground(new java.awt.Color(63, 63, 63));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("Precio (Bs.):");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(21, 150, 203));
        jLabel2.setText("DURACION DIAS:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 20));

        jSpinnerDuracionDias.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jSpinnerDuracionDias.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel2.add(jSpinnerDuracionDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

        jSpinnerPrecio.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jSpinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.00f, 0.00f, null, 0.01f));
        jSpinnerPrecio.setToolTipText("");
        jSpinnerPrecio.setName(""); // NOI18N
        jPanel2.add(jSpinnerPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 160, 80));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("PAGADO (Bs):");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 20));

        jTextFieldPagado.setEditable(false);
        jTextFieldPagado.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPagado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldPagado.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldPagado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPagado.setText("0");
        jPanel2.add(jTextFieldPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 330, 120));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(21, 150, 203));
        jLabel8.setText("PACIENTE:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 100, 30));

        jLabelll.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelll.setForeground(new java.awt.Color(255, 153, 102));
        jLabelll.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelll.setText("Selected ID:");
        jPanel1.add(jLabelll, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 130, 30));

        jButtonPagoTratamiento.setBackground(new java.awt.Color(153, 204, 255));
        jButtonPagoTratamiento.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonPagoTratamiento.setForeground(new java.awt.Color(51, 51, 51));
        jButtonPagoTratamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/dollar.png"))); // NOI18N
        jButtonPagoTratamiento.setText("Ir a Pagos");
        jButtonPagoTratamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPagoTratamiento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonPagoTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagoTratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPagoTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 630));

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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if( jTable1.getSelectedRowCount()>0 ){
            String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.buscarParaEdicion(id);

            jTextFieldIdPaciente.setText( tratamiento.getId_paciente());
            jTextFieldNombrePaciente.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            jTextAreaDescripcion.setText(tratamiento.getDescripcion());
            jSpinnerDuracionDias.setValue(Integer.parseInt(tratamiento.getDuracion_dias()));
            jSpinnerPrecio.setValue(Float.parseFloat(tratamiento.getCosto()));
            jTextFieldPagado.setText(tratamiento.getPagado());
            jLabelSelectedID.setText(tratamiento.getId());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButtonBuscarPorCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCIActionPerformed
        this.buscarTratamiendoPorCIPaciente();
    }//GEN-LAST:event_jButtonBuscarPorCIActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.nuevo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonHistorialClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistorialClinicoActionPerformed
        String id_tratamiento = jLabelSelectedID.getText();
        if( ! id_tratamiento.equals("0")){
            FormHistorialTratamiento historial = new FormHistorialTratamiento(FormTratamiento.this);
            FormHistorialTratamiento.jLabelIdTratamiento.setText( id_tratamiento );
            
            FormHistorialTratamiento.jLabelTratPaciente.setText( jTextFieldIdPaciente.getText() + " - " + jTextFieldNombrePaciente.getText() );
            FormHistorialTratamiento.jLabelTratDuracionDias.setText( jSpinnerDuracionDias.getValue().toString() );
            FormHistorialTratamiento.jTextAreaTratDescripcion.setText( jTextAreaDescripcion.getText() );
            
            float costoTotal = Float.parseFloat(jSpinnerPrecio.getValue().toString());
            float pagado = Float.parseFloat(jTextFieldPagado.getText());
            FormHistorialTratamiento.jLabelTratCosto.setText( String.valueOf(costoTotal) );
            FormHistorialTratamiento.jLabelTratPagado.setText( String.valueOf(pagado) );
            FormHistorialTratamiento.jLabelTratRestante.setText( String.valueOf(costoTotal-pagado) );
            historial.setVisible(true);
        }else
            JOptionPane.showMessageDialog(null, "Seleccione un Tratamiento de la tabla!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonHistorialClinicoActionPerformed

    private void jTextAreaDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' && c!='-' && (c<'0' || c>'9') && c!='ñ' && c!='Ñ'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextAreaDescripcionKeyTyped

    private void jTextAreaDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionKeyReleased
        jTextAreaDescripcion.setText(jTextAreaDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_jTextAreaDescripcionKeyReleased

    private void jTextFieldIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteActionPerformed
        this.buscarPacientePorCI();
    }//GEN-LAST:event_jTextFieldIdPacienteActionPerformed

    private void jButtonBuscarPorCI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCI1ActionPerformed
        /**
        * En el parámetro se está Enviando como argumento, el objeto de esta misma clase, que
        * al momento de abrirse el formulario de FormPaciente se va utilizar para dos cosas:
        * 1. Para centrar la ventana paciente de acuerto a esta ventana.
        * 2. Para verificar si que el FormPaciente se abrió desde este FormConsulta, para que desde allí, dependiendo,
        * se puede enviar datos del cliente hasta aquí: el CI y su nombre.
        */
        FormPaciente pac = new FormPaciente(this);
        pac.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarPorCI1ActionPerformed

    private void jTextFielBuscarPorCIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielBuscarPorCIKeyReleased
        this.buscarTratamiendoPorCIPaciente();
    }//GEN-LAST:event_jTextFielBuscarPorCIKeyReleased

    private void jButtonPagoTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagoTratamientoActionPerformed
        String id_tratamiento = jLabelSelectedID.getText();
        if( ! id_tratamiento.equals("0")){
            FormPagoTratamiento pago = new FormPagoTratamiento(FormTratamiento.this);
            FormPagoTratamiento.jLabelIdTratamiento.setText( id_tratamiento );
            
            FormPagoTratamiento.jLabelTratPaciente.setText( jTextFieldIdPaciente.getText() + " - " + jTextFieldNombrePaciente.getText() );
            FormPagoTratamiento.jLabelTratDuracionDias.setText( jSpinnerDuracionDias.getValue().toString() );
            FormPagoTratamiento.jTextAreaTratDescripcion.setText( jTextAreaDescripcion.getText() );
            
            float costoTotal = Float.parseFloat(jSpinnerPrecio.getValue().toString());
            float pagado = Float.parseFloat(jTextFieldPagado.getText());
            FormPagoTratamiento.jLabelTratCosto.setText( String.valueOf(costoTotal) );
            FormPagoTratamiento.jLabelTratPagado.setText( String.valueOf(pagado) );
            FormPagoTratamiento.jLabelTratRestante.setText( String.valueOf(costoTotal-pagado) );
            pago.setVisible(true);
        }else
            JOptionPane.showMessageDialog(null, "Seleccione un Tratamiento de la tabla!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonPagoTratamientoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonBuscarPorCI;
    private javax.swing.JButton jButtonBuscarPorCI1;
    private javax.swing.JButton jButtonHistorialClinico;
    private javax.swing.JButton jButtonPagoTratamiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelSelectedID;
    private javax.swing.JLabel jLabelll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinnerDuracionDias;
    public static javax.swing.JSpinner jSpinnerPrecio;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFielBuscarPorCI;
    public static javax.swing.JTextField jTextFieldIdPaciente;
    public static javax.swing.JTextField jTextFieldNombrePaciente;
    public static javax.swing.JTextField jTextFieldPagado;
    // End of variables declaration//GEN-END:variables

}
