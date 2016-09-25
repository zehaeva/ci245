import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zehaeva on 9/25/16.
 */
public class J_18 {
    /**
     * Asks for a number and then outputs the prime factors of it
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int factor_me;
        ArrayList<Integer> factors = new ArrayList<Integer>();
        char cont = 'y';

        while (cont == 'y') {
            System.out.print("Enter a number to be factored: ");
            factor_me = input.nextInt();

            factors = prime_factors(factor_me, 2);

            for (Integer i :
                    factors) {
                System.out.printf("%d ", i);
            }
            System.out.print("\nDo you wish to factor another number? (y/n): ");
            cont = input.nextLine().charAt(0);
        }
    }

    /**
     * recusively finds all the prime factors of a number
     * this works kind of like the sieve of ethos-somethingorother
     * @param factor_me number to be factored
     * @param factor factor to try
     * @return arraylist full of all the factors
     */
    private static ArrayList<Integer> prime_factors(int factor_me, int factor) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        if (factor_me == 1) {
        //  nothing left to find! return!
        }
    //  does this factor divide evenly?
        else if (factor_me % factor == 0) {
        //  I guess so ! let's see if the result is also a factor of this same number
            factors = prime_factors(factor_me / factor, factor);
        //  can't forget this one!
            factors.add(factor);
        }
        else {
        //  I guess there's nothing left for this number, let's find the next one
            factors = prime_factors(factor_me, (factor+1));
        }
        return factors;
    }

}
