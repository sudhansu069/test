

// Find the Median of Stream
import java.util.*;
public class MedianFinder{
	
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;


	public static void main(String[] args) {
		
      MedianFinder medianFinder = new MedianFinder();
      System.out.println(medianFinder.findMedian(7));
      System.out.println(medianFinder.findMedian(10));
      System.out.println(medianFinder.findMedian(14));
      System.out.println(medianFinder.findMedian(12));

	}

	public MedianFinder(){

		 maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
		 minHeap =  new PriorityQueue<>();
	}

	public double findMedian(int value){

		maxHeap.offer(value);
		minHeap.offer(maxHeap.poll());

		if(maxHeap.size() < minHeap.size()){

			maxHeap.offer(minHeap.poll());
		}

		if(maxHeap.size() != minHeap.size()){

			return (double)maxHeap.peek();
		}else{

			return (double)(maxHeap.peek()+minHeap.peek())/2;
		}
	}

}