import java.util.*;

class Permutations {
	public static ArrayList<String> getAllPermutations(String input) {
		if (input == null) {
			return null;
		}

		ArrayList<String> arr = new ArrayList<String>();

		if (input.length() == 1) {
			arr.add(input);
			return arr;
		}

		char first = input.charAt(0);
		String rest = input.substring(1);
		ArrayList<String> restPerm = getAllPermutations(rest);
		
		ArrayList<String> newRest = new ArrayList<String>();
		for (String s : restPerm) {
			for (int i = 0; i <= s.length(); i++) {
				newRest.add(s.substring(0,i) + first + s.substring(i));	
			}
			
		}

		arr.addAll(newRest);
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(getAllPermutations("cat"));
	}
}