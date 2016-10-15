
import java.util.*;
import java.math.*;

public class ServerDatabase {
	public static final ArrayList<ArrayList<Conta>> contas;
	public static final int N = 100;

	static {
		contas = new ArrayList<ArrayList<Conta>>();
		for (int i = 0; i < N; i++) {
			contas.add(new ArrayList<Conta>());
		}
	}

	public static int hashCode(String md5) {
		BigInteger bi = new BigInteger(md5, 16);
		BigInteger m = new BigInteger(Integer.toString(N), 10);
		int pos;
		pos = bi.mod(m).intValue();
		return pos;
	}

	public static void insereConta(Conta conta) {
		int index = hashCode(conta.getMd5());
		contas.get(index).add(conta);
	}

	public static Conta getConta(String md5) {
		int index = hashCode(md5);
		Conta c = contas.get(index).get(0);
		return c;
	}

}
