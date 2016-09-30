/**
 * Created by zehaeva on 9/29/16.
 */
public class Exponent implements Expression {
    private Expression _e;
    private int _exp;

    public Exponent(Expression e, int exp) {
        this._e = e;
        this._exp = exp;
    }

    public int evaluate() {
        int val = 1;
        for (int i = 0; i < this._exp; i++) {
            val *= this._e.evaluate();
        }
        return val;
    }

    @Override
    public String toString() {
        return String.format("%s ^ %d", this._e.toString(), this._exp);
    }
}
