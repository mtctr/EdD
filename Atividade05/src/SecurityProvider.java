
import java.math.*;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityProvider {
	public static String salt = "5a1t";

	public static String md5(String stringToConvert) {
		String hashtext = "";
		stringToConvert += salt;

		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(stringToConvert.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(SecurityProvider.class.getName()).

					log(Level.SEVERE, null, ex);
		}
		return hashtext;
	}

	public static String md5ToServer(Conta conta) {
		String cat = conta.getAgencia() + conta.getNumero() + conta.getSenha() + SecurityProvider.salt;

		return SecurityProvider.md5(cat);
	}

	public static String[] md5ToClient(Conta conta) {
		String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
		String[] str = new String[toCrypt.length()];
		for (int i = 0; i < str.length; i++) {
			str[i] = md5(toCrypt.substring(i, i + 1));
		}
		return str;
	}

}
