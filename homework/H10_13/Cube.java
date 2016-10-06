/**
 * Created by zehaeva on 10/5/16.
 */
public class Cube implements ThreeDimensionalShape {
    private double _width;
    private double _length;
    private double _height;

    public Cube(double width, double length, double height) {
        this._width = width;
        this._length = length;
        this._height = height;
    }

    public double getWidth() {
        return _width;
    }

    public void setWidth(double width) {
        this._width = width;
    }

    public double getLength() {
        return _length;
    }

    public void setLength(double length) {
        this._length = length;
    }

    public double getHeight() {
        return _height;
    }

    public void setHeight(double height) {
        this._height = height;
    }

    @Override
    public double getVolume() {
        return this._length * this._width * this._height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (this._length * this._width + this._width * this._height + this._height * this._length);
    }
}
