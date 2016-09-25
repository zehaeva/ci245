import java.util.ArrayList;

public class J_16 {

  public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ArrayList<int[]> power_Set = new ArrayList<int[]>();

        power_sets(array, power_Set);

      for (int[] ps: power_Set) {
          System.out.printf("{");
          for (int i = 0; i < ps.length; i++) {
              System.out.printf("%d ", ps[i]);
          }
          System.out.println("}");
      }
    }

    public static void print_power_set(int[] array) {
        if (array.length == 0) {
            System.out.print("{} ");
        }
        else {
            int e = array[0];
            int[] temp = new int[array.length - 1];

        //  S U _e
            for (int i = 1; i < array.length; i++) {
                temp[i - 1] = array[i];
            }

        //  Print P(temp)
            print_power_set(temp);

        //  Print F(e, P(T))
            System.out.printf("{%d", e);
            for (int i = 0; i  < temp.length; i++) {
                System.out.printf(", %d", temp[i]);
            }
            System.out.printf("}");
        }
    }

    public static void power_sets(int[] set_S, ArrayList<int[]> set_P) {
        if (set_S.length == 0) {
            set_P.add(new int[1]);
        }
        else {
            int e = set_S[0];
            int[] temp = new int[set_S.length - 1];

        //  fill temp array
            for (int i = 1; i < set_S.length; i++) {
                temp[i-1] = set_S[i];
            }

        //  get all the combinations of e and all the elements in temp array
            for (int i = 1; i <= set_S.length; i++) {
                int[] hold = new int[i ];
                hold[0] = e;
                for (int j = 0; j < i - 1; j++) {
                    hold[j + 1] = temp[j];
                }
                set_P.add(hold);
            }

        //  get all the power sets of temp
            power_sets(temp, set_P);
        }
    }

  }
