package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import sql.Conexion;

/** @author alfreding0 */
public class HistorialClinico {
    private String id;
    private boolean epilepsia_convulciones;
    private String epilepsia_convulciones_tratamiento;
    private boolean anemia;
    private String anemia_tratamiento;
    private boolean diabetes;
    private String diabetes_tratamiento;
    private boolean hepatitis;
    private String hepatitis_tratamiento;
    private boolean hipertension_arterial;
    private String hipertension_arterial_tratamiento;
    private boolean asma;
    private String asma_tratamiento;
    private boolean tuberculosis;
    private String tuberculosis_tratamiento;
    private boolean vih_sida;
    private String vih_sida_tratamiento;
    private boolean gastritis;
    private String gastritis_tratamiento;
    private boolean cancer;
    private String cancer_tratamiento;
    private boolean menopausia;
    private String id_paciente;
    
    private final Conexion con = new Conexion();
    
    public HistorialClinico(){}

    public HistorialClinico(boolean epilepsia_convulciones, String epilepsia_convulciones_tratamiento, boolean anemia, String anemia_tratamiento, boolean diabetes, String diabetes_tratamiento, boolean hepatitis, String hepatitis_tratamiento, boolean hipertension_arterial, String hipertension_arterial_tratamiento, boolean asma, String asma_tratamiento, boolean tuberculosis, String tuberculosis_tratamiento, boolean vih_sida, String vih_sida_tratamiento, boolean gastritis, String gastritis_tratamiento, boolean cancer, String cancer_tratamiento, boolean menopausia, String id_paciente) {
        this.epilepsia_convulciones = epilepsia_convulciones;
        this.epilepsia_convulciones_tratamiento = epilepsia_convulciones_tratamiento;
        this.anemia = anemia;
        this.anemia_tratamiento = anemia_tratamiento;
        this.diabetes = diabetes;
        this.diabetes_tratamiento = diabetes_tratamiento;
        this.hepatitis = hepatitis;
        this.hepatitis_tratamiento = hepatitis_tratamiento;
        this.hipertension_arterial = hipertension_arterial;
        this.hipertension_arterial_tratamiento = hipertension_arterial_tratamiento;
        this.asma = asma;
        this.asma_tratamiento = asma_tratamiento;
        this.tuberculosis = tuberculosis;
        this.tuberculosis_tratamiento = tuberculosis_tratamiento;
        this.vih_sida = vih_sida;
        this.vih_sida_tratamiento = vih_sida_tratamiento;
        this.gastritis = gastritis;
        this.gastritis_tratamiento = gastritis_tratamiento;
        this.cancer = cancer;
        this.cancer_tratamiento = cancer_tratamiento;
        this.menopausia = menopausia;
        this.id_paciente = id_paciente;
    }
    
    public void mostrarDatosHistorialClinico(JCheckBox[] jcheckboxarray, JTextArea[] jtextarearray, String ci){
        try {
            ResultSet rs=con.ejecutarConsulta("SELECT * FROM historial_clinico WHERE id_paciente='"+ci+"';");
            ResultSetMetaData datos = rs.getMetaData();
            
            int nc=datos.getColumnCount();
            
            while (rs.next()) {
                for(int i=2; i < nc; i++){
                    String columna = datos.getColumnName(i);
                    switch (columna) {
                        case "epilepsia_convulciones":
                            jcheckboxarray[0].setSelected(rs.getBoolean(i));
                        case "epilepsia_convulciones_tratamiento":
                            jtextarearray[0].setText(rs.getString(i));
                            
                        case "anemia":
                            jcheckboxarray[1].setSelected(rs.getBoolean(i));
                        case "anemia_tratamiento":
                            jtextarearray[1].setText(rs.getString(i));
                            
                        case "diabetes":
                            jcheckboxarray[2].setSelected(rs.getBoolean(i));
                        case "diabetes_tratamiento":
                            jtextarearray[2].setText(rs.getString(i));
                            
                        case "hepatitis":
                            jcheckboxarray[3].setSelected(rs.getBoolean(i));
                        case "hepatitis_tratamiento":
                            jtextarearray[3].setText(rs.getString(i));
                            
                        case "hipertension_arterial":
                            jcheckboxarray[4].setSelected(rs.getBoolean(i));
                        case "hipertension_arterial_tratamiento":
                            jtextarearray[4].setText(rs.getString(i));
                            
                        case "asma":
                            jcheckboxarray[5].setSelected(rs.getBoolean(i));
                        case "asma_tratamiento":
                            jtextarearray[5].setText(rs.getString(i));
                            
                        case "tuberculosis":
                            jcheckboxarray[6].setSelected(rs.getBoolean(i));
                        case "tuberculosis_tratamiento":
                            jtextarearray[6].setText(rs.getString(i));
                            
                        case "vih_sida":
                            jcheckboxarray[7].setSelected(rs.getBoolean(i));
                        case "vih_sida_tratamiento":
                            jtextarearray[7].setText(rs.getString(i));
                            
                        case "gastritis":
                            jcheckboxarray[8].setSelected(rs.getBoolean(i));
                        case "gastritis_tratamiento":
                            jtextarearray[8].setText(rs.getString(i));
                            
                        case "cancer":
                            jcheckboxarray[9].setSelected(rs.getBoolean(i));
                        case "cancer_tratamiento":
                            jtextarearray[9].setText(rs.getString(i));
                            
                        case "menopausia":
                            jcheckboxarray[10].setSelected(rs.getBoolean(i));
                    }
//                    System.out.println(datos.getColumnName(i));
//                    System.out.println(i + ": " + rs.getObject(i) + "\n");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar historial clinico!\n"+ex.getMessage());
        }
    }
    
    public boolean actualizarHistorialClinico(){
        return con.ejecutarComando("UPDATE historial_clinico SET epilepsia_convulciones = "+this.epilepsia_convulciones+", \n" +
"							epilepsia_convulciones_tratamiento = '"+this.epilepsia_convulciones_tratamiento+"', \n" +
"							anemia = "+this.anemia+", \n" +
"							anemia_tratamiento = '"+this.anemia_tratamiento+"', \n" +
"							diabetes = "+this.diabetes+", \n" +
"							diabetes_tratamiento = '"+this.diabetes_tratamiento+"', \n" +
"							hepatitis = "+this.hepatitis+", \n" +
"							hepatitis_tratamiento = '"+this.hepatitis_tratamiento+"', \n" +
"							hipertension_arterial = "+this.hipertension_arterial+", \n" +
"							hipertension_arterial_tratamiento = '"+this.hipertension_arterial_tratamiento+"', \n" +
"							asma = "+this.asma+", \n" +
"							asma_tratamiento = '"+this.asma_tratamiento+"', \n" +
"							tuberculosis = "+this.tuberculosis+", \n" +
"							tuberculosis_tratamiento = '"+this.tuberculosis_tratamiento+"', \n" +
"							vih_sida = "+this.vih_sida+", \n" +
"							vih_sida_tratamiento = '"+this.vih_sida_tratamiento+"', \n" +
"							gastritis = "+this.gastritis+", \n" +
"							gastritis_tratamiento = '"+this.gastritis_tratamiento+"', \n" +
"							cancer = "+this.cancer+", \n" +
"							cancer_tratamiento = '"+this.cancer_tratamiento+"', \n" +
"							menopausia = "+this.menopausia+" \n" +
"							WHERE id_paciente = '"+this.id_paciente+"';");
    }
}
