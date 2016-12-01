import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame {
    private Map _map;
    private boolean _isRunning;
    private Timer _timer;
    private JPanel _panel;
    private Player[] _players;
    private Dimension _grid_size;

    public Game() throws HeadlessException {
        this._players = new Player[2];
        this._players[0] = new Player("Human", true, new Color(64,128,64));
        this._players[1] = new Player("Computer", false, Color.RED);

        this._grid_size = new Dimension(24, 24);

        this._map = new Map(480, 480, this._grid_size);

        this._players[0].generateUnits(2, 5, this._grid_size);
        this._players[1].generateUnits(18, 5, this._grid_size);

        for (Player p:
                this._players) {
            for (Unit u :
                    p.getUnits()) {
                this._map.getUnits().add(u);
            }
        }

        this._panel = new JPanel() {
            public void paintComponent(Graphics g) {
                _map.drawUnits(g);
            }
        };

        this._panel.setPreferredSize(new Dimension(this._map.getWidth(), this._map.getHeight()));

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
        private int _current_player = 0;

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
        //  are we a human?
            if (_players[this._current_player].isHuman()) {
                if(_players[this._current_player].executeCommands()) {
                    this._current_player++;
                }
            }
            else {

            }
        }
    }
}
