import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by zehaeva on 10/13/16.
 */
public class MyColorChooser extends JPanel {
    private ColorSlider _red;
    private ColorSlider _green;
    private ColorSlider _blue;

    private JLabel _label;

    private Color _mycolor;

    public MyColorChooser() {
        this._red = new ColorSlider();
        this._green = new ColorSlider();
        this._blue = new ColorSlider();

        this._red.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setLabelBackground();
            }
        });

        this._green.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setLabelBackground();
            }
        });

        this._blue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setLabelBackground();
            }
        });

        this._label = new JLabel();
        this._label.setBackground(Color.red);
        this._label.setMinimumSize(new Dimension(50, 50));
        this._label.setMaximumSize(new Dimension(100, 100));
        this._label.setPreferredSize(new Dimension(35, 35));

        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        this.add(this._red, c);
        c.gridx = 1;
        this.add(this._green, c);
        c.gridx = 2;
        this.add(this._blue, c);
        c.gridx = 3;
        this.add(this._label, c);
    }

    public Color getCcolor() {
        return _mycolor;
    }

    private void setLabelBackground() {
        _label.setBackground(new Color(this._red.getValue(),
                this._green.getValue(),
                this._blue.getValue()));
        this.setBackground(new Color(this._red.getValue(),
                this._green.getValue(),
                this._blue.getValue()));
    }

    public void setColor(Color color) {
        this._mycolor = color;
    }
}
