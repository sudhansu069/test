public class TrieUsingArray{

	private TrieNode root;

	public TrieUsingArray(){

		 root = new TrieNode();
	}

	public static void main(String[] args) {
		
		TrieUsingArray trie = new TrieUsingArray();

		trie.insert("hello");
		trie.insert("heroes");

		System.out.println(trie.search("hell"));
	}

	public void insert(String word){

		  TrieNode curr = root;

		  for(int i = 0;i< word.length();i++){

		  	 char c = word.charAt(i);
		  	 int index = c -'a';

		  	 if(curr.children[index] == null){

                 curr.children[index] = new TrieNode(c);

		  	 }

		  	 curr = curr.children[index];

		  	 if(i == word.length()-1){

		  	 	curr.isLeaf = true;
		  	 }
		  }
	}


	public boolean search(String word){

		TrieNode t = searchNode(word);

		if(t != null && t.isLeaf){
           return true;
		}

		return false;
	}

	private TrieNode searchNode(String word){

		  TrieNode curr =  root;
 
		  for(int i = 0;i< word.length();i++){

		  	  char c = word.charAt(i);
		  	  int index = c - 'a';

		  	  if(curr.children[index] == null) return null;

		  	  curr = curr.children[index];
		  }

		  return curr;
	}
	

	static class TrieNode{

		 TrieNode[] children = new TrieNode[26];
		 char c;
		 boolean isLeaf;

		 public TrieNode(){


		 }

		 public TrieNode(char c ){

		 	this.c = c;
		 }
	}

}