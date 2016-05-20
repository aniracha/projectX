class Node<K, V> {

	K key;
	V value;
	Node next;

	Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class LinkedList<K , V> {

	Node head;
	Node tail;
	public void insertAtLast(K key, V value) {
		Node node = new Node(key, value);

		if (head == null) {
			head = node;
			tail = node;
			return;	
		}

		tail.next = node;
		tail = tail.next;

	}

	public Node find(K key) {
		Node current = head;

		while (current != null) {
			if (current.key.equals(key)) {
				return current;
			} else {
				current = current.next;
			}
		}

		return null;
	}
}

class Hashtable<K, V> {

	LinkedList linkedList[];
	int size;

	Hashtable(int size) {
		this.size = size;
		this.linkedList = (LinkedList[]) (new LinkedList[size]);
	}

	public int getHashcode(K key) {
		return key.toString().length();
	}

	public void put(K key, V value) {
		int hashcode = getHashcode(key);
		LinkedList list = null;
		if (linkedList[hashcode] == null) {
			linkedList[hashcode] = new LinkedList();
			list = linkedList[hashcode];
		} else {
			list = linkedList[hashcode];
		}

		Node node = list.find(key);
		if (node == null) {
			list.insertAtLast(key, value);
		} else {
			node.value = value;
		}

	}

	public V get(K key) {
		int hashcode = getHashcode(key);
		LinkedList list = linkedList[hashcode];
		if (list == null) {
			return null;
		}
		Node node = list.find(key);
		if (node != null) {
			return (V) node.value;
		} else {
			return null;
		}
	}

}

class HashTableImplementor {
	public static void main(String[] args) {
		Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>(10);
		hashTable.put("abc", 10);
		hashTable.put("abd", 20);
		hashTable.put("abe", 30);

		hashTable.put("abde", 200);
		hashTable.put("abdf", 300);
		hashTable.put("abdg", 230);


		System.out.println(hashTable.get("abd"));
		System.out.println(hashTable.get("abdf"));
	}

}
