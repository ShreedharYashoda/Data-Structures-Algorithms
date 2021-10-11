// Lettcode 102 

import java.util.*;
class LevelOrderTraversal {
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

		System.out.println(levelOrder(root));
  }

	static class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();
		q.add(root);

		while(!q.isEmpty()){
			int size = q.size();
			List<Integer> sub = new LinkedList<>();

			for(int i=0; i<size; i++){
				TreeNode cur = q.poll();
				sub.add(cur.val);
				if(cur.left != null) q.add(cur.left);
				if(cur.right != null) q.add(cur.right);
			}

			ans.add(sub);
		}
		return ans;
	}


}