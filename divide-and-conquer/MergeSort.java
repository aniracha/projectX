class MergeSort {

	int arr[];
	int workhorse[];

	MergeSort (int arr[]) {
		this.arr = arr;
		this.workhorse = new int[arr.length];
	}

	public void doMergesort(int low, int high) {
		int mid = (low + high)/2;
		if (low < high) {
			doMergesort(low, mid);
			doMergesort(mid+1, high);
			merge(low, mid, high);
		}

	}


	public void merge(int low, int mid, int high) {

		int firstlow = low;
		int firstHigh = mid;
		int secondlow = mid+1;
		int secondhigh = high;

		int i = 0;
		while (firstlow <= firstHigh && secondlow <= secondhigh) {
			if (arr[firstlow] < arr[secondlow]) {
				workhorse[i++] = arr[firstlow];
				firstlow++;
			} else {
				workhorse[i++] = arr[secondlow];
				secondlow++;
			}

		}

		while (firstlow <= firstHigh) {
			workhorse[i++] = arr[firstlow];
			firstlow++;
		}

		while (secondlow <= secondhigh) {
			workhorse[i++] = arr[secondlow];
			secondlow++;
		}

		for (int j = 0; j < i; j++) {
			arr[low + j] = workhorse[j]; 
		}

	}
	public static void main(String[] args) {
		int input[] = {2,10, 1, 5, 3, 90, 100, 6, 78};
		MergeSort mergeSort = new MergeSort(input);
		mergeSort.doMergesort(0, input.length-1);
		for (int i : mergeSort.arr) {
			System.out.print(i + " ");	
		}
		
	}

}