import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hcanaway on 10/6/2016.
 */
public class CalcHypotenuse extends JFrame {
    private JTextField sideOne;
    private JPanel panel1;
    private JTextField sideTwo;
    private JButton calculateButton;
    private JTextField hypotenuse;

    public CalcHypotenuse() {
        super("Calc Hypotenuse");
        populatePanel();
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sideOne.getText().isEmpty() && !sideTwo.getText().isEmpty()) {
                    hypotenuse.setText(String.format("%f", Math.sqrt(Math.pow(Double.parseDouble(sideOne.getText()), 2.0) + Math.pow(Double.parseDouble(sideTwo.getText()), 2.0))));
                }
            }
        });

        setVisible(true);
    }

    private void populatePanel() {
        this.panel1 = new JPanel();
        this.panel1.setLayout(new GridLayout(4, 2));

        JLabel label = new JLabel();
        label.setText("Side One:");
        this.panel1.add(label);

        this.sideOne = new JTextField();
        this.panel1.add(this.sideOne);

        JLabel label1 = new JLabel();
        label1.setText("Side Two:");
        this.panel1.add(label1);

        this.sideTwo = new JTextField();
        this.panel1.add(this.sideTwo);

        this.panel1.add(new JLabel());

        this.calculateButton = new JButton();
        this.calculateButton.setText("Calculate");
        this.panel1.add(this.calculateButton);

        this.panel1.add(new JLabel());

        this.hypotenuse = new JTextField();
        this.panel1.add(this.hypotenuse);

        add(this.panel1);
    }
}
