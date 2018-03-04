public class MinEditDiatnceProblem{


	  public static void main(String[] args) {
	  	
	  	   MinEditDiatnceProblem object = new MinEditDiatnceProblem();

	  	   System.out.println(object.minEditDistanceDp("catjshdjashjdhaskjdhkjashjkdhajskh","cut"));
	  }
	

       // O(3^m)  Run Time
	  // Can be solved using Dp
	   public int minEditDistance(String str1,String str2){

	   	  return minEditDistanceHelper(str1,str1.length(),str2,str2.length());
	   }

      
	   private int minEditDistanceHelper(String str1,int m,String str2,int n){

	   	  if(m == 0) return n;

	   	  if(n == 0) return m;

	   	  if(str1.charAt(m-1) == str2.charAt(n-1))
	   	  	return minEditDistanceHelper(str1,m-1,str2,n-1);

	   	  return 1+Math.min(minEditDistanceHelper(str1,m-1,str2,n-1),Math.min(minEditDistanceHelper(str1,m,str2,n-1),minEditDistanceHelper(str1,m-1,str2,n)));
	   }


	   public int minEditDistanceDp(String s1,String s2){

          int m = s1.length();
          int n = s2.length();

          int[][] dp = new int[m+1][n+1];

          for(int i = 0;i<=m;i++){

          	for(int j = 0 ;j<= n ;j++){

          		if(i == 0){

          			dp[i][j] = j;
          		}
          		else if(j == 0){

          			dp[i][j] = i;
          		}
          		else if(s1.charAt(i-1) == s2.charAt(j-1)){
          			dp[i][j] = dp[i-1][j-1];
          		}else{

          			dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
          		}
          	}
          }

          return dp[m][n];
	   }
}