import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 10/27/16.
 */
public class CirclesUsingCircles extends JFrame {
    public CirclesUsingCircles() {
        CirclesClass p = new CirclesClass();

        this.add(p);
        this.pack();
        this.setTitle("Drawing Cubes");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
    }

    private class CirclesClass extends JPanel {
        private JTextField _radius;
        public CirclesClass() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            this.add(new JLabel("Radius: "), c);

            c.gridy = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            this._radius = new JTextField();
            this._radius.setText("0");
            this._radius.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            this.add(this._radius);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (this._radius.getText().matches("^[0-9.]*$")) {
                Integer r = 2 * Integer.parseInt(this._radius.getText());
                g.drawArc(90, 90, r, r, 0, 360);
            }
        }
    }
}
