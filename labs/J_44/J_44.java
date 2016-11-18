/**
 * Created by hcanaway on 11/17/2016.
 */
public class J_44 {
    public static void main(String[] args) {
        int mult = 5;
        int shift = 4;
        String temp = encrypt("seatechastronomy", mult, shift);
        System.out.println(temp);
        System.out.println(decrypt(temp, mult, shift));
    }

    public static String encrypt(String text, int multiplier, int shift) {
        String return_me = "";
        for (char a :
                text.toLowerCase().toCharArray()) {
            int value = a - 97;
            int new_value = ((value * multiplier + shift ) % 26);
            return_me += (char)(new_value + 97);
        }
        return return_me;
    }

    public static String decrypt(String text, int multiplier, int shift) {
        String return_me = "";
        for (char a :
                text.toLowerCase().toCharArray()) {
            int value = a - 97;
            int new_value = mod_inverse(value, multiplier, shift);
            return_me += (char)(new_value + 97);
        }
        return return_me;
    }

    public static int mod_inverse(int value, int mult, int shift) {
        int i;
        for (i=0;i<26;i++) {
            if (((26*i + value - shift) % mult) == 0){
                break;
            }
        }
        return ((26 * i + value - shift) / mult);
    }
}
