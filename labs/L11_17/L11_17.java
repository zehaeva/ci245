import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zehaeva on 9/29/16.
 */
public class L11_17 {
    public static void main(String[] args) {
        char cont = 'y';
        int exception = 0;
        Scanner input = new Scanner(System.in);

        while (cont == 'y') {
            try {
                switch (exception) {
                    case 0:
                        throw new ExceptionB();
                    case 1:
                        throw new ExceptionA();
                    case 2:
                        throw new NullPointerException();
                    case 3:
                        throw new IOException("io exception!");
                    default:
                        System.out.println("We're out of exceptions!");
                }

            } catch (ExceptionB ex) {
                System.out.println("Here I am again, on my own");
            } catch (ExceptionA ex) {
                System.out.println("Going down the only road i've ever known");
            } catch (NullPointerException ex) {
                System.out.println("Like a drifter I was born to walk alone");
            } catch (IOException ex) {
                System.out.println("and i've made up my mind");
            } finally {
                exception++;
                System.out.print("Do you want to see the next exception?(y/n): ");
                cont = input.next().charAt(0);
            }
        }
    }
}
