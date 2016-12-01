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
		return new BST (a, getMin(b), removeMin(b));		
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
		
		return v;
 	}
	
	static LinkedList<Integer> toList(BST s){
		LinkedList<Integer> l = new LinkedList<Integer>();
		toList(l,s);
		return l;
	} 
}
