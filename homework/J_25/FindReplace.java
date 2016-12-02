import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 10/13/16.
 */
public class FindReplace extends JDialog implements ActionListener {
    private JTextField _needle;
    private JTextField _nail;
    private JButton _find;
    private JButton _replace;
    private JButton _replace_all;
    private JButton _cancel;
    private JCheckBox _match_case;
    private JPanel _panel;

    private NotePad _owner;

    public FindReplace(NotePad np) {
        this._owner = np;

        this._panel = new JPanel();
        this._panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;
        this._panel.add(new JLabel("Find What: "), c);

        this._needle = new JTextField(12);
        c.gridx = 1;
        this._panel.add(this._needle, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._find = new JButton();
        this._find.setText("Find");
        this._find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find();
            }
        });
        this._panel.add(this._find, c);

        c.fill = GridBagConstraints.NONE;
        c.gridy = 1;
        c.gridx = 0;
        this._panel.add(new JLabel("Replace With: "), c);

        this._nail = new JTextField(12);
        c.gridx = 1;
        this._panel.add(this._nail, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._replace = new JButton();
        this._replace.setText("Replace");
        this._replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replace();
            }
        });
        this._panel.add(this._replace, c);

        c.gridy = 3;
        this._replace_all = new JButton();
        this._replace_all.setText("Replace All");
        this._panel.add(this._replace_all, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;
        this._match_case = new JCheckBox();
        this._match_case.setText("Match Case");
        this._panel.add(this._match_case, c);

        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this._cancel = new JButton();
        this._cancel.setText("Cancel");
        this._cancel.addActionListener(this);
        this._panel.add(this._cancel, c);

        this.add(this._panel);

        this.pack();
        this.setLocationRelativeTo(np);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public void replace() {
        int index;

    //  if there is something selected
        if(_owner.getTextArea().getSelectedText() != null) {
        //  double check
            index  = this.searchIndex();
            if (index > -1) {
            //  then replace it!
                _owner.getTextArea().setText(_owner.getTextArea().getText().replaceFirst(
                        _owner.getTextArea().getSelectedText(), this._nail.getText()));

            }
        }

        this.find();
    }

    public void replace_all() {
        this._owner.getTextArea().setText(this._owner.getTextArea().getText().replaceAll(this.getNeedle(),
                this.getNail()));
    }

    public void find() {
        int index = searchIndex();
        if (index >= 0) {
            _owner.getTextArea().select(index, index + _needle.getText().length());
        }
    }

    private int searchIndex() {
        int searchIndex;
        //  find should match case!
        if (this._match_case.isSelected()) {
            searchIndex = _owner.getTextArea().getText().indexOf(_needle.getText());
        }
        else {
            //  or not
            searchIndex = _owner.getTextArea().getText().toLowerCase().indexOf(_needle.getText().toLowerCase());
        }

        return searchIndex;
    }


    public String getNeedle() { return _needle.getText(); }

    public void setNeedle(String needle) {
        this._needle.setText(needle);
    }

    public String getNail() {
        return _nail.getText();
    }

    public void setNail(String nail) {
        this._nail.setText(nail);
    }

    public JCheckBox getMatchCase() {
        return _match_case;
    }

    public void setMatchCase(JCheckBox matchCase) {
        this._match_case = matchCase;
    }
}
