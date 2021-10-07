class MyHashMap{
		int[] map;

		public MyHashMap(){
			this.map = new int[11];
		}

		public void put(int key, int val){
			this.map[key] = val+1;
		}

		public int get(int key){
			return this.map[key]-1;
		}

		public void remove(int key){
			this.map[key] = 0;
		}

	public static void main(String[] args) {
    MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1); // The map is now [[1,1]]
		System.out.println(Arrays.toString(myHashMap.map));
		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
		System.out.println(Arrays.toString(myHashMap.map));
		System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
		myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
		System.out.println(Arrays.toString(myHashMap.map));
		System.out.println(myHashMap.get(2));     // return 1, The map is now [[1,1], [2,1]]
		myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
		System.out.println(Arrays.toString(myHashMap.map));
		System.out.println(myHashMap.get(2));     // return -1 (i.e., not found), The map is now [[1,1]]
  }

}