import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieb {
	public static void main(String[] args) {
		int numberOfPrimes = Integer.parseInt(args[0]);
		int currentPrime = 0;
		int SieveMax = 9;
		List<Integer> primes = new ArrayList<Integer>();

		while (primes.size() < numberOfPrimes) {
			SieveMax = SieveMax * 10;
			primes = getPrimes(SieveMax);
		}
		// Nach dem durchlaufen dieser While-Schleife ist sichergestellt dass
		// genuegend Primzahlen gefunden wurden.

		while(currentPrime<numberOfPrimes){
			System.out.println(primes.get(currentPrime));
			currentPrime++;
		}
	}

	private static List<Integer> getPrimes(int max) {
		boolean[] possible_primes = new boolean[max];
		Arrays.fill(possible_primes, true);

		List<Integer> primes = new ArrayList<Integer>();

		for (int i = 2; i < max; i++) {
			if (possible_primes[i]) {
				primes.add(i);
				if (i > Math.sqrt(max)) // Es muessen nur Vielfachen von Zahlen
										// gestrichen werden, die kleiner oder
										// gleich die Wurzel von max sind
					continue;
				for (int j = i * i; j < max; j = j + i) {
					possible_primes[j] = false;
				}
			}
		}

		return primes;

	}
}