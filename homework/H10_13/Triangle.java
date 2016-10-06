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

    public double getArea() {
        double s = (this._side1 + this._side2 + this._side3) / 2.0;
        return Math.sqrt(s * (s - this._side1) * (s - this._side2) * (s - this._side3));
    }
}
