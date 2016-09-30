/**
 * Created by zehaeva on 9/29/16.
 */
public class Negate implements Expression {
    private Expression _e;
    public Negate(Expression e) {
        this._e = e;
    }

    public int evaluate() {
        return this._e.evaluate() * -1;
    }

    @Override
    public String toString() {
        return String.format(" - %s", this._e.toString());
    }
}
