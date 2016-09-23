public class L3_12 {
    public static void main(String[] args) {
        Invoice inv = new Invoice("temp", "a temp Object", 20, 50.0);
        System.out.println(inv.toString());

        System.out.printf("Invoice Total: %f\n", inv.getInvoiceAmount());

        inv.setQuantity(-5);
        System.out.println(inv.toString());

        inv.setPartPrice(-4);
        System.out.println(inv.toString());

        inv.setPartPrice(4);
        System.out.println(inv.toString());

        inv.setPartNumber("Steel Billet");
        System.out.println(inv.toString());
    }
}