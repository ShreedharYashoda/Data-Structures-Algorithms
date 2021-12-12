public class UnionFind {
	int[] root;

	public UnionFind(int size) {
		this.root = new int[size];

		for(int i=0; i<size; i++) {
			root[i] = i;
		}
	}

	public void union(int x, int y) {
		int rootx = this.find(x);
		int rooty = this.find(y);

		if (rootx != rooty) {
			root[rootx] = rooty;
		}
	}

	public int find(int x) {
		while(x != root[x]) {
			x = root[x];
		}

		return x;
	}	

	public boolean connected(int x, int y) {
		return this.find(x) == this.find(y);
	}


	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		// 1-2-5-6-7 3-8-9 4
    		uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
	}
}
