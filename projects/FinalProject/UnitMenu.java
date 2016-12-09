import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 12/8/16.
 */
public class UnitMenu extends JFrame {
    private Game _parent;
    private Unit _unit;

    public UnitMenu(Game parent, Unit unit) throws HeadlessException {
        this._parent = parent;
        this._unit = unit;

        JPanel p = new JPanel();

        JButton b = new JButton();
        b.setText("Move");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "move");
               dispose();
            }
        });
        p.add(b);

        b = new JButton();
        b.setText("Attack");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "attack");
                dispose();
            }
        });
        p.add(b);

        this.add(p);
        this.pack();
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
