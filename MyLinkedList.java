import java.util.*;
public class MyLinkedList{

	private ListNode head;


	public static void main(String[] args) {


		MyLinkedList list1 = new MyLinkedList();
		 
		 

        list1.insertAtEnd(1);
        list1.insertAtEnd(6);
        list1.insertAtEnd(9);
       
        ListNode node = list1.addOneToList(list1.head); 
        
        list1.displayList(node);



	}

	public ListNode addOneToList(ListNode head){

		int carry =  addWithcarry(head);
		if(carry>0){
			ListNode newNode = new ListNode(carry);
			newNode.next= head;
			head = newNode;
		}
		return head;
	}

	private int addWithcarry(ListNode head){
		if(head == null) return 1;

		int result = head.key+addWithcarry(head.next);

		head.key  = result%10;
		return result/10;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next  = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 1;i<= n+1;i++){
            
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast =  fast.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
        
    }

	public ListNode sortList(ListNode head){

		 if(head == null || head.next == null) return head;

		 ListNode prev = null;
		 ListNode slow = head;
		 ListNode fast = head;

		 while(fast != null && fast.next != null){

		 	 prev = slow;
		 	 slow = slow.next;
		 	 fast = fast.next.next;
		 }

		 prev.next = null;

		 ListNode l1 = sortList(head);
		 ListNode l2 = sortList(slow);

		 ListNode result = mergeSortedLists(l1,l2);
		 return result;
	}

	public ListNode mergeKSortedList(ListNode[] lists){

        
          Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){


          	   public int compare(ListNode l1,ListNode l2){

          	   	  return l1.key - l2.key;
          	   }
          });

          ListNode pseudoHead = new ListNode(0);
          ListNode prev = pseudoHead;

          for(ListNode n : lists){

          	  queue.offer(n);
          }

          while(!queue.isEmpty()){

          	  ListNode node = queue.poll();

          	  prev.next = node;
          	  prev = prev.next;

          	  if(node.next != null){

                 queue.offer(node.next);
          	  }
          }

          return pseudoHead.next;
	}


	public ListNode reverseListByGroup(ListNode head,int k){

		 if(head == null) return null;

		 ListNode prev = null;

		 int count = 0;
		 ListNode current = head;
		 ListNode next = null;

		 while(current != null && count < k){

		 	 next = current.next;
		 	 current.next = prev;
		 	 prev = current;
		 	 current = next;
		 	 count++;
		 }

		 if(next != null){

		 	head.next = reverseListByGroup(next,k);
		 }

		 return prev;
	}

	public boolean isPallindrom(ListNode head){

		 ListNode slow  = head;
		 ListNode fast  = head;

		 while(fast != null && fast.next != null){

		 	slow = slow.next;
		 	fast = fast.next.next;
		 }

		 if(fast != null){

		 	slow  = slow.next;
		 }

		 slow = reverse(slow);
		 fast = head;

		 while(slow != null){

            if(slow.key != fast.key) return false;

            slow =  slow.next;
            fast =  fast.next;
		 }

		 return true;
	}


	public ListNode removeNthNodeFromEnd(ListNode head,int n){

          if(head == null) return null;

          ListNode fast = head;
          ListNode slow = head;

        int count = 0;

        while(fast != null && count < n){

        	fast = fast.next;
        	count++;
        }

        if(fast == null){

        	head = head.next;
        	return head;
        }

        while(fast.next != null){

        	slow = slow.next;
        	fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;

	}


    /**
    *  Reverse a linked list from position m to n. Do it in-place and in one-pass.
    *  For example: given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
    */
	public ListNode reverseListII(ListNode head,int m,int n){

          if(head == null) return null;
          ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list

          dummy.next = head;
          ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing

          for(int i = 0; i<m-1; i++) pre = pre.next;
          
          ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed

          ListNode then = start.next; // a pointer to a node that will be reversed

          // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
          // dummy-> 1 -> 2 -> 3 -> 4 -> 5

          for(int i=0; i<n-m; i++)
          {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
          }

          // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
          // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
           return dummy.next;
	}

	public ListNode reverseUsingRec(ListNode head){

		 if(head == null || head.next == null) return head;

		 ListNode second = head.next;
		 head.next = null;

		 ListNode rest = reverseUsingRec(second);
		 second.next = head;
		 return rest; 
	}
    /**
    * Given a linked list, swap every two adjacent nodes and return its head.
    * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
    */
	public ListNode swapNodesInPair(ListNode head){

          if(head == null || head.next == null) return head;

          ListNode remaining = head.next.next;

          ListNode newHead = head.next;
          newHead.next = head;
          head.next = swapNodesInPair(remaining);
          return newHead;
	}
    /**
    *  Given a Linked List and a key . Delete all the occurances of the key
    *
    */
	public ListNode removeNodesWithKey(ListNode head,int key){


         if(head  == null) return null;


         ListNode pseudoHead = new ListNode(0);
         pseudoHead.next =  head;

         ListNode iterator = pseudoHead;

         ListNode current = head;

         while(current != null){

         	  if(current.key != key){

         	  	 iterator.next = current;
         	  	 iterator = iterator.next;
         	  }

         	  current = current.next;
         }
         iterator.next = null;

         return pseudoHead.next;
	}
   
    /**
    * Given a two Linked Lists which are connected at some point. Find the connection node
    *
    */
	public ListNode getIntersectionOfTwoList(ListNode headA,ListNode headB){

		  if(headA == null || headB == null) return null;

		  ListNode p1 = headA;
		  ListNode p2 = headB;

		  int length1 = 0;
		  int length2 = 0;

		  while(p1 != null){

		  	 length1++;
		  	 p1 = p1.next;
		  }

		  while(p2 != null){

		  	 length2++;
		  	 p2 = p2.next;
		  }

		  p1 = headA;
		  p2 = headB;
		  int diff  = 0;

		  if(length1 > length2){

		  	 diff = length1- length2;

		  	 while(diff >0){

		  	 	 p1 = p1.next;
		  	 	 diff--;
		  	 }
		  }

		  if(length1 < length2){

             diff = length2 - length1;

             while(diff > 0){

             	p2 = p2.next;
             	diff--;
             }
		  }


		  while(p1 != null && p2 != null){

		  	  if(p1.key == p2.key){

		  	  	  return p1;
		  	  }
		  	  p1 = p1.next;
		  	  p2 = p2.next;
		  }

		  return null;
	}
    
    /**
    * Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5
    */
	public ListNode partition(ListNode head,int x){


		  ListNode pseudoHead1 = new ListNode(0);
		  ListNode pseudoHead2 = new ListNode(0);

		  pseudoHead1.next = head;

		  ListNode current = head;
		  ListNode first = pseudoHead1;
		  ListNode second = pseudoHead2;

		  while(current != null){

		  	  if(current.key < x){

		  	  	  first = first.next;
		  	  	  current = current.next;
		  	  }else{

		  	  	  second.next = current;
		  	  	  first.next = current.next;
		  	  	  current = current.next;
		  	  	  second = second.next;
		  	  }
		  }

		  second.next = null;
		  first.next = pseudoHead2.next;
		  return pseudoHead1.next;
	}
    

    /**
    * Given a sorted linked list, delete all nodes that have duplicate numbers
    * leaving only distinct numbers from the original list.
    * For example, given 1->1->1->2->3, return 2->3.
    *
    */
	public void removeDuplicatesInSortedListII(ListNode head){

         ListNode dummy = new ListNode(0);
         ListNode prev = dummy;
         dummy.next = head;
         ListNode current = head;

         while(current != null){

             // Until the current and previous values are same, keep updating current
         	 while(current.next != null && prev.next.key == current.next.key){

         	 	current = current.next;
         	 }
             /* if current has unique value i.e current
                is not updated, Move the prev pointer
                to next node*/
         	 if(prev.next == current){

         	 	prev = current;
         	 }else{
                /* when current is updated to the last
               duplicate value of that segment, make
               prev the next of current*/
         	 	prev.next = current.next;
         	 }

         	 current = current.next;
         }

         head = dummy.next;
	}

    /**
    *  Remove Duplicates from a sorted Linked List
    * Example : 
    * Input : 1->2->2->3->5
    * Output :1->2->3->5
    *
    */
	public void removeDuplicatesInSortedList(ListNode head){ 

		  ListNode prev = head;
		  ListNode current = head.next;

		  while(current != null){

		  	   if(prev.key == current.key){

		  	   	  prev.next = current.next;
		  	   	 
		  	   }else{

		  	   	  prev = current;

		  	   }

		  	    current = current.next;
		  }
	}

	public ListNode mergeSortedLists(ListNode l1,ListNode l2){

		  ListNode pseudoHead = new ListNode(0);

		  ListNode p = pseudoHead;

		  while(l1 != null || l2 != null){

		  	  if(l1 != null && l2 != null){

		  	  	 if(l1.key < l2.key){

		  	  	 	  p.next = l1;
		  	  	 	  l1 = l1.next;
		  	  	 }else{

		  	  	 	p.next = l2;
		  	  	 	l2 = l2.next;
		  	  	 }

		  	  	 p = p.next;
		  	  }else if(l1 != null){

		  	  	  p.next = l1;
		  	  	  break;
		  	  }else if(l2 != null){

		  	  	p.next = l2;
		  	  	break;
		  	  }
		  }

		  return pseudoHead.next;
	}

	public ListNode cloneList(ListNode head){

        if(head == null ) return null;

        ListNode p = head;

        while(p != null){

        	ListNode copy = new ListNode(p.key);
        	copy.next = p.next;
        	p.next = copy;
        	p = copy.next;
        }

        p = head;

        while(p != null){

        	 if(p.random != null){

        	 	p.next.random = p.random.next;
        	 }

        	 p = p.next.next;
        }

	    p = head;
		ListNode pseudoHead = new ListNode(0);
		ListNode copy, copyIter = pseudoHead;

		while (p != null) {
			ListNode next  = p.next.next;

			copy = p.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			p.next = next;

			p = next;
		}

	return pseudoHead.next;

	}

	public void displayListWithRandom(ListNode head){

		  ListNode current = head;

		  while(current != null ){

		  	 System.out.print(current+" ->");
		  	 current = current.next;
		  }

		  System.out.print("Null");
		  System.out.println();
	}
   
    /**
    *  Given a linked List . Check if there is a cycle in It.
    */
	public boolean hasCycle(ListNode head){

         ListNode slow = head;
         ListNode fast = head;

         while(fast != null && fast.next != null){

         	  slow = slow.next;
         	  fast = fast.next.next;

         	  if(slow == fast)return true;
         }

         return false;

	}

    /**
    * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln
    * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
    * For example, given {1,2,3,4}, reorder it to {1,4,2,3}. 
    * You must do this in-place without altering the nodes' values.
    * Algo : First Break the Two list in two Halves . Then reverse the second half and then merge both
    */
	public void reorderList(ListNode head){


		  ListNode second = getMiddle(head);

		  second = reverse(second);

		  ListNode p1 = head;
		  ListNode p2 = second;

		  while(p2 != null){


		  	   ListNode temp1 = p1.next;
		  	   ListNode temp2 = p2.next;

		  	   p1.next = p2;
		  	   p2.next = temp1;
		  	   p1 = temp1;
		  	   p2 = temp2;
		  }
	}


	public ListNode getMiddle(ListNode head){


		   ListNode slow = head;
		   ListNode fast = head;
		   ListNode prevSlow = null;

		   while(fast != null && fast.next != null){

		   	 prevSlow  = slow;
		   	 slow = slow.next;
		   	 fast = fast.next.next;

		   }

		   if(fast == null){

		   	   prevSlow.next = null;
		   	   return slow;
		   }

		   ListNode mid = slow.next;
		   slow.next = null;
		   return mid;
	}



	public ListNode reverse(ListNode head){


		 ListNode prev =  null;
		 ListNode current = head;

		 while(current != null){

		 	ListNode next = current.next;
		 	current.next = prev;
		 	prev = current;
		 	current = next;
		 }

		 return prev;
	}

	public ListNode getHead(){

         return head;
	}

	public void setHead(ListNode head){

		this.head  = head;
	}


	public void displayList(){


		 if(head == null) return;

		 ListNode current = head;

		 while(current != null){

		 	  System.out.print(current.key+"->");
		 	  current = current.next;
		 }

		  System.out.print("Null");
		  System.out.println();

	}

	public void displayList(ListNode head){


		 if(head == null) return;

		 ListNode current = head;

		 while(current != null){

		 	  System.out.print(current.key+"->");
		 	  current = current.next;
		 }

		  System.out.print("Null");
		  System.out.println();

	}
    
    /**
    *You are given two linked lists representing two non-negative numbers
    *The digits are stored in reverse order and each of their nodes contain a single digit
    * Add the two numbers and return it as a linked list.
    * input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    * Output: 7 -> 0 -> 8
    */
	public ListNode  addTwoNumbers(ListNode l1,ListNode l2){

        int carry = 0;

        ListNode newHead = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;

        while(p1 != null || p2 != null){

        	 carry += (p1 != null ? p1.key :0) + (p2 != null ? p2.key :0);

        	 p3.next = new ListNode(carry%10);

        	 p3 = p3.next;

        	 carry = carry/10;

        	 if(p1 != null) p1 = p1.next;
        	 if(p2 != null) p2 = p2.next; 
        }

        if(carry ==1){

        	p3.next = new ListNode(1);
        }

        return newHead.next;
	}

	public void insertAtEnd(int key){

		  ListNode newNode = new ListNode(key);

		  if(head == null){

		  	  head = newNode;
		  	  return;
		  }

		  ListNode current = head;

		  while(current.next != null){

		  	  current = current.next;
		  }
		  current.next = newNode;
	}
	

	 static class ListNode{

	 	  int key;

	 	  ListNode next;
	 	  ListNode random;

	 	  public ListNode(int key){

	 	  	  this.key = key;
	 	  }

	 	  public String toString(){

	 	  	  int rand  = random != null ? random.key : -1;

	 	  	  return key+":"+rand;
	 	  }
	 }
}