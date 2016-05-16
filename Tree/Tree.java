import java.util.ArrayList;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode (int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(value);
	}
} 
 class Tree {

 	TreeNode root;

 	public void insert(int value) {
 		TreeNode node = new TreeNode(value);
 		if (root == null) {
 			root = node;
 			return;
 		}

 		TreeNode current = root;
 		boolean isLeftChild = false;
 		TreeNode parent = null;
 		while (current != null) {
 			parent = current;
 			if (value < current.value) {
 				current = current.left;
 				isLeftChild = true;
 			} else {
 				current = current.right;
 				isLeftChild = false;
 			}
 		}

 		if (isLeftChild) {
 			parent.left = node;
 		} else {
 			parent.right = node;
 		}
 	}

 	public void inorder(TreeNode node) {
 		if (node != null) {
 			inorder(node.left);
 			System.out.print(node.value + " ");
 			inorder(node.right);
 		}
 	}

 	public void printLevelOrder() {
 		ArrayList<ArrayList<TreeNode>> list = new ArrayList<ArrayList<TreeNode>>();
 		ArrayList<TreeNode> firstNode = new ArrayList<TreeNode>();
 		TreeNode current = root;
 		firstNode.add(current);
 		list.add(firstNode);
 		int level = 0;
 		while (true) {
 			ArrayList<TreeNode> otherLevels = new ArrayList<TreeNode>();

 			for (TreeNode node : list.get(level)) {
 				if (node.left != null) {
 					otherLevels.add(node.left);
 				} 

 				if (node.right != null) {
 					otherLevels.add(node.right);
 				}
 			}

 			if (otherLevels.isEmpty()) {
 				break;
 			} else {
 				list.add(++level, otherLevels);
 			}
 		}

 		System.out.println(list);

 	}


 	public static void main(String[] args) {
 		Tree tree = new Tree();
 		tree.insert(100);
 		tree.insert(10);
 		tree.insert(50);

 		tree.insert(200);

 		tree.insert(300);

 		tree.insert(400);
 		tree.insert(60);
 		tree.inorder(tree.root);
 		System.out.println();
 		tree.printLevelOrder();


 	}
 }