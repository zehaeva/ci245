/**
 * Created by zehaeva on 9/29/16.
 */
public class Exponent implements Expression {
    private Expression _e;
    private double _exp;

    public Exponent(Expression e, double exp) {
        this._e = e;
        this._exp = exp;
    }

    public double evaluate() {
        double val = 1;
        for (double i = 0; i < this._exp; i++) {
            val *= this._e.evaluate();
        }
        return val;
    }

    @Override
    public String toString() {
        return String.format("%s ^ %f", this._e.toString(), this._exp);
    }
}
