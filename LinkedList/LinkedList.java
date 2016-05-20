class Node {
	int value;
	Node next;
	Node (int value) {
		this.value = value;
	}
}


class LinkedList {

	Node head;

	public void display() {

		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void reverseI() {
		Node current = head;
		Node next = null;
		Node previous = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}

		head = previous;

	}

	public Node reverseR(Node input) {

		if (input == null) {
			return null;
		}

		if (input.next == null) {
			head = input;
			return input;
		} else {
			Node current = reverseR(input.next);
			current.next = input;
			input.next = null;
			return input;
		}
		
	}

	public void addAtLast(int value) {
		Node node = new Node(value);

		if (head == null) {
			head = node;
			return;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		current.next = node;

	}



	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addAtLast(10);
		linkedList.addAtLast(20);
		linkedList.addAtLast(30);
		linkedList.addAtLast(40);
		linkedList.addAtLast(50);
		linkedList.addAtLast(60);
		linkedList.display();
		linkedList.reverseI();
		linkedList.display();
		linkedList.reverseI();
		linkedList.display();
		linkedList.reverseR(linkedList.head);
		linkedList.display();
		linkedList.reverseR(linkedList.head);
		linkedList.display();
	}
}



