//https://www.programcreek.com/2014/04/leetcode-range-sum-query-mutable-java/
public class SegmentTree{

	private TreeNode root;

	public static void main(String[] args) {
		
		int[] arr = {1 ,3 ,5, 7, 9 ,11};
         SegmentTree tree = new SegmentTree(arr);

         System.out.println(tree.getSum(tree.root,1,3));
		 

	}

	public SegmentTree(int[] arr){

       root = createSegTree(arr,0,arr.length-1);
	}


	public TreeNode createSegTree(int [] arr, int low,int high){

         
            if(low == high){

            	 TreeNode temp = new TreeNode(arr[low],low);
            	 return temp;
            }

            int mid = low + (high-low)/2;

            TreeNode root = new TreeNode();
            root.left = createSegTree(arr,low,mid);
            root.right = createSegTree(arr,mid+1,high);

            root.low = root.left.low;
	        root.high = root.right.high;
	        root.val = root.left.val + root.right.val;

	        return root;
	}

	public int getSum(TreeNode root,int ql,int qh){

		if(ql <= root.low && qh >= root.high)
		   return root.val;
	 
		if(qh<root.low || ql>root.high)
		  return 0;
 
	    return getSum(root.left,ql,qh)+getSum(root.right,ql,qh);
    }


  public void update(TreeNode root,int ind,int diff){

	if(root == null)
	  return ;

	if(ind < root.low || ind > root.high)
	   return ;
 
	else if(ind >= root.low && ind <= root.high)
	{
		root.val += diff;
	}
	update(root.left,ind,diff);
	update(root.right,ind,diff);
}

    static class TreeNode{

    	 int low,high,val;

    	 TreeNode left;
    	 TreeNode right;

    	 public TreeNode(){


    	 }

    	 public TreeNode(int x,int index){

             val = x ;
             low = index;
             high = index;
    	 }


    }
}