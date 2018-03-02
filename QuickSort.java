import java.util.*;
public class QuickSort{

	public static void main(String[] args) {
		
		QuickSort quickSort = new QuickSort();
		int[] arr = {2,1,4,3,11,6};

		quickSort.sort(arr);

		System.out.println(Arrays.toString(arr));



	}
	
      
       

      public void sort(int[] arr){

      	  sortHelper(arr,0,arr.length-1);
      }

      private void sortHelper(int[] arr,int low,int high){


      	  if(low > high) return;

      	  int q = partition(arr,low,high);

      	  sortHelper(arr,low,q-1);
      	  sortHelper(arr,q+1,high);
      }

      private int partition(int[] arr, int low,int high){

      	int i = low;
        int pivot = arr[high];
      	for(int j = low;j<high;j++){

      		if(arr[j] < pivot){
                 
      			swap(arr,i,j);
      			i++;
      		}
      	}

      	swap(arr,i,high);
      	return i;
      }

      private void swap(int[] arr,int i,int j){

      	  int temp = arr[i];
      	  arr[i] = arr[j];
      	  arr[j] = temp;
      }

}