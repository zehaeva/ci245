import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 12/2/2016.
 */
public class EncryptionView extends JFrame {
    public EncryptionView() throws HeadlessException {

        this.setPreferredSize(new Dimension(500, 500));

        this.setLayout(new BorderLayout());

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
