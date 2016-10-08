import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by zehaeva on 10/8/2016.
 */
public class GuessTheNumber extends JFrame {
    private JLabel _instructions;
    private JLabel _clue;
    private JTextField _my_guess;
    private JButton _new_guess;
    private int _guess;
    private int _last_guess = 1000;

    public GuessTheNumber() throws HeadlessException {
        this.setLayout(new GridBagLayout());


        GridBagConstraints c;

        this._instructions = new JLabel();
        this._instructions.setText("I have a number between 1 and 1000. Can you guess my number?\n" +
                "Please enter your guess");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        this.add(this._instructions, c);

        this._new_guess = new JButton();
        this._new_guess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewGuess();
                _my_guess.setText("");
                _my_guess.setEnabled(true);
                _my_guess.setBackground(Color.white);
                _my_guess.setForeground(Color.black);
                _clue.setText(" ");
            }
        });
        this._new_guess.setText("Give me a new number to guess");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        this.add(this._new_guess, c);

        this._clue = new JLabel();
        this._clue.setText(" ");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(this._clue, c);

        this._my_guess = new JTextField();
        this._my_guess.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int my_guess = Integer.parseInt(_my_guess.getText());
                int diff;
                if (my_guess != _guess) {
                    diff = my_guess - _guess;
                    if (Math.abs(diff) > _last_guess) {
                        _my_guess.setBackground(Color.cyan);
                    } else {
                        _my_guess.setBackground(Color.red);
                    }

                    _last_guess = Math.abs(diff);

                    if (diff > 0) {
                        _clue.setText("Too High!");
                    } else {
                        _clue.setText("Too Low!");
                    }
//                    setBackground();
                } else {
                    _clue.setText("Correct!");
                    _my_guess.setEnabled(false);
                    _my_guess.setBackground(new Color(0, 128, 0));
                    _my_guess.setForeground(Color.white);
                }
                super.keyReleased(e);
            }
        });
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(this._my_guess, c);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setNewGuess();
    }

    public void setNewGuess() {
        Random rand = new Random();

        this._guess = rand.nextInt(1000);
    }

}
