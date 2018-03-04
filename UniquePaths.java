public class UniquePaths{

	  public static void main(String[] args) {
	  	
	  	  UniquePaths object = new UniquePaths();

	  	  System.out.println(object.uniquePaths2(3,3));
	  }
      
      // DP Approach - Run Time O(m*n)
	  public int uniquePaths2(int m,int n){

	  	  int [][] dp = new int[m][n];

	  	  for(int i = 0;i<m;i++){

	  	  	 for(int j = 0;j<n;j++){

	  	  	 	if(i == 0 || j == 0){

	  	  	 		dp[i][j] = 1;
	  	  	 	}else{

	  	  	 		dp[i][j] = dp[i-1][j]+dp[i][j-1];
	  	  	 	}
	  	  	 }
	  	  }

	  	  return dp[m-1][n-1];
	  }
	
       // Expontial Run time 
	   public int uniquePaths(int m,int n){


	   	   return dfs(0,0,m,n);
	   }

	   private int dfs(int i,int j,int m,int n){

	   	   if(i == m-1 && j == n-1){

	   	   	 return 1;
	   	   }

	   	   if(i < m-1 && j < n-1){

	   	   	   return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
	   	   }

	   	   if(i < m-1){

	   	   	   return dfs(i+1,j,m,n);
	   	   }

	   	   if(j < n-1){

	   	   	  return dfs(i,j+1,m,n);
	   	   }

	   	   return 0;
	   }
}