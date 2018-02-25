import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class FindKLargestString{
	

	public static void main(String[] args) {
		
		List<String> inputStrs = new ArrayList<>();

		inputStrs.add("abc");
		inputStrs.add("ashjsa");
		inputStrs.add("sdsa");
		inputStrs.add("dsadadsadsada");
		inputStrs.add("sdsa");
		inputStrs.add("sadasdsa");
		inputStrs.add("dasdsadsadsadsadsadsa");
		inputStrs.add("sa");

		System.out.println(kLargest(inputStrs,3));
	}

	public static List<String> kLargest(List<String> inputStrs,int k){


		Queue<String> minHeap = new PriorityQueue<>(k,new Comparator<String>(){


			  public int compare(String s1,String s2){

			  	  return s1.length() - s2.length();
			  }
		});


		for(String s : inputStrs){


			minHeap.offer(s);

			if(minHeap.size()>k){

				minHeap.poll();
			}
		}

		return new ArrayList<String>(minHeap);
	}
}