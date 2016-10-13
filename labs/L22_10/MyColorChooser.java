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
    private JSlider _red;
    private JSlider _green;
    private JSlider _blue;
    private JTextField _red_display;
    private JTextField _green_display;
    private JTextField _blue_display;

    private JLabel _label;

    private Color _mycolor;

    public MyColorChooser() {
        this._red = new JSlider(0, 255);
        this._green = new JSlider(0, 255);
        this._blue = new JSlider(0, 255);

        this._red_display = new JTextField();
        this._red_display.setText("128");
        this._red_display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                _red.setValue(Integer.parseInt(_red_display.getText()));
            }
        });

        this._green_display = new JTextField();
        this._green_display.setText("128");
        this._green_display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                _green.setValue(Integer.parseInt(_green_display.getText()));
            }
        });
        this._blue_display = new JTextField();
        this._blue_display.setText("128");
        this._blue_display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                _blue.setValue(Integer.parseInt(_blue_display.getText()));
            }
        });

        this._red.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                _red_display.setText(String.valueOf(_red.getValue()));
                setLabelBackground();
            }
        });

        this._green.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                _green_display.setText(String.valueOf(_green.getValue()));
                setLabelBackground();
            }
        });

        this._blue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                _blue_display.setText(String.valueOf(_blue.getValue()));
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
        c.gridheight = 2;
        this.add(this._label, c);

        c.gridy = 1;
        c.gridx = 0;
        this.add(this._red_display, c);
        c.gridx = 1;
        this.add(this._green_display, c);
        c.gridx = 2;
        this.add(this._blue_display, c);
    }

    public Color getCcolor() {
        return _mycolor;
    }

    private void setLabelBackground() {
        _label.setBackground(new Color(Integer.parseInt(_red_display.getText()),
                Integer.parseInt(_green_display.getText()),
                Integer.parseInt(_blue_display.getText())));
        this.setBackground(new Color(Integer.parseInt(_red_display.getText()),
                Integer.parseInt(_green_display.getText()),
                Integer.parseInt(_blue_display.getText())));
    }

    public void setColor(Color color) {
        this._mycolor = color;
    }
/*
    public Dimension getPreferredSize() {
        return new Dimension(600, 200);
    }

    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }
    */
}
