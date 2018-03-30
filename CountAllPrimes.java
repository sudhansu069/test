public class CountAllPrimes{
	
      // count all the Primes less than n.
	  public int countPrime(int n){

          boolean [] notPrime = new boolean[n];

          if(n <= 1) return 0;

          notPrime[0] = true;
          notPrime[1] = true;

           for(int i = 2; i < Math.sqrt(n); i++){
	        if(!notPrime[i]){
	            for(int j = 2; j*i < n; j++){
	                notPrime[i*j] = true; 
	            }
	        }
          }

        int count = 0; 
	    for(int i = 2; i< notPrime.length; i++){
	        if(!notPrime[i]) count++;
	    }
       return count; 


	  }
}