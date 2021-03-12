package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/** @author alfreding0 */
public class Tratamiento {
    private String id;
    private String duracion_dias;
    private String descripcion;
    private String costo;
    private String id_paciente;
    private String id_medico;    
    
    
    private final Conexion con = new Conexion();
    
    public Tratamiento(){}

    public Tratamiento(String duracion_dias, String descripcion, String costo, String id_paciente, String id_medico) {
        this.duracion_dias = duracion_dias;
        this.descripcion = descripcion;
        this.costo = costo;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

    public String getId() {
        return id;
    }

    public String getDuracion_dias() {
        return duracion_dias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public String getId_medico() {
        return id_medico;
    }

    public Conexion getCon() {
        return con;
    }
    
    
    
    public void mostrarDatosTratamiento(JTable jtable){
        try {
            String [] tituloEncabezado = {"ID", "PACIENTE", "DURACION DIAS", "DESCRIPCION", "COSTO", "MEDICO"};
            
            String consulta = "SELECT t.id, per.nombre as paciente, t.duracion_dias, t.descripcion, t.costo, " +
                                "t.id_medico, (select min(nombre) from persona where ci=t.id_medico) as medico\n" +
                                "FROM tratamiento t, paciente p, persona per\n" +
                                "WHERE t.id_paciente=p.ci AND per.ci=p.ci\n" +
                                "ORDER BY t.id DESC\n" +
                                "LIMIT 8;";            
            ResultSet rs=con.ejecutarConsulta(consulta);
                                
            DefaultTableModel model = new DefaultTableModel(null, tituloEncabezado);
            
            ResultSetMetaData datos = rs.getMetaData();  
            int num_columnas = datos.getColumnCount()-1; //menos uno quitando el id_medico de la consulta que solo servia para la subconsulta
            
            while(rs.next()){
                
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=0; i<num_columnas; i++){
                    if(i<5){ //solo va llegar hasta la columna de costo, antes de id_medico
                        int columnIndex=i+1;
                        datosPorFila[i]=rs.getObject(columnIndex);
                    }else{
                        datosPorFila[i]=rs.getObject("medico"); //ignoramos id_medico y solo obtenemos el nombre de medico
                    }
                }
                model.addRow(datosPorFila);
            }
            
            jtable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar tratamientos!\n"+ex.getMessage());
        }
    }
    
    public boolean registrarTratamiento(String id){
        String consulta = "SELECT id FROM tratamiento WHERE id='"+id+"'; ";
        ResultSet rs = con.ejecutarConsulta(consulta);
        
        try {
            if(rs.next())
                return con.ejecutarComando("UPDATE tratamiento SET duracion_dias='"+this.duracion_dias+"', descripcion='"+this.descripcion+"', costo='"+this.costo+"', id_paciente='"+this.id_paciente+"'\n" +
                                            "WHERE id='"+id+"';");
            else
                return con.ejecutarComando("INSERT INTO tratamiento (duracion_dias, descripcion, costo, id_paciente, id_medico) \n" +
                                            "VALUES ('"+this.duracion_dias+"', '"+this.descripcion+"', '"+this.costo+"', '"+this.id_paciente+"', '"+this.id_medico+"');");
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean eliminarTratamiento(String id){
        return con.ejecutarComando("DELETE FROM tratamiento WHERE id='"+id+"';");
    }
    
    public void buscarParaEdicion(String id){
        try {            
            String consulta = "SELECT t.id, t.duracion_dias, t.descripcion, t.costo, pa.ci as id_paciente \n" +
                                "FROM  tratamiento t, paciente pa, persona per \n" +
                                "WHERE t.id_paciente=pa.ci AND pa.ci=per.ci \n" +
                                "AND t.id='"+id+"';";
            ResultSet rs=con.ejecutarConsulta(consulta);
            if(rs.next()){
                    try{
                        this.id = rs.getString("id");
                        this.duracion_dias = rs.getString("duracion_dias");
                        this.descripcion = rs.getString("descripcion");
                        this.costo = rs.getString("costo");
                        this.id_paciente = rs.getString("id_paciente");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                    }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void buscarTratamientosPorCIPaciente(JTable jtable, String ciPaciente){
        try {
            String [] tituloEncabezado = {"ID", "PACIENTE", "DURACION DIAS", "DESCRIPCION", "COSTO", "MEDICO"};
            
            String consulta = "SELECT t.id, per.nombre as paciente, t.duracion_dias, t.descripcion, t.costo, t.id_medico, (select min(nombre) from persona where ci=t.id_medico) as medico\n" +
                                "FROM tratamiento t, paciente p, persona per\n" +
                                "WHERE t.id_paciente=p.ci AND per.ci=p.ci AND p.ci='"+ciPaciente+"'\n" +
                                "ORDER BY t.id DESC\n" +
                                "LIMIT 8;";            
            ResultSet rs=con.ejecutarConsulta(consulta);
                                
            DefaultTableModel model = new DefaultTableModel(null, tituloEncabezado);
            
            ResultSetMetaData datos = rs.getMetaData();  
            int num_columnas = datos.getColumnCount()-1; //menos uno quitando el id_medico de la consulta que solo servia para la subconsulta
            
            while(rs.next()){
                
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=0; i<num_columnas; i++){
                    if(i<5){ //solo va llegar hasta la columna de costo, antes de id_medico
                        int columnIndex=i+1;
                        datosPorFila[i]=rs.getObject(columnIndex);
                    }else{
                        datosPorFila[i]=rs.getObject("medico"); //ignoramos id_medico y solo obtenemos el nombre de medico
                    }
                }
                model.addRow(datosPorFila);
            }
            
            jtable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar tratamientos!\n"+ex.getMessage());
        }
    }
}
