public class CloneGraph{


	public Node cloneGraph(Node node){

		 if(node == null)return null;

		 Queue<Node> queue = new LinkedList<Node>();
		 HashMap<Node, Node> map = new HashMap<Node,Node>();

         Node newHead = new Node(node.label);

         queue.add(node);
         map.put(node, newHead);

         while(!queue.isEmpty()){

         	 Node curr = queue.poll();
         	 ArrayList<Node> currNeighbors = curr.neighbors;

         	 for(Node aNeighbor: currNeighbors){

         	 	 if(!map.containsKey(aNeighbor)){


         	 	 	 Node copy = new Node(aNeighbor.label);

         	 	 	 map.put(aNeighbor,copy);
         	 	 	 map.get(curr).neighbors.add(copy);
         	 	 	 queue.add(aNeighbor);
         	 	 }else{

         	 	 	map.get(curr).neighbors.add(map.get(aNeighbor));
         	 	 }
         	 }


             return  newHead;

         }
	}
	
	 static class Node{

	 	  int label;
	 	  ArrayList<Node> neighbors;
          public UndirectedGraphNode(int x) { 
          	label = x; 
          	neighbors = new ArrayList<Node>(); 
          }

	 }
}