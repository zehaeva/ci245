
public class Addition implements Expression {

    private final Expression left;
    private final Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return this.left.evaluate() + this.right.evaluate();
    }

    @Override
    public String toString() {
        return String.format(" (%s + %s) ", this.left, this.right);
    }
}