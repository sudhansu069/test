
import java.util.*;
public class LargestNumber{

	public static void main(String[] args) {
		

		int[] arr = {10,9};

		System.out.println(largestNumber(arr));


	}
	


     public static String largestNumber(int[] arr){

     	 String[] strs = new String[arr.length];

     	 for(int i = 0;i< arr.length;i++){


     	 	   strs[i] = String.valueOf(arr[i]);
     	 }

     	 Arrays.sort(strs,new Comparator<String>(){


             public int compare(String a,String b){

             	 return (b+a).compareTo(a+b);
             }
     	 });

     	 StringBuilder res = new StringBuilder();

     	 for(String s : strs){

     	 	 res.append(s);
     	 }

     	 while(res.length()> 1 && res.charAt(0) == 0){

     	 	 res.deleteCharAt(0);
     	 }

     	 return new String(res);
     }

}