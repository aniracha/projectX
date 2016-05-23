import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class SuffixTreeNode {
	char value;
	Map<Character, SuffixTreeNode> children;

	SuffixTreeNode() {
		this.value = '*';
		this.children = new HashMap<Character, SuffixTreeNode>();
	}

	SuffixTreeNode(char value) {
		this.value = value;
		this.children = new HashMap<Character, SuffixTreeNode>();
	}

}
public class SuffixTree {

	SuffixTreeNode root;

	SuffixTree() {
		root = new SuffixTreeNode();
	}

	public void buildSuffixTree(String input) {

		for (int i = 0; i < input.length(); i++) {
			SuffixTreeNode newNode = null;
			if (!root.children.containsKey(input.charAt(i))) {
				newNode = new SuffixTreeNode(input.charAt(i));
				root.children.put(input.charAt(i), newNode);
			} else {
				newNode = root.children.get(input.charAt(i));
			}

			SuffixTreeNode parent = newNode;
			for (int j = i+1; j < input.length(); j++) {
				if (parent.children.containsKey(input.charAt(j))) {
					parent = parent.children.get(input.charAt(j));
				} else {
					SuffixTreeNode childrenOneLevelDown = new SuffixTreeNode(input.charAt(j));
					parent.children.put(input.charAt(j), childrenOneLevelDown);
					parent = parent.children.get(input.charAt(j));
				}
			}
		}
	}

	public boolean search(String searchString) {
		SuffixTreeNode current = root;

		for (char c : searchString.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			} else {
				current = current.children.get(c);
			}
		}
		return true;
	}


	public static void main(String[] args) {
		List < String > input = new ArrayList < String > () {
            {
                add("ba");
                add("ban");
                add("ana");
                add("anas");
                add("nan");
                add("anans");
                add("ananas");
                add("n");
                add("s");
                add("as");
                add("naab");
                add("baan");
                add("aan");
            }
        };

        SuffixTree suffixTree = new SuffixTree();
        suffixTree.buildSuffixTree("bananas");

        for (String s : input) {
        	if (suffixTree.search(s)) {
        		System.out.println(s + " found");
        	} else {
        		System.out.println(s + " not found");
        	}
        }
	}

}