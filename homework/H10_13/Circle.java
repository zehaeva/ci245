/**
 * Created by zehaeva on 10/5/16.
 */
public class Circle implements TwoDimensionalShape {
    private double _radius;
    public Circle(double radius) {
        this._radius = radius;
    }

    public double getRadius() {
        return this._radius;
    }

    public double getArea() {
        return Math.PI * this._radius / 2;
    }
}
