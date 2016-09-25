import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zehaeva on 9/25/16.
 */
public class J_17 {
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
        System.out.println("Tree: ");
        print_tree(tree);
        print_tree_reverse(tree);
    }

    private static void print_tree_reverse(TreeSet<String> tree) {
        for (String word:
             tree.descendingSet()) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    private static void print_tree(TreeSet<String> tree) {
        for (String word :
                tree) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    private static void print_hash(HashSet<String> hash) {
        for (String word :
                hash) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
}
