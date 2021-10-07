class BinarySearch {
	
	public static int binarySearch(int[] A, int target) {
		int left = 0, right = A.length-1;

		while(left <= right) {

			//To avoid overflow
			int mid = (right + (right-left))/2;

			if(target == A[mid]) {
				return mid;
			} else if (target < A[mid]) {
				right = mid-1;
			} else {
				left = mid+1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 2, 5, 6, 8, 9, 10, 12, 14 };
		int target = 6;

		System.out.println(binarySearch(A, target));

		target = 23;
		System.out.println(binarySearch(A, target));
	}
}