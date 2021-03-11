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
    
    public void mostrarDatosConsulta(JTable jtable){
        try {
            String [] titulos = {"CI", "NOMBRES","CELULAR","EMAIL","FECHA_NAC", "GENERO", "DIRECCION", "OCUPACIÓN", "FECHA_REG"};
            DefaultTableModel model = new DefaultTableModel(null, titulos);
            
            ResultSet rs=con.ejecutarConsulta("SELECT p.* FROM  persona p, paciente pac WHERE p.ci=pac.ci;");
            ResultSetMetaData datos = rs.getMetaData();
            
            int nc=datos.getColumnCount();
            
            while (rs.next()) {
                Object fila []= new Object [nc];
                for(int i=0;i<nc;i++){
                    fila[i]=rs.getObject(i+1);
                }
                model.addRow(fila);
            }
            jtable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar clientes!\n"+ex.getMessage());
        }
    }
    
    public boolean registrarConsulta(){
        return con.ejecutarComando("INSERT INTO consulta (razon_motivo, hora_ini, hora_fin, precio, id_paciente, id_medico) "
                                        +"VALUES ('"+this.razon_motivo+"', '"+this.hora_ini+"', '"+this.hora_fin+"', '"+this.precio+"', '"+this.id_paciente+"', '"+this.id_medico+"');");
    }
}
