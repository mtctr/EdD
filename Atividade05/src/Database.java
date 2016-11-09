
import java.util.*;

public class Database {
	public static final ArrayList<Letra> caracteres;
	static {
		caracteres = new ArrayList<Letra>();

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			caracteres.add(new Letra(String.valueOf(ch)));
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			caracteres.add(new Letra(String.valueOf(ch)));
		}
		caracteres.add(new Letra(" "));

		for (char ch = '0'; ch <= '9'; ch++) {
			caracteres.add(new Letra(String.valueOf(ch)));
		}
	}

	public static Letra getLetra(String md5) {
		int i = 0;
		while (!caracteres.get(i).getMd5Code().equals(md5)) {
			i++;
		}
		return caracteres.get(i);
	}
	
	public static Conta getConta(String[] md5) {
		String str = "";

		for (int i = 0; i < md5.length; i++) {
			str += (getLetra(md5[i]).getCaractere());
		}
		//compara cada caractere com um numero
		//quando chegar no saldo a comparacao sera positiva
		//e apos isso ocorre a divisao da string
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			for (char ch = '0'; ch <= '9'; ch++) {
				if (str.substring(i, i + 1).equals(String.valueOf(ch))) {
					index = i;
					break;
				}

			}
		}
		String nome = str.substring(0, index - 1);
		String saldo = str.substring(index - 1, str.length());
		Conta c = new Conta(nome, saldo);
		return c;
	}
}
