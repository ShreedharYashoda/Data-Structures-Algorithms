import java.util.*;
class KeysAndRooms{

	public static boolean canVisitAllRooms(int[][] rooms) {
        
		Set<Integer> seen = new HashSet<>();
		dfs(0, seen, rooms);
		return seen.size() == rooms.length;
	}

	public static void dfs(int node, Set<Integer> seen, int[][] rooms){
		if(seen.contains(node)) return;
		seen.add(node);
		for(int nbr:rooms[node]){
			dfs(nbr, seen, rooms);
		}
	}


	public static void main(String[] args){
		int[][] rooms = {{1},{2},{3},{}};  //true
		int[][] rooms2 = {{1,3},{3,0,1},{2},{}}; //false

		System.out.println(canVisitAllRooms(rooms));
		System.out.println(canVisitAllRooms(rooms2));
	}


}