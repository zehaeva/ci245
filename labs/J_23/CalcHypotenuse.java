import javax.swing.*;
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
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sideOne.getText().isEmpty() && !sideTwo.getText().isEmpty()) {
                    hypotenuse.setText("SOMETHING!");
                }
            }
        });

        setVisible(true);
    }
}
