import java.util.*;

class Point {
	int x;
	int y;
	int count;
	Set<Integer> set = new TreeSet<Integer>();
	Point (int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

class MatrixWithConstraints {

	public static void printLongestPathWithConstraints(int input[][]) {
		LinkedHashMap<Integer, Point> map = new LinkedHashMap<Integer, Point>();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				int value = input[i][j];
				int minusOne = value - 1;
				int pluxOne = value + 1;
				Point newPoint = null;
				if (map.containsKey(minusOne)) {
					Point minusOneKey = map.get(minusOne);
					if (Math.abs(i - minusOneKey.x) == 1 && (j == minusOneKey.y)) {
						newPoint = new Point(i,j, ++minusOneKey.count);
						newPoint.set.add(value);
						newPoint.set.addAll(minusOneKey.set);
						map.put(value, newPoint);
					}
					
					if (Math.abs(j - minusOneKey.y) == 1 && (i == minusOneKey.x)) {
						newPoint = new Point(i,j, ++minusOneKey.count);
						newPoint.set.add(value);
						newPoint.set.addAll(minusOneKey.set);
						map.put(value, newPoint);
					}	
				}

				if (map.containsKey(pluxOne)) {
					Point pluxOneKey = map.get(pluxOne);
					int val = 0;
					Set<Integer> previous = new HashSet<Integer>();
					if (map.containsKey(value)) {
						val = map.get(value).count;
						previous = map.get(value).set;
					}
					int total = 0;
					if (Math.abs(i - pluxOneKey.x) == 1 && (j == pluxOneKey.y)) {
						total = val + (++pluxOneKey.count);
						newPoint = new Point(i,j, total);
						newPoint.set.add(value);
						newPoint.set.addAll(pluxOneKey.set);
						newPoint.set.addAll(previous);
						map.put(value, newPoint);
					}
					
					if (Math.abs(j - pluxOneKey.y) == 1 && (i == pluxOneKey.x)) {
						total = val + (++pluxOneKey.count);
						newPoint = new Point(i,j, total);
						newPoint.set.add(value);
						newPoint.set.addAll(pluxOneKey.set);
						newPoint.set.addAll(previous);
						map.put(value, newPoint);
					}	
				} 

				if (newPoint == null) {
					newPoint = new Point(i, j, 1);
					newPoint.set.add(value);
					map.put(value, newPoint);
				}
				
			}
		}
		Point point = null;
		int max = -1;
		for (Map.Entry<Integer, Point> entry: map.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue().x + " " + entry.getValue().y + " " + entry.getValue().count + " " + entry.getValue().set);
			if (entry.getValue().count > max) {
				max = entry.getValue().count;
				point = entry.getValue();
			}
		}

		System.out.println("The answer " + point.set);

	}

	public static void main(String[] args) {
		int input[][] = {{1, 2, 9},
                   		{6, 3, 8},
                   		{5, 4, 7}};
        printLongestPathWithConstraints(input);

	}
}