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

	public int binSearchOfRange(int[] nums, int target) {
		int left = 0, right = nums.length-1;

		if (target < 1 || target > nums[right]) return -1;

		while(left <= right) {
			int mid = (left+right)/2;

			if(mid == 0) return nums[mid];

			if(target <= nums[mid] && target > nums[mid-1]) {
				return nums[mid];
			} else if (target <= nums[mid-1]) {
				right = mid-1;
			} else if (target > nums[mid]){
				left = mid+1;
			}
		}

		return -1;
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
		System.out.println();
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 10}, 3));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 10}, 1));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 10}, 7));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 10}, 12));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 10}, 0));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 8, 12}, 3));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 8, 12}, 7));
		System.out.println(bs.binSearchOfRange(new int[]{2, 5, 8, 12}, 12));
	}
}