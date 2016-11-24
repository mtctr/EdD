
public class Test11 {

	public static void main(String[] args) {
		  BST b1=null;
		  b1=BST.add(b1, 5);
		  b1=BST.add(b1, 2);
		  b1=BST.add(b1, 8);
		  b1=BST.add(b1, 6);
		  new Fenetre(b1,"B1");
		  
		  BST b2=null;
		  b2=BST.add(b2, 12);
		  b2=BST.add(b2, 9);
		  b2=BST.add(b2, 10);
		  b2=BST.add(b2, 13);
		  new Fenetre(b2,"B2");
		  
		  BST b3=BST.merge(b1, b2);
		  new Fenetre(b3, "B3=merge(B1,B2)");
		  
	}

}
