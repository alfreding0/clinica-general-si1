package clases;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utils.HeaderTable;
import utils.PlaceHolder;

/**
 * @author alfreding0
 */
public class FormPaciente extends javax.swing.JFrame {
    private PlaceHolder placeholder;
    private final Class formularioEmisor;
    
    public FormPaciente(Component component) {
        initComponents();
        this.formularioEmisor = component.getClass();
        this.setLocationRelativeTo(component); //Mostrar esta ventana centrado al formulario principal
        this.mostrarDatos();
        this.repintarHeaderTabla();
        this.ponerPlaceHolders();      
        this.habilitarBotonEnviarDatos();
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
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);//CI
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);//nombre
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);//celular
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);//email
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);//direccion
    }
    

    //Funciones y procedimientos
    private void nuevo(){
        this.limpiarTodo();
        jTextFieldCI.requestFocus();
    }
    
    private void guardar() {
        if (this.validarCamposLlenos()){
            String ci = jTextFieldCI.getText();
            String nombre = jTextFieldNombreCompleto.getText();
            String celular = jTextFieldcelular.getText();
            String email = jTextFieldEmail.getText();
            String fecha_nac = (new SimpleDateFormat("yyyy-MM-dd")).format(jDateChooserFechaNac.getDate());
            String genero = jComboBoxGenero.getSelectedItem().toString().substring(0, 1);
            String direccion = jTextFielddireccion.getText();
            String ocupacion = jTextFielocupacion.getText();

            Paciente pac = new Paciente(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion);

            boolean registroSatisfactorio = pac.guardarPaciente();

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
        Paciente pac = new Paciente();
        pac.mostrarDatosEnTabla(jTable1, "");
        this.fijarAnchoColumnasTabla();
    }
    
    private void eliminar(){
        if(!jTextFieldCI.getText().isEmpty()){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
            if (res == JOptionPane.YES_OPTION) {
                Paciente pac = new Paciente();
                boolean estadoEjecucion = pac.eliminarPaciente(jTextFieldCI.getText());
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
        jTextFieldCI.setText("");
        jTextFieldNombreCompleto.setText("");
        jTextFieldcelular.setText("");
        jTextFieldEmail.setText("@gmail.com");
        jTextFielocupacion.setText("");
        jTextFielddireccion.setText("");
        jDateChooserFechaNac.setDate(new Date());
        jComboBoxGenero.setSelectedIndex(0);
        jTextFieldCI.setEditable(true);
        jTextFielBuscarPorCI.setText("");
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CI");
        model.addColumn("NOMBRE COMPLETO");
        model.addColumn("CELULAR");
        model.addColumn("EMAIL");
        model.addColumn("DIRECCION");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
    private boolean validarCamposLlenos(){
        if( !jTextFieldEmail.getText().isEmpty() )
            if( !this.esEmailValido() )
                JOptionPane.showMessageDialog(null, "Verifique que el correo sea válido!");
        
        return (!jTextFieldCI.getText().isEmpty() 
                && !jTextFieldNombreCompleto.getText().isEmpty()
                && !jTextFieldcelular.getText().isEmpty()
                && this.esEmailValido()
                && !jTextFielocupacion.getText().isEmpty()
                && !jTextFielddireccion.getText().isEmpty()
                && !this.esJDatechooserVacio()
                && jComboBoxGenero.getSelectedIndex() != 0);
    }
    
    private boolean esJDatechooserVacio(){
        
        try {
            jDateChooserFechaNac.getDate().toString();
            return false;
        }catch(Exception e){
            return true;
        }
    }
    
    private boolean esEmailValido(){
        short arroba = 0;
        short punto = 0;
        String val = jTextFieldEmail.getText();
        for (int i = 0; i < val.length(); i++) {
            if(val.charAt(i) == '@')
                arroba++;
            if(val.charAt(i) == '.')
                punto++;
        }
        return arroba==1 && punto>0;
    }
    
    private void enviarDatosPaciente(){
        if(!jTextFieldCI.getText().isEmpty()){
            if(formularioEmisor == FormConsulta.class){ //verifica si la instancia formularioEmisor es del mismo tipo que FormConsulta, para saber que se abrió esta ventana desde allí.
                FormConsulta.jTextFieldIdPaciente.setText(jTextFieldCI.getText());
                FormConsulta.jTextFieldNombrePaciente.setText(jTextFieldNombreCompleto.getText());
            }else if(formularioEmisor == FormTratamiento.class){ //verifica si la instancia formularioEmisor es del mismo tipo que FormTratamiento 
                FormTratamiento.jTextFieldIdPaciente.setText(jTextFieldCI.getText());
                FormTratamiento.jTextFieldNombrePaciente.setText(jTextFieldNombreCompleto.getText());
            }
            this.dispose();
        }else
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Paciente!!!");
    }
    
    /**
     * Si este formulario se abre desde FormConsulta ó FormTratamiento para registrar un nuevo paciente,
     * entonces se habilitará el botón enviar datos, de lo contrario significa que
     * ha sido abierto desde el FormPrincipal por lo que no se necesita enviar datos
     * a ningun formulario.
     */
    private void habilitarBotonEnviarDatos(){
        if((formularioEmisor == FormConsulta.class) || (formularioEmisor == FormTratamiento.class))
            jButtonEnviarDatos.setVisible(true);
        else
            jButtonEnviarDatos.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFielocupacion = new javax.swing.JTextField();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jTextFieldcelular = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFielddireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooserFechaNac = new com.toedter.calendar.JDateChooser();
        jTextFielBuscarPorCI = new javax.swing.JTextField();
        jButtonBuscarPorCI = new javax.swing.JButton();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButtonEnviarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 50, 47));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 122, 163)));
        jPanel1.setLayout(null);

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
        jPanel1.add(jButton1);
        jButton1.setBounds(130, 320, 120, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 150, 203));
        jLabel1.setText("CI:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 110, 160, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(21, 150, 203));
        jLabel2.setText("NOMBRE COMPLETO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(500, 110, 160, 28);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 150, 203));
        jLabel5.setText("CELULAR:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 140, 160, 28);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(21, 150, 203));
        jLabel6.setText("EMAIL:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(500, 140, 160, 28);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(21, 150, 203));
        jLabel7.setText("GENERO:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(500, 170, 160, 28);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(21, 150, 203));
        jLabel8.setText("FECHA NACIMIENTO:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 170, 160, 28);

        jTextFielocupacion.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielocupacion.setForeground(new java.awt.Color(21, 150, 203));
        jTextFielocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielocupacion.setBorder(null);
        jTextFielocupacion.setName(""); // NOI18N
        jTextFielocupacion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielocupacion.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFielocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielocupacionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielocupacionKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFielocupacion);
        jTextFielocupacion.setBounds(220, 200, 260, 30);

        jTextFieldCI.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldCI.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTextFieldCI.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 150, 203)));
        jTextFieldCI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCI.setName(""); // NOI18N
        jTextFieldCI.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldCI.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFieldCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCIKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldCI);
        jTextFieldCI.setBounds(220, 110, 260, 30);

        jTextFieldNombreCompleto.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldNombreCompleto.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldNombreCompleto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombreCompleto.setBorder(null);
        jTextFieldNombreCompleto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldNombreCompleto.setName(""); // NOI18N
        jTextFieldNombreCompleto.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldNombreCompleto.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFieldNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreCompletoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNombreCompletoKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldNombreCompleto);
        jTextFieldNombreCompleto.setBounds(660, 110, 260, 30);

        jTextFieldcelular.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldcelular.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldcelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldcelular.setBorder(null);
        jTextFieldcelular.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldcelular.setName(""); // NOI18N
        jTextFieldcelular.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldcelular.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFieldcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldcelularKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldcelular);
        jTextFieldcelular.setBounds(220, 140, 260, 30);

        jTextFieldEmail.setBackground(new java.awt.Color(63, 63, 63));
        jTextFieldEmail.setForeground(new java.awt.Color(21, 150, 203));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmail.setText("@gmail.com");
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldEmail.setName(""); // NOI18N
        jTextFieldEmail.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldEmail.setSelectionColor(new java.awt.Color(21, 150, 203));
        jPanel1.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(660, 140, 260, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(21, 150, 203));
        jLabel9.setText("OCUPACION:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 200, 160, 28);

        jTextFielddireccion.setBackground(new java.awt.Color(63, 63, 63));
        jTextFielddireccion.setForeground(new java.awt.Color(21, 150, 203));
        jTextFielddireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielddireccion.setBorder(null);
        jTextFielddireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFielddireccion.setName(""); // NOI18N
        jTextFielddireccion.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextFielddireccion.setSelectionColor(new java.awt.Color(21, 150, 203));
        jTextFielddireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielddireccionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielddireccionKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFielddireccion);
        jTextFielddireccion.setBounds(660, 200, 260, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(21, 150, 203));
        jLabel11.setText("DIRECCION:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(500, 200, 160, 28);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 150, 203));
        jLabel4.setText("PACIENTES");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 30, 360, 30);

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
        jPanel1.add(jButton2);
        jButton2.setBounds(800, 580, 120, 30);

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
        jPanel1.add(jButton4);
        jButton4.setBounds(430, 320, 120, 30);

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
        jPanel1.add(jButton5);
        jButton5.setBounds(240, 320, 114, 30);

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
        jPanel1.add(jButton6);
        jButton6.setBounds(340, 320, 110, 30);

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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 390, 860, 190);

        jDateChooserFechaNac.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.add(jDateChooserFechaNac);
        jDateChooserFechaNac.setBounds(220, 170, 260, 30);

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
        jPanel1.add(jTextFielBuscarPorCI);
        jTextFielBuscarPorCI.setBounds(60, 360, 170, 30);

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
        jPanel1.add(jButtonBuscarPorCI);
        jButtonBuscarPorCI.setBounds(230, 360, 40, 30);

        jComboBoxGenero.setBackground(new java.awt.Color(63, 63, 63));
        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Masculino", "Femenino" }));
        jComboBoxGenero.setToolTipText("");
        jPanel1.add(jComboBoxGenero);
        jComboBoxGenero.setBounds(660, 170, 260, 30);

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
        jPanel1.add(jButton3);
        jButton3.setBounds(40, 320, 102, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(60, 350, 470, 10);

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(21, 150, 203));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/historial-clinico-32.png"))); // NOI18N
        jButton7.setText("Ver historial clínico");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(730, 320, 220, 30);

        jButtonEnviarDatos.setBackground(new java.awt.Color(255, 102, 102));
        jButtonEnviarDatos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonEnviarDatos.setForeground(new java.awt.Color(21, 150, 203));
        jButtonEnviarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/enviar-25.png"))); // NOI18N
        jButtonEnviarDatos.setText("Enviar datos");
        jButtonEnviarDatos.setBorderPainted(false);
        jButtonEnviarDatos.setContentAreaFilled(false);
        jButtonEnviarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviarDatos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonEnviarDatos.setIconTextGap(2);
        jButtonEnviarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEnviarDatos);
        jButtonEnviarDatos.setBounds(780, 290, 160, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //System.exit(0); //cerrar todo el programa
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

    private void jTextFieldNombreCompletoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompletoKeyReleased
        jTextFieldNombreCompleto.setText(jTextFieldNombreCompleto.getText().toUpperCase());
    }//GEN-LAST:event_jTextFieldNombreCompletoKeyReleased

    private void jButtonBuscarPorCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorCIActionPerformed
        this.buscarPorCI();
    }//GEN-LAST:event_jButtonBuscarPorCIActionPerformed

    private void jTextFielBuscarPorCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielBuscarPorCIKeyTyped
        this.buscarPorCI();
    }//GEN-LAST:event_jTextFielBuscarPorCIKeyTyped

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if( jTable1.getSelectedRowCount()>0 ){
            String ci = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            Paciente pac = new Paciente();
            pac.buscarParaEdicion(ci);
            
            jTextFieldCI.setText( pac.getCi() );
            jTextFieldNombreCompleto.setText(pac.getNombre());
            jTextFieldcelular.setText(pac.getCelular());
            jTextFieldEmail.setText(pac.getEmail());
            jTextFielocupacion.setText(pac.getOcupacion());
            jTextFielddireccion.setText(pac.getDireccion());
            jDateChooserFechaNac.setDate(new Date(pac.getFecha_nac().replace('-', '/')));
            if(pac.getGenero().equals("M")) jComboBoxGenero.setSelectedIndex(1); else jComboBoxGenero.setSelectedIndex(2);
            
            jTextFieldCI.setEditable(false);
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTextFielocupacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielocupacionKeyReleased
        jTextFielocupacion.setText(jTextFielocupacion.getText().toUpperCase());
    }//GEN-LAST:event_jTextFielocupacionKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.nuevo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFielddireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyReleased
        jTextFielddireccion.setText(jTextFielddireccion.getText().toUpperCase());
    }//GEN-LAST:event_jTextFielddireccionKeyReleased

    private void jTextFieldNombreCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompletoKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' && c!='ñ' && c!='Ñ'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNombreCompletoKeyTyped

    private void jTextFieldcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcelularKeyTyped
        char n=evt.getKeyChar();
        if(n<'0' || n>'9'|| jTextFieldcelular.getText().length()>8)
            evt.consume();
    }//GEN-LAST:event_jTextFieldcelularKeyTyped

    private void jTextFielddireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' && c!='#' && c!='_' && c!='-' && c!='.' && (c<'0' || c>'9') && c!='ñ' && c!='Ñ'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFielddireccionKeyTyped

    private void jTextFieldCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCIKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCIKeyTyped

    private void jTextFielocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielocupacionKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' && c!='#' && c!='_' && c!='-' && (c<'0' || c>'9')  && c!='ñ' && c!='Ñ'){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFielocupacionKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String ci = jTextFieldCI.getText();
        if( ! ci.isEmpty() ){
            FormHistorialClinico form = new FormHistorialClinico( ci, FormPaciente.this );
            FormHistorialClinico.jLabelIDpaciente.setText( ci );
            FormHistorialClinico.jLabelNombrepaciente.setText( jTextFieldNombreCompleto.getText() );
            form.setVisible(true);
        }else
            JOptionPane.showMessageDialog(null, "Seleccione un paciente!!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonEnviarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarDatosActionPerformed
        this.enviarDatosPaciente();
    }//GEN-LAST:event_jButtonEnviarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonBuscarPorCI;
    private javax.swing.JButton jButtonEnviarDatos;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFielBuscarPorCI;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldcelular;
    private javax.swing.JTextField jTextFielddireccion;
    private javax.swing.JTextField jTextFielocupacion;
    // End of variables declaration//GEN-END:variables
/**
     * @author alfreding0
     */
}
