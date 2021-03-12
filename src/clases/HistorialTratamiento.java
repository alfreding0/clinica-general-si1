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
import utils.ModeloMostrarDatos;

/** @author alfreding0 */
public class HistorialTratamiento {
    private String id;
    private String detalle;
    private String fecha_hora;
    private String id_tratamiento;
    
    private final Conexion con = new Conexion();
    
    public HistorialTratamiento(){}

    public HistorialTratamiento(String detalle, String id_tratamiento) {
        this.detalle = detalle;
        this.id_tratamiento = id_tratamiento;
    }

    public String getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public String getId_tratamiento() {
        return id_tratamiento;
    }

    public Conexion getCon() {
        return con;
    }
    
    
    
    public void mostrarDatosHistorial(JTable jtable, String id_tratamiento){
        try {
            String [] tituloEncabezado = {"ID", "DETALLE", "FECHA Y HORA"};
            String consulta = "SELECT id, detalle, fecha_hora FROM historial WHERE id_tratamiento='"+id_tratamiento+"' ORDER BY fecha_hora DESC;";
            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(tituloEncabezado, jtable, con, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Historial de tratamiento!\n"+ex.getMessage());
        }
    }
    
    public boolean registrarHistorialTratamiento(String id){
        String consulta = "SELECT id FROM historial WHERE id='"+id+"'";
        ResultSet rs = con.ejecutarConsulta(consulta);
        try {
            if(rs.next())
                return con.ejecutarComando("UPDATE historial SET detalle='"+this.detalle+"' WHERE id='"+id+"';");
            else
                return con.ejecutarComando("INSERT INTO historial (detalle, id_tratamiento) VALUES ('"+this.detalle+"','"+this.id_tratamiento+"');");
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void buscarParaEdicion(String id){
        try {            
            String consulta = "SELECT id, detalle \n" +
                                "FROM historial\n" +
                                "WHERE id='"+id+"';";
            ResultSet rs=con.ejecutarConsulta(consulta);
            if(rs.next()){
                    try{
                        this.id = rs.getString("id");
                        this.detalle = rs.getString("detalle");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                    }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
