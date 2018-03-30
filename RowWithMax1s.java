public class RowWithMax1s{


	public static void main(String[] args) {
		
		 int[][] matrix = {


            {0, 0, 0, 0},
		 	{0 ,1, 1, 1},
		 	{0 ,0 ,1 ,1},
		 	{1 ,1 ,1 ,1}
		 	
		 };

		 RowWithMax1s object = new RowWithMax1s();

		 System.out.println(object.findRowWithMaxOnes(matrix));


	}
	
	public int findRowWithMaxOnes(int[][] matrix){


	       int m = matrix.length;
	       int n = matrix[0].length;

	       int i = 0;
	       int j = n-1;

	       int maxRows = -1;

	       while(i<n){

	       	    while(j>=0 && matrix[i][j] == 1 ){

	       	    	j--;
	       	    	maxRows = i;
	       	    }

	       	    i++;
	       }

	       return maxRows; 
	}
}