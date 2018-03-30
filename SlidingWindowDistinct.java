import java.util.*;
public class SlidingWindowDistinct{

	 public static void main(String[] args) {
	 	
	 	int[] arr = {1, 2, 1, 3, 4, 2, 3};

	 	SlidingWindowDistinct object = new SlidingWindowDistinct();

	 	object.countDistinctInSlidingWindow(arr,4);


	 }
	
	  public void countDistinctInSlidingWindow(int[] arr,int k){

	  	   Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();

	  	   int count = 0;

	  	   for(int i = 0;i<arr.length;i++){ 

	  	   	  if(!countMap.containsKey(arr[i]))count++;

	  	   	  countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
	  	   	 

	  	   	  if(i >= k){

                 if(countMap.get(arr[i-k]) == 1){

                 	  countMap.remove(arr[i-k]);
                 	  count--;
                 }else{

                 	 countMap.put(arr[i-k],countMap.get(arr[i-k])-1);
                 }

                }
                  
                 if(i>= k-1)
                 System.out.println(count);
	  	   	  
	  	   	  
	  	   }
	  }

}