package Praktikum5;

public class Test {
    
    public static void main(String args[]) {
        Punkt p1 = new Punkt(0,0);
        Punkt p2 = new Punkt(0,10);
        Punkt p3 = new Punkt(10,0);
        Punkt p4 = new Punkt(10,10);
        
        System.out.println(p1);
        
        Gerade g1 = new Gerade (p1, p3);
        Gerade g2 = new Gerade (p1, p2);
        
        System.out.println(g1);
        System.out.println(g2);
        
        /*Praktikum5.Punkt p5 = g1.schnittpunktMit(g2);
        System.out.println(p5);
        Praktikum5.Punkt p6 = g2.schnittpunktMit(g1);
        System.out.println(p6);
        
        Praktikum5.Strecke s = new Praktikum5.Strecke (p1, p4);
        Praktikum5.Gerade gm = s.mittelsenkrechte();

        Praktikum5.Gerade g = new Praktikum5.Strecke(p2, p3).aufGerade();
        
        System.out.println(gm);
        System.out.println(gm.gleich(g2));
        System.out.println(gm.gleich(g));
        
        
        Praktikum5.Dreieck d = new Praktikum5.Dreieck(p1, p2, p3);
        
        System.out.println(d);
        System.out.println(d.umfang());
        System.out.println(d.flaeche());
        
        Praktikum5.Kreis u = d.umkreis();
        System.out.println(u);
        System.out.println(u.umfang());
        System.out.println(u.flaeche());	
        
        Praktikum5.Kreis i = d.inkreis();
        System.out.println(i);
        System.out.println(i.umfang());
        System.out.println(i.flaeche());*/
    }
}
