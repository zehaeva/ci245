import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by zehaeva on 10/29/16.
 */
public class PieChartFrame extends JFrame {
    private JTextField _number_one;
    private JTextField _number_two;
    private JTextField _number_three;
    private JTextField _number_four;
    private PieChart _panel;

    public PieChartFrame() throws HeadlessException {
        this.setTitle("Pie Chart");

        this.setLayout(null);

        this._number_one = new JTextField();
        this._number_two = new JTextField();
        this._number_three = new JTextField();
        this._number_four = new JTextField();
        this.add(this._number_one);
        this.add(this._number_two);
        this.add(this._number_three);
        this.add(this._number_four);

        Dimension size = new Dimension(100, 24);
        this._number_one.setPreferredSize(size);
        this._number_two.setPreferredSize(size);
        this._number_three.setPreferredSize(size);
        this._number_four.setPreferredSize(size);

        this._number_one.setText("0");
        this._number_two.setText("0");
        this._number_three.setText("0");
        this._number_four.setText("0");

        ActionListener rp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };

        this._number_one.addActionListener(rp);
        this._number_two.addActionListener(rp);
        this._number_three.addActionListener(rp);
        this._number_four.addActionListener(rp);

        Insets insets = this.getInsets();
        size = this._number_one.getPreferredSize();
        Dimension last = size;
        this._number_one.setBounds(0 + insets.left, 0 + insets.top, size.width, size.height);

        size = this._number_two.getPreferredSize();
        this._number_two.setBounds(0 + insets.left, insets.top + last.height, size.width, size.height);
        last = size;

        size = this._number_three.getPreferredSize();
        this._number_three.setBounds(0 + insets.left, insets.top + last.height * 2, size.width, size.height);
        last = size;

        size = this._number_four.getPreferredSize();
        this._number_four.setBounds(0 + insets.left, insets.top + last.height * 3, size.width, size.height);

        this._panel = new PieChart();
        this._panel.setPreferredSize(new Dimension(400, 400));
        this._panel.setBounds(0 + insets.left, 0 + insets.top, 400, 400);
        this.add(this._panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
    }

    private class PieChart extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            Double one = Double.parseDouble(_number_one.getText());
            Double two = Double.parseDouble(_number_two.getText());
            Double three = Double.parseDouble(_number_three.getText());
            Double four = Double.parseDouble(_number_four.getText());

            if ((one + two + three + four) > 0.0 ) {
                Double total = one + two + three + four;
                Double one_r = one * 360.0 / total;
                Double two_r = two * 360.0 / total;
                Double three_r = three * 360.0 / total;
                Double four_r = four * 360.0 / total;
                int start = 0;
                g2d.setColor(Color.green);
                g2d.fill(new Arc2D.Double(110, 10, 150, 150, start, one_r.intValue(), Arc2D.PIE));
                g2d.setColor(Color.blue);
                start += one_r.intValue();
                g2d.fill(new Arc2D.Double(110, 10, 150, 150, start, two_r.intValue(), Arc2D.PIE));
                start += two_r.intValue();
                g2d.setColor(Color.magenta);
                g2d.fill(new Arc2D.Double(110, 10, 150, 150, start, three_r.intValue(), Arc2D.PIE));
                start += three_r.intValue();
                g2d.setColor(Color.red);
                g2d.fill(new Arc2D.Double(110, 10, 150, 150, start, four_r.intValue(), Arc2D.PIE));
            }
        }
    }
}
