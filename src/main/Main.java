package main;


import clases.Principal;
import clases.FormMedico;
import clases.Principal2;
import clases.ProbandoInterfazPrincipal;
import java.sql.SQLException;

/** @author alfreding0 */
public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
        
//        Principal2 p = new Principal2();
//        p.setVisible(true);
        
        ProbandoInterfazPrincipal p = new ProbandoInterfazPrincipal();
        p.setVisible(true);
    }
}
/** @author alfreding0 */