import java.util.*;
public class WallsGateProblem{


	  private int[] XDir = {0,-1,0,1};
	  private int[] YDir = {1,0,-1,0};

	  public static void main(String[] args) {
	  	
	  	  int[][] grid = {
	  	  	{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
	  	  	{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
	  	  	{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
	  	  	{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
	  	  };



        WallsGateProblem object = new WallsGateProblem();

        object.printGrid(grid);
        object.calculateShortestDistance(grid);
        object.printGrid(grid);

	  }

	  public void printGrid(int[][] grid){

	  	  for(int i = 0;i<grid.length;i++){

	  	  	  System.out.println(Arrays.toString(grid[i]));
	  	  }

	  	  System.out.println();
	  }
	
	   public void calculateShortestDistance(int[][] grid){


	   	     Queue<Node> queue = new LinkedList<>();

	   	     for(int i = 0;i<grid.length;i++){

	   	     	  for(int j = 0;j< grid[i].length;j++){

                      if(grid[i][j] == 0){

                      	  queue.offer(new Node(i,j));
                      }
	   	     	  }
	   	     }

	   	     while(!queue.isEmpty()){

	   	     	 Node node = queue.poll();

	   	     	 int x = node.x;
	   	     	 int y = node.y;

	   	     	 for(int k = 0;k<4;k++){

	   	     	 	  int newX = x+XDir[k];
	   	     	 	  int newY = y+YDir[k];

	   	     	 	  
	   	     	 	  if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] <grid[x][y]+1){

	   	     	 	  	continue;
	   	     	 	  }

	   	     	 	  grid[newX][newY] = grid[x][y]+1;

	   	     	 	  queue.offer(new Node(newX,newY));
	   	     	 }
	   	     }
	   }

	   static class Node{

	   	   int x;
	   	   int y;
	   	   


	   	   public Node(int x,int y){

	   	   	   this.x = x;
	   	   	   this.y = y;
	   	   	    
	   	   }
	   }
}