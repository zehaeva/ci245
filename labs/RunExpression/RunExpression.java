
public class RunExpression {

	public static void main(String[] args) {
		Expression two = new Constant(2);
	    Expression four = new Constant(4);
	    Expression negOne = new Negate(new Constant(1));
	    Expression sumTwoFour = new Addition(two, four);
	    Expression mult = new Multiplication(sumTwoFour, negOne);
	    Expression exp = new Exponent(mult, 2);
	    Expression res = new Addition(exp, new Constant(1));

	    /**
	     * This line should prdouble out:
	     * (  ( ( 2  +  4 )  *  - 1  )  ^ 2 +  1 )  = 37
	     */
	    System.out.println(res + " = " + res.evaluate());

		Expression div = new Division(two, four);

		System.out.println(div + " = " + div.evaluate());
	}
}


