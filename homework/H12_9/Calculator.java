import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/8/2016.
 */
public class Calculator extends JFrame {
    private JTextField _output_text;
    private JPanel _output_panel;
    private JPanel _input_panel;
    
    protected JButton _one;
    protected JButton _two;
    protected JButton _three;
    protected JButton _four;
    protected JButton _five;
    protected JButton _six;
    protected JButton _seven;
    protected JButton _eight;
    protected JButton _nine;
    protected JButton _zero;
    protected JButton _dot;
    protected JButton _equals;
    protected JButton _divide;
    protected JButton _multiply;
    protected JButton _subtract;
    protected JButton _add;

    public Calculator() throws HeadlessException {
        this.setup();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setup() {
        this.setLayout(new GridBagLayout());

        //  set up the output text box
        this._output_panel = new JPanel();
        this._output_text = new JTextField();
        this._output_panel.add(this._output_text);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(this._output_text, c);

        //  setup the buttons!
        this._input_panel = new JPanel();
        this._input_panel.setLayout(new GridLayout(4, 4, 4, 4));


        this._one = new JButton();
        this._two = new JButton();
        this._three = new JButton();
        this._four = new JButton();
        this._five = new JButton();
        this._six = new JButton();
        this._seven = new JButton();
        this._eight = new JButton();
        this._nine = new JButton();
        this._zero = new JButton();
        this._dot = new JButton();
        this._equals = new JButton();
        this._divide = new JButton();
        this._multiply = new JButton();
        this._subtract = new JButton();
        this._add = new JButton();

        this._one.setText("1");
        this._two.setText("2");
        this._three.setText("3");
        this._four.setText("4");
        this._five.setText("5");
        this._six.setText("6");
        this._seven.setText("7");
        this._eight.setText("8");
        this._nine.setText("9");
        this._zero.setText("0");
        this._dot.setText(".");
        this._equals.setText("=");
        this._divide.setText("/");
        this._multiply.setText("*");
        this._subtract.setText("-");
        this._add.setText("+");

        //  row one
        this._input_panel.add(this._seven);
        this._input_panel.add(this._eight);
        this._input_panel.add(this._nine);
        this._input_panel.add(this._divide);
        //  row two
        this._input_panel.add(this._four);
        this._input_panel.add(this._five);
        this._input_panel.add(this._six);
        this._input_panel.add(this._multiply);
        //  row three
        this._input_panel.add(this._one);
        this._input_panel.add(this._two);
        this._input_panel.add(this._three);
        this._input_panel.add(this._subtract);
        //  row four
        this._input_panel.add(this._zero);
        this._input_panel.add(this._dot);
        this._input_panel.add(this._equals);
        this._input_panel.add(this._add);

        /*for (Component button :
                this._input_panel.getComponents()) {
            if (button instanceof JButton) {
                ((JButton) button).set(new Insets(10, 10, 10, 10));
            }
        }*/

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        this.add(this._input_panel, c2);
    }

    public String getOutputText() {
        return _output_text.getText();
    }

    public void setOutputText(String outputText) {
        this._output_text.setText(outputText);
    }
}
