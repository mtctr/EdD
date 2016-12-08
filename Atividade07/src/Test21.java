import java.util.Arrays;


public class Test21 {
	
	private static String stringtab(int[] tab, int n){
		if(n==0) return "{}";
		StringBuffer b=new StringBuffer();
		b.append("{");
		for(int i=0; i<n-1; i++) b.append(tab[i]+", ");
		b.append(tab[n-1]+"}");
		return b.toString();
	}

	public static void main(String[] args) {
		int[] tab=new int[]{4,1,5};
		for(int i=0; i<=tab.length; i++){
			Game test=new Game(Arrays.copyOf(tab, i));
			System.out.println("Seeds="+stringtab(tab,i)+" Results= "+test.getResults());
		}
	}

}
