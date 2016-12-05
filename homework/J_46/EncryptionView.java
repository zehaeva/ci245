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

        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        this.add(p);

        Dimension d = new Dimension(100, 24);

        JLabel l = new JLabel();
        l.setText("To Encrypt");
        l.setPreferredSize(d);
        p.add(l, "North");
        l.setText("Encrypted");
        p.add(l, BorderLayout.CENTER);
        l.setText("Decrypted");
        p.add(l, BorderLayout.EAST);

        this._encrypt = new JTextField();
        this._encrypt.setPreferredSize(d);
        p.add(this._encrypt, BorderLayout.WEST);

        this._decrypt = new JTextField();
        this._decrypt.setPreferredSize(d);
        p.add(this._decrypt, BorderLayout.EAST);

        this._encrypted = new JTextField();
        this._encrypted.setPreferredSize(d);
        p.add(this._encrypted, BorderLayout.CENTER);

        this._encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _encrypted.setText(_crypt_lib.encrypt(_encrypt.getText()).toString());
                _decrypt.setText(_crypt_lib.decrypt(_crypt_lib.encrypt(_encrypt.getText())));
            }
        });


        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
