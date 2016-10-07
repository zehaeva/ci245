/**
 * Created by zehaeva on 9/29/16.
 */
public class Division extends Multiplication {
    /**
     * Integer Division by inverting the second expression
     * @param e1 Numorator
     * @param e2 Denominator
     */
    public Division(Expression e1, Expression e2) {
        super(e1, new Constant(1 / e2.evaluate()));
    }

    @Override
    public String toString() {
        return super.toString().replace("*", "/");
    }

}
