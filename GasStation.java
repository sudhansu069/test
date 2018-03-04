public class GasStation{

	 public static void main(String[] args) {
	 	
	 	 
	 }
	
     
       public boolean canCompleteCircle(int[] gas,int[] cost){


       	     int sumRemaining = 0;

       	     int total = 0;

       	     int start = 0;

       	     for(int i = 0;i<gas.length;i++){


       	     	 int remaining = gas[i] - cost[i];

       	     	 if(sumRemaining >= 0){

       	     	 	 sumRemaining += remaining;
       	     	 }else{

       	     	 	 sumRemaining = remaining;
       	     	 	 start = i;
       	     	 }
       	     }

       	     if(total >= 0){

       	     	return start;
       	     }
       	     return -1;
       }

}