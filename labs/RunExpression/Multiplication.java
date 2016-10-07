/**
 * Created by zehaeva on 9/29/16.
 */
public class Multiplication implements Expression {
    private Expression _e1;
    private Expression _e2;

    public Multiplication(Expression e1, Expression e2) {
        this._e1 = e1;
        this._e2 = e2;
    }

    public double evaluate() {
        return this._e1.evaluate() * this._e2.evaluate();
    }

    @Override
    public String toString() {
        return String.format(" (%s * %s) ", this._e1.toString(), this._e2.toString());
    }
}
