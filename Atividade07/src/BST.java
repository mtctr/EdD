public class BST {

	int value;
	BST left,right;

	public BST(int v){
		value=v;
		left=null;
		right=null;
	}

	public BST(BST l,int v, BST r){
		value=v;
		left=l;
		right=r;
	}
	
	static BST add(BST a, int x){
		if(a==null) return new BST(x);
		if(a.value>x) a.left=add(a.left,x);
		if(a.value<x) a.right=add(a.right,x);
		return a;
	}
	
	static BST merge(BST a,BST b){
		return new BST (a, getMin(b), removeMin(b));		
	}
	
	static int getMin(BST a) {
		if (a.left == null)
			return a.value;
		return getMin(a.left);
	}

	static BST removeMin(BST a) {
		if (a.left == null)
			return a.right;
		return new BST(removeMin(a.left), a.value, a.right);
	}
}
