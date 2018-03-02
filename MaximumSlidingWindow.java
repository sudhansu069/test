
import java.util.*;
// Find the Maximum in sub array of size K
public class MaximumSlidingWindow{


	public static void main(String[] args) {
		
		int [] arr = {2,1,9,4,3,11,8,6};

		MaximumSlidingWindow object = new MaximumSlidingWindow();

		System.out.println(object.maxSlidingWindow(arr,3));
	}
	

	public List<Integer> maxSlidingWindow(int[] arr,int k){


	     Deque<Integer> deque = new ArrayDeque<>();
	     List<Integer> result = new ArrayList<>();

	     for(int i = 0;i<arr.length;i++){

            while(!deque.isEmpty() && deque.peekFirst() < i-k+1){

            	deque.pollFirst();
            }

            while(!deque.isEmpty() && arr[i] > arr[deque.peekLast()]){

            	deque.pollLast();
            }

            deque.offerLast(i);

            if(i >= k-1){

               result.add(arr[deque.peekFirst()]);
            }
	     }

	     return result;


	}
}