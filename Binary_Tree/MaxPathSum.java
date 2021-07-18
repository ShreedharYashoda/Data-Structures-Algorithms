// Leetcode 124

class MaxPathSum {

	static class Solution{
		int max = 0;
		public int getMaxPathSum(Node root){
			if(root == null){
				return 0;
			}

			int left = Math.max(getMaxPathSum(root.left), 0);
			int right = Math.max(getMaxPathSum(root.right), 0);

			max = Math.max(max, left + right + root.val);

			return Math.max(left, right) + root.val;

		}

	}
	

  public static void main(String[] args) {
			/* Construct the following tree
                  1
               /    \
              2      3
               \    / \
               -4  5   6
								  /\
								 7  8
        */
    		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(-4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

				Solution sol = new Solution();
				sol.getMaxPathSum(root);
				System.out.println("Max path sum is " + sol.max);
  }

	static class Node{
		int val;
		Node left , right;

		Node(int val){
			this.val = val;
		}
	}

}