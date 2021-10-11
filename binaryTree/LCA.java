//Leetcode 236
class LCA {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if(root == null) return null;

			if(root.val == p.val || root.val == q.val) return root;
			
        
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);

			if(left == null){
				return right;
			}

			if(right == null){
				return left;
			}

			return root;
    }


  public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		/*
		             1
							2     3
					  4   6  7  5
						  9     8
		*/
    System.out.println(lowestCommonAncestor(root, root.right.left, root.right.right).val);
  }

	static class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
}