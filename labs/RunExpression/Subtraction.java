/**
 * Created by zehaeva on 9/29/16.
 */
public class Subtraction extends Addition {

    public Subtraction(Expression left, Expression right) {
        super(left, new Negate(right));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
