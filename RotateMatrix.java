import java.util.*;
public class RotateMatrix{

	public static void main(String[] args) {
		
		int[][] matrix = {

			 {1,2,3},
			 {4,5,6},
			 {7,8,9}
		};

        printMatrix(matrix);
        rotateAntiClockwise(matrix);
        printMatrix(matrix);

	}
	

	public static void rotateClockwise(int[][] matrix){

         transpose(matrix);
         reverseRows(matrix);

	}

	public static void rotateAntiClockwise(int[][] matrix){

         transpose(matrix);
         reverseCols(matrix);

	}

	public static void transpose(int[][] matrix){


		for(int i = 0;i<matrix.length;i++){

			for(int j = i+1;j<matrix[0].length;j++){

				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void reverseRows(int[][] matrix){

		 for(int i = 0;i<matrix.length;i++){

		 	int low = 0;
		 	int high= matrix[0].length-1;

		 	while(low <= high){

                 int temp = matrix[i][low];
                 matrix[i][low] = matrix[i][high];
                 matrix[i][high] = temp;

                 low++;
                 high--;

		 	}
		 }
	}

	public static void reverseCols(int[][] matrix){

		 for(int i = 0;i<matrix[0].length;i++){

		 	int low = 0;
		 	int high = matrix.length-1;

		 	while(low <= high){

                 int temp = matrix[low][i];
                 matrix[low][i] = matrix[high][i];
                 matrix[high][i] = temp;

                 low++;
                 high--;

		 	}
		 }
	}

	public static void printMatrix(int[][] matrix){

		 for(int i = 0;i<matrix.length;i++){

		 	System.out.println(Arrays.toString(matrix[i]));
		 }

		 System.out.println();
	}
}