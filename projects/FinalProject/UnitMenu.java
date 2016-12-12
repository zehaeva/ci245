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

        this.setLayout(new GridLayout());

        this.setBounds(unit.getPixelPosition().x + unit.getUnitSize() + 3,
                unit.getPixelPosition().y + unit.getUnitSize() + 3,
                100, 100);

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton b = new JButton();
        b.setText("Move");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "move");
            }
        });
        b.setBounds(0,0,100, 24);
        this.add(b);

        b = new JButton();
        b.setText("Attack");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _parent.actionPerformed(_unit, "attack");
            }
        });
        b.setBounds(0,26,100, 24);
        this.add(b);
    }

    public Unit getUnit() {
        return this._unit;
    }
}
