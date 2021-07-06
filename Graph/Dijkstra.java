import java.util.*;
class Dijkstra {
  
  public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    int[] dist = new int[edges.length];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    pq.offer(new int[]{start, 0});

    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int curNode = cur[0];
      int curDist = cur[1];

      for(int[] edge:edges[curNode]){
        int tarNode = edge[0];
        int tarDist = edge[1];

        int newDist = curDist + tarDist;
        if(newDist < dist[tarNode]){
          dist[tarNode] = newDist;
          pq.offer(new int[]{tarNode, newDist});
        }
      }
    }

    for(int i=0; i<dist.length; i++){
      if(dist[i] == Integer.MAX_VALUE){
        dist[i] = -1;
      }
    }

    return dist;
		
  }

	public static void main(String[] args) {
    int start = 0;
    int[][][] edges = {
    {{1,7}},
    {{2,6},{3,20},{4,3}},
    {{3,14}},
    {{4,2}},
    {},
    {}
    };
    
    int[] ans = dijkstrasAlgorithm(start, edges);
    System.out.println(Arrays.toString(ans));
  }
}