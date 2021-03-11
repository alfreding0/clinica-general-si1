package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sql.Conexion;
import utils.ModeloMostrarDatos;

/** @author alfreding0 */
public class Paciente extends Persona{
    private final Conexion con = new Conexion();
    
    public Paciente(){ }

    public Paciente(String ci, String nombre, String celular, String email, String fecha_nac, String genero, String direccion, String ocupacion) {
        super(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion);
    }
    
    public boolean guardarPaciente(){
        String ci = super.getCi();
        String nombre = super.getNombre();
        String celular = super.getCelular();
        String email = super.getEmail();
        String fecha_nac = super.getFecha_nac();
        String genero = super.getGenero();
        String direccion = super.getDireccion();
        String ocupacion = super.getOcupacion();
        
        ResultSet rs = con.ejecutarConsulta("SELECT ci FROM persona WHERE ci='" + ci + "';");
        try {
            String persona, paciente;
            if(rs.next()){  //boolean
                persona = "UPDATE persona SET nombre='"+nombre+"', celular='"+celular+"', email='"+email+"', fecha_nac='"+fecha_nac+"', genero='"+genero+"', direccion='"+direccion+"', ocupacion='"+ocupacion+"' WHERE ci = '"+ci+"';";
                paciente = "--UPDATE paciente SET ci='"+ci+"' WHERE ci = '"+ci+"';"; //el carnet no debería cambiar jamás
                
            }else{
                persona = "INSERT INTO persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion) VALUES ('"+ci+"', '"+nombre+"', '"+celular+ "', '"+email+"', '"+fecha_nac+"', '"+genero+"', '"+direccion+"', '"+ocupacion+"');";
                paciente = "INSERT INTO paciente (ci) VALUES ('"+ci+"');\n";
            }
            return con.ejecutarComando(persona + paciente );
                
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    public void mostrarDatosEnTabla(JTable mitabla, String ci){
        try {
            String consulta = "SELECT p.ci, p.nombre, p.celular, p.email, p.direccion FROM  persona p, paciente pa WHERE p.ci=pa.ci AND p.ci ILIKE '%"+ci+"%' ORDER BY p.fecha_reg DESC LIMIT 8;";
            String[] tituloEncabezado = {"CI", "NOMBRE COMPLETO", "CELULAR", "EMAIL", "DIRECCION"};
            
            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(tituloEncabezado, mitabla, con, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al mostrar datos en la tabla!\n" + ex.getMessage(), "Tarea fallida!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean eliminarPaciente(String ci){
        String comando = "DELETE FROM persona WHERE ci = '"+ci+"';";
        return con.ejecutarComando(comando);
    }
    
    public void buscarParaEdicion(String ci){
        try {            
            String consulta = "SELECT p.* FROM  persona p, paciente pa WHERE p.ci=pa.ci AND p.ci='" +ci+ "';";
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
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void buscarPacientePorCI(JTextField jtextfield, String ci){
        try {
            String consulta = "SELECT nombre FROM persona WHERE ci='"+ci+"';";
            ResultSet rs = con.ejecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("nombre"));
            else
                JOptionPane.showMessageDialog(null, "No existe el paciente con CI: " + ci);
        } catch (SQLException ex) {
            System.out.println("Error al buscar paciente!\n" + ex.getMessage());
        }
    }
}
/** @author alfreding0 */