import java.util.Arrays;
import java.util.NoSuchElementException;
import gdp.stdlib.StdIn;

public class Sudoku {

	enum Variante {
		normal, mitDiagonalen
	};

	static Variante v;

	static int[] board = new int[81];

	/*
	 * Those three arrays below make it easier for me to check if a certain
	 * value is already in this row, column, box, or diagonal. With the
	 * exception of diagonals, there is 9 of each type, so 9 elements in each
	 * outer array, and 9 elements in each nested array to keep track of each
	 * number. I thought about using a nested class but I believe that would be
	 * overkill for something that is essentially just an array.
	 */
	static int[][] rows = new int[9][9];;
	static int[][] columns = new int[9][9];;
	static int[][] boxes = new int[9][9];
	static int[][] diagonals = new int[2][9];
	static int[][][] segments = { rows, columns, boxes, diagonals };

	public static void main(String[] args) {
		read();

		write();
		System.out.println(check());
	}

	public static void write() {
		if (v == Variante.mitDiagonalen) {
			System.out.println("Sudoku mit Diagonalen");
		} else {
			System.out.println("Sudoku");
		}
		int[] line;
		int offset;
		String delimiter, cell;
		for (int i = 0; i < 3; i++) {
			System.out.println("+-------+-------+-------+");
			for (int j = 0; j < 3; j++) {
				offset = 27 * i + 9 * j;
				line = Arrays.copyOfRange(board, offset, offset + 9);
				System.out.print("| ");
				for (int k = 0; k < 9; k++) {
					delimiter = " ";
					// System.out.println(k+1 + " - " + (k+1)%3);
					if ((k + 1) % 3 == 0) {
						delimiter += "| ";
					}
					cell = (line[k] > -1) ? Integer.toString(line[k]) : " ";
					System.out.print(cell + delimiter);
				}

				System.out.println();
			}
		}
		System.out.println("+-------+-------+-------+");
	}

	public static void read() {
		for (int i = 0; i < 9; i++) {
			try {
				String line = StdIn.readLine();
				// fill the array with -1 if there is any other character, else
				// with the corresponding number
				for (int j = 0; j < 9; j++) {
					char c = line.charAt(j);
					board[i * 9 + j] = -1;
					if (Character.isDigit(c)) {
						board[i * 9 + j] = Character.getNumericValue(c);
					}
				}
			} catch (NoSuchElementException | StringIndexOutOfBoundsException e) {
				System.err.println("input error");
				System.exit(-1);
			}
		}
	}

	public static boolean check() {

		/* check for duplicate numbers in each row */
		for (int row = 0; row < 9; row++) {
			boolean[] numbers_in_row = new boolean[9];
			for (int i = 0; i < 9; i++) {
				int n = board[row * 9 + i];
				if (n > -1) {
					if (numbers_in_row[n]) // this number has already appeared
											// in the same row earlier
						return false;
					numbers_in_row[n] = true;
				}
			}
		}

		/* check for duplicate numbers in each column */
		for (int column = 0; column < 9; column++) {
			boolean[] numbers_in_column = new boolean[9];
			for (int i = 0; i < 9; i++) {
				int n = board[i * 9 + column];
				if (n > -1) {
					if (numbers_in_column[n]) // this number has already
												// appeared in the same column
												// earlier
						return false;
					numbers_in_column[n] = true;
				}
			}
		}

		/* check for duplicate numbers in each square */
		for (int squares_y = 0; squares_y < 3; squares_y++) {
			for (int squares_x = 0; squares_x < 3; squares_x++) {
				boolean[] numbers_in_square = new boolean[9];

				for (int inner_y = 0; inner_y < 3; inner_y++) {
					for (int inner_x = 0; inner_x < 3; inner_x++) {
						int n = board[squares_y * 27 + squares_x * 3 + inner_x
								+ inner_y * 9];
						if (n > -1) {
							if (numbers_in_square[n]) // this number has already
														// appeared in the same
														// column earlier
								return false;
							numbers_in_square[n] = true;
						}
					}
				}
			}
		}

		if (v == Variante.mitDiagonalen) {
			boolean[] numbers_in_main_diagonal = new boolean[9];
			boolean[] numbers_in_minor_diagonal = new boolean[9];
			for (int i = 0; i < 9; i++) {
				int n = board[i * 9 + i];
				if (n > -1) {
					if (numbers_in_main_diagonal[n]) // this number has already
														// appeared in the main
														// diagonal earlier
						return false;
					numbers_in_main_diagonal[n] = true;
				}

				int m = board[9 * i + 8 - i];
				if (m > -1) {
					if (numbers_in_minor_diagonal[m]) // this number has already
														// appeared in the minor
														// diagonal earlier
						return false;
					numbers_in_minor_diagonal[m] = true;
				}
			}
		}

		return true;
	}

	public static void solve() {
		solve(0); /*
				 * wird eine (erste) Loesung gefunden, so wird sie ausgegeben
				 * und das Programm wird beendet
				 */
		/*
		 * kommt man hierher, so wurde offenbar keine Loesung gefunden:
		 */
		System.out.println("nicht loesbar :-(");
	}

	public static void solve(int ab) {
		//System.out.println("Solving: solve("+ab+")");
		if (ab == 81) {
			// alle Positionen sind gefuellt
			System.out.println("solved:\n");
			write();
			System.exit(0);
		}
		while (board[ab] > -1) {
			//System.out.println("board["+ab+"] ist: "+ board[ab]);
			++ab; // naechste Position
			if (ab == 81) { // alles gefuellt
				System.out.println("solved:\n");
				write();
				System.exit(0);
			}
		}
		//System.out.println("versuche zu loesen: board["+ab+"]");
		// Position ‚ab‘ ungesetzt, probiere alle Varianten:
		for (int i = 0; i < 9; ++i) { // 0 .. 8
			board[ab] = i;
			// System.out.println("Bord an Stelle "+ab+" setzen auf: "+i);
			if (check()) { // korrekt ? (moegliche loesung)
				solve(ab + 1); /*
								 * rekursiv ab der naechsten Position loesen
								 */
				// wenn solve(ab+1) keine Lösung findet,
				// geht es hier in solve(ab) weiter !!!
			} else{
				continue;
			}
		}
		//System.out.println("setze zurueck: board["+ab+"]");
		board[ab] = -1; // wieder zurueck setzen, sonst steht ja die 8 vom Ende
						// der for-loop da
		//System.out.println("=Ende der Funktion erreicht. board["+ab+"] = -1. Loese jetzt: "+(ab-1));
	}
}
