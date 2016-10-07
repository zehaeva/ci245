
public class Constant implements Expression {

    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format(" %f ", this.value);
    }

}