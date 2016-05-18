class ModifiedBinarySearch {

	public static boolean doOrdinaryBinarySearch(int arr[], int first, int last, int key) {
		if (first > last) {
			return false;
		}
		int mid = (first + last)/2;
		if (key == arr[mid]) {
			return true;
		} else if (key > arr[mid]) {
			return doOrdinaryBinarySearch(arr, mid+1, last, key);
		} else {
			return doOrdinaryBinarySearch(arr, first, mid-1, key);
		}
	}

	public static int getPivot(int arr[], int first, int last) {
		if (first > last) {
			return -1;
		}

		int mid = (first + last)/2;
		if (first < mid && arr[mid] < arr[first]) {
			return first;
		} else if (last > mid && arr[mid] > arr[last]){
			return mid;
		} else if (arr[first] < arr[mid]) {
			return getPivot(arr, mid+1, last);
		} else {
			return getPivot(arr, first, mid-1);
		}
	}

	public static void main(String[] args) {
		int arr[] = {2,3,4,5,6,7,8,1};
		System.out.println(getPivot(arr, 0, arr.length - 1));
	}
}