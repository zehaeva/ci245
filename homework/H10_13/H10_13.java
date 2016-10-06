/**
 * Created by hcanaway on 10/6/2016.
 */
public class H10_13 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];

        shapes[0] = new Square(5, 4);
        shapes[1] = new Circle(5);
        shapes[2] = new Triangle(3, 4, 5);

        shapes[3] = new Cube(5, 6, 7);
        shapes[4] = new Sphere(6);
        shapes[5] = new Tetrahedron(6);

        for (Shape shape :
                shapes) {
            if (shape instanceof TwoDimensionalShape) {
                System.out.printf("%s: Area = %f\n", shape.toString(), ((TwoDimensionalShape) shape).getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.printf("%s: Surface Area = %f; Volume = %f\n", shape.toString(),
                        ((ThreeDimensionalShape) shape).getSurfaceArea(), ((ThreeDimensionalShape) shape).getVolume());
            }
        }
    }
}
