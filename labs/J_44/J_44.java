/**
 * Created by hcanaway on 11/17/2016.
 */
public class J_44 {

    public static String encrypt(String text, int multiplier, int shift) {
        String return_me = "";
        for (char a :
                text.toLowerCase().toCharArray()) {
            int value = a - 65;
            int new_value = ((value * multiplier + shift ) % 26);
            return_me += new_value;
        }
        return return_me;
    }
}
