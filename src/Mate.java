/**
 * Created by martin on 1/31/17.
 */
public class Mate extends Getraenk{
    public Mate(String name) {
        super(name, 500, 100);
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
        return status("Mate");
    }
}
