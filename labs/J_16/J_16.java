public class J_16 {

  public static void main(String[] args) {
        int[] array = {1, 2, 3};

        print_power_set(array);
    }

    public static void print_power_set(int[] array) {
        int[] tmp;
        if (array.length == 0) {
            System.out.print("{}\n");
        }
        else {
            //System.out.printf("{%d} ", array[0]);
            for (int i = array.length; i > 0; i--) {
                System.out.printf("{%d", array[0]);
                for (int j = i; j < array.length; j++) {
                    System.out.printf(", %d", array[j]);
                }
                System.out.print("} ");
            }
            //tmp = Arrays.copyOfRange(array, 1, array.length);
            //print_power_set(tmp);
        }
    }
  }
