package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/** @author alfreding0 */
public class Consulta {
    private String id;
    private String razon_motivo;
    private String fecha;
    private String hora_ini;
    private String hora_fin;
    private String precio;
    private String id_paciente;
    private String id_medico;
    
    private final Conexion con = new Conexion();
    
    public Consulta(){}

    public Consulta(String razon_motivo, String hora_ini, String hora_fin, String precio, String id_paciente, String id_medico) {
        this.razon_motivo = razon_motivo;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
        this.precio = precio;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }
    
    public void mostrarDatosConsulta(JTable jtable, String fechaInicio, String fechaFin){
        try {
            String [] tituloEncabezado = {"PACIENTE", "RAZON O MOTIVO", "FECHA","INICIO","FIN","PRECIO Bs.", "MEDICO"};
            
            String consulta_1_paciente = "SELECT c.id, per.nombre as paciente, c.razon_motivo, c.fecha, c.hora_ini, c.hora_fin, c.precio\n" +
                                            "FROM consulta c, paciente p, persona per\n" +
                                            "WHERE c.id_paciente=p.ci AND per.ci=p.ci\n" +
                                            "AND c.fecha BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'\n" +
                                            "ORDER BY c.id;";

            String consulta_2_paciente = "SELECT c.id, per.nombre as medico\n" +
                                            "FROM consulta c, medico m, persona per\n" +
                                            "WHERE c.id_medico=m.ci AND per.ci=m.ci\n" +
                                            "AND c.fecha BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'\n" +
                                            "ORDER BY c.id;";
            
            ResultSet rs_1=con.ejecutarConsulta(consulta_1_paciente);
            ResultSet rs_2=con.ejecutarConsulta(consulta_2_paciente);
                      
            
        
            DefaultTableModel model = new DefaultTableModel(null, tituloEncabezado);
            
            ResultSetMetaData datos = rs_1.getMetaData();  
            int num_columnas = datos.getColumnCount();
            
            while(rs_1.next()){
                rs_2.next();
                
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=1; i<=num_columnas; i++){
                    if(i==num_columnas)
                        datosPorFila[i-1]=rs_2.getObject(2); //solo nombre del medico
                    else{
                        int columnIndex=i+1;
                        datosPorFila[i-1]=rs_1.getObject(columnIndex); //todas las columnas pero sin el nombre del medico
                    }
                }
                model.addRow(datosPorFila);
            }
            
            jtable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar consultas!\n"+ex.getMessage());
        }
    }
    
    public boolean registrarConsulta(){
        return con.ejecutarComando("INSERT INTO consulta (razon_motivo, hora_ini, hora_fin, precio, id_paciente, id_medico) "
                                        +"VALUES ('"+this.razon_motivo+"', '"+this.hora_ini+"', '"+this.hora_fin+"', '"+this.precio+"', '"+this.id_paciente+"', '"+this.id_medico+"');");
    }
}
