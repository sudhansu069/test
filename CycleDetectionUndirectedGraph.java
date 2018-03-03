// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

import java.util.*;

public class CycleDetectionUndirectedGraph{
	
    private int V;

    private LinkedList<Integer>[] adj;


    public static void main(String[] args) {
    	
      CycleDetectionUndirectedGraph g1 = new CycleDetectionUndirectedGraph(5);

    	g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }

    public CycleDetectionUndirectedGraph(int v){

    	V = v;

    	adj = new LinkedList[V];

    	for(int i = 0;i<V;i++){

    		adj[i] = new LinkedList();
    	}
    }

    public void addEdge(int u,int v){

    	 adj[u].add(v);

    }

    public boolean isCyclic(){

    	 boolean[] visited = new boolean[V];

    	 for(int i = 0;i<V;i++){

    	 	if(!visited[i]){

    	 		if(isCyclicUtil(i,visited,-1)){

    	 			return true;
    	 		}
    	 	}
    	 }

    	 return false;
    }

    private boolean isCyclicUtil(int v,boolean[] visited,int parent){


    	  visited[v] = true;

    	  Iterator<Integer> itr = adj[v].listIterator();

    	  while(itr.hasNext()){

    	  	 int i = itr.next();

    	  	 if(!visited[i]){
              
               if(isCyclicUtil(i,visited,v)){

               	   return true;
               }

    	  	 }else if(i != v){

    	  	 	return true;
    	  	 }
    	  }

    	  return false;
    }

}