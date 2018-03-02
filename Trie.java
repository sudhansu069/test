import java.util.*;
public class Trie{

	private TrieNode root;

	public Trie(){

		root = new TrieNode();
	}

	public static void main(String[] args) {
		
		Trie trie =  new Trie();
		trie.insert("Hello");
		trie.insert("Heros");

		System.out.println(trie.getAllWordsWithPrefix("He"));


	}

	public List<String> getAllWordsWithPrefix(String prefix){

		 TrieNode t = searchNode(prefix);

		 return doLevelOrderTraversal(t,prefix);
		  
	}

	private List<String> doLevelOrderTraversal(TrieNode root,String prefix){

         List<String> result = new ArrayList<>();
		 if(root.isLeaf){

		 	result.add(prefix);
		 	return result;
		 }

		 for(Character c : root.children.keySet()){

		 	  TrieNode node = root.children.get(c);
               
		 	  result.addAll(doLevelOrderTraversal(node,prefix+node.c));
		 }

		 return result;
	}


	public void insert(String word){

        TrieNode curr = root;

        for(int i = 0;i<word.length();i++){

        	char c = word.charAt(i);

        	if(curr.children.get(c) != null){

        		curr = curr.children.get(c);
        	}else{

        		TrieNode node = new TrieNode(c);
        		curr.children.put(c,node);
        		curr = node;
        	}

        	if(i == word.length()-1){

        		curr.isLeaf = true;
        	}
        }


	}

	public boolean serach(String word){

		TrieNode t = searchNode(word);

		if(t != null && t.isLeaf){

			return true;
		}


		return false;
	}

	public boolean startWith(String prefix){

		 TrieNode t = searchNode(prefix);

		 return t!= null;
	}

    private TrieNode searchNode(String str){

    	 Map<Character,TrieNode> children = root.children;

    	 TrieNode t = null;

    	 for(int i = 0;i<str.length();i++){

    	 	char c  = str.charAt(i);
    	 	if(children.containsKey(c)){

    	 		t = children.get(c);
    	 		children = t.children;
    	 	}else{

    	 		return null;
    	 	}
    	 }

    	 return t;
    }

	
	static class TrieNode{

		 char c;
		 Map<Character,TrieNode> children = new HashMap<>();
		 boolean isLeaf;

		 public TrieNode(){};

		 public TrieNode(char c){

		 	this.c = c;
		 }
	}
}