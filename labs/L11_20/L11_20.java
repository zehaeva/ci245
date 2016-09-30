import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zehaeva on 9/29/16.
 */
public class L11_20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char cont = 'y';

        while (cont == 'y') {
            try {
                someMethod();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                System.out.print("\nDo you want to see the exception again?(y/n): ");
                cont = input.next().charAt(0);
            }
        }
    }

    private static void someMethod() throws NullPointerException {
        try {
            someMethod2();
        } catch (NullPointerException e) {
            throw e;
        }
    }

    private static void someMethod2() throws NullPointerException{
        throw new NullPointerException();
    }
}
