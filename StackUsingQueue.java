import java.util.*;

public class StackUsingQueue<E>{
	
	  private Queue<E> queue ;


	  public static void main(String[] args) {
	  	
	  	  StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>();

	  	  stack.push(1);
	  	  stack.push(2);
	  	  stack.push(3);

	  	  while(!stack.isEmpty()){

	  	  	 System.out.println(stack.pop());
	  	  }
	  }

	  public StackUsingQueue(){

	  	 queue = new LinkedList<>();
	  }

	  public void push(E x){

	  	   queue.offer(x);

	  	   int size  = queue.size();

	  	   for(int i = 0;i< size-1;i++){

                queue.offer(queue.poll());
	  	   }
	  }

	  public E pop(){

	  	  return queue.poll();
	  }

	  public E top(){

	  	  return queue.peek();
	  }

	  public boolean isEmpty(){

	  	 return queue.isEmpty();
	  }

	 





}