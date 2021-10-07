import java.util.*;

class BinarySearch {

	public int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            // System.out.println("left "+left+" right "+right+" mid " +mid);
            if(nums[mid] == target) return nums[mid];
            
            if(nums[mid] < target) {
                left = mid + 1;
            } 
            
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        
        return -1; 
	}

	public int binSearchFloorEntry(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int floor = 0;

		while(left <= right) {
			int mid = (left+right)/2;
      // System.out.println("left "+left+" right "+right+" mid " +mid);

			if(nums[mid] <= target) {
				left = mid + 1;
				floor = mid;
			}

			if(nums[mid] > target) {
				right = mid-1;
			}
		}

		return nums[floor];
	}

	public int binSearchCielEntry(int[] nums, int target) {
		int left =0, right = nums.length - 1;
		int ceil = right;

		while(left <= right) {
			int mid = (left+right)/2;

			if(nums[mid] >= target) {
				right = mid - 1;
				ceil = mid;
			}

			if(nums[mid] < target) {
				left = mid + 1;
			}
		}

		return nums[ceil];
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(new int[]{-1,0,3,5,9,12}, 9));
		System.out.println(bs.binarySearch(new int[]{-1,0,3,5,9,12}, 2));
		System.out.println();
		System.out.println(bs.binSearchFloorEntry(new int[]{-1,0,3,5,9,12}, 9));
		System.out.println(bs.binSearchFloorEntry(new int[]{-1,0,3,5,9,12}, 2));
		System.out.println(bs.binSearchFloorEntry(new int[]{-1,0,3,5,9,12}, 7));
		System.out.println();
		System.out.println(bs.binSearchCielEntry(new int[]{-1,0,3,5,9,12}, 9));
		System.out.println(bs.binSearchCielEntry(new int[]{-1,0,3,5,9,12}, 2));
		System.out.println(bs.binSearchCielEntry(new int[]{-1,0,3,5,9,12}, 7));
	}
}