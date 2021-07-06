import java.util.*;
class CanSum {
  public static void main(String[] args) {
    System.out.println(canSum(7, new int[]{2,3}));
		System.out.println(tabulate(17, new int[]{2,3,4}));
		System.out.println(tabulate(300, new int[]{7,14}));
  }

  // O(n^m)  O(m) n-> length of array, m-target
  public static boolean canSum(int target, int[] candidates){
    if(target == 0) return true;
		if(target < 0) return false;

    // boolean isPossible = false;
    for(int cand:candidates){
        if(canSum(target-cand, candidates)){
					return true;
				}
    }
      
    return false;
  }

	// O(mn) O(m)
  public static boolean tabulate(int target, int[] candidates){
    boolean[] dp = new boolean[target+1];
		Arrays.fill(dp, false);
		dp[0] = true;
		// System.out.println(Arrays.toString(dp));

		for(int i=0; i<=target; i++){
			if(dp[i] == true){
				for(int cand:candidates){
					if(i+cand <= target){
						dp[i+cand] = true;
					}
				}
			}
			
		}
		// System.out.println(Arrays.toString(dp));
    return dp[target];
  }
}