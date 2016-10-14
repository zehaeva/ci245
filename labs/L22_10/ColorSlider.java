import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by zehaeva on 10/13/16.
 */
public class ColorSlider extends JPanel {
    private JSlider _slider;
    private JTextField _text;

    public ColorSlider() {
        this.setLayout(new GridBagLayout());

        this._slider = new JSlider(0, 255);
        this._text = new JTextField();
        this._text.setText("128");
        this._text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                _slider.setValue(Integer.parseInt(_text.getText()));
                fireStateChanged();
            }
        });
        this._slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                _text.setText(String.valueOf(_slider.getValue()));
                fireStateChanged();
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(this._slider, c);
        c.gridy = 1;
        this.add(this._text, c);
    }

    public int getValue() {
        return this._slider.getValue();
    }

    public void addChangeListener(ChangeListener listener) {
        listenerList.add(ChangeListener.class, listener);
    }
    public void removeChangeListener(ChangeListener listener) {
        listenerList.remove(ChangeListener.class, listener);
    }
    protected void fireStateChanged() {
        ChangeListener[] listeners = listenerList.getListeners(ChangeListener.class);
        if (listeners != null && listeners.length > 0) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener: listeners) {
                listener.stateChanged(evt);
            }
        }
    }

}
