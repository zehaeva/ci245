public class J_5 {
	public static void main(String[] args) {
		double[][] matrix = {{1,4,7}, {3,0,5}, {-1,9,11}};
		//double[][] matrix = {{3,0,2,-1}, {1,2,0,-2}, {4,0,6,-3}, {5,0,2,0}};

		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix.length;j++) {
				System.out.printf("%f\t", minor(matrix, i, j));
			}
			System.out.println();
		}
	}

	public static double minor(double[][] matrix, int ith, int jth) {
		double[][] sub_matrix = new double[matrix.length - 1][matrix.length - 1];
		int sub_row = 0; int sub_col = 0;

		try {
			for (int i=0;i<matrix.length;i++) {
				if (i != ith) {
					for (int j=0;j<matrix.length;j++) {
						if (i != ith && j != jth) {
							sub_matrix[sub_row][sub_col] = matrix[i][j];
							sub_col++;
						}
					}
					sub_col = 0;
					sub_row++;
				}
			}
		}
		catch (Exception ex) {
			System.out.printf("sub_row: %d, sub_col: %d\n", sub_row, sub_col);
		}

		return determinant(sub_matrix);
	}

	public static double determinant(double[][] matrix) {
		double det = 0;
		if (matrix.length == 2) {
			det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		else {
			double[][] temp = new double[matrix.length - 1][matrix.length - 1];
			int skip = 0;
			double sign = 1.0;
			for (int k=0;k<matrix.length;k++) {
				for (int i=0;i<matrix.length-1;i++) {
					skip = 0;
					for (int j=0;j<matrix.length-1;j++) {
						if (j == k) {
							skip = 1;
						}
						temp[i][j] = matrix[i + 1][j + skip];
					}
				}	

				det += sign * matrix[0][k] * (determinant(temp));
				sign *= -1.0;
				skip = 0;
			}
		}
		return det;
	}
}
