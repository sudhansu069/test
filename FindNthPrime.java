public class FindNthPrime{
	
	  public int findNthPrime(int userInput){

	     int counter = 0;

		for(int i = 1; ; i++) {
		    if(isPrime(i)
		        counter++;

		    if(counter == userInput) {
		        print(i);
		        break;
		    }
		}
	  }


	  private  boolean isPrime(long n) {
		    if(n < 2)
		        return false;

		    for (long i = 2; i * i <= n; i++) {
		        if (n % i == 0)
		            return false;
		    }
    		return true;
     }
}