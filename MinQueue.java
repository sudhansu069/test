
import java.util.*;
public class MinQueue{
	

	private Queue<Integer> minHeap ;
	private Queue<Integer> queue;


	public static void main(String[] args) throws Exception {
		
		   MinQueue minQueue = new MinQueue();

		  
		   minQueue.offer(2);
		    minQueue.offer(11);

           System.out.println(minQueue.min());
           minQueue.poll();

		   minQueue.offer(5);
		    System.out.println(minQueue.min());
		   minQueue.offer(8);

	}


	public MinQueue(){

		  queue = new LinkedList<>();
		  minHeap = new PriorityQueue<>();

	}

	public void offer(int item){

       queue.offer(item);
       minHeap.offer(item);

	}

	public int poll(){


       int item = queue.poll();

       if(minHeap.peek() == item){

       	   minHeap.poll();
       }

       return item;

	}

	public int min() throws Exception{
      if(minHeap.isEmpty()) throw new Exception("Queue Is Empty");

      return minHeap.peek();
	}

	public int peek() throws Exception{

        if(queue.isEmpty()) throw new Exception("Queue Is Empty");

        return queue.peek();
	}

}