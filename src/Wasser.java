/**
 * Created by martin on 1/31/17.
 */
public class Wasser extends Getraenk {
    public Wasser(String name, int menge) {
        super(name, menge, 200);
    }

    @Override
    public boolean essen() {
        return false;
    }

    @Override
    public boolean trinken() {
        return super.trinken();
    }

    @Override
    public String status() {
        return status("Wasser");
    }
}
