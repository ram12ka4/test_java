package in.rambasak;

public class ArraySum {

	public static int subArraySum(int arr[], int n, int sum) {

		int curr_sum = arr[0], start = 0, end;

		// Pick a starting point
		for (end = 1; end < n; end++) {

			// If curr_sum exceeds given sum then remove the starting element
			while (curr_sum > sum && start < end - 1) { 

				curr_sum -= arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				int p = end - 1;
				System.out.println("Sum found between indexes " + start + " and " + p);
				return 1;
			}

			if (end < n) {
				curr_sum += arr[end];
			}
		}

		System.out.println("No subarray found");
		return 0;
	}

// Running time of this algo is O(n)
	public static boolean isSubSum1(int arr[], int n, int sum) {

		int curr_sum = arr[0], s = 0;

		for (int e = 1; e < n; e++) {
			// clean the previous window
			while (curr_sum > sum && s < e - 1) {
				curr_sum -= arr[s];
				s++;
			}
			if (curr_sum == sum) {
				return true;
			}
			if (e < n) {
				curr_sum += arr[e];
			}
		}
		return (curr_sum == sum);
	}

	// Running time of this algo is O(n * n)
	public static boolean isSubSum(int arr[], int n, int sum) {
		for (int i = 0; i < n; i++) {
			int curr_sum = 0;
			for (int j = i; j < n; j++) {
				curr_sum += arr[j];

				if (curr_sum == sum) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 4, 20, 3, 10, 15 };
		int[] arr1 = { 4, 7, 3, 1, 2 };
		int k = 33;
		int l = 9;
		int n = arr.length;
		int m = arr1.length;
		System.out.println(isSubSum(arr, n, k));
		System.out.println(isSubSum1(arr1, m, l));
		System.out.println(subArraySum(arr, n, k));

	}

}
