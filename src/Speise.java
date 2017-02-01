/**
 * Created by martin on 1/31/17.
 */
public abstract class Speise extends Lebensmittel {
    protected int standardmenge;

    public Speise(String name, int menge, int standardmenge){
        super(name, menge);
        this.standardmenge = standardmenge;
    }

    public boolean essen(){
        if(menge < standardmenge){
            menge = 0;
            return false;
        }
        menge -= standardmenge;
        return true;
    }

    public String status(String typ){
        return String.format("%s (%s, %dg)", typ, name, menge);
    }
}
