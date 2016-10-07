import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 10/6/2016.
 */
public class Demo extends JFrame{
    private JCheckBox snapToGridCheckBox;
    private JCheckBox showGridCheckBox;
    private JTextField textField1;
    private JTextField textField2;
    private JButton OKButton;
    private JButton cancelButton;
    private JButton helpButton;
    private JPanel panel1;

    public Demo() {
        populatePanel();
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void populatePanel() {
        this.panel1 = new JPanel();
        this.panel1.setLayout(new GridLayout(3, 4));

        this.snapToGridCheckBox = new JCheckBox();
        this.snapToGridCheckBox.setText("Snap to Grid");
        this.panel1.add(this.snapToGridCheckBox);

        JLabel label = new JLabel();
        label.setText("X:");
        this.panel1.add(label);

        this.textField1 = new JTextField();
        this.panel1.add(this.textField1);

        this.OKButton = new JButton();
        this.OKButton.setText("OK");
        this.panel1.add(this.OKButton);

        this.showGridCheckBox = new JCheckBox();
        this.showGridCheckBox.setText("Show Grid");
        this.panel1.add(this.showGridCheckBox);

        JLabel label1 = new JLabel();
        label1.setText("Y:");
        this.panel1.add(label1);

        this.textField1 = new JTextField();
        this.panel1.add(this.textField1);

        this.cancelButton = new JButton();
        this.cancelButton.setText("Cancel");
        this.panel1.add(this.cancelButton);

        this.panel1.add(new JLabel());
        this.panel1.add(new JLabel());
        this.panel1.add(new JLabel());

        this.helpButton = new JButton();
        this.helpButton.setText("Help");
        this.panel1.add(this.helpButton);

        add(this.panel1);

    }
}
