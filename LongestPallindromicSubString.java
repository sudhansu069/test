public class LongestPallindromicSubString{
	
	private int low;
	private int max;

	public static void main(String[] args) {
		
		LongestPallindromicSubString object = new LongestPallindromicSubString();

		System.out.println(object.longestPallindrom("abcmadamppq"));
	}

	public String longestPallindrom(String str){

		 for(int i = 0;i<str.length()-1;i++){

		 	extendPallindrom(str,i,i);
		 	extendPallindrom(str,i,i+1);
		 }

		 return str.substring(low,low+max);
	}


	private void extendPallindrom(String str,int i,int j){

		 

		while(i>= 0 && j< str.length() && str.charAt(i) == str.charAt(j)){

			 i--;j++;
		}

		if(max < j-i-1){

			max = j-i-1;
			low = i+1;
		}
	}
}