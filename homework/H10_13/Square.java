/**
 * Created by zehaeva on 10/5/16.
 */
public class Square implements TwoDimensionalShape {
    private double _length;
    private double _width;

    public Square(double length, double width) {
        this._length = length;
        this._width = width;
    }

    public double getWidth(){
        return this._width;
    }
    public void setWidth(double width) {
        this._width = width;
    }

    public double getLength(){
        return this._length;
    }
    public void setLength(double length) {
        this._length = length;
    }

    public double getArea() {
        return this._length * this._width;
    }

    @Override
    public String toString() {
        return String.format("Square{Length=%f, Width=%f}", this._length, this._width);
    }
}
