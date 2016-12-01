import java.util.ArrayList;

/**
 * Created by zehaeva on 11/30/2016.
 */
public class Player {
    private ArrayList<Unit> _units;
    private String _name;

    public Player(String _name) {
        this._name = _name;
        this._units = new ArrayList<>();
    }

    public ArrayList<Unit> getUnits() {
        return _units;
    }

    public void generateUnits() {
        for (int i = 0; i < 5; i++) {
            this._units.add(new Unit(0, i, 10, 0, 0));
        }
    }
}
