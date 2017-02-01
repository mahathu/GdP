package Praktikum5;

public class Gerade {
	// ax + by + c = 0
	double a, b, c;
	
	public Gerade (Punkt p1, Punkt p2) {
		if(p1.x == p2.x && p1.y == p2.y)
			return null;

	}
	
	public boolean gleich (Gerade g) {
        if(g.a == this.a && g.b == this.b && g.c == this.c )
            return true;
        return false;
	}

	public Gerade (double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String toString() {
	    return String.format("Praktikum5.Gerade(%f, %f, %f)", a, b, c);
	}
	
	public boolean senkrecht() {
	return b == 0;
	}
	
	public double anstieg() {
	// TODO
	}
	
	public Punkt schnittpunktMit (Gerade g) {
	// TODO
	}
}
