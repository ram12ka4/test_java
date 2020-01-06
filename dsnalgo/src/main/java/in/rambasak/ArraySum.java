package in.rambasak;

public class ArraySum {

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
		int k = 33;
		int n = arr.length;
		System.out.println(isSubSum(arr, n, k));
		System.out.println(isSubSum1(arr, n, k));

	}

}
