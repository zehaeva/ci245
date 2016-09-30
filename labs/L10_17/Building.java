/**
 * Created by zehaeva on 9/29/16.
 */
public class Building implements CarbonFootprint {
    private int _num_floors;
    private String _address;
    private String _city;

    public Building(int _num_floors, String _address, String _city) {
        this._num_floors = _num_floors;
        this._address = _address;
        this._city = _city;
    }

    public int get_num_floors() {
        return _num_floors;
    }

    public void set_num_floors(int _num_floors) {
        this._num_floors = _num_floors;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public int getCarbonFootprint(){
        return this._num_floors * 50;
    }
}
