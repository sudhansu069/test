import java.util.*;
public class FindElementOccuringOnce{


	 public static void main(String[] args) {
	 	
	 	int[] arr = {2,3,2,2};
	 	FindElementOccuringOnce object = new FindElementOccuringOnce();

	 	System.out.println(object.findElementOccuringOnce(arr,3));
	 }
	
     
      /**
       * Given a Array where each element occurs k times except one element which occurs one time. 
       * Find the number which occurs once.
       */
	  public int findElementOccuringOnce(int[] arr,int k){

	  	    int[] countSetBit = new int[32];

            for(int i = 0;i< arr.length;i++){

            	for(int j = 0;j<32;j++){

            		 int kthSetBit = 1<<j;

            		 if((arr[i]&kthSetBit) == kthSetBit){

            		 	  countSetBit[j]++;
            		 }
            	}
            }

            int sol = 0;

            for(int i = 0;i<32;i++){

            	countSetBit[i] = countSetBit[i]%k;
            	if(countSetBit[i] == 1){

                    sol = sol | (1<<i);
            	}
            }

            return sol;
   
          
	  }
}