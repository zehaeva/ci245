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
        this.setPreferredSize(new Dimension(500, 150));
        this.setTitle("Airline Reservation System");

        this._ara = new AirlineReservationAdapter();

        this._window = new JPanel();
        this._window.setLayout(null);
        this.add(this._window);
        this._window.setPreferredSize(new Dimension(640, 480));

        Insets i = this._window.getInsets();

        this._label = new JTextArea();
        this._window.add(this._label);
        this._label.setBounds(0 + i.left, 0 + i.top, 400, 480);


        JButton temp = new JButton();
        temp.setText("Economy");
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 _label.setText(_ara.getEconomy());
            }
        });
        temp.setBounds(400 + i.left, i.top, 150, 20);
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
        temp.setBounds(400 + i.left, 30 + i.top, 150, 20);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(640, 480);
    }
}
