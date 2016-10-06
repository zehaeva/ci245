import javax.swing.*;

/**
 * Created by hcanaway on 10/6/2016.
 */
public class Demo extends JFrame{
    private JCheckBox snapToGridCheckBox;
    private JTextField textField1;
    private JTextField textField2;
    private JButton OKButton;
    private JButton cancelButton;
    private JButton helpButton;
    private JPanel panel1;

    public Demo() {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
