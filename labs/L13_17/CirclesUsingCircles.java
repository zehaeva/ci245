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
        this.setTitle("Circles Using Class");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
    }

    private class CirclesClass extends JPanel {
        private JTextField _radius;
        private JLabel _diameter;
        private JLabel _circumference;
        private JLabel _area;

        public CirclesClass() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.NORTHWEST;
            this.add(new JLabel("Radius: "), c);

            c.gridx = 1;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
            this._radius = new JTextField();
            this._radius.setText("10");
            this._radius.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (_radius.getText().matches("^[0-9]*$")) {
                        calcValues();
                    }
                    repaint();
                }
            });

            this.add(this._radius, c);

            c.gridx = 2;
            c.gridy = 1;
            c.gridwidth = 1;
            c.gridheight = 1;
            this._diameter = new JLabel();
            this.add(this._diameter, c);
            c.gridy = 2;
            this._circumference = new JLabel();
            this.add(this._circumference, c);
            c.gridy = 3;
            this._area = new JLabel();
            this.add(this._area, c);

            calcValues();
        }

        private void calcValues() {
            double r = Double.parseDouble(_radius.getText());
            _diameter.setText(String.valueOf(r * 2.0));
            _circumference.setText(String.valueOf(2.0 * Math.PI * r));
            _area.setText(String.valueOf(r * r * Math.PI));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (this._radius.getText().matches("^[0-9]*$")) {
                Integer r = 2 * Integer.parseInt(this._radius.getText());
                g.drawArc(10, 10, r, r, 0, 360);
            }
        }
    }
}
