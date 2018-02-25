public class FindRowWithMax1s{



	public static void main(String[] args) {
		
        FindRowWithMax1s object = new FindRowWithMax1s();
		int[][] mat = {

			{0,1,1,1},
			{0,0,1,1},
			{0,0,1,1},
			{1,1,1,1}
		};
        System.out.println(object.findRowWithMaxOnes(mat));

	}
	
    public int findRowWithMaxOnes(int[][] mat){

		  int j = findFirstOccurnaceOfOneInFirstRow(mat[0]);

		  if(j == -1){

		  	 j = mat[0].length-1;
		  }

		  int maxIndex = 0;

		  for(int i = 1;i<mat.length;i++){

		  	  while(j >= 0 && mat[i][j] == 1){

		  	  	 j--;
		  	  	 maxIndex = i;
		  	  }
		  }

		  return maxIndex;
	}

	private int findFirstOccurnaceOfOneInFirstRow(int[] arr){


		 for(int i = 0;i<arr.length;i++){

		 	if(arr[i] == 1) return i; 
		 }

		 return -1;
	}
	
}