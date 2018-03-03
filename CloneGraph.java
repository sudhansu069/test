public class CloneGraph{


	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){

		 if(node == null)return null;

		 Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		 HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
                                   new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

         UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

         queue.add(node);
         map.put(node, newHead);

         while(!queue.isEmpty()){

         	 UndirectedGraphNode curr = queue.poll();
         	 ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;

         	 for(UndirectedGraphNode aNeighbor: currNeighbors){

         	 	 if(!map.containsKey(aNeighbor)){


         	 	 	 UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);

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
	
	 static class UndirectedGraphNode{

	 	  int label;
	 	  ArrayList<UndirectedGraphNode> neighbors;
          public UndirectedGraphNode(int x) { 
          	label = x; 
          	neighbors = new ArrayList<UndirectedGraphNode>(); 
          }

	 }
}