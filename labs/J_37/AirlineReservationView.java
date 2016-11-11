import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationView extends JFrame {
    private JPanel _window;

    public AirlineReservationView() throws HeadlessException {
        this.setPreferredSize(new Dimension(500, 100));
        this.setTitle("Airline Reservation System");

        this._window = new JPanel();
        this.add(this._window);

        JButton temp = new JButton();
        temp.setText("Economy");
        this._window.add(temp);

        temp = new JButton();
        temp.setText("First Class");
        this._window.add(temp);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(500, 100);
    }
}
