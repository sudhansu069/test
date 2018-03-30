public class NumberOfIslands{
	
	  private int m;
	  private int n;

	  public static void main(String[] args) {
	  	
	  	   NumberOfIslands object = new NumberOfIslands();

	  	   char[][] grid = {

	  	   	 {'1','1','0','0','0'},
	  	   	 {'1','1','0','0','0'},
	  	   	 {'0','0','1','0','0'},
	  	   	 {'0','0','0','1','1'}
	  	   };

	  	   System.out.println(object.numberOfIslands(grid));
	  }

	  public int numberOfIslands(char[][] grid){

	  	  if(grid == null || grid.length == 0) return 0;

	  	  int count = 0 ;

	  	  m = grid.length;
	  	  n = grid[0].length;

	  	  for(int i = 0;i<m;i++){

	  	  	 for(int j = 0;j<n;j++){

	  	  	 	 if(grid[i][j] == '1'){

	  	  	 	 	dfs(grid,i,j);
	  	  	 	 	++count;
	  	  	 	 }
	  	  	 }
	  	  }

	  	  return count;
	  }

	  private void dfs(char[][] grid,int i,int j){

	  	  if(i<0 || j< 0 || i>= m || j>= n || grid[i][j]  != '1') return;

	  	  grid[i][j] = 0;

	  	  dfs(grid,i+1,j);//down
	  	  dfs(grid,i-1,j);// up
	  	  dfs(grid,i,j+1); // right
	  	  dfs(grid,i,j-1); // left


	  }
}