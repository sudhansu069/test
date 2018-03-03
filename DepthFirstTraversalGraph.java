
import java.util.*;

public class DepthFirstTraversalGraph{
	

	  private int V;

	  private List<Integer>[]adj;


	  public static void main(String[] args) {
	  	
	  	  DepthFirstTraversalGraph g = new DepthFirstTraversalGraph(4);

	  	  g.addEdge(0,1);
	  	  g.addEdge(0,2);
	  	  g.addEdge(1,3);
	  	  g.addEdge(2,1);
	  	  g.addEdge(2,3);

	  	  g.dfs(0);
	  }

	  public DepthFirstTraversalGraph(int v){

	  	  V = v;
	  	  adj = new LinkedList[v];

	  	  for(int i = 0;i<v;i++){

	  	  	adj[i] = new LinkedList();
	  	  }
	  }

	  public void dfs(int v){

	  	   boolean [] visited = new boolean[V];
	  	   dfsUtil(v,visited);
	  }

	  private void dfsUtil(int v,boolean[] visited){

	  	  visited[v] = true;

	  	  System.out.println(v+" ");

	  	  Iterator<Integer> itr = adj[v].listIterator();

	  	  while(itr.hasNext()){

	  	  	  int newVertex = itr.next();

	  	  	  if(!visited[newVertex]){
	  	  	  	dfsUtil(newVertex,visited);
	  	  	  }
	  	  }
	  }


	  public void addEdge(int u,int v){

                adj[u].add(v);

	  }
}