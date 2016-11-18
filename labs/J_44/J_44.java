/**
 * Created by hcanaway on 11/17/2016.
 */
public class J_44 {
    /**
     * takes the given string and then encrypts it and decrypts it
     * @param args
     */
    public static void main(String[] args) {
        int mult = 5;
        int shift = 4;
        String temp = encrypt("seatechastronomy", mult, shift);
        System.out.println(temp);
        System.out.println(decrypt(temp, mult, shift));
    }

    /**
     * Finds the Modulo Inverse for 26 and the multiplier
     * @param mult
     * @return
     */
    public static int mod_inverse(int mult) {
        int i;
        for (i=0;i<26;i++) {
            if ((mult * i) % 26 == 1) {
                break;
            }
        }
        return i;
    }

    /**
     * Encrypts the string using the Affline Cypher
     * @param text
     * @param multiplier
     * @param shift
     * @return
     */
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

    /**
     * Decrypts the string using the given info
     * @param text
     * @param multiplier
     * @param shift
     * @return
     */
    public static String decrypt(String text, int multiplier, int shift) {
        String return_me = "";
        int mi = mod_inverse(multiplier);
        for (char a :
                text.toLowerCase().toCharArray()) {
            int value = a - 97;
            int new_value = (mi * (value - shift)) % 26;
            return_me += (char)(new_value + 97);
        }
        return return_me;
    }

}
