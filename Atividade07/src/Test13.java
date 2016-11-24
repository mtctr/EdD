import java.util.Vector;


public class Test13 {
	
	private static void printVector(Vector<Pair<BST>> v){
		System.out.print("#"+v.size());
		for(Pair<BST> p:v)
			System.out.print("("+BST.toList(p.first)+","+BST.toList(p.second)+") ");
		System.out.println();
	}

	public static void main(String[] args) {
		  BST a=null;
		  Vector<Pair<BST>> v=BST.allSubsets(a);
		  System.out.print("A="+BST.toList(a)+" Subsets= ");
		  printVector(v);
		  
		  a=BST.add(a, 5);
		  v=BST.allSubsets(a);
		  System.out.print("A="+BST.toList(a)+" Subsets= ");
		  printVector(v);
		  
		  a=BST.add(a, 2);
		  v=BST.allSubsets(a);
		  System.out.print("A="+BST.toList(a)+" Subsets= ");
		  printVector(v);
		  
		  a=BST.add(a, 8);
		  v=BST.allSubsets(a);
		  System.out.print("A="+BST.toList(a)+" Subsets= ");
		  printVector(v);
		  
		  new Fenetre(a,"A");
	}

}
