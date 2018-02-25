import java.util.*;
public class MergeSort{
	
    
      private int[] temp;


      public static void main(String[] args) {
      	
      	  MergeSort mergeSort = new MergeSort();
      	  int[] arr = {2,12,3,11,4};

      	  mergeSort.mergeSort(arr);

      	  System.out.println(Arrays.toString(arr));


      }

      public void mergeSort(int[] arr){


      	     temp = new int[arr.length];

      	     mergeSortHelper(arr,0,arr.length-1);
      }


      private void mergeSortHelper(int[] arr,int low,int high){


      	  if(low < high){

      	  	  int mid = low+(high-low)/2;

      	  	  mergeSortHelper(arr,low,mid);
      	  	  mergeSortHelper(arr,mid+1,high);

      	  	  merge(arr,low,mid,high);


      	  }
      }

      private void merge(int[] arr,int low,int mid,int high){

      	     for(int i = low;i<=mid;i++){

      	     	  temp[i] = arr[i];
      	     }

      	     for(int j = mid+1;j<= high;j++){

      	     	 temp[j] = arr[j];
      	     }

      	     int index1 = low;
      	     int index2 = mid+1;
             int index = low;

      	     while(index1 <= mid && index2 <= high){

                if(temp[index1] < temp[index2]){

                	arr[index++] = temp[index1++];
                }else{

                    arr[index++] = temp[index2++];
                }
      	     }

      	     while(index1 <= mid){

      	     	arr[index++] = temp[index1++];
      	     }

      	     while(index2 <= high){

      	     	arr[index++] = temp[index2++];
      	     }
      }

}