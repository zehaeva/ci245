import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by zehaeva on 9/27/16.
 */
public class J_19 {
    public static void main(String[] args) {

        List<Integer> ints = generate_random_int_list();

        List<Integer> sorted = merge_sort(ints);

        print_list(ints);
        print_list(sorted);
    }

    private static List<Integer> merge_sort(List<Integer> list) {
        List<Integer> output = new ArrayList<>();

    //  is there only one thing left?
        if (list.size() == 1) {
            output.add(list.get(0));
        }
        else {
            //  first divide the array
            List<Integer> left = list.subList(0, list.size() / 2);
            List<Integer> right = list.subList(list.size() / 2, list.size());
            //  sort the left
            left = merge_sort(left);
            //  sort the right
            right = merge_sort(right);
            //  lastly merge the sorted halves back together
            int left_index = 0;
            int right_index = 0;
            while (left_index < left.size() && right_index < right.size()) {
                if (left.get(left_index) <= right.get(right_index)) {
                    output.add(left.get(left_index));
                    left_index++;
                }
                else {
                    output.add(right.get(right_index));
                    right_index++;
                }
            }

            if (left_index == left.size()) {
                while (right_index < right.size()) {
                    output.add(right.get(right_index));
                    right_index++;
                }
            }
            else {
                while (left_index < left.size()) {
                    output.add(left.get(left_index));
                    left_index++;
                }
            }
        }
        return output;
    }

    private static void print_list(List<Integer> int_list) {
        for (Integer value :
                int_list) {
            System.out.printf("%s ", NumberFormat.getNumberInstance(Locale.US).format(value));
        }
        System.out.println();
    }

    private static List<Integer> generate_random_int_list() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        int n;
        int i = 0;

    //  how many?
        n = 10; //rand.nextInt(10);

    //  generate them!
        while (i++ < n) {
            list.add(rand.nextInt());
        }

        return list;
    }
}
