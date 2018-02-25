// Assuming the Words are in small case lettes, Design an O(mn) algorithm to group the anagrams;

import java.util.*;
public class GroupAnagrams2{

	public static void main(String[] args) {
		
		GroupAnagrams2 object = new GroupAnagrams2();
		List<String> words = Arrays.asList(new String[]{"bat","tab","debitcard","badcredit","elvis","lives"});

		System.out.println(object.groupAnagrams(words));
	}


	public List<List<String>> groupAnagrams(List<String>words){

		  Map<Integer,List<String>> map = new HashMap<>();

		  for(String str : words){

		  	  int hash = stringHash(str);

		  	  System.out.println(str+":"+hash);

		  	  if(!map.containsKey(hash)){

		  	  	 map.put(hash,new ArrayList<>());
		  	  }

		  	  map.get(hash).add(str);
		  }


		  List<List<String>> result = new ArrayList<>();

		  for(Map.Entry<Integer,List<String>> entry : map.entrySet()){


		  	    if(entry.getValue().size() >1){

		  	    	result.add(entry.getValue());
		  	    }
		  }

		  return result;
	}


	private int stringHash(String str){

		int value = 0;

		for(int i = 0;i< str.length();i++){

			char ch = str.charAt(i);

			value += ch;
		}

		return value;
	}
	

}