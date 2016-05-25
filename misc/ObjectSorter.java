import java.util.Comparator;
import java.util.Arrays;
class OSComparator implements Comparator<ObjectSorter>{
	public int compare(ObjectSorter first, ObjectSorter second) {
		//return second.age - first.age;
		//return first.age - second.age;
		//return first.name.compareTo(second.name);
		return second.name.compareTo(first.name);
	}
}
public class ObjectSorter {

	public String toString() {
		return name;
	}

	String name;
	int age;
	ObjectSorter(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		ObjectSorter objs[] = new ObjectSorter[2];
		objs[0] = new ObjectSorter("Anirban", 29);
		objs[1] = new ObjectSorter("Bazinga", 30);
		Arrays.sort(objs, new OSComparator());

		for (ObjectSorter obj : objs) {
			System.out.println(obj.name + " " + obj.age);
		}
	}
}