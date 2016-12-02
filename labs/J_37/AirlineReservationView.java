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
    private JButton _first_class;
    private JButton _economy;

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
        JScrollPane scrollPane = new JScrollPane(this._label, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this._window.add(scrollPane);
        this._label.setBounds(0 + i.left, 0 + i.top, 400, 480);
        scrollPane.setBounds(0 + i.left, 0 + i.top, 400, 400);

        this._economy = new JButton();
        this._economy.setText("Economy");
        this._economy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 _label.setText(_ara.getEconomy());
                 if(_ara.isEconomyFull()) {
                     _economy.setEnabled(false);
                 }
            }
        });
        this._economy.setBounds(400 + i.left, 30 + i.top, 150, 20);
        this._window.add(this._economy);

        this._first_class = new JButton();
        this._first_class.setText("First Class");
        this._first_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _label.setText(_ara.getFirstClass());
                if (_ara.isFirstClassFull()) {
                    _first_class.setEnabled(false);
                }
            }
        });
        this._first_class.setBounds(400 + i.left, 60 + i.top, 150, 20);
        this._window.add(this._first_class);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
    }
}
