/**
 * Created by zehaeva on 9/29/16.
 */
public class Bicycle implements CarbonFootprint {
    private int _gears;
    private String _wheel_type;
    private String _handle_bars;

    public Bicycle(int gears, String wheelType, String handleBars) {
        this._gears = gears;
        this._wheel_type = wheelType;
        this._handle_bars = handleBars;
    }

    public int getGears() {
        return _gears;
    }

    public void setGears(int gears) {
        this._gears = gears;
    }

    public String getWheelType() {
        return _wheel_type;
    }

    public void setWheelType(String wheelType) {
        this._wheel_type = wheelType;
    }

    public String getHandleBars() {
        return _handle_bars;
    }

    public void setHandleBars(String handleBars) {
        this._handle_bars = handleBars;
    }

    public int getCarbonFootprint() {
        return 0;
    }
}
