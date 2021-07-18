class Diameter {

	static class Solution{
		int maxDia = 0;
		public int getDiameter(Node root){
			if(root == null){
				return 0;
			}

			int left = getDiameter(root.left);
			int right = getDiameter(root.right);

			int dia = left + right + 1;
			maxDia = Math.max(maxDia, dia);

			return Math.max(left, right) + 1;

		}

	}
	

  public static void main(String[] args) {
			/* Construct the following tree
                 1
               /   \
              2     3
               \   / \
                4 5   6
								 /\
								7  8
        */
    		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

				Solution sol = new Solution();
				sol.getDiameter(root);
				System.out.println("Diameter is " + sol.maxDia);
  }

	static class Node{
		int val;
		Node left , right;

		Node(int val){
			this.val = val;
		}
	}

}