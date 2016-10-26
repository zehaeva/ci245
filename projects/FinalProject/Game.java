import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame {
    private Map _map;
    private Unit[] _units;
    private boolean _isRunning;
    private java.util.Timer timer;

    public Game() throws HeadlessException {
        this._map = new Map(200, 200);

        this._units = new Unit[10];

        this._map.getUnits().add(new Unit(new Point(5, 5), 5));
        this._map.getUnits().add(new Unit(new Point(25, 25), 10));
        this._map.getUnits().add(new Unit(new Point(25, 0), 7));
        this._map.getUnits().add(new Unit(new Point(5, 25), 20));
        this._map.getUnits().add(new Unit(new Point(55, 55), 15));

        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                _map.drawUnits(g);
            }
        };

        this.setPreferredSize(new Dimension(this._map.getWidth(), this._map.getWidth()));

        this.add(p);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {

        timer = new Timer();
        timer.schedule(new GameLoop(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    private class GameLoop extends java.util.TimerTask
    {
        public void run() //this becomes the loop
        {
            doGameUpdates();
            render();

            if (!_isRunning)
            {
                timer.cancel();
            }
        }
    }
}
