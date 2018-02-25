// Stack Implementation Using MaxHeap 

import java.util.*;
import java.lang.*;
public class StackUsingHeap{


    private static final int DEFAULT_CAPACITY = 16;
	private int rank;
	private int maxCapacity;
	private int currentCapacity;

	Queue<ValueWithRank> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


	public static void main(String[] args) {
		
		StackUsingHeap stack = new StackUsingHeap();

		stack.push(1);
		stack.push(2);

		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}


	public StackUsingHeap(int capacity){

        rank = 0;

        maxCapacity = capacity;

        currentCapacity = 0;
	}


	public StackUsingHeap(){

		this(DEFAULT_CAPACITY);
	}


	public void push(int data) throws RuntimeException{


		  if(currentCapacity >= maxCapacity) throw new RuntimeException("Stack Overflow");

		  currentCapacity++;

		  maxHeap.offer(new ValueWithRank(data,rank++));
	}

	public int pop() throws RuntimeException{

		  if(currentCapacity == 0) throw new RuntimeException("Stack Underflow");

		  currentCapacity--;

		  ValueWithRank valueWithRank = maxHeap.poll();

		  return valueWithRank.value;
	}

	public int peek() throws RuntimeException{

          if(currentCapacity == 0) throw new RuntimeException("Stack Underflow");

          ValueWithRank valueWithRank = maxHeap.peek();

          return valueWithRank.value;


	}

	
	
     private static class ValueWithRank implements Comparable<ValueWithRank>{

     	private int  value;
     	private int rank;

     	public ValueWithRank(int value,int rank){

     		this.value = value;
     		this.rank = rank;
     	}

     	public int compareTo(ValueWithRank that){

     		 return Integer.compare(this.rank,that.rank);
     	}


     }

}