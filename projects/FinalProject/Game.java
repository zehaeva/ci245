import javax.swing.*;
import java.awt.*;
import java.util.Timer;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame {
    private Map _map;
    private Unit[] _units;
    private boolean _isRunning;
    private Timer _timer;
    private JPanel _panel;

    public Game() throws HeadlessException {
        this._map = new Map(200, 200);

        this._units = new Unit[10];

        this._map.getUnits().add(new Unit(5, 5, 5));
        this._map.getUnits().add(new Unit(25, 25, 10));
        this._map.getUnits().add(new Unit(25, 0, 7, 5, 5));
        this._map.getUnits().add(new Unit(5, 25, 20));
        this._map.getUnits().add(new Unit(55, 55, 15));

        this._panel = new JPanel() {
            public void paintComponent(Graphics g) {
                _map.drawUnits(g);
            }
        };

        this.setPreferredSize(new Dimension(this._map.getWidth(), this._map.getWidth()));

        this.add(this._panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {

        _timer = new Timer();
        _timer.schedule(new GameLoop(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    private class GameLoop extends java.util.TimerTask
    {
        public void run() //this becomes the loop
        {
            doGameUpdates();
            render();

            if (!_isRunning) {
                _timer.cancel();
            }
        }

        private void render() {
            _panel.repaint();
        }

        private void doGameUpdates() {

        }
    }
}
