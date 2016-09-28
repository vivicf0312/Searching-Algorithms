public class LinearSearch {

	static int findIndex(int arr[], int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.print("Value found located at index: " + i);
				
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 8, 2, 6, 3, 5 };
		System.out.print("Array: " + java.util.Arrays.toString(arr));
		System.out.println(" ");
		findIndex(arr, 3);

	}

}
