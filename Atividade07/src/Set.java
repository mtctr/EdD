import java.util.LinkedList;
import java.util.Vector;

public class Set {

	private BST root;

	public Set() {
		root = null;
	}

	private Set(BST r) {
		root = r;
	}

	void add(int x) {
		root = BST.add(root, x);
	}

	boolean isEmpty() {
		return root == null;
	}

	boolean isSingleton() {
		return root != null && root.left == null && root.right == null;
	}
	
	int getMin() {
		return BST.getMin(root);
	}

	public LinkedList<Integer> toList() {
		return BST.toList(root);
	}

	public Vector<Pair<Set>> allSubsets() {
		Vector<Pair<Set>> res = new Vector<Pair<Set>>();
		for (Pair<BST> p : BST.allSubsets(root))
			res.add(new Pair<Set>(new Set(p.first), new Set(p.second)));
		return res;
	}

	public String toString() {
		if (isEmpty())
			return "#0[]";
		StringBuffer b = new StringBuffer();
		LinkedList<Integer> l = toList();
		int n = l.size();
		int last = l.get(n - 1);
		b.append("#" + n + "[");
		for (int x : l)
			if (x == last)
				b.append(x);
			else
				b.append(x + ", ");
		b.append("]");
		return b.toString();
	}

}
