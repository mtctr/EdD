
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
		this.md5 = SecurityProvider.md5ToServer(this);
	}

	public Conta(String agencia, String numero, String senha, String saldo, String nomeCliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.md5 = SecurityProvider.md5ToServer(this);;
	}

	public Conta(String nomeCliente, String saldo) {
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.md5 = SecurityProvider.md5ToServer(this);
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
	
}
