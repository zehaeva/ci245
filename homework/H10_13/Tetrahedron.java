/**
 * Created by zehaeva on 10/5/16.
 */
public class Tetrahedron implements ThreeDimensionalShape {
    private double _edge;

    public Tetrahedron(double edgeLength) {
        this._edge = edgeLength;
    }

    public double getEdgeLength() {
        return _edge;
    }

    public void setEdgeLength(double edgeLength) {
        this._edge = edgeLength;
    }

    @Override
    public double getVolume() {
        return Math.pow(this._edge, 3.0) / (6 * Math.sqrt(2.0));
    }

    @Override
    public double getSurfaceArea() {
        return Math.sqrt(3.0) * Math.pow(this._edge, 2.0);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "Edge=" + _edge +
                '}';
    }
}
