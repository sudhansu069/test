
/**
*  Finding the K closest stars near the Earth
*/
import java.util.*;
public class KNearestStars{

 public static void main(String[] args) {
 	
 	List<Star> stars = new ArrayList<>();

 	stars.add(new Star(3,3,3));
 	stars.add(new Star(4,5,3));

 	stars.add(new Star(1,2,3));
 	stars.add(new Star(1,2,1));
 	stars.add(new Star(1,1,0));
 	stars.add(new Star(1,0,0));
 	

 	System.out.println(kClosestStars(stars,4));
 }



	public static List<Star> kClosestStars(List<Star> stars,int k){

		  Queue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());


		  for(Star star : stars){

		  	  if(maxHeap.size() < k){

		  	  	   maxHeap.offer(star);
		  	  }else{

		  	  	  if(maxHeap.peek().distance() > star.distance()){

		  	  	  	   maxHeap.poll();
		  	  	  	   maxHeap.offer(star);
		  	  	  }
		  	  }
		  }

		  return new ArrayList<>(maxHeap);
	}



	private static class Star implements Comparable<Star>{

       float x,y,z;


       public Star(float x,float y,float z){

       	   this.x = x ;
       	   this.y = y;
       	   this.z = z;
       }

       public double distance(){


       	   return Math.sqrt(x*x+y*y+z*z);
       }

       public int compareTo(Star that){

       	   return Double.compare(this.distance(),that.distance());
       }

       public String toString(){

       	   return x+":"+y+":"+z;
       }

	}
	


}