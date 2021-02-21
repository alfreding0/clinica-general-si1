package clases;

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
        String str = "hola " + this.experiencia + " asdfasd" + "fasdf";
        
        String comando = "insert into persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion)\n" +
                            " values ('"+ super.getCi() +"', '" + super.getNombre() + "', '" + super.getCelular() + "',	'" + super.getEmail() + "', '" + super.getFecha_nac() + "', '" + super.getGenero() + "', '"+ super.getDireccion() +"', '" + super.getDireccion() + "');\n" +
                            " insert into medico (ci, experiencia, trabajos_ant) values ('" + super.getCi() + "', '"+ this.experiencia +"', '" + this.trabajos_ant + "');";
        
        con.ejecutarComando(comando);
    }
}




/** @author alfreding0 */