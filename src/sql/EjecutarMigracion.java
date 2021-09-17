package sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EjecutarMigracion {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        try {
            String consulta = "";
            
            String rutaProyecto = new File(".").getAbsolutePath();
            String dropTables = rutaProyecto.substring(0, rutaProyecto.length()-1).concat("src/sql/drop_tables.sql");
            String createTables = rutaProyecto.substring(0, rutaProyecto.length()-1).concat("src/sql/create_tables.sql");
            String triggers = rutaProyecto.substring(0, rutaProyecto.length()-1).concat("src/sql/triggers.sql");
            String insertData = rutaProyecto.substring(0, rutaProyecto.length()-1).concat("src/sql/insert_data.sql");

            //leyendo el codigo de drop_tables.sql
            Scanner input = new Scanner(new File(dropTables)); 
            while (input.hasNextLine()) {
                consulta = consulta + input.nextLine() + "\n";
            }
            
            //leyendo el codigo de create_tables.sql
            input = new Scanner(new File(createTables)); 
            while (input.hasNextLine()) {
                consulta = consulta + input.nextLine() + "\n";
            }
            
            //leyendo el codigo de triggers.sql
            input = new Scanner(new File(triggers)); 
            while (input.hasNextLine()) {
                consulta = consulta + input.nextLine() + "\n";
            }
            
            //leyendo el codigo de insert_data.sql
            input = new Scanner(new File(insertData)); 
            while (input.hasNextLine()) {
                consulta = consulta + input.nextLine() + "\n";
            }
            System.out.println(consulta);
            
            con.ejecutarComando(consulta);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ops! No se pudo ejecutar la migración!\n" + ex.getMessage());
        }
    }
}