
// https://leetcode.com/problems/contains-duplicate-ii/description/
public class ContainsDuplicatesII{

	public static void main(String[] args) {
		
		  
	}
	
      public boolean containsDuplicate(int[] arr,int k){

      	  Map<Integer,Integer> map = new HashMap<>();

      	  for(int i = 0;i<arr.length;i++){

      	  	 if(map.containsKey(arr[i])){

      	  	 	int prevIndex = map.get(arr[i]);

      	  	 	if(i- prevIndex <= k)return true;
      	  	 }

      	  	 map.put(arr[i],i);
      	  }
      }

}