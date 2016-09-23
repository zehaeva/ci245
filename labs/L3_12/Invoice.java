public class Invoice {
    private String _part_number;
    private String _part_description;
    private int _quantity;
    private double _part_price;

    public Invoice(String PartNumber, String PartDescription, int Quantity, double PartPrice) {
        this._part_number = PartNumber;
        this._part_description = PartDescription;
        this._quantity = Quantity;
        this._part_price = PartPrice;
    }

    public String getPartNumber() {
        return _part_number;
    }

    public void setPartNumber(String PartNumber) {
        this._part_number = PartNumber;
    }

    public String getPartDescription() {
        return _part_description;
    }

    public void setPartDescription(String PartDescription) {
        this._part_description = PartDescription;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int Quantity) {
        if (Quantity < 0) {
            Quantity = 0;
        }
        this._quantity = Quantity;
    }

    public double getPartPrice() {
        return _part_price;
    }

    public void setPartPrice(double partPrice) {
        if (partPrice < 0.0) {
            partPrice = 0.0;
        }
        this._part_price = partPrice;
    }

    public double getInvoiceAmount() {
        double temp;
        return this._quantity * this._part_price;
    }


    public String toString() {
        return this._part_number + ": " + this._part_description + " Quantity: " + this._quantity + " Unit Price: " + this._part_price;
    }
}