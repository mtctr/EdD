import java.util.*;

public class Game {

	private Set seeds;

	public Game(int[] numbers) {
		this.seeds = new Set();
		for (int i = 0; i < numbers.length; i++) {
			seeds.add(numbers[i]);
		}
	}

	private Set getResult(Set s) {
		if (s.isSingleton()) {
			return s;
		} else {
			Set results = new Set();
			LinkedList<Integer> l = s.toList();			
			

		}
	}

}
