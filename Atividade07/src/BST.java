import java.util.*;

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
		if(a==null){
			return new BST(x);
			}
		if(a.value>x){
			a.left=add(a.left,x);
		}
		if(a.value<x){
			a.right=add(a.right,x);
		}
		return a;
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
	
	//passo 1.a
	static BST merge(BST a,BST b){
		if(a != null && b != null){
			return new BST (a, getMin(b), removeMin(b));
		}
		else if (a != null && b == null){
			return a;
		}
		else if (b != null && a == null){
			return b;
		}
		else{
			return null;
		}
	}
	
	//passo 1.b
	private static void	toList(LinkedList<Integer> l, BST s){
		if(s != null){
			l.addLast(getMin(s));
			toList(l,removeMin(s));
		}
		
	}
	
	//passo 1.c
	static Vector<Pair<BST>>allSubsets(BST a){
		Vector<Pair<BST>> v = new Vector<Pair<BST>>();
		if(a==null){
			v.add(new Pair<BST>(null,null));
		}
		else{
			for(Pair<BST> l: allSubsets(a.left)){
				for(Pair<BST> r: allSubsets(a.right)){
					BST sl = new BST(l.first, a.value, r.first);
					BST slbar = merge(l.second, r.second);
					v.add(new Pair<BST>(sl, slbar));
					v.add(new Pair<BST>(slbar, sl));
				}
			}
		}
		
		return v;
 	}
	
	//passo 1.b
	static LinkedList<Integer> toList(BST s){
		LinkedList<Integer> l = new LinkedList<Integer>();
		toList(l,s);
		return l;
	} 
}
