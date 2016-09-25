import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zehaeva on 9/25/16.
 */
public class J_17 {
    /**
     * accepts a string of text and then prints out the unique words
     * utilizing a treeset and a hashset
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String source_text;
        String[] source_array;
        HashSet<String> hash = new HashSet<String>();
        TreeSet<String> tree = new TreeSet<String>();

        //get input
        System.out.print("Enter a line of text: ");
        source_text = input.nextLine();
        source_array = source_text.split(" ");
        //store in hash/tree set
        for (String word :
                source_array) {
            hash.add(word);
            tree.add(word);
        }

        System.out.println("Hash: ");
        print_hash(hash);
        print_hash_reverse(hash);

        System.out.println("Tree: ");
        print_tree(tree);
        print_tree_reverse(tree);
    }

    /**
     * prints a treeset in reverse order
     * @param tree
     */
    private static void print_tree_reverse(TreeSet<String> tree) {
        for (String word:
             tree.descendingSet()) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    /**
     * prints a treeset
     * @param tree
     */
    private static void print_tree(TreeSet<String> tree) {
        for (String word :
                tree) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    /**
     * prints a hashset in order, utilizing a treeset to sort the hashset
     * @param hash
     */
    private static void print_hash(HashSet<String> hash) {
        TreeSet<String> tree = new TreeSet<String>();
        tree.addAll(hash);
        for (String word :
                tree) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    /**
     * prints a hashset in reverse order utilizing a treeset
     * @param hash
     */
    private static void print_hash_reverse(HashSet<String> hash) {
        TreeSet<String> tree = new TreeSet<String>();
        tree.addAll(hash);
        for (String word :
                tree.descendingSet()) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
}
