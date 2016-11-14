import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationView extends JFrame {
    private JPanel _window;
    private JTextArea _label;
    private AirlineReservationAdapter _ara;

    public AirlineReservationView() throws HeadlessException {
        this.setPreferredSize(new Dimension(500, 100));
        this.setTitle("Airline Reservation System");

        this._ara = new AirlineReservationAdapter();

        this._window = new JPanel();
        this.add(this._window);

        this._label = new JTextArea();
        this._window.add(this._label);

        JButton temp = new JButton();
        temp.setText("Economy");
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 _label.setText(_ara.getEconomy());
            }
        });
        this._window.add(temp);

        temp = new JButton();
        temp.setText("First Class");
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _label.setText(_ara.getFirstClass());
            }
        });
        this._window.add(temp);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(500, 100);
    }
}
