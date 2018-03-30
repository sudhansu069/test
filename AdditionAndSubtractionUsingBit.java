public class AdditionAndSubtractionUsingBit{

	 public static void main(String[] args) {
	 	
         System.out.println(subract(2,3));
	 }
	

	  public static int add(int x,int y){

	  	  if(y == 0) return x;
	  	 
	  	   return add(x^y,(x&y)<<1);

	  }

	   public static int subract(int x,int y){

	  	  if(y == 0) return x;
	  	 
	  	   return subract(x^y,(~x&y)<<1);

	  }
}