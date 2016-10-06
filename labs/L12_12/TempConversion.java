import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by hcanaway on 10/6/2016.
 */
public class TempConversion extends JFrame{
    private double _celsius;
    private JPanel panel;
    private JTextField fahrenheit;
    private JTextField celsius;
    private JTextField kelvin;

    public TempConversion() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fahrenheit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Double.parseDouble(fahrenheit.getText()) != getFahrenheit()) {
                    int i = fahrenheit.getCaretPosition();
                    setFahrenheit(Double.parseDouble(fahrenheit.getText()));
                    setText();
                    fahrenheit.setCaretPosition(i);
                }
                super.keyReleased(e);
            }
        });

        celsius.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Double.parseDouble(celsius.getText()) != _celsius) {
                    int i = celsius.getCaretPosition();
                    setCelsius(Double.parseDouble(celsius.getText()));
                    setText();
                    celsius.setCaretPosition(i);
                }
                super.keyReleased(e);
            }
        });

        kelvin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Double.parseDouble(kelvin.getText()) != getKelvin()) {
                    int i = kelvin.getCaretPosition();
                    setKelvin(Double.parseDouble(kelvin.getText()));
                    setText();
                    kelvin.setCaretPosition(i);
                }
                super.keyReleased(e);
            }
        });


        setVisible(true);
    }

    public double getCelsius() {    return this._celsius;   }
    public void setCelsius(double value) {  this._celsius = value;  }
    public double getFahrenheit() { return 9.0 / 5.0 * this._celsius + 32; }
    public void setFahrenheit(double value) {   this._celsius = (value - 32) * 5.0/9.0; }
    public double getKelvin() { return this._celsius + 273.15;  }
    public void setKelvin(double value) { this._celsius = value - 273.15;   }

    public void setText() {
        fahrenheit.setText(String.format("%1f", this.getFahrenheit()));
        celsius.setText(String.format("%1f", this.getCelsius()));
        kelvin.setText(String.format("%1f", this.getKelvin()));
    }
}
