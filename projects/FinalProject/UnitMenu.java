import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 12/8/16.
 */
public class UnitMenu extends JPanel {
    private Game _parent;
    private Unit _unit;

    public UnitMenu(Game parent, Unit unit) throws HeadlessException {
        this._parent = parent;
        this._unit = unit;

        this.setLayout(null);

        this.setBounds(unit.getPixelPosition().x + unit.getUnitSize() * 2,
                unit.getPixelPosition().y + 3,
                100, 100);

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        Rectangle bound = new Rectangle(3, 0, 94, 24);

        JLabel l = new JLabel("HP: " + this._unit.getHitPoints());
        l.setBounds(bound);
        this.add(l);

        JButton b = new JButton();
        b.setText("Move");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "move");
            }
        });
        bound.setLocation(3, 26);
        b.setBounds(bound);
        this.add(b);

        b = new JButton();
        b.setText("Attack");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "attack");
            }
        });
        bound.setLocation(3, 52);
        b.setBounds(bound);
        this.add(b);
    }

    public Unit getUnit() {
        return this._unit;
    }
}
