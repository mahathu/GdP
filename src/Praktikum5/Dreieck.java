package Praktikum5;

public class Dreieck extends Figur {
	Punkt A, B, C;
	
	public Dreieck(Punkt A, Punkt B, Punkt C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public String toString() {
        return String.format("Praktikum5.Dreieck(%s, %s, %s)", A, B, C);
	}
	
	public double umfang() {
	// TODO
	}
	
	public double flaeche() {
	// TODO
	}
	
	public Kreis umkreis() {
	// nothing to do: unveraendert belassen
		Strecke a = new Strecke(B, C);
		Strecke b = new Strecke(A, C);
		
		Gerade ma = a.mittelsenkrechte();
		Gerade mb = b.mittelsenkrechte();
		
		Punkt  m = ma.schnittpunktMit(mb);
		
		double radius = new Strecke(m, A).laenge();
		
		return new Kreis (m, radius);
	}
    
	public Kreis inkreis() {
	// nothing to do: unveraendert belassen
		Gerade wh1 = winkelhalbierende (A, B, C);
		Gerade wh2 = winkelhalbierende (B, A, C);

		Punkt M = wh1.schnittpunktMit(wh2);

		Punkt L = new Strecke(A,B).lot(M);
		double r = new Strecke(M, L).laenge();

		return new Kreis (M, r);
	}
    
	static Gerade winkelhalbierende(Punkt Scheitel,
					Punkt P1,
					Punkt P2) {
	// TODO
	}

}
