import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame implements MouseListener {
    private Map _map;
    private boolean _isRunning;
    private Timer _timer;
    private JPanel _panel;
    private Player[] _players;
    private Dimension _grid_size;
    private GameLoop _gl;

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

        this._gl = new GameLoop();

        this._panel = new JPanel() {
            public void paintComponent(Graphics g) {
                _map.drawUnits(g);
            }
        };

        this._panel.addMouseListener(this);

        this._panel.setPreferredSize(new Dimension(this._map.getWidth(), this._map.getHeight()));

        this.add(this._panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        this._isRunning = true;
        this._timer = new Timer();
        this._timer.schedule(this._gl, 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // are we clicking on a unit?
        for (Unit x : this._players[this._gl.currentPlayer()].getUnits()) {
            if (x.getShape().contains(e.getX(), e.getY())) {
                if (!x.isSelected()) {
                    x.select();
                } else {
                    x.unSelect();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private class GameLoop extends java.util.TimerTask
    {
        private int _current_player = 0;

        public void run() //this becomes the loop
        {
            this.doGameUpdates();
            this.renderGame();

            if (!_isRunning) {
                _timer.cancel();
            }
        }

        private void renderGame() {
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

        public int currentPlayer() {
            return this._current_player;
        }
    }
}
