import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Created by zehaeva on 10/31/16.
 */
public class TopPanel extends JPanel {
    JButton _undo;
    JButton _clear_all_shapes;
    JComboBox _colors;
    JComboBox _shapes;
    JCheckBox _filled;
    DrawPanel _drawPanel;

    public TopPanel(DrawPanel drawPanel) {
        this._undo = new JButton();
        this._undo.setText("Undo");
        this._undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _drawPanel.clearLastShape();
            }
        });

        this._clear_all_shapes  = new JButton();
        this._clear_all_shapes.setText("Clear All");
        this._clear_all_shapes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _drawPanel.clearDrawing();
            }
        });

        this._colors = new JComboBox();
        this._colors.addItem("Black");
        this._colors.addItem("White");
        this._colors.addItem("Red");
        this._colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c;
                try {
                    int index = _colors.getSelectedIndex();
                    String name = _colors.getItemAt(index).toString();
                    Field f = Color.class.getField(name.toLowerCase());
                    c = (Color) f.get(null);

                } catch (Exception ex) {
                    c = Color.BLACK;
                }

                _drawPanel.setCurrentColor(c);
            }
        });

        this._shapes = new JComboBox();
        this._shapes.addItem("Line");
        this._shapes.addItem("Oval");
        this._shapes.addItem("Rectangle");
        this._shapes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _drawPanel.setShapeType(_shapes.getSelectedIndex());
            }
        });

        this._filled = new JCheckBox();
        this._filled.setText("Filled");
        this._filled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _drawPanel.setFilledShape(_filled.isSelected());
            }
        });

        this._drawPanel = drawPanel;

        this.add(this._undo);
        this.add(this._clear_all_shapes);
        this.add(this._colors);
        this.add(this._shapes);
        this.add(this._filled);
    }

    public void colorListener(ActionListener actionListener) {
        this._colors.addActionListener(actionListener);
    }

    public JComboBox getColors() {
        return this._colors;
    }
}
