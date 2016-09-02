public class H5_15 {
	public static void main(String[] args) {
		print_triangle(1, 11, 0, '*', ' ');
		print_triangle(1, 11, 11, ' ', '*');
		print_triangle(0, 11, 0, ' ', '*');
		for (int i=10;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print(' ');
			}
			for(int j=11;j>i;j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	public static void print_triangle(int a, int b, int c, char e, char f) {
		for (int i=a;i<b;i++) {
			for(int j=c;j<i;j++) {
				System.out.print(e);
			}
			for(int j=b;j>i;j--) {
				System.out.print(f);
			}
			System.out.println();
		}
	}
}
