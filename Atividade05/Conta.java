
public class Conta {

	private String agencia;
	private String numero;
	private String senha;
	private String nomeCliente;
	private String saldo;
	private String md5;

	public Conta(String agencia, String numero, String senha) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.md5 = SecurityProvider.md5(SecurityProvider.md5ToServer(this));
	}

	public Conta(String agencia, String numero, String senha, String nomeCliente, String saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.md5 = SecurityProvider.md5(SecurityProvider.md5ToServer(this));
	}

	public Conta(String nomeCliente, String saldo) {
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.md5 = SecurityProvider.md5(SecurityProvider.md5ToServer(this));
	}

	// toString
	@Override
	public String toString() {
		String str = "\nAGENCIA: " + this.agencia;
		str += "\nCONTA: " + this.numero;
		str += "\nSENHA: " + this.senha;
		str += "\nNOME CLIENTE: " + this.nomeCliente;
		str += "\nSALDO: " + this.saldo;
		str += "\nMD5: " + this.md5;

		return str;
	}

	// GETTERS
	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public String getSenha() {
		return senha;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getSaldo() {
		return saldo;
	}

	public String getMd5() {
		return md5;
	}

	public static void test() {
		Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
		System.out.println(c1);
		Conta c2 = new Conta("John Doe", "10");
		System.out.println(c2);
		Conta c3 = new Conta("123", "321", "666");
		System.out.println(c3);
	}

	public static void test3() {
		Conta c = new Conta("1234", "2222", "1245");
		ServerDatabase.insereConta(c);
		String chave = SecurityProvider.md5ToServer(c);
		System.out.println(chave);
	//	Conta conta = ServerDatabase.getConta(chave);
	//	System.out.println(conta);
	}
}
