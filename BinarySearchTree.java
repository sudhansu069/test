import java.util.*;


public class BinarySearchTree{

 private TreeNode root;



 public static void main(String[] args) {
 	
 	  BinarySearchTree bst = new BinarySearchTree();

 	   bst.insert(5);
 	   bst.insert(3);
 	   bst.insert(2);
 	   bst.insert(4);
 	   bst.insert(8);
 	   bst.insert(6);


 	  List<Integer> preorder = bst.serializeBST(bst.root);
 	  TreeNode newRoot = bst.deserializeBst(preorder);

 	 bst.inorderTraversal(newRoot);
 
 	  
 }

   public TreeNode deserializeBst(List<Integer> preorder){

   	    return deserializeBstHelper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
   }

   private TreeNode deserializeBstHelper(List<Integer> preorder,int min,int max){


   	      if(index >= preorder.size()) return null;

   	      TreeNode root = null;

   	      if(preorder.get(index) > min && preorder.get(index) < max){

   	      	  root = new TreeNode(preorder.get(index));
   	      	  index++;
   	      	  root.left =  deserializeBstHelper(preorder,min,root.key);
   	      	  root.right =  deserializeBstHelper(preorder,root.key,max);
   	      }

   	      return root;
   }
   
   /**
    * Serilize a BST
    */
   public List<Integer>serializeBST(TreeNode root){


   	    List<Integer> result = new ArrayList<>();
   	    serializeBSTHelper(root,result);
   	    return result;


   }

   private void serializeBSTHelper(TreeNode root,List<Integer> result){

      if(root == null) return;

      result.add(root.key);
      serializeBSTHelper(root.left,result);
      serializeBSTHelper(root.right,result);

   }

   /**
    * Given the preorder Traversal of the Binary Tree . Construct the Binary Tree out of it
    */

   int index  = 0;
   public TreeNode deserialize(List<Integer> preorder){

       if(index == preorder.size() || preorder.get(index) == Integer.MIN_VALUE){

       	   index++;
       	   return null;
       }

       TreeNode root = new TreeNode(preorder.get(index));
       index++;

       root.left = deserialize(preorder);
       root.right =  deserialize(preorder);
       return root;

   }
   
   /**
    * Given a Binary Tree . Serilize it.
    * Approach - Use Preorder Traversal
    */
   public List<Integer> serializeBinaryTree(TreeNode root){


   	  List<Integer> result = new ArrayList<>();
   	  serializeBinaryTreeHelper(root,result);
   	  return result;

   }

   private void serializeBinaryTreeHelper(TreeNode root,List<Integer> result){

   	  if(root == null){

   	  	 result.add(Integer.MIN_VALUE);
   	  	 return;
   	  }

   	  result.add(root.key);
   	  serializeBinaryTreeHelper(root.left,result);
   	  serializeBinaryTreeHelper(root.right,result);

   }

   /**
    * Given two Binary Tree . Check if they are same tree
    */
   public boolean isSameTree(TreeNode root1,TreeNode root2){

   	  if(root1 == null && root2 == null) return true;

   	  if(root1 == null || root2 == null) return false;

   	  if(root1.key == root2.key){

         return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
   	  }else{

   	  	return false;
   	  }
   }

   private TreeNode firstElement = null;
   private TreeNode secondElement = null;
   private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
   /**
    * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    */
   public void recoverBinarySearchTree(TreeNode root){

       traverse(root);

       if(firstElement != null && secondElement != null){

       	  int temp = firstElement.key;
       	  firstElement.key = secondElement.key;
       	  secondElement.key = temp;
       }

   }

   private void traverse(TreeNode root){

   	  if(root == null) return ;

   	  traverse(root.left);

      if(firstElement == null && prev.key >= root.key){

      	firstElement =  prev;
      }

      if(firstElement != null && prev.key >= root.key){

      	 secondElement = root;
      }

      prev = root;
      
   	  traverse(root.right);


   }
 
  /**
   * Given a Binary Tree . Find the Max Depth of the Binary Tree .
   */
  public int maxDepth(TreeNode root){


  	  if(root == null) return 0;

  	  int left = maxDepth(root.left);
  	  int right = maxDepth(root.right);

  	  return 1 + Math.max(left,right);
  }
  
  /**
   * Given a Bianry Tree . Find all the paths from root to the leaves.
   * Appraoch - Backtracking 
   */
  public List<List<Integer>> findAllRootToLeafPaths(TreeNode root){

  	  List<List<Integer>> result = new ArrayList<>();
  	  List<Integer> current = new ArrayList<>();

  	  findAllRootToLeafPathsHelper(root,result,current);
  	  return result;
  }

  private void findAllRootToLeafPathsHelper(TreeNode root,List<List<Integer>> result,List<Integer> current){

  	   if(root == null) return;

  	   current.add(root.key);

  	   if(root.left == null && root.right == null){

  	   	  result.add(new ArrayList<>(current));
  	   	  current.remove(current.size()-1);
  	   	  return;
  	   }else{

  	   	  findAllRootToLeafPathsHelper(root.left,result,current);
  	   	  findAllRootToLeafPathsHelper(root.right,result,current);
  	   }

  	   current.remove(current.size()-1);


  }

  private int goal;
  double min = Double.MAX_VALUE;
  /**
   *  Given a Binary Search Tree  and target value . Find the key in BST whihc is closest to target 
   */
  public int closestKeyInBst(TreeNode root,int target){         
        
        closestKeyInBstHelper(root,target);
        return goal;

  }

  private void closestKeyInBstHelper(TreeNode root,int target){

      if(root == null) return;

      if(Math.abs(root.key - target) < min){

      	  min = Math.abs(root.key - target);
      	  goal = root.key;
      }

      if(target < root.key){

      	  closestKeyInBstHelper(root.left,target);
      }
      else{
      
          closestKeyInBstHelper(root.right,target);
      }
  }
  
  /**
   * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
   */
  public int sumNumbers(TreeNode root){

        return sumNumbersHelper(root,0);

  }

  private int sumNumbersHelper(TreeNode root,int sum){

  	  if(root == null) return sum;

  	  if(root.left == null && root.right == null){

  	  	return sum*10+root.key;
  	  }

  	  return sumNumbersHelper(root.left,root.key+sum*10)+sumNumbersHelper(root.right,root.key+sum*10);
  }

 /**
  * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. .
  * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
  * https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
  */
 public void connect(TreeNode root){

    
       Queue<TreeNode> queue = new LinkedList<>();

       queue.offer(root);
       queue.offer(null);

       while(!queue.isEmpty()){

       	  TreeNode p = queue.poll();
       	  if(p != null){

       	  	  p.next = queue.peek();

       	  	  if(p.left != null)queue.offer(p.left); 

       	      if(p.right != null) queue.offer(p.right);
       	  }
       	  else if(!queue.isEmpty()){

       	  	  queue.offer(null);
       	  }

       	  

       }
 }
 

 /**
  * Given the Binary Preorder Traversal of a Binary Search Tree. check if the preorder is valid
  * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
  */
 public boolean verifyPreorderSerilizationOfBinaryTree(int[] preorder){

     Stack<Integer> stack = new Stack<>();

     int min = Integer.MIN_VALUE;

     for(int i = 0;i<preorder.length;i++){

     	  if(preorder[i] < min)return false;

     	  while(!stack.isEmpty() && stack.peek() < preorder[i]){

     	  	 min =  stack.pop();
     	  }

     	  stack.push(preorder[i]);
     }

     return true;

 }

 /**
  * Given A Bianry Tree . Find the LCA .
  * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
  */
 public TreeNode lCAOfBinaryTree(TreeNode root,TreeNode p,TreeNode q){


     if (root == null || root == p || root == q) return root;

     TreeNode left = lCAOfBinaryTree(root.left, p, q);
     TreeNode right = lCAOfBinaryTree(root.right, p, q);

     return left == null ? right : right == null ? left : root;
 }
  

  /**
   * Given A Binary Search Tree and two nodes in the BST . Find loweset common Ancestor of both the
   * nodes .
   * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
   */
  public TreeNode findLCAOfBST(TreeNode root,TreeNode A,TreeNode B){

     if(A.key < root.key && B.key < root.key)
        return findLCAOfBST(root.left,A,B);
     
     if(A.key > root.key && B.key > root.key) 
      return findLCAOfBST(root.right,A,B);

     return root;

      

  }
 
 /**
  * Given A Bianry Tree . Find its left Side View .
  */ 
 public List<Integer> leftSideView(TreeNode root){


 	  List<Integer> result = new ArrayList<>();
 	  Queue<TreeNode> queue = new LinkedList<>();

 	  queue.offer(root);

 	  while(!queue.isEmpty()){

 	  	  int size = queue.size();

 	  	  for(int i = 0;i<size;i++){

            TreeNode node = queue.poll();
 	  	  	if(i == 0){

              result.add(node.key);
 	  	  	}
            if(node.left != null) queue.offer(node.left);
 	  	  	if(node.right != null) queue.offer(node.right);
 	  	  	
 	  	  }
 	  } 

 	  return result;
 } 

 /**
  * Given A Binary Tree . Find its Right Side view .
  * https://leetcode.com/problems/binary-tree-right-side-view/description/
  */
 public List<Integer> rightSideView(TreeNode root){


 	  List<Integer> result = new ArrayList<>();
 	  Queue<TreeNode> queue = new LinkedList<>();

 	  queue.offer(root);

 	  while(!queue.isEmpty()){

 	  	  int size = queue.size();

 	  	  for(int i = 0;i<size;i++){

            TreeNode node = queue.poll();
 	  	  	if(i == 0){

              result.add(node.key);
 	  	  	}

 	  	  	if(node.right != null) queue.offer(node.right);
 	  	  	if(node.left != null) queue.offer(node.left);
 	  	  }
 	  } 

 	  return result;
 }






 /**
 * Given A Binarytree . Check if it is mirror of itself .
 * https://leetcode.com/problems/symmetric-tree/description/
 */
 public boolean isSymmetric(TreeNode root){

 	 if(root == null || isSymmetricHelp(root.left,root.right))
 	 	return true;
 	 return false;
 }

 private boolean isSymmetricHelp(TreeNode left ,TreeNode right){


 	  if(left == null || right == null){

 	  	   return left == right;
 	  }

 	  if(left.key != right.key)return false;

 	  return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
 }

 /**
 * Implement a BST Iterator which has two APIs next() and hasNext()
 * where next() will return the next smallest element and hasNext() will say whether there is any more elements.
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
  static class BSTIterative{

  	  Stack<TreeNode> stack ;

  	  public BSTIterative(TreeNode root){

  	  	  stack = new Stack<>();

  	  	  while(root != null){

  	  	  	 stack.push(root);
  	  	  	 root = root.left;
  	  	  }
  	  }

  	  public boolean hasNext(){

  	  	  return !stack.isEmpty();
  	  }

  	  public int next(){

  	  	  TreeNode node = stack.pop();
  	  	  int result = node.key;

  	  	  if(node.right != null){

  	  	  	  node = node.right;

  	  	  	  while(node != null){

  	  	  	  	stack.push(node);
  	  	  	  	node = node.left;
  	  	  	  }
  	  	  }

  	  	  return result;
  	  }

  }

 
  

  /**
  * Given a Binary Tree . Check if its Height Balanced .
  */ 
  public boolean isBalancedTree(TreeNode root){

  	  if(root == null) return true;

  	  if(getHeight(root) == -1) return false;

  	  return true;
  }

  private int getHeight(TreeNode root){

  	  if(root == null) return 0;

  	  int left = getHeight(root.left);
  	  int right = getHeight(root.right);

  	  if(left == -1 || right == -1) return -1;

  	  if(Math.abs(left - right) > 1) return -1;

  	  return Math.max(left,right)+1;




  }
  /**
  * Find the maximum sum path in a binary tree . The path can start at any node
  */
  public int maxPathSum(TreeNode root){


      int[] max = new int[1];

      max[0] = Integer.MIN_VALUE;

      calculateSum(root,max);

      return max[0];


  }


  private int calculateSum(TreeNode root,int[] max){

  	  if(root == null) return Integer.MIN_VALUE;

  	  int left = calculateSum(root.left,max);
  	  int right =  calculateSum(root.right,max);

  	  int current = Math.max(root.key,Math.max(root.key+left,root.key+right));

  	  max[0] = Math.max(max[0],Math.max(current,root.key+left+right));
  	  return max[0];
  } 

 /**
 * Find the Min Depth Of a Binary Tree
 * Use Two Queue.
 * Run Time = O(n), Space = O(n)
 *
 */
 public int findMinDepth(TreeNode root){


 	 if(root == null) return 0;

 	 Queue<TreeNode> nodes = new LinkedList<>();
 	 Queue<Integer> depths = new LinkedList<>();

 	 nodes.offer(root);
 	 depths.offer(1);

 	 while(!nodes.isEmpty()){


 	 	  TreeNode current = nodes.poll();

 	 	  int currDepth = depths.poll();

 	 	  if(current.left == null) return currDepth;

 	 	  if(current.left != null){

 	 	  	  nodes.offer(current.left);
 	 	  	  depths.offer(currDepth+1);
 	 	  }

 	 	  if(current.right != null){

 	 	  	  nodes.offer(current.right);
 	 	  	  depths.offer(currDepth+1);
 	 	  }
 	 }

 	 return 0;
 }



 public TreeNode sortedListToBst(ListNode head){

 	 return toBst(head,null);
 }

 private TreeNode toBst(ListNode head,ListNode tail){

 	  if(head == tail ) return null;

 	  ListNode slow  = head;
 	  ListNode fast = head;

 	  while(fast != tail && fast.next != tail){

 	  	  slow  = slow.next;
 	  	  fast = fast.next.next;
 	  }

 	  TreeNode root = new TreeNode(slow.key);

 	  root.left = toBst(head,slow);
 	  root.right = toBst(slow.next,tail);

 	  return root;


 }

 public TreeNode buildTreeFromInorderAndPre(int[] inorder,int [] preorder){


 	  int inStart = 0;
 	  int inEnd = inorder.length-1;

 	  int preStart =  0;
 	  int preEnd = preorder.length-1;

 	  TreeNode root = buildTreeFromInorderAndPreorderHelper(inorder,inStart,inEnd,preorder,preStart,preEnd);
      return root;
 }


 public TreeNode sortedArrayToBalancedBST(int[] arr){


 	  return buildBalancedBST(arr,0,arr.length-1);
 }

 private TreeNode buildBalancedBST(int[] arr,int start,int end){

 	 if(start > end) return null;

 	 int mid = (start+end)/2;

 	 TreeNode root = new TreeNode(arr[mid]);
 	 root.left = buildBalancedBST(arr,start,mid-1);
 	 root.right = buildBalancedBST(arr,mid+1,end);
 	 return root;
 }


 private TreeNode buildTreeFromInorderAndPreorderHelper(int[] inorder,int inStart,int inEnd,int[] preorder,int preStart,int preEnd){


 	if(inStart > inEnd || preStart > preEnd) return null;

 	TreeNode root = new TreeNode(preorder[preStart]);

 	int index =  -1;

 	for(int i = inStart;i<= inEnd;i++){

 		if(inorder[i] == preorder[preStart]){
 			index = i;
 			break;
 		}
 	}


 	int leftLength = index - inStart;

 	root.left = buildTreeFromInorderAndPreorderHelper(inorder,inStart,index-1,preorder,preStart+1,preStart+leftLength);
 	root.right = buildTreeFromInorderAndPreorderHelper(inorder,index+1,inEnd,preorder,preStart+leftLength+1,preEnd);

 	return root;
 }
 
 /**
 * Construct the Binary tree when the Inorder and Post order traversla are provided
 * Recusrive Approach.
 */
 public TreeNode  buildTreeFromInorderAndPost(int[] inorder,int[] postorder){

 	  int inStart = 0;
 	  int inEnd = inorder.length-1;

 	  int postStart =  0;
 	  int postEnd = postorder.length-1;

 	  TreeNode root = buildTreeFromInorderAndPostHelper(inorder,inStart,inEnd,postorder,postStart,postEnd);
      return root;

 }

 private TreeNode buildTreeFromInorderAndPostHelper(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){


 	  if(inStart >  inEnd || postStart > postEnd) return null;

 	  TreeNode root = new TreeNode(postorder[postEnd]);

 	  int index =  -1;

 	  for(int i = inStart;i<= inEnd;i++){

 	  	if(inorder[i] == postorder[postEnd]){

 	  		index = i;
 	  		break;
 	  	}
 	  }

 	  int leftLength = index - inStart;

 	  root.left = buildTreeFromInorderAndPostHelper(inorder,inStart,index-1,postorder,postStart,postStart+leftLength-1);
 	  root.right = buildTreeFromInorderAndPostHelper(inorder,index+1,inEnd,postorder,postStart+leftLength,postEnd-1);

 	  return root;
 }
 /**
 * Find all the paths from the root to leaf 
 * Backtracking Approach
 */
 public List<List<Integer>> findAllRootToLeafPathsWithSum(TreeNode root,int sum){

 	  List<List<Integer>> result = new ArrayList<>();
 	  List<Integer> temp = new ArrayList<>();

 	  if(root != null){
 	  	 dfs(root,sum,result,temp);
 	  }

 	  return result;
 }

 private void dfs(TreeNode root,int sum,List<List<Integer>> result,List<Integer> temp){

 	 if(root == null) return;

 	 temp.add(root.key);

 	 if(root.left == null && root.right == null && root.key == sum){

 	 	 
 	 	result.add(new ArrayList<>(temp));
 	 	temp.remove(temp.size()-1);

 	 	return;

 	 }else{

 	 	  dfs(root.left,sum-root.key,result,temp);
 	 	  dfs(root.right,sum-root.key,result,temp);
 	 }

 	 temp.remove(temp.size()-1);

 }

 /**
 *  Check if the Binary tree has the root to leaf path sum with the given sum
 *  Iterative Approach
 */
 public boolean hasPathSum2(TreeNode root,int sum){

 	 Queue<TreeNode> nodes = new LinkedList<>();
 	 Queue<Integer> values = new LinkedList<>();

 	 nodes.offer(root);
 	 values.offer(root.key);

 	 while(!nodes.isEmpty()){

 	 	 TreeNode node = nodes.poll();
 	 	 int currSum = values.poll();

 	 	 if(node.left == null && node.right == null && currSum == sum)return true;

 	 	 if(node.left != null){
 	 	 	nodes.offer(node.left);
 	 	 	values.offer(currSum+node.left.key);
 	 	 }

 	 	 if(node.right != null){
 	 	 	nodes.offer(node.right);
 	 	 	values.offer(currSum+node.right.key);
 	 	 }
 	 }
 	 return false;
 }

 /**
 * Check if the Binary tree has the root to leaf path sum with the given sum
 * Recursive Approach
 */
 public boolean hasPathSum(TreeNode root,int sum){

 	  if(root == null) return false;

 	  if(root.key == sum && root.left == null && root.right == null) return true;

 	  return hasPathSum(root.left,sum-root.key) || hasPathSum(root.right,sum-root.key);
 }
 

 /**
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
 public void flatten(TreeNode root) { 

   TreeNode cur = root;  
   Stack<TreeNode> rtrees = new Stack<TreeNode>();  
 
   while (cur != null) {  
 
     if (cur.left != null) {

       if (cur.right != null) rtrees.push(cur.right);  
       cur.right = cur.left;  
       cur.left = null;  
     }  
     if (cur.right == null && !rtrees.isEmpty()) {  
       cur.right = rtrees.pop();  
     }  
     cur = cur.right;  
   }  
 }  
  
  /**
  * Given  a Binary Tree . Check if the Tree is a BST or not
  * Idea : Do Inorder Traversal Using Iterative Approach and check if any where the prev >= curr
  * Run Time : O(n)
  * Space : O(n)
  */ 
  public boolean isValidBST(TreeNode root){

  	  if(root == null) return true;

  	  Stack<TreeNode> stack = new Stack<>();

  	  TreeNode prev  = null;

  	  while(root != null || !stack.isEmpty()){

  	  	  while(root != null){

  	  	  	stack.push(root);
  	  	  	root = root.left;
  	  	  }

  	  	  root = stack.pop();

  	  	  if(prev != null && prev.key >= root.key) return false;

  	  	  prev = root;
  	  	  root = root.right;
  	  }

  	  return true;
  }

 /**
 * Find the longest Consecutive nodes
 */
 public int longestConsecutive(TreeNode root) {
        return recursiveHelper(root, null, 0);
    }

     private int recursiveHelper(TreeNode curr, TreeNode parent, int depth) {
    	
    	if (curr == null) {
    		return 0;
    	} 
    	
    	int currDepth = 0;
    	
    	if (parent != null && parent.key + 1 == curr.key) {
    		currDepth = depth + 1;
    	} else {
    		currDepth = 1;
    	}
    	return Math.max(currDepth, Math.max(recursiveHelper(curr.left, curr, currDepth), recursiveHelper(curr.right, curr, currDepth)));
    }



 /**
 *  Given  a BST  . Find the kth Smallest Element in the bst.
 *  Just Do Inorder Traversal Using Stack and while doing so keep track of the count ,
 *  Run Time : O(n)
 *  Space :O(n)
 */


 public int kthSmallest(TreeNode root,int k){

 	  Stack<TreeNode> stack = new Stack<>();

 	  TreeNode temp = root;

 	  int count = 0;

 	  while(temp != null || !stack.isEmpty()){

 	  	  while(temp != null){

 	  	  	 stack.push(temp);
 	  	  	 temp = temp.left;
 	  	  }

 	  	  TreeNode node = stack.pop();
 	  	  temp = node.right;
 	  	  count++;

 	  	  if(count == k) return node.key;
 	  }

 	  return -1;
 }



 /**
 * Invert A Binary Tree . When we say Invert, we are actually doing the mirror of the tree
 */
 public TreeNode invertTree(TreeNode root){

 	  if(root == null) return null;

 	  Queue<TreeNode> queue = new LinkedList<>();

 	  queue.offer(root);

 	  while(!queue.isEmpty()){


 	  	  TreeNode node = queue.poll();

 	  	  if(node.left != null){

 	  	  	  queue.offer(node.left);
 	  	  }

 	  	  if(node.right != null){

 	  	  	 queue.offer(node.right);
 	  	  }

 	  	  TreeNode temp = node.left;
 	  	  node.left = node.right;
 	  	  node.right = temp;
 	  }

 	  return root;
 }
 /**
  * Post Order Traversal using Stack
  **/
 public void postorderTraversal(TreeNode root){

 	  if(root == null) return;

 	  Stack<TreeNode> stack = new Stack<>();

 	  stack.push(root);

 	  while(!stack.isEmpty()){

 	  	  TreeNode temp = stack.peek();

 	  	  if(temp.left == null && temp.right == null){

 	  	  	  stack.pop();

 	  	  	  System.out.print(temp.key+" ");
 	  	  }else{

 	  	  	 if(temp.right != null){

 	  	  	 	stack.push(temp.right);
 	  	  	 	temp.right = null;
 	  	  	 }

 	  	  	 if(temp.left != null){

 	  	  	 	stack.push(temp.left);
 	  	  	 	temp.left = null;
 	  	  	 }
 	  	  }
 	  }
 }


 /**
  * Inorder Traversal using Stack
  */
 public void inorderTraversal(TreeNode root){


 	  if(root == null) return;

 	  Stack<TreeNode> stack = new Stack<>();

 	  TreeNode temp = root;

 	  while(temp != null || !stack.isEmpty()){

 	  	  while(temp != null){

 	  	  	  stack.push(temp);
 	  	  	  temp  = temp.left;
 	  	  }

 	  	  TreeNode node = stack.pop();
 	  	  System.out.print(node.key+" ");
 	  	  temp = node.right;
 	  }


 }

/**
 * Pre Order Traversal using Stack
 */
 public void preOrderTraversal(TreeNode root){

    if(root == null) return ;
    Stack<TreeNode> stack = new Stack<>();
    
    stack.push(root);

    while(!stack.isEmpty()){

    	TreeNode n = stack.pop();

    	System.out.print(n.key+" ");

    	if(n.right != null) stack.push(n.right);
    	if(n.left != null) stack.push(n.left);
    }
 }

 /**
 *  Insert  A Key into Binary Search Tree
 *  Approach : Iterative Approach
 *  Run Time : O(n)
 *  Space : O(1)
 */
 public void insert(int key){

 	  if(root == null){

 	  	 root = new TreeNode(key);
 	  	 return;
 	  }

 	  TreeNode curr = root;


 	   while(true){

          if(key > curr.key){

          	  if(curr.right == null){

          	  	  curr.right = new TreeNode(key);
          	  	  break;
          	  }else{

          	  	 curr = curr.right;
          	  }
          }else{

          	  if(curr.left == null){

          	  	 curr.left =  new TreeNode(key);
          	  	 break;
          	  }else{

          	  	  curr = curr.left;
          	  }
          }
 	   }
 }

 static class ListNode{

 	  int key;

 	  ListNode next;

 	  public ListNode(int key){

 	  	 this.key = key;
 	  }
 }
	

  static class TreeNode{

  	  int key;
  	  TreeNode left;
  	  TreeNode right;

  	  TreeNode next;

  	  public TreeNode(int key){

  	  	 this.key = key;
  	  }

  }
}