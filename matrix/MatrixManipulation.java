import java.util.*;

class MatrixManipulation {

	public static void rotateClockwise(int[][] mat) {
		printMatrix(mat);
		int row = mat.length, col = mat[0].length;
		int[][] res = new int[col][row];

		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				res[c][r] = mat[row-1-r][c];
			}
		}

		printMatrix(res);
	}

	public static void rotateAntiClockwise(int[][] mat) {
		printMatrix(mat);
		int row = mat.length, col = mat[0].length;
		int[][] res = new int[col][row];

		for(int c=col-1; c>=0; c--) {
			for(int r=0; r<row; r++) {
				res[col-1-c][r] = mat[r][c];
			}
		}

		printMatrix(res);
	}

	// public static int[][] rotateRight(int[][] mat) {
	// 	int row = mat.length, col = mat[0].length;
	// 	int[][] rev = new int[col][row];
	// 	// printMatrix(mat);
	// 	for(int c = 0; c<col; c++) {
	// 		List<Integer> rowList = new ArrayList<>();
	// 		for(int r = row-1; r>=0; r--) {
	// 			rowList.add(mat[r][c]);
	// 		}
	// 		rev[c] = rowList.stream().mapToInt(i -> i).toArray();
	// 	}

	// 	// printMatrix(rev);
	// 	return rev;
	// }

	public static void main(String[] args) {
		int[][] mat = {{1,2,3}};
		rotateClockwise(mat);
		mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotateClockwise(mat);

		mat = new int[][]{{1,2,3}};
		rotateAntiClockwise(mat);
		mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotateAntiClockwise(mat);
	}

	public static void printMatrix(int[][] mat) {
		for(int i=0; i<mat.length; i++){
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
	}
}