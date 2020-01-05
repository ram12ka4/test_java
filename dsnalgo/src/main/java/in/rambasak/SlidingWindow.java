package in.rambasak;

public class SlidingWindow {

	// Array = { 1, 8, 30, -5, 20, 7 };
	// 0 1 2 3 4 5

	// First I will show u the code with running time O((n-k)*k)
	public static int maxSumSubArr(int arr[], int k, int n) {

		int MAX_SUM = Integer.MIN_VALUE;

		for (int i = 0; i + k - 1 < n; i++) {
			int curr_sum = 0;

			for (int j = 0; j < k; j++) {
				curr_sum += arr[i + j];
			}
			MAX_SUM = Math.max(curr_sum, MAX_SUM);
		}

		return MAX_SUM;
	}

		
	public static int maxSumSubArr1(int[] arr, int k, int n) {

		int curr_sum = 0;

		for (int i = 0; i < k; i++) {
			curr_sum += arr[i];
		}

		int MAX_SUM = curr_sum;

		for (int j = k; j < n; j++) {
			curr_sum += (arr[j] - arr[j - k]);
			MAX_SUM = Math.max(curr_sum, MAX_SUM);
		}

		return MAX_SUM;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 8, 30, -5, 20, 7 };
		int k = 3;
		int n = arr.length;
		System.out.println(maxSumSubArr(arr, k, n));
		System.out.println(maxSumSubArr1(arr, k, n));
	}

}
