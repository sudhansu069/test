import java.util.*;
public class LargestAreaOfHistogram{


public int largestRectangleArea(int[] height) {
	
	 Stack<Integer> stack = new Stack<>();

	 int max_area = 0;
	 int tp;
	 int area_with_top;

	 int i = 0;
     while (i < height.length){

           if (stack.isEmpty() || height[stack.peek()] <= height[i]){

           	   stack.push(i++);
           }else{

           	  tp = stack.pop();

           	  area_with_top = height[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
           	  if (max_area < area_with_top){

           	  	   max_area = area_with_top;
           	  }
           }
     }

     while(!s.isEmpty()){

     	 tp = stack.pop();
     	 area_with_top = height[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
     	 if (max_area < area_with_top){

           	max_area = area_with_top;
         }
     }

     return max_area;



 }


	    // Using Devide And Conquere Approach
	    // Run Time = O(nlogn)
	    public int largestRectangleAreaDQ(int[] A) {
	        if (A == null || A.length == 0)
	            return 0;
        return maxArea(A, 0, A.length - 1);
       }

        public int maxArea(int[] A, int l, int r) {
	        if (l == r)
	            return A[l];
	        int m = l + (r - l) / 2;
	        int area = maxArea(A, l, m);
	        area = Math.max(area, maxArea(A, m + 1, r));
	        area = Math.max(area, maxCombineArea(A, l, m, r));
	        return area;
       }

       public int maxCombineArea(int[] A, int l, int m, int r) {
        int i = m, j = m + 1;
        int area = 0, h = Math.min(A[i], A[j]);
        while (i >= l && j <= r) {
            h = Math.min(h, Math.min(A[i], A[j]));
            area = Math.max(area, (j - i + 1) * h);
            if (i == l)
                ++j;
            else if (j == r)
                --i;
            else {
                if (A[i - 1] > A[j + 1])
                    --i;
                else
                    ++j;
            }
        }
        return area;
    }
}