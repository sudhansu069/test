
// Calculate the Moving avarage of a data stream
import java.util.*;
public class MovingAverage{
	
    private int size;
    private Queue<Integer> window;
    private int sum;


    public static void main(String[] args) {
    	
    	MovingAverage movingAvg = new MovingAverage(2);
        System.out.println(movingAvg.next(4));
        System.out.println(movingAvg.next(1));
        System.out.println(movingAvg.next(2));
        System.out.println(movingAvg.next(3));

    }

    public MovingAverage(int size){

    	  this.size = size;
    	  window = new ArrayDeque<>();
    }

    public double next(int val){

           window.offer(val);

    	   if(window.size() > size){

    	   	 sum -= window.poll();
    	   }

    	   sum += val;
    	   return (double)sum/window.size();
    }





}