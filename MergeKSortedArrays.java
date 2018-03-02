import java.util.*;
public class MergeKSortedArrays{

	public static void main(String[] args) {
		
		int[][] arr = {

			{2,4,9},
			{1,2,89},
			{2,5,6}
		};

		MergeKSortedArrays object = new MergeKSortedArrays();

		System.out.println(object.mergeKSortedArrays(arr));
	}



	public List<Integer> mergeKSortedArrays(int[][] arr){

         Queue<Node> queue = new PriorityQueue<>();

         for(int i = 0;i<arr.length;i++){

         	queue.offer(new Node(i,0,arr[i][0]));
         }

         List<Integer> result = new ArrayList<>();

         while(!queue.isEmpty()){

             Node node = queue.poll();

             result.add(node.val);

             if(node.col < arr[node.row].length-1){

             	 queue.offer(new Node(node.row,node.col+1,arr[node.row][node.col+1]));
             }
         }

         return result;
	}
	

	static class Node implements Comparable<Node>{

		  int row;
		  int col;
		  int val;

		  public Node(int row,int col,int val){

		  	  this.row = row;
		  	  this.col = col;
		  	  this.val = val;
		  }

		  public int compareTo(Node that){

		  	 return this.val - that.val;
		  }
	}
}