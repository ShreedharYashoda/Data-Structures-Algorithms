import java.util.*;

class BubbleSort {

	public static void bubbleSort(int[] A){
		int count = 0;
		for(int j=0; j<A.length; j++){
			
			for(int i=1; i<A.length-count; i++){
				if(A[i-1] > A[i]) {
					swap(A, i-1, i);
				}
			}
			count++;
		}
	}
	
	public static void main(String[] args){
		int[] A = {6, 3, -9, 1, 5, 7};
		bubbleSort(A);
		System.out.println(Arrays.toString(A));
	}

	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}