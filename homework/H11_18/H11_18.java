/**
 * Created by zehaeva on 10/27/16.
 */
public class H11_18 {
    public static void main (String[] args) {
        try {
            throw new ExceptionB();
        }
        catch (ExceptionA e) {
            System.out.println("Super Class exception!");
        }
        //catch (ExceptionB e) {
        //    System.out.println("We'll never get here so the compiler hates us!");
        //}
    }
}
