package main;


import clases.FormPrincipal;
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
        
        FormPrincipal p = new FormPrincipal();
        p.setVisible(true);
    }
}
/** @author alfreding0 */