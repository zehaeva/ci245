/**
 * Created by zehaeva on 10/5/16.
 */
public class Sphere implements ThreeDimensionalShape {
    private  double _radius;

    public Sphere(double _radius) {
        this._radius = _radius;
    }

    public double getRadius() {
        return _radius;
    }

    public void setRadius(double radius) {
        this._radius = radius;
    }

    @Override
    public double getVolume() {
        return 4.0 * Math.PI * Math.pow(this._radius, 3.0) / 3.0;
    }

    @Override
    public double getSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(this._radius, 2.0);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "Radius=" + _radius +
                '}';
    }
}
