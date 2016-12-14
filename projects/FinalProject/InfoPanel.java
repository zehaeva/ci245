import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 12/14/2016.
 */
public class InfoPanel extends JPanel {
    private JLabel _label;

    public InfoPanel(Point location, Dimension dimension) {
        this._label = new JLabel("Status: ");
        this._label.setPreferredSize(dimension);
        this._label.setVerticalTextPosition(SwingConstants.CENTER);
        this._label.setVerticalAlignment(SwingConstants.CENTER);

        this.setBounds(location.x, location.y, dimension.width, dimension.height);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(this._label);
    }

    public void setText(String text) {
        this._label.setText(text);
    }
}
