public class MyQueue<E>{
	
    
      private E[] arr;
      private int index;
      private int capacity;

      public static void main(String[] args)throws Exception {
      	
      	MyQueue<String> queue = new MyQueue<>(5);

      	queue.enqueue("A");
      	queue.enqueue("B");
      	queue.enqueue("C");

      	while(!queue.isEmpty()){

      		 System.out.println(queue.dequeue());
      	}
      }

      @SuppressWarnings("unchecked")
	public MyQueue(int size){

      	arr = (E[]) new Object[size];
      	this.capacity = size;

      }

      public boolean isEmpty(){

      	return index == 0;
      }

      public void enqueue(E data) throws Exception{

         if(index == capacity-1)throw new Exception("Queue Is Full");

         arr[index] = data;
         index++;
      }

      public E dequeue() throws Exception{

         if(isEmpty()) throw new Exception("Queue  is Empty");

         E data = arr[0];

         for(int i = 0;i< index-1;i++){

         	arr[i] = arr[i+1];
         }

         index--;
         return data;
      }


}