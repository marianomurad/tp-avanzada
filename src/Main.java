import GUI.App.App;
import java.awt.*;


public class Main {

    /**
     * Launch the application.
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App window = new App();
                window.getFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
