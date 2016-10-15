
public class test {
	public static void test() {
		Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
		System.out.println(c1);
		Conta c2 = new Conta("John Doe", "10");
		System.out.println(c2);
		Conta c3 = new Conta("123", "321", "666");
		System.out.println(c3);

	}

	public static void test2() {
		Conta c = new Conta("1234", "2222", "1245");
		System.out.println(SecurityProvider.md5ToServer(c));
	}

	public static void test3() {
		Conta c = new Conta("1234", "2222", "1245");
		ServerDatabase.insereConta(c);
		String chave = SecurityProvider.md5ToServer(c);
		System.out.println(chave);
		Conta conta = ServerDatabase.getConta(chave);
		System.out.println(conta);
	}

	public static void main(String[] args) {
		test3();
	}

}
