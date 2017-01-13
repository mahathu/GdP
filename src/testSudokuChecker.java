class testSudokuChecker {
	public static void main(String args[]) {
		Sudoku.v = Sudoku.Variante.normal;
		if (args.length > 0 && args[0].equals("-x")){
			Sudoku.v = Sudoku.Variante.mitDiagonalen;
			System.out.println("Sudoku mit Diagonalen");
		} else{
			System.out.println("Sudoku");
		}
		Sudoku.read();
		Sudoku.write();
		if (!Sudoku.check()) {
			System.out.print("not ");
		}
		System.out.println("ok");
	}
}