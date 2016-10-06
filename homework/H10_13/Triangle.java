/**
 * Created by zehaeva on 10/5/16.
 */
public class Triangle implements TwoDimensionalShape {
    private double _side1;
    private double _side2;
    private double _side3;

    public Triangle(double side1, double side2, double side3) {
        this._side1 = side1;
        this._side2 = side2;
        this._side3 = side3;
    }

    public double getSide1() {
        return _side1;
    }

    public void setSide1(double side1) {
        this._side1 = side1;
    }

    public double getSide2() {
        return _side2;
    }

    public void setSide2(double side2) {
        this._side2 = side2;
    }

    public double getSide3() {
        return _side3;
    }

    public void setSide3(double side3) {
        this._side3 = side3;
    }

    public double getArea() {
        double s = (this._side1 + this._side2 + this._side3) / 2.0;
        return Math.sqrt(s * (s - this._side1) * (s - this._side2) * (s - this._side3));
    }

    @Override
    public String toString() {
        return String.format("Triangle{S1=%f,S2=%f,S3=%f}", this._side1, this._side2, this._side3);
    }
}
