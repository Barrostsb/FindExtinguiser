import GUI.frmLogin;

/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class FindExt  {
    public static void main(String args[]) {
        try {
        	// Quaqua Look and Feel
        	javax.swing.UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        	
        	// Liquid Look and Feel
        	com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true, "panther");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
            	new frmLogin().setVisible(true);
            }
        });
    }
}