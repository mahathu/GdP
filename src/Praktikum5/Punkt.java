package Praktikum5;

public class Punkt {
	double x, y;

	public Punkt (double x, double y) {
	// TODO
	}
	
	public String toString () {

		return String.format("Praktikum5.Punkt(%f, %f)", x, y);
	}
	
	public Gerade geradeDurch (Punkt p) {
	    return new Gerade(this, p);
	}
    
	public boolean aufStrecke(Strecke s) {
	// TODO
	}

}
