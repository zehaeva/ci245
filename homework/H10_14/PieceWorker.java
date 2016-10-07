/**
 * Created by zehaeva on 10/6/16.
 */
public class PieceWorker extends Employee {
    private double _wage;
    private int _pieces;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
        super(firstName, lastName, socialSecurityNumber);
        this._wage = wage;
        this._pieces = pieces;
    }

    public double getWage() {
        return _wage;
    }

    public void setWage(double wage) {
        this._wage = wage;
    }

    public int getPieces() {
        return _pieces;
    }

    public void setPieces(int pieces) {
        this._pieces = pieces;
    }

    @Override
    public double earnings() {
        return this._wage * this._pieces;
    }

    @Override
    public String toString() {
        return String.format("piece employee: %s%n%s: $%,.2f; %s: %d",
         super.toString(), "per piece wage", getWage(),
         "pieces made", getPieces());
    }
}
