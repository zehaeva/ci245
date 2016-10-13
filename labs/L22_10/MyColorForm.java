import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/13/16.
 */
public class MyColorForm extends JFrame {
    private MyColorChooser _chooser;

    public MyColorForm() throws HeadlessException {
        this._chooser = new MyColorChooser();

        this.setSize(500, 100);

        this.setLayout(new GridBagLayout());

        add(this._chooser);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
