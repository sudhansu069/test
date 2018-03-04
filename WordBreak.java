

import java.util.*;
public class WordBreak{


	public static void main(String[] args) {
		
		Set<String> dictionary = new HashSet<>();

		dictionary.add("leet");
		dictionary.add("code");
		dictionary.add("ed");

		WordBreak wordBreak = new WordBreak();

		System.out.println(wordBreak.wordBreak("leetcode",dictionary));
	}
	
	public boolean wordBreak(String s,Set<String> dictionary){

		 return wordBreakHelper(s,0,dictionary);
	}

	private boolean wordBreakHelper(String s,int start,Set<String> dictionary){

		 if(start >= s.length()) return true;

		 for(String word : dictionary){

		 	 int length = word.length();

		 	 if(start+length > s.length())continue;

		 	 if(s.substring(start,start+length).equals(word)){

		 	 	if(wordBreakHelper(s,start+length,dictionary)){

		 	 		return true;
		 	 	}
		 	 }
		 }

		 return false;
	}
}