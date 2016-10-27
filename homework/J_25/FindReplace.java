import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/13/16.
 */
public class FindReplace extends JPanel {
    private JTextField _needle;
    private JTextField _nail;
    private JButton _find;
    private JButton _replace;
    private JButton _replace_all;
    private JButton _cancel;
    private JCheckBox _match_case;

    public FindReplace() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;
        this.add(new JLabel("Find What: "), c);

        this._needle = new JTextField(12);
        c.gridx = 1;
        this.add(this._needle, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._find = new JButton();
        this._find.setText("Find");
        this.add(this._find, c);

        c.fill = GridBagConstraints.NONE;
        c.gridy = 1;
        c.gridx = 0;
        this.add(new JLabel("Replace With: "), c);

        this._nail = new JTextField(12);
        c.gridx = 1;
        this.add(this._nail, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._replace = new JButton();
        this._replace.setText("Replace");
        this.add(this._replace, c);

        c.gridy = 3;
        this._replace_all = new JButton();
        this._replace_all.setText("Replace All");
        this.add(this._replace_all, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;
        this._match_case = new JCheckBox();
        this._match_case.setText("Match Case");
        this.add(this._match_case, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._cancel = new JButton();
        this._cancel.setText("Cancel");
        this.add(this._cancel, c);

    }

    public JTextField getNeedle() {
        return _needle;
    }

    public void setNeedle(JTextField needle) {
        this._needle = needle;
    }

    public JTextField getNail() {
        return _nail;
    }

    public void setNail(JTextField nail) {
        this._nail = nail;
    }

    public JCheckBox getMatchCase() {
        return _match_case;
    }

    public void setMatchCase(JCheckBox matchCase) {
        this._match_case = matchCase;
    }
}
