import java.util.*;
public class LongestRange{
	  private Set<Integer> set = new HashSet<>();
	  private Set<Integer> visited = new HashSet<>();
	  public static void main(String[] args) {
	  	
	  	  int[] arr = {1,-1,4,0,3};
	  	  LongestRange object = new LongestRange();
	  	  System.out.print(object.maxRange(arr)); // Ans = 3 {1,-1,0}

	  }
	  public int maxRange(int[] arr){
	  	  for(int i = 0;i<arr.length;i++)set.add(arr[i]);
	  	  int max  = 0;

	  	  for(int i = 0;i<arr.length;i++){

	  	  	 if(!visited.contains(arr[i])){

	  	  	 	 int length = dfs(arr[i],0);

	  	  	 	 max = Math.max(length,max);
	  	  	 }
	  	  }
	  	  return max;
	  }

	  private int dfs(int x,int count){

	  	  if(visited.contains(x))return count;

	  	  count++;
	  	  visited.add(x);

	  	  if(set.contains(x-1) && set.contains(x+1))return dfs(x-1,0)+count+dfs(x+1,0);
	  	  else if(set.contains(x-1))return dfs(x-1,0)+count;
	  	  else return count+dfs(x+1,0);
	  }


	}