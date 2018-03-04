import java.util.*;
public class SetMatrixZeros {


	public static void main(String[] args) {
		
		SetMatrixZeros object = new SetMatrixZeros();

		int[][] matrix = {
			{1,1,1,0},
			{1,1,1,0},
			{1,1,0,0},
			{1,0,0,0}
		};

		object.printMatrix(matrix);
		object.setZeroes(matrix);
		object.printMatrix(matrix);


	}
	
	public void setZeroes(int[][] matrix){

		  boolean[] rows = new boolean[matrix.length];
		  boolean[] cols = new boolean[matrix[0].length];

		  for(int i = 0;i<matrix.length;i++){

		  	for(int j= 0;j<matrix[0].length;j++){

		  		if(matrix[i][j] == 0){

		  			rows[i] = true;
		  			cols[j] = true;
		  		}
		  	}
		  } 

		   for(int i = 0;i<matrix.length;i++){

		  	for(int j= 0;j<matrix[0].length;j++){

		  		if(rows[i] || cols[j]){

		  			 matrix[i][j] = 0;
		  		}
		  	}
		  } 
	}

	public void printMatrix(int[][] matrix){

		 for(int i = 0;i<matrix.length;i++){

		 	System.out.println(Arrays.toString(matrix[i]));
		 }

		 System.out.println();
	}
}