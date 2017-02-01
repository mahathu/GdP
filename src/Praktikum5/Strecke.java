package Praktikum5;

public class Strecke {
	Punkt A, B;
	
	public Strecke (Punkt A, Punkt B) {
	// TODO
	}
	
	public String toString () {
		return String.format("Praktikum5.Strecke(%s, %s)", A, B);
	}
	
	public Gerade aufGerade() {
		return new Gerade(A, B);
	}
	
	public double laenge() {
		return Math.sqrt(Math.pow(B.x - A.x,2)+Math.pow(B.y - A.y,2));
	}
	
	public Gerade mittelsenkrechte() {
	// TODO
	}
    
	public Punkt lot(Punkt P) {
	// TODO
	}

}
