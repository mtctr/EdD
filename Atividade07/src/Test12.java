
public class Test12 {

	public static void main(String[] args) {
		  BST a=null;
		  System.out.println("Liste(A)="+BST.toList(a));
		  
		  a=BST.add(a, 5);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 2);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 8);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 6);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 12);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 9);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 10);
		  System.out.println("Liste(A)="+BST.toList(a));
		  a=BST.add(a, 13);
		  new Fenetre(a,"A");
		  
		  System.out.println("Liste(A)="+BST.toList(a));

	}

}
