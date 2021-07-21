import java.util.*;

class TopBottomView {

	public static void bottomView(Node root, int dist, int level, Map<Integer, Integer[]> map){
		if(root == null) return;

		if(!map.containsKey(dist) || level >= map.get(dist)[0]){
			map.put(dist, new Integer[]{level, root.val});
		}

		bottomView(root.left, dist-1, level+1, map);
		bottomView(root.right, dist+1, level+1, map);
	}

	public static void topView(Node root, int dist, int level, Map<Integer, Integer[]> map){
		if(root == null) return;

		if(!map.containsKey(dist) || level < map.get(dist)[0]){
			map.put(dist, new Integer[]{level, root.val});
		}

		topView(root.left, dist-1, level+1, map);
		topView(root.right, dist+1, level+1, map);
	}

	public static void main(String[] args) {
    /* Construct the following tree
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

		Map<Integer, Integer[]> map = new TreeMap<>();

		bottomView(root, 0, 0, map);

		for(Integer[] a:map.values()){
			System.out.print(a[1] + " ");
		}

		System.out.println();
		Map<Integer, Integer[]> map2 = new TreeMap<>();
		topView(root, 0, 0, map2);

		for(Integer[] a:map2.values()){
			System.out.print(a[1] + " ");
		}
  }

	static class Node{
		int val;
		Node left = null, right = null;

		Node(int val){
			this.val = val;
		}
	}
} 