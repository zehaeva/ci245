import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/13/16.
 */
public class FileBrowser extends JFrame {
    public FileBrowser() throws HeadlessException {

        this.setPreferredSize(new Dimension(500, 500));

        this.setLayout(new BorderLayout());

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
