import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hcanaway on 12/6/2016.
 */
public class LoginForm extends JFrame {
    private JLabel _output;
    private JTextField _username;
    private JTextField _password;
    private User _current_user;

    public LoginForm() throws HeadlessException {
        this._current_user = null;
        JPanel p = new JPanel();
        this.add(p);

        p.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        Dimension d = new Dimension(100, 24);

        c.gridx = 0;
        c.gridy = 0;
        c.insets.right = 5;
        c.insets.top = 5;
        JLabel l = new JLabel("User Name:");
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setPreferredSize(d);
        p.add(l, c);

        c.gridx = 0;
        c.gridy = 1;
        l = new JLabel("Password:");
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setPreferredSize(d);
        p.add(l, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 10;
        this._output = new JLabel();
        this._output.setPreferredSize(new Dimension(400, 200));
        this._output.setVerticalAlignment(SwingConstants.TOP);
        p.add(this._output, c);
        c.gridheight = 1;

        c.gridx = 1;
        c.gridy = 0;
        this._username = new JTextField();
        this._username.setPreferredSize(d);
        p.add(this._username, c);

        c.gridx = 1;
        c.gridy = 1;
        this._password = new JTextField();
        this._password.setPreferredSize(d);
        p.add(this._password, c);


        d = new Dimension(100, 24);
        c.gridx = 1;
        c.gridy = 2;
        JButton b = new JButton("Login");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (! _username.getText().isEmpty() && ! _password.getText().isEmpty()) {
                    login();
                }
                else {
                    _output.setText("Not all fields are filled in!");
                }
            }
        });
        b.setPreferredSize(d);
        p.add(b, c);

        c.gridx = 1;
        c.gridy = 3;
        b = new JButton("Register");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (! _username.getText().isEmpty() && ! _password.getText().isEmpty()) {
                    UserFactory.registerUser(_username.getText(), _password.getText());
                    login();
                    if (_current_user == null) {
                        _output.setText("User Registration Failure!");
                    }
                    else {
                        _output.setText("User Registered");
                    }
                }
                else {
                    _output.setText("Not all fields are filled in!");
                }
            }
        });
        b.setPreferredSize(d);
        p.add(b, c);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(640, 480);
    }

    private void login() {
        this._current_user = UserFactory.logIn(this._username.getText(), this._password.getText());
        if (this._current_user == null) {
            this._output.setText("Login Failed, User Name/Password Incorrect");
        }
        else {
            this._output.setText("User logged in");
        }
    }
}
