/**
 * Created by martin on 1/31/17.
 */
public class Brot extends Speise {
    public Brot(int typ, int menge) {
        super("", menge, 50);

        switch (typ) {
            case 0:
                this.name = "Weissbrot";
            case 1:
                this.name = "Schwarzbrot";
            case 2:
                this.name = "Mischbrot";
            default:
                this.name = "Spezialbrot";
        }
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
        return status("Brot");
    }
}
