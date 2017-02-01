/**
 * Created by martin on 1/31/17.
 */
public class Wurst extends Speise {
    public Wurst(String name, int menge) {
        super(name, menge, 10);
    }

    @Override
    public boolean essen() {
        return super.essen();
    }

    @Override
    public boolean trinken() {
        return false;
    }

    @Override
    public String status() {
        return status("Wurst");
    }
}
