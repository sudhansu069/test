
/**
*  LRU Cache Implementation . Most Elegant way to implement LRU Cache.
*
*/

import java.util.*;
public class LRUCache{


   public static void main(String[] args) {
   	
      LRUCache cache = new LRUCache(2);

      cache.set(1,1);
      cache.set(2,2);
      System.out.println(cache.getKey(1));


   }



	private int capacity ;

	Map<Integer,Node> map = new HashMap<>();

	private Node head;
	private Node end;


	public LRUCache(int capacity){

		this.capacity = capacity;
	}

	public int getKey(int key){

		  if(map.containsKey(key)){

		  	  Node node  = map.get(key);

		  	  remove(node.key);
		  	  insertAtStart(node);

		  	  return node.value;
		  }

		  return -1;
	}

	public void set(int key,int value){


		  if(map.containsKey(key)){

		  	  Node old = map.get(key);
		  	  old.value = value;
		  	  remove(old.key);
		  	  insertAtStart(old);
		  }else{

		  	   Node newNode = new Node(key,value);

		  	   if(map.size() >= capacity){
                   
                   map.remove(end.key);
                   remove(end.key);
                   insertAtStart(newNode);

		  	   }else{

                   insertAtStart(newNode);

		  	   }

		  	    map.put(key,newNode);
		  }
	}


	private void insertAtStart(Node n){


		  n.next = head;

		  if(head != null){

		  	 head.prev = n;

		  }

		  head = n;

		  if(end == null){

		  	  end = head;
		  }
	}


	private void remove(int key){


		  Node node = map.get(key);

		  if(node.prev != null){

              node.prev.next = node.next;
		  }else{

		  	  head = node.next;
		  }


		  if(node.next != null){

		  	 node.prev.next = node.next;
		  }else{

		  	  end = node.prev;

		  }
	}
	
	static class Node{

		  int key;
		  int value;
		  Node next ;
		  Node prev;

		  public Node(int key,int value){

		  	 this.key = key;
		  	 this.value = value;
		  }
	}
}