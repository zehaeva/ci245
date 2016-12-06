import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by zehaeva on 12/2/2016.
 */
public class EncryptionView extends JFrame {
    private AESCrypt _crypt_lib;
    private JTextField _encrypt;
    private JTextField _encrypted;
    private JTextField _decrypt;

    public EncryptionView() throws HeadlessException {
        this._crypt_lib = new AESCrypt();

        this.setPreferredSize(new Dimension(500, 200));
        this.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        this.add(p);

        GridBagConstraints c = new GridBagConstraints();

        Dimension text_dimension = new Dimension(300, 24);

        JLabel l = new JLabel();
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setText("To Encrypt");
        c.gridx = 0;
        c.gridy = 0;
        p.add(l, c);

        l = new JLabel();
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setText("Encrypted");
        c.gridx = 0;
        c.gridy = 1;
        p.add(l, c);

        l = new JLabel();
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setText("Decrypted");
        c.gridx = 0;
        c.gridy = 2;
        p.add(l, c);

        this._encrypt = new JTextField();
        this._encrypt.setPreferredSize(text_dimension);
        c.gridx = 1;
        c.gridy = 0;
        p.add(this._encrypt, c);

        this._encrypted = new JTextField();
        this._encrypted.setPreferredSize(text_dimension);
        c.gridx = 1;
        c.gridy = 1;
        p.add(this._encrypted, c);

        this._decrypt = new JTextField();
        this._decrypt.setPreferredSize(text_dimension);
        c.gridx = 1;
        c.gridy = 2;
        p.add(this._decrypt, c);

        this._encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _encrypted.setText(_crypt_lib.encrypt(_encrypt.getText()).toString());
                _decrypt.setText(_crypt_lib.decrypt(_encrypted.getText()));
            }
        });

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
