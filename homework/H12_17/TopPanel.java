import javax.swing.*;

/**
 * Created by zehaeva on 10/31/16.
 */
public class TopPanel extends JPanel {
    JButton _undo;
    JButton _clear_all_shapes;
    JComboBox _colors;
    JComboBox _shapes;
    JCheckBox _filled;

    public TopPanel() {
        this._undo = new JButton();
        this._clear_all_shapes  = new JButton();
        this._colors = new JComboBox();
        this._shapes = new JComboBox();
        this._filled = new JCheckBox();


    }
}
