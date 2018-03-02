
import java.util.*;
public class QueueUsingStack<E>{
	
	  private Stack<E> inputStack;
	  private Stack<E> outputStack;


	  public static void main(String[] args) {
	  	
	  	 QueueUsingStack<Integer> queue = new QueueUsingStack<>();

	  	 queue.offer(1);
	  	 queue.offer(2);
	  	 queue.offer(3);

	  	 while(!queue.isEmpty()){

	  	 	 System.out.println(queue.poll());
	  	 }
	  }

	  public QueueUsingStack(){

	  	 inputStack = new Stack<>();
	  	 outputStack = new Stack<>();
	  }

	  public void offer(E x){

          inputStack.push(x);

	  }


	  public E poll(){

          if(outputStack.isEmpty()){

          	while(!inputStack.isEmpty()){

          		 outputStack.push(inputStack.pop());
          	}
          }
          return outputStack.pop();
	  }

	  public E peek(){

	  	 if(outputStack.isEmpty()){

          	while(!inputStack.isEmpty()){

          		 outputStack.push(inputStack.pop());
          	}
	     }

	     return outputStack.peek();
	}

	public boolean isEmpty(){

		 return inputStack.isEmpty() && outputStack.isEmpty();
	}

	 
}