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

		if (first == last) {
			return first;
		}

		int mid = (first + last)/2;
		if (first < mid && arr[mid] < arr[mid-1]) {
			return mid-1;
		} else if (last > mid && arr[mid] > arr[mid+1]){
			return mid;
		} else if (arr[first] < arr[mid]) {
			return getPivot(arr, mid+1, last);
		} else {
			return getPivot(arr, first, mid-1);
		}
	}

	public static boolean doMBS(int arr[], int low, int high, int key) {
		int pivot = getPivot(arr, low, high);
		if (pivot == -1) {
			return doOrdinaryBinarySearch(arr, low, high, key);
		}

		if (arr[pivot] == key) {
			return true;
		}

		if (key >= arr[low]) {
			return doOrdinaryBinarySearch(arr, low, pivot-1, key);
		} else {
			return doOrdinaryBinarySearch(arr, pivot+1, high, key);
		}
	}


	public static void main(String[] args) {
		int arr[] = {2,3,4,5,6,7,8,1};
		//int arr[] = {4,5,6,7,1,2,3};
//		int arr[] = {7,6,5,4,3,2,1};
		//int arr[] = {1,2,3,4,5,6,7};
		if (doMBS(arr, 0, arr.length - 1, 1)) {
			System.out.println("found");
		} else {
			System.out.println("not found");
		}
		//System.out.println(getPivot(arr, 0, arr.length - 1));
	}
}