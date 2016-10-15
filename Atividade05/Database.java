
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
}