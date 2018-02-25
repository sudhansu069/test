
// Given An unsorted Array . Find the median in linear time .
// The idea is to use randomised Quck Select Algo to find the kth Smallest element . here k = n/2

import java.lang.*;
import java.util.*;
public class FindMedianUnsortedArray{


	 public static void main(String[] args) {
	 	
	 	FindMedianUnsortedArray object = new FindMedianUnsortedArray();

	 	int[] arr = {3,9,1,4,6,11};
	 	 
	 	System.out.println(object.findMedian(arr));
	 	
	 }


	  public double findMedian (int [] arr){

	  	   if(arr.length %2 !=  0){
	  		   
	  		     return getKthLargest(arr, arr.length/2+1);
	  	   }else{
	  		   int x = getKthLargest(arr, arr.length/2);
	  		   int y = getKthLargest(arr, arr.length/2+1);
	  		   return (x+y)/2;
	  	   }
	  }
	  
	  private int getKthLargest(int[] arr,int k){
		  
		  
		    int low = 0;
		    int high = arr.length-1;
		    
		    while(low <= high){
		    	
		    	 int q = partition(arr, low, high);
		    	 
		    	 if(q == arr.length-k) return arr[q];
		    	 
		    	 else if(q < arr.length-k)low = q+1;
		    	 else high = q-1;
		    }
		    
		    return -1;
	  }
	
    
       public int partition(int[] arr, int low, int high){


       	  Random rand = new Random();

       	  int randomIndex = low+rand.nextInt(high-low+1);

       	  swap(arr,randomIndex,high);

       	  int pivot = arr[high];

       	  int i = low;

       	  for(int j = low ;j< high;j++){

       	  	   if(arr[j] < pivot){

       	  	   	  swap(arr,i,j);
       	  	   	  i++;
       	  	   }
       	  }

       	  swap(arr,i,high);

       	  return i;
       }


       private void swap(int[] arr,int i,int j){

       	int temp = arr[i];
       	arr[i] = arr[j];
       	arr[j] = temp;
       }

}