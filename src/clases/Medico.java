package clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    
    public void insertarMedico(){
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
        
        String persona = "INSERT INTO persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion) VALUES ('"+ci+"', '"+nombre+"', '"+celular+ "', '"+email+"', '"+fecha_nac+"', '"+genero+"', '"+direccion+"', '"+ocupacion+"');";
        String medico = "INSERT INTO medico (ci, experiencia, trabajos_ant) VALUES ('"+ci+"', '"+experiencia1+"', '"+trabajos_ant1+"');\n";

        con.ejecutarComando( persona + medico );
    }
}




/** @author alfreding0 */