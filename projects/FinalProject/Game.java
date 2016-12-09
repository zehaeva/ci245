import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame implements MouseListener, ActionListener {
    private Map _map;
    private boolean _isRunning;
    private Timer _timer;
    private JPanel _panel;
    private Player[] _players;
    private Dimension _grid_size;
    private GameLoop _gl;
    private String _action;

    /**
     * initalization of the main Game loop
     * @throws HeadlessException
     */
    public Game() throws HeadlessException {
        this._players = new Player[2];
        this._players[0] = new Player("Human", true, new Color(64,128,64));
        this._players[1] = new Player("Computer", false, Color.RED);

        this._grid_size = new Dimension(24, 24);

        UnitFactory.setGridSize(this._grid_size);

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
        int opponent;
        if (this._gl.currentPlayer() == 0) {
            opponent = 1;
        }
        else {
            opponent = 0;
        }

    //  find the unit that was clicked on!
        for (Unit x : this._players[this._gl.currentPlayer()].getUnits()) {
        //  if this unit was clicked on
            if (x.getShape().contains(e.getX(), e.getY())) {
            //  if he's not selected then we must have meant to select him!
                if (!x.isSelected()) {
                    x.select();
                    UnitMenu menu = new UnitMenu(this, x);
                    menu.setVisible(true);
                //  highlight where he can move too
                } else {
                //  I guess we're unselecting him,
                    x.unSelect();
                    this._map.deHighlightSpaces(x.getPossibleMoves());
                }
            }
        //  did we click on an area that we can move to?
            else if(x.isSelected() && x.isMoving()) {
                //  let's see if we're moving him to where we clicked
                for (GridSpace p : x.getPossibleMoves()) {
                    if (p.contains(e.getX(), e.getY())) {
                        this._players[this._gl.currentPlayer()].useAction();
                        x.unSelect();
                        x.setMoving(false);
                        this._map.deHighlightSpaces(x.getPossibleMoves());
                        x.setPosition(new Point(e.getX(), e.getY()));
                    }
                }
            }
        //  we didn't click on a valid move,  maybe we attacked?
            else if (x.isSelected()) {
                for (GridSpace space:
                        x.getPossibleAttacks()) {
                    for (Unit unit:
                            this._players[opponent].getUnits()) {
                        if (space.contains(unit.getPosition())) {
                        //  resolve that attack
                            this.resolveAttack(x, unit);
                            x.unSelect();
                            this._players[this._gl.currentPlayer()].useAction();
                            this._map.deHighlightSpaces(x.getPossibleAttacks());
                        }
                    }
                }
            }
        }
    }

    /**
     * resolves the attacks between two units
     * @param attacker
     * @param defender
     */
    private void resolveAttack(Unit attacker, Unit defender) {
        defender.takeDamage(defender.defend() - attacker.attack());
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void actionPerformed(Unit unit, String action) {
        switch(action) {
            case "move":
                unit.setMoving(true);
                this._map.highlightSpaces(unit.getPossibleMoves());
                break;
            case "attack":
                this._map.highlightSpaces(unit.getPossibleAttacks());
                break;
        }
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

        /**
         * runs the main gameUpdates, keeps track of who's turn it is
         */
        private void doGameUpdates() {
        //  are we a human?
            if (_players[this._current_player].isHuman()) {
                if(_players[this._current_player].executeCommands()) {
                    this._current_player = 1;
                    _players[this._current_player].newTurn();
                }
            }
        //  THE AI!
            else {
                Player me = _players[this._current_player];
                Unit u = me.getUnits().get(0);
                u.setPosition(new Point(u.getPosition().x, u.getPosition().y - u.getUnitSize()));
                me.useAction();
                u = me.getUnits().get(1);
                u.setPosition(new Point(u.getPosition().x, u.getPosition().y - u.getUnitSize()));
                me.useAction();
                u = me.getUnits().get(1);
                u.setPosition(new Point(u.getPosition().x, u.getPosition().y - u.getUnitSize()));
                me.useAction();
                this._current_player = 0;
                _players[this._current_player].newTurn();
            }
        }

        public int currentPlayer() {
            return this._current_player;
        }
    }
}
