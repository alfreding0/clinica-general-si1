package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sql.Conexion;
import utils.ModeloMostrarDatos;

/** @author alfreding0 */
public class PagoTratamiento {
    private String id;
    private String monto;
    private String fecha_hora;
    private String id_tratamiento;
    private String saldo_restante;
    
    private final Conexion con = new Conexion();
    
    public PagoTratamiento(){}

    public PagoTratamiento(String monto, String saldo_restante, String id_tratamiento) {
        this.monto = monto;
        this.saldo_restante = saldo_restante;
        this.id_tratamiento = id_tratamiento;
    }

    public String getId() {
        return id;
    }

    public String getMonto() {
        return monto;
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

    public String getSaldo_restante() {
        return saldo_restante;
    }
    
    
    
    public void mostrarPagoTratamiento(JTable jtable, String id_tratamiento){
        try {
            String [] tituloEncabezado = {"ID", "FECHA Y HORA", "MONTO", "SALDO RESTANTE"};
            String consulta = "SELECT id, fecha_hora, monto, saldo_restante FROM pago_tratamiento WHERE id_tratamiento='"+id_tratamiento+"' ORDER BY fecha_hora DESC;";
            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(tituloEncabezado, jtable, con, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar pagos de tratamiento!\n"+ex.getMessage());
        }
    }
    
    public boolean registrarPagosTratamiento(){
        String instruct_1 = "INSERT INTO pago_tratamiento (monto, saldo_restante, id_tratamiento) VALUES ('"+this.monto+"', '"+this.saldo_restante+"', '"+this.id_tratamiento+"');";
        String instruct_2= "UPDATE tratamiento SET pagado = pagado + '"+this.monto+"';";
        return con.ejecutarComando(instruct_1 + instruct_2);
    }
    
    public void refrescarMontoYSaldo(){
        try {
            String consulta = "SELECT costo, pagado, (costo-pagado) as saldo_restante FROM tratamiento WHERE id='"+this.id_tratamiento+"'";
            ResultSet rs = con.ejecutarConsulta(consulta);
            rs.next();
            FormPagoTratamiento.jLabelTratCosto.setText( rs.getString("costo") );
            FormPagoTratamiento.jLabelTratPagado.setText( rs.getString("pagado") );
            FormPagoTratamiento.jLabelTratRestante.setText( rs.getString("saldo_restante") );
        } catch (SQLException ex) {
            System.out.println("Error al refrescar saldos en pagotratamiento!\n" + ex.getMessage());
        }
    }
}
