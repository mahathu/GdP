/**
 * Created by martin on 1/31/17.
 */
public abstract class Getraenk extends Lebensmittel {
    protected int standardmenge;

    public Getraenk(String name, int menge, int standardmenge) {
        super(name, menge);
        this.standardmenge = standardmenge;
    }
    public boolean trinken(){
        if(menge < standardmenge){
            menge = 0;
            return false;
        }
        menge -= standardmenge;
        return true;
    }

    public String status(String typ){
        return String.format("%s (%s, %dml)", typ, name, menge);
    }
}
