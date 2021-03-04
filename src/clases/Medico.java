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
public class Medico extends Persona{
    private String experiencia;
    private String trabajos_ant;
    private final Conexion con = new Conexion();
    
    public Medico(){ }

    public Medico(String ci, String nombre, String celular, String email, String fecha_nac, String genero, String direccion, String ocupacion, String experiencia, String trabajos_ant) {
        super(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion);
        this.experiencia = experiencia;
        this.trabajos_ant = trabajos_ant;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getTrabajos_ant() {
        return trabajos_ant;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void setTrabajos_ant(String trabajos_ant) {
        this.trabajos_ant = trabajos_ant;
    }
    
    
    
    public boolean guardarMedico(){
        String ci = super.getCi();
        String nombre = super.getNombre();
        String celular = super.getCelular();
        String email = super.getEmail();
        String fecha_nac = super.getFecha_nac();
        String genero = super.getGenero();
        String direccion = super.getDireccion();
        String ocupacion = super.getOcupacion();
        String experiencia1 = this.getExperiencia();
        String trabajos_ant1 = this.getTrabajos_ant();
        
        ResultSet rs = con.ejecutarConsulta("SELECT ci FROM persona WHERE ci='" + ci + "';");
        try {
            String persona, medico;
            if(rs.next()){
                persona = "UPDATE persona SET nombre='"+nombre+"', celular='"+celular+"', email='"+email+"', fecha_nac='"+fecha_nac+"', genero='"+genero+"', direccion='"+direccion+"', ocupacion='"+ocupacion+"' WHERE ci = '"+ci+"';";
                medico = "UPDATE medico SET experiencia='"+experiencia1+"', trabajos_ant='"+trabajos_ant1+"' WHERE ci = '"+ci+"';";
                
            }else{
                persona = "INSERT INTO persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion) VALUES ('"+ci+"', '"+nombre+"', '"+celular+ "', '"+email+"', '"+fecha_nac+"', '"+genero+"', '"+direccion+"', '"+ocupacion+"');";
                medico = "INSERT INTO medico (ci, experiencia, trabajos_ant) VALUES ('"+ci+"', '"+experiencia1+"', '"+trabajos_ant1+"');\n";
            }
            return con.ejecutarComando( persona + medico );
                
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    public void mostrarDatosEnTabla(JTable mitabla, String ci){
        try {
            String [] tittle = {"CI", "NOMBRE COMPLETO", "CELULAR", "EMAIL", "DIRECCION"};
            DefaultTableModel model = new DefaultTableModel(null, tittle);
            
            String consulta = "SELECT p.ci, p.nombre, p.celular, p.email, p.direccion FROM  persona p, medico m WHERE p.ci=m.ci AND p.ci ILIKE '%"+ci+"%' ORDER BY p.fecha_reg DESC LIMIT 6;";
            ResultSet rs=con.ejecutarConsulta(consulta); 
            ResultSetMetaData datos=rs.getMetaData();  
            int num_columnas=datos.getColumnCount();
            while(rs.next()){
                Object datosPorFila []=new Object[num_columnas]; 
                for(int i=0; i<num_columnas; i++){
                    try{
                        int columnIndex=i+1;
                        datosPorFila[i]=rs.getObject(columnIndex);
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                    }
                }
                model.addRow(datosPorFila);
            }
            mitabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean eliminarMedico(String ci){
        String comando = "DELETE FROM persona WHERE ci = '"+ci+"';";
        return con.ejecutarComando(comando);
    }
    
    public void buscarParaEdicion(String ci){
        try {            
            String consulta = "SELECT p.*, m.experiencia, m.trabajos_ant FROM  persona p, medico m WHERE p.ci=m.ci AND p.ci='" +ci+ "';";
            ResultSet rs=con.ejecutarConsulta(consulta); 
            ResultSetMetaData datos=rs.getMetaData();  
            int num_columnas=datos.getColumnCount();
            if(rs.next()){
                String resultadoEncontrado []=new String[num_columnas]; 
                    try{
                        resultadoEncontrado[0]=rs.getString("ci");
                        resultadoEncontrado[1]=rs.getString("nombre");
                        resultadoEncontrado[2]=rs.getString("celular");
                        resultadoEncontrado[3]=rs.getString("email");
                        resultadoEncontrado[4]=rs.getString("fecha_nac");
                        resultadoEncontrado[5]=rs.getString("genero");
                        resultadoEncontrado[6]=rs.getString("direccion");
                        resultadoEncontrado[7]=rs.getString("ocupacion");
                        resultadoEncontrado[8]=rs.getString("experiencia");
                        resultadoEncontrado[9]=rs.getString("trabajos_ant");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                    }
                super.setCi( resultadoEncontrado[0] );
                super.setNombre(resultadoEncontrado[1] );
                super.setCelular(resultadoEncontrado[2] );
                super.setEmail(resultadoEncontrado[3] );
                super.setFecha_nac(resultadoEncontrado[4] );
                super.setGenero(resultadoEncontrado[5] );
                super.setDireccion(resultadoEncontrado[6] );
                super.setOcupacion(resultadoEncontrado[7] );
                this.setExperiencia(resultadoEncontrado[8] );
                this.setTrabajos_ant(resultadoEncontrado[9] );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




/** @author alfreding0 */