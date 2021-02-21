package clases;
/** @author alfreding0 */
public class Medico extends Persona{
    private String experiencia;
    private String trabajos_ant;
    
    public Medico(){ }

    public Medico(String ci, String nombre, String celular, String email, String fecha_nac, String genero, String direccion, String ocupacion, String fecha_reg, String experiencia, String trabajos_ant) {
        super(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion, fecha_reg);
        this.experiencia = experiencia;
        this.trabajos_ant = trabajos_ant;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getTrabajos_ant() {
        return trabajos_ant;
    }
}




/** @author alfreding0 */