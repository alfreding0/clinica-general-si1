package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import sql.Conexion;
import utils.ModeloMostrarDatos;

/** @author alfreding0 */
public class Usuario {
    private String id;
    private String username;
    private String password;
    private String creado_en;
    private String privilegio;
    private String id_medico;
    Conexion con = new Conexion();
    
    public Usuario(){}
    
    public Usuario(String username, String password, String privilegio, String id_medico){
        this.username = username;
        this.password = password;
        this.id_medico = id_medico;
        this.privilegio = privilegio;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public String getId_medico() {
        return id_medico;
    }

    public String getPrivilegio() {
        return privilegio;
    }
    

    public Conexion getCon() {
        return con;
    }
    
    public boolean esConexionNull(){
        return con.getConnection()==null;
    }
    
    public void desconectar(){
        con.desconectar();
    }
    
    
    public void mostrarUsuario(JTable jtable){
        try {
            String[] tituloEncabezado = {"ID", "USERNAME", "CREADO EN", "PRIVILEGIO", "MEDICO"};
            String consulta = "SELECT id, username, creado_en, privilegio, p.nombre\n" +
                                "FROM usuario u, persona p\n" +
                                "WHERE u.id_medico=p.ci;";
            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(tituloEncabezado, jtable, con, consulta);
        } catch (SQLException ex) {
            System.out.println("Error al mostrar datos de usuario!\n" + ex.getMessage());
        }
    }
    
    public boolean guardarUsuario(String id){
        try {
            String consulta = "SELECT id FROM usuario WHERE id='"+id+"'";
            ResultSet rs = con.ejecutarConsulta(consulta);
            
            String comando;
            if(rs.next())
                comando = "UPDATE usuario SET username='"+this.username+"', password=md5('"+this.password+"'), privilegio='"+this.privilegio+"' WHERE id='"+id+"';";
            else
                comando = "INSERT INTO usuario (username, password, privilegio, id_medico) " + 
                            "VALUES ('"+this.username+"', md5('"+this.password+"'), '"+this.privilegio+"','"+this.id_medico+"');";
            return con.ejecutarComando(comando);
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean eliminarUsuario(String id){
        return con.ejecutarComando("DELETE FROM usuario WHERE id='"+id+"'");
    }
    
    public void buscarParaEdicion(String id){        
        try {
            String consulta = "SELECT id, username, creado_en, privilegio, id_medico FROM  usuario WHERE id='" +id+ "';";
            ResultSet rs=con.ejecutarConsulta(consulta);
            rs.next();
            this.id=rs.getString("id");
            this.username=rs.getString("username");
            this.creado_en=rs.getString("creado_en");
            this.privilegio=rs.getString("privilegio");
            this.id_medico=rs.getString("id_medico");
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario para edición.\n"+ex.getMessage());
        }
    }
    
    public String[] validarIngresoAlSistema(String username, String pass){
        String[] respuesta = new String[3];
        try {
            String consulta = "SELECT ci, nombre, privilegio FROM usuario, persona \n" +
                    "WHERE usuario.id_medico=persona.ci \n" +
                    "AND username='"+username+"' AND password=md5('"+pass+"');";
            ResultSet rs = con.ejecutarConsulta(consulta);
            if(rs.next()){
                respuesta[0] = rs.getString("ci");
                respuesta[1] = rs.getString("nombre");
                respuesta[2] = rs.getString("privilegio");
                return respuesta;
            }else
                return null;
        } catch (SQLException ex) {
            System.out.println("Ha surgido un error inesperado, intente más tarde!\n"+ex.getMessage());
            return null;
        }
    }
    
    public String verificarUsuarioCambiarPassword(String usuario, String pass){
        String respuesta;
        try {
            String consulta = "SELECT id FROM usuario\n" +
                    "WHERE id_medico='"+usuario+"' AND password=md5('"+pass+"');"; //va a verificar solo por el CI medico que es fk. Si en caso tiene varias cuentas de usuario seguirá funcionando.
            ResultSet rs = con.ejecutarConsulta(consulta);
            if(rs.next()){
                respuesta = rs.getString("id");
                return respuesta;
            }else
                return null;
        } catch (SQLException ex) {
            System.out.println("Ha surgido un error inesperado, intente más tarde!\n"+ex.getMessage());
            return null;
        }
    }
    
    public boolean cambiarPasswordUsuario(String idUser, String newPassword){
        String comando = "UPDATE usuario SET password=md5('"+newPassword+"') WHERE id='"+idUser+"';";
        return con.ejecutarComando(comando);
    }
}
/** @author alfreding0 */