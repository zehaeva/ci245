import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zehaeva on 9/29/16.
 */
public class L11_21 {
    public static void main(String[] args) {
        char cont = 'y';
        Scanner input = new Scanner(System.in);

        while (cont == 'y') {
            try {
               someMethod();
            } catch (Exception ex) {
                System.out.println("I caught an Exception!");
                ex.printStackTrace();
            } finally {
                System.out.print("\nDo you want to see the exception again?(y/n): ");
                cont = input.next().charAt(0);
            }
        }
    }

    private static void someMethod() throws Exception {
        Random rand = new Random();
        try {
            if (rand.nextInt(2) > 10) {
                throw new IOException();
            }
            throw new NullPointerException();
        } catch (IOException ex) {
            System.out.println("I caught an IO Exception!");
        }
    }
}
