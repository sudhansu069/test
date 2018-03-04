public class MaxProductSubArray{


	public static void main(String[] args) {
		
		 int[] nums = {2,3,-2,4};

		 MaxProductSubArray object = new MaxProductSubArray();

		 System.out.println(object.maxProdcutsubarray(nums));


	}
	

	public int maxProdcutsubarray(int[] nums){

		   int[] max = new int[nums.length];
		   int[] min = new int[nums.length];

		   max[0] = min[0] = nums[0];
		   int result = nums[0];

		   for(int i = 1;i<nums.length;i++){

		   	 if(nums[i] > 0){

		   	 	  max[i] = Math.max(nums[i],nums[i]*max[i-1]);
		   	 	  min[i] = Math.min(nums[i],nums[i]*min[i-1]);
		   	 }else{
                   
                  max[i] = Math.max(nums[i],nums[i]*min[i-1]);
		   	 	  min[i] = Math.min(nums[i],nums[i]*max[i-1]);
		   	 }

		   	 result = Math.max(result,max[i]);
		   }

		   return result;
	}
}