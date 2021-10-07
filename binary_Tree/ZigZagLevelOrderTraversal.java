import java.util.*;
class ZigZagLevelOrderTraversal {
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

		System.out.println(zigzagLevelOrder(root));
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        boolean odd = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> sublist = new LinkedList<Integer>();
            
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                
                if(odd) sublist.add(cur.val);
                else sublist.addFirst(cur.val);
            }
            
            list.add(sublist);
            odd = !odd;
        }
        
        return list;
        
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