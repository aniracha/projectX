class Kadane {

	public static int getKadane(int arr[]) {
		int sumTillNow = -1000;
		int maxTillNow = -1000;
		for (int i = 0; i < arr.length; i++) {
			if (sumTillNow + arr[i] < arr[i]) {
				sumTillNow = arr[i];
			} else {
				sumTillNow += arr[i];
			}

			if (sumTillNow > maxTillNow) {
				maxTillNow = sumTillNow;
			}
		}

		return maxTillNow;
	}
	public static void main(String[] args) {
		//int arr[] = {-10,-20, 20, -2, 9, -100, 1, 2, 3 ,70, -200};
		int arr[] = {-10,-20, -20, -2, -9, -100, -1, -2, -3 ,-70, -200};
		System.out.println(getKadane(arr));
	}
}