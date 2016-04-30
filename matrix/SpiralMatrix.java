class SpiralMatrix {

	public static void printSpiralMatrix(int arr[][]) {
		int m = 0; //no of rows
		int n = 0; //no of columns
		int row = arr.length;
		int col = arr[0].length;
		while (m < row && n < col) {
			for (int i = n; i < col; i++) {
				System.out.println(arr[m][i]);
			}
			m++;

			for (int i = m; i < row; i++) {
				System.out.println(arr[i][col-1]);
			}
			col--;

			for (int i = col-1; i >= n; i--) {
				System.out.println(arr[row-1][i]);
			}
			row--;

			for (int i = row-1; i >= m; i--) {
				System.out.println(arr[i][n]);
			}
			n++;

		}
	}
	public static void main(String[] args) {
		int input[][] = {{1, 2, 9, 10},
                   		{6, 3, 8, 11},
                   		{5, 4, 7, 12},
                   		{13, 14, 15, 16}};
        printSpiralMatrix(input);	
	}	
}