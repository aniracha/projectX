import java.util.ArrayList;
class AllSubsets {
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> input) {
		if (input == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> toBeReturned = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		if (input.isEmpty()) {
			toBeReturned.add(empty);
			return toBeReturned;
		}

		ArrayList<Integer> cloned = (ArrayList<Integer>)input.clone();

		int first = cloned.remove(0);
		ArrayList<ArrayList<Integer>> oneLessSet = getAllSubsets(cloned);
		ArrayList<ArrayList<Integer>> oneLessSetAgain = getAllSubsets(cloned);

		toBeReturned.addAll(oneLessSet);
		for (ArrayList<Integer> list : oneLessSetAgain) {
			list.add(first);
		}
		toBeReturned.addAll(oneLessSetAgain);

		return toBeReturned;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println(getAllSubsets(list));
	}
}