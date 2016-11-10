
public class testes {

	public static void main(String[] args) {
		//teste passo 2
//		System.out.println("Construcao de FenwickTree(3) : " + new FenwickTree(3));
//		System.out.println("Construcao da arvore da figura : " +
//		new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
//		new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
//		new FenwickTree(1, new FenwickTree(3),
//		new FenwickTree(1, new FenwickTree(6), new FenwickTree(1)))));
		
		//teste passo 3
		System.out.println("Construcao de allZeros(3) : " + FenwickTree.allZeros(3));
		System.out.println("Construcao de allZeros(4) : " + FenwickTree.allZeros(4));
		System.out.println("Construcao de allZeros(5) : " + FenwickTree.allZeros(5));
		System.out.println("Construcao de allZeros(6) : " + FenwickTree.allZeros(6));

		
	}

}
