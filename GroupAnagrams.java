
import java.util.*;

public class GroupAnagrams{

	public static void main(String[] args) {

		GroupAnagrams object = new GroupAnagrams();
		
		List<String> words = Arrays.asList(new String[]{"bat","tab","debitcard","badcredit","elvis","lives"});

		System.out.println(object.groupAnagrams(words));
	}
	
     
     public List<List<String>> groupAnagrams(List<String> words){

     	  Map<String,List<String>> map = new HashMap<>();

     	  for(String str : words){

     	  	  char[] arr = str.toCharArray();
     	  	  Arrays.sort(arr);

     	  	  String sortedString = new String(arr);

     	  	  if(!map.containsKey(sortedString)){

     	  	  	  map.put(sortedString,new ArrayList<String>());
     	  	  } 	  
     	  	  map.get(sortedString).add(str);

     	  }

     	  List<List<String>> result = new ArrayList<>();

     	  for(Map.Entry<String,List<String>> entry : map.entrySet()){

     	  	  if(entry.getValue().size() > 1){

     	  	  	  result.add(entry.getValue());
     	  	  }
     	  }

     	  return result;
     }

}