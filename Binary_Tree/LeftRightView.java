import java.util.*;
class LeftRightView {
  public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.right = new Node(9);
		root.left.right = new Node(6);
		root.right.right = new Node(5);
		root.right.left = new Node(7);
		root.right.left.right = new Node(8);
		/*
		             1
							2     3
					  4   6  7  5
						 9      8
		*/

		List<Integer> res = new ArrayList<>();
		View instance = new View();
		instance.leftView(root, 1, res);

		System.out.println(res);

		Collections.reverse(res);
		instance.maxLevel = 0;
		instance.rightView(root.right, 1, res);
		System.out.println(res);

  }

	static class View{
		int maxLevel = 0;

		public void leftView(Node root, int level, List<Integer> res){
			if(root == null) return;

			if(maxLevel < level){
				res.add(root.data);
				maxLevel = level;
			}

			leftView(root.left, level+1, res);
			leftView(root.right, level+1, res);
		}

		public void rightView(Node root, int level, List<Integer> res){
			if(root == null) return;

			if(maxLevel < level){
				res.add(root.data);
				maxLevel = level;
			}

			rightView(root.right, level+1, res);
			rightView(root.left, level+1, res);
		}
		
	}
	

	static class Node{
		int data;
		Node left, right;

		public Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}


}