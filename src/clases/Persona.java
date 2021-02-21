package clases;
/** @author alfreding0 */
public class Persona {
    private String ci;
    private String nombre;
    private String celular;
    private String email;
    private String fecha_nac;
    private String genero;
    private String direccion;
    private String ocupacion;
    private String fecha_reg;
    
    public Persona(){ }

    public Persona(String ci, String nombre, String celular, String email, String fecha_nac, String genero, String direccion, String ocupacion, String fecha_reg) {
        this.ci = ci;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.genero = genero;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.fecha_reg = fecha_reg;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getGenero() {
        return genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }
    
    
}
/** @author alfreding0 */