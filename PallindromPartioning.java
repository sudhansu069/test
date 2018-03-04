import java.util.*;
public class PallindromPartioning{

	public static void main(String[] args) {
		
		PallindromPartioning object = new PallindromPartioning();

		System.out.println(object.pallindromPartioning("aab"));
	}
	

	 public List<String> pallindromPartioning(String str){


	 	  List<String> result = new ArrayList<>();

	 	  if(str == null){

	 	  	 return result;
	 	  }

	 	  int length = str.length();

	 	  int[][] table = new int[length][length];

	 	  for(int l =1 ;l<= length ;l++){

	 	  	 for(int i = 0; i <= length-l;i++){

                 int j = i+l-1;

                 if(str.charAt(i) == str.charAt(j)){

                 	if(l == 1 || l == 2){

                 		 table[i][j] = 1;
                 	}else{

                 		table[i][j] = table[i+1][j-1];
                 	}

                 	if(table[i][j] == 1){

                 		result.add(str.substring(i,j+1));
                 	}


                 }else{

                 	table[i][j] = 0;
                 }
	 	  	 }
	 	  }

	 	  return result;
	 }
}