package clases;
/** @author alfreding0 */
public class Paciente extends Persona{
    
    public Paciente(){ }

    public Paciente(String ci, String nombre, String celular, String email, String fecha_nac, String genero, String direccion, String ocupacion, String fecha_reg) {
        super(ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion, fecha_reg);
    }
}
/** @author alfreding0 */