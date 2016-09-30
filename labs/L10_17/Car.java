/**
 * Created by zehaeva on 9/29/16.
 */
public class Car implements CarbonFootprint {
    private int _doors;
    private String _color;
    private boolean _deisel;

    public Car(int _doors, String _color, boolean _deisel) {
        this._doors = _doors;
        this._color = _color;
        this._deisel = _deisel;
    }

    public int get_doors() {
        return _doors;
    }

    public void set_doors(int _doors) {
        this._doors = _doors;
    }

    public String get_color() {
        return _color;
    }

    public void set_color(String _color) {
        this._color = _color;
    }

    public boolean is_deisel() {
        return _deisel;
    }

    public void set_deisel(boolean _deisel) {
        this._deisel = _deisel;
    }

    public int getCarbonFootprint() {
        if (this._deisel) {
            return 100;
        }
        else {
            return 75;
        }
    }
}
