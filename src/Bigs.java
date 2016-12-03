public class Bigs {
	// addiert die Ziffernfelder a und b
	public static int[] add(int[] a, int[] b) {
		int max_len = a.length > b.length ? a.length + 1 : b.length + 1;
		int a_val, b_val, rollover;
		a_val = b_val = rollover = 0;
		int[] result = new int[max_len];
		for (int i = 0; i < max_len; i++) {
			a_val = b_val = 0;

			if (i < a.length) {
				a_val = a[i];
			}
			if (i < b.length) {
				b_val = b[i];
			}
			if (a_val + b_val + rollover > 9) {
				result[i] = (a_val + b_val + rollover) % 10;
				rollover = 1;
			} else {
				result[i] = a_val + b_val + rollover;
				rollover = 0;
			}
		}

		if (result[result.length - 1] == 0) {
			int[] new_result = new int[result.length - 1];
			for (int i = 0; i < new_result.length; i++) {
				new_result[i] = result[i];
			}
			return new_result;
		}
		return result;
	}

	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	// bei sehr langen Zahlen soll das Format verwendet werden, welches auch von
	// bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
	static void print(int[] n) {
		for (int i = 1; i <= n.length; i++) {
			System.out.print(n[i - 1]);
			if (i % 68 == 0) {
				System.out.println("\\");
			}
		}
	}

	// konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
	static int[] digit(int d) {
		if (d > 9) {
			throw new IllegalArgumentException();
		}
		int[] digit = { d };
		return digit;
	}

	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[] Null() {
		return new int[] { 0 };
	}

	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[] One() {
		return new int[] { 1 };
	}

	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[] n) {
		return n[0]; // Einerstelle
	}

	// ganzzahliger Quotient bei Division durch 10
	static int[] div10(int[] n) {
		int[] result = new int[n.length - 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = n[i + 1];
		}
		return result;
	}

	// Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
	static int[] fromInt(int n) {
		String str = String.valueOf(n);
		String[] strArray = str.split("");
		int len = str.length();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(strArray[len - i - 1]);
		}
		return arr;
	}

	// kopiert den Wert von n
	static int[] copy(int[] n) {
		return n.clone();
	}

	// multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
	static int[] times(int[] n, int d) { /* TODO */
		if (d > 9) {
			throw new IllegalArgumentException();
		}
		return times(n, new int[] { d });
	}

	// multipliziert das Ziffernfeld n mit 10
	static int[] times10(int[] n) {
		int[] result = new int[n.length + 1];
		result[0] = 0;
		for (int i = 1; i < result.length; i++) {
			result[i] = n[i - 1];
		}
		return result;
	}

	// multipliziert zwei Ziffernfelder
	static int[] times(int[] a, int[] b) { /* TODO */

		return a;
	}

	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less(int[] a, int[] b) {
		if (a.length > b.length) {
			return false;
		} else if (a.length < b.length) {
			return true;
		}
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] < b[i]) {
				return true;
			} else if (a[i] > b[i]) {
				return false;
			}
		}
		// both are equal
		return false;
	}

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal(int[] a, int[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
	// mindenstens eine Ziffer,
	// alle Positionen liegen zwischen 0 und 9, keine fuehrenden Nullen (ausser
	// bei Null selbst)
	static boolean ok(int[] n) {
		for (int digit : n) {
			if (digit < 0 || digit > 9)
				return false;
		}
		if (n[n.length - 1] == 0 && n.length > 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] s) {
		/*
		 * int[] a = One(); for (int i = 0; i < 10000; ++i) { a = times(a, 2); }
		 * System.out.println("2^10000 hat " + a.length + " Stellen"); print(a);
		 * // 2 hoch 10000 System.out.println();
		 * 
		 * int[] b = fromInt(775); int[] c = copy(b); for (int i = 1; i < 1042;
		 * ++i) { c = times(c, b); } System.out.println("775^1042 hat " +
		 * c.length + " Stellen"); print(c); // 775 hoch 1042
		 * System.out.println();
		 * 
		 * System.out.println(less(a, c)); // beantwortet die Frage aus der //
		 * Aufgabenueberschrift
		 */

		int[] a = { 5, 3, 2, 3, 4, 2, 7, 3 };
		int[] b = { 5, 3, 2, 3, 4, 2 }; // 243235
		int[] c = { 0, 4, 2, 3 };

		int[] x = { 4, 1, 1 };
		int[] y = { 5 };

		int[] z = add(x, y);
		for (int i = 0; i < 1000000; i++) {
			z = add(z, a);
		}

		print(z);
	}
}
