public class J_20 {

    public static void main(String[] args) {
	// write your code here
        java.util.Scanner input = new java.util.Scanner(System.in);
        char cont = 'y';
        String what_did_he_say;
        
        while (cont == 'y') {
            System.out.print("Please enter some text: ");
            what_did_he_say = input.nextLine();
            
            System.out.println(what_did_he_say);
            
            System.out.print("Again? (y/n): ");
            cont = input.nextLine().charAt(0);
        }
    }
}
