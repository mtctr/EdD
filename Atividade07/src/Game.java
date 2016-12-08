import java.util.LinkedList;
import java.util.Vector;

public class Game {

	private Set seeds;

	public Game(int[] numbers) {
		this.seeds = new Set();
		for (int i = 0; i < numbers.length; i++) {
			seeds.add(numbers[i]);
		}
	}
	public Set getResults(){
		return getResult(seeds);
	}
	private Set getResult(Set s) {
		if (s.isSingleton()) {
			return s;
		} else {
			Set results = new Set();
			for (Pair<Set> subset : s.allSubsets()) {
				if(!subset.first.isEmpty() && !subset.second.isEmpty()){
					LinkedList<Integer> l1 = getResult(subset.first).toList();
					LinkedList<Integer> l2 = getResult(subset.second).toList();
					for (int u : l1) {
						for (int v : l2) {
							results.add(u);
							results.add(u + v);
							results.add(u * v);
							if (u - v > 0)
								results.add(u - v);
							if (u % v == 0)
								results.add(u / v);
						}
					}
				}	
			}
			return results;
		}

	}

}
