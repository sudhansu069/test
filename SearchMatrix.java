public class SearchMatrix{


	 public static void main(String[] args) {
	 	
	 	  int[][] matrix = {
	 	  	{10, 20, 30, 40},
	 	  	{15, 25, 35, 45},
	 	  	{27, 29, 37, 48},
	 	  	{32, 33, 39, 50}
	 	  };
          
          SearchMatrix object = new SearchMatrix();
          System.out.println(object.search(matrix,29));

	 }
	
     /**
      *  Search in a row wise and column wise sorted matrix
      *  Run Time = O(m+n)
      */
      public boolean search(int[][] matrix,int target){
        
            int i  = 0;
            int j  = matrix[0].length-1;

            while(i < matrix.length && j >= 0){


            	 if(matrix[i][j] == target){

            	 	return true;
            	 }else if(target > matrix[i][j]){

            	 	 i++;
            	 }else{

            	 	j--;
            	 }
            } 

            return false;

      }

}