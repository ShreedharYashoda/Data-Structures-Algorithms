class MaxSumSubArray {

	// O(n) Doesn't handle all negative array.
	public static int maxSumSubArray(int[] A) {
		int maxSoFar = 0;
		int maxEndingHere = 0;

		for(int i:A){
			maxEndingHere += i;
			maxEndingHere = Integer.max(maxEndingHere, 0);
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	public static int maxSumSubArray2(int[] A) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;

		for(int i:A){
			maxEndingHere += i;
			maxEndingHere = Integer.max(maxEndingHere, i);
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	public static void main(String[] args){
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("MaxSumSubArray is " + maxSumSubArray2(A));

		int[] B = { -8, -3, -6, -2, -5, -4 };
		System.out.println("MaxSumSubArray is " + maxSumSubArray2(B));

	}
}