import java.util.*;
public class MatrixSpiralOrder{

	public static void main(String[] args) {
		

		int[][] matrix = {

			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};

		MatrixSpiralOrder object  = new MatrixSpiralOrder();

		object.printMatrix(matrix);
		object.matrixSpiralTraversal(matrix);
	}


	 public void matrixSpiralTraversal(int[][] matrix){


	 	   int top = 0,left = 0;
	 	   int bottom = matrix.length-1;
	 	   int right = matrix[0].length-1;

	 	   String  direction = "right";

	 	   while(top <= bottom && left <= right){


	 	   	   if(direction == "right"){

	 	   	   	   for(int i = left;i<= right;i++){

	 	   	   	   	  System.out.print(matrix[top][i]+" ");
	 	   	   	   }

	 	   	   	   top++;
	 	   	   	   direction = "down";
	 	   	   }

	 	   	   else if(direction == "down"){

	 	   	   	   for(int i = top;i<= bottom;i++){

	 	   	   	   	  System.out.print(matrix[i][right]+" ");
	 	   	   	   }

	 	   	   	   right--;
	 	   	   	   direction = "left";
	 	   	   }
	 	   	   else if(direction == "left"){

	 	   	   	   for(int i = right;i >= left;i--){

	 	   	   	   	  System.out.print(matrix[bottom][i]+" ");
	 	   	   	   }

	 	   	   	   bottom--;
	 	   	   	   direction = "up";
	 	   	   }

	 	   	   else if(direction == "up"){

	 	   	   	   for(int i = bottom;i >=  top;i--){

	 	   	   	   	  System.out.print(matrix[i][left]+" ");
	 	   	   	   }

	 	   	   	   left++;
	 	   	   	   direction = "right";
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