public class MaxSumSubArray{


	 public static void main(String[] args) {
	 	
	 	int[] arr = {-2,-3,4,-1,-2,1,5,-3};

	 	MaxSumSubArray object = new MaxSumSubArray();

	 	System.out.println(object.maxSum(arr));

	 }
	
      // Kadens Algorithm
	  public int maxSum(int[] arr){

	  	  int maxSofar = arr[0];
	  	  int maxEndingHere = arr[0];

	  	  for(int i = 1;i< arr.length;i++){

	  	  	  maxEndingHere = Math.max(arr[i],maxEndingHere+arr[i]);
	  	  	  maxSofar = Math.max(maxSofar,maxEndingHere);
	  	  }

	  	  return maxSofar;
	  }
}