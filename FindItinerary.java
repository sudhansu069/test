// https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;
public class FindItinerary{


	public static void main(String[] args) {
		
		  String[][] ticket = {

		  	  {"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}
		  };

		  FindItinerary object = new FindItinerary();

		  System.out.println(object.findItinerary(ticket));
	}


	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	LinkedList<String> result = new LinkedList<String>();
	
     public List<String> findItinerary(String[][] tickets){

     	for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket[0], q);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
 
		dfs("JFK");
		return result;
     }

     public void dfs(String s) {
		
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}
}