
//You are given a list of n-1 integers and these integers are in the range of 1 to n.
//There are no duplicates in list One of the integers is missing in the list. Write an efficient code to find the missing integer.
public class MissingNumber{

	public static void main(String[] args) {
		
		int[] nums = {3,2,1,4,6,7};

		System.out.println("Missing Number:"+findMissingNumber(nums));
	}
	

	public static int findMissingNumber(int[] nums){

         int n = nums.length;

         int expectedSum = (n+1)*(n+2)/2;

         int actualSum = 0;
         for(int i = 0;i< n;i++){

           actualSum += nums[i];
         }

         return expectedSum-actualSum;
	}
}