import javax.swing.*;
import java.awt.*;

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
        this._undo.setText("Undo");
        this._clear_all_shapes  = new JButton();
        this._clear_all_shapes.setText("Clear All");
        this._colors = new JComboBox();
        this._colors.addItem("Black");
        this._colors.addItem("White");
        this._colors.addItem("Red");
        this._shapes = new JComboBox();
        this._shapes.addItem("Line");
        this._shapes.addItem("Oval");
        this._shapes.addItem("Rectangle");
        this._filled = new JCheckBox();
        this._filled.setText("Filled");

        this.add(this._undo);
        this.add(this._clear_all_shapes);
        this.add(this._colors);
        this.add(this._shapes);
        this.add(this._filled);
    }
}
