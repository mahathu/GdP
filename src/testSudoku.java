class testSudoku {
	public static void main(String args[]) {
		Sudoku.v = Sudoku.Variante.normal;
		if (args.length > 0 && args[0].equals("-x"))
			Sudoku.v = Sudoku.Variante.mitDiagonalen;

		Sudoku.read();
		Sudoku.write();
		if (Sudoku.check())
			Sudoku.solve();
		else
			System.out.println("not ok");
	}
}