import java.util.ArrayList;

public class WasserstandManager {

    private ArrayList<Wasserstand> wasserstaende= new ArrayList<>();

    public void add (Wasserstand newWasserstand){
        wasserstaende.add(newWasserstand);
    }

    public Wasserstand findById (int id){
        for (Wasserstand w: wasserstaende) {
            if (id == w.getId()){
                return w;
            }
        }
        return null;
    }

    public ArrayList<Wasserstand> findAllByGewaesser (String gewaesserName){
        ArrayList<Wasserstand> name = new ArrayList<>();

        for (Wasserstand w: wasserstaende) {
            if (w.getGewaesserName().equals(gewaesserName)){
                name.add(w);
            }

        }
        return name;
    }
    
    public Wasserstand findLastWasserstand (String gewaesserName){
        int lastZeitpunkt = 0;
        Wasserstand newest = null;
        
        for (Wasserstand w: wasserstaende) {
            if (w.getGewaesserName().equals(gewaesserName)){
                if(w.getZeitpunkt() > lastZeitpunkt){
                    newest = w;
                    lastZeitpunkt = w.getZeitpunkt();
                }
            }
            
        }
        return newest;
    }

    public ArrayList<Wasserstand> findForAlamierung (){
        ArrayList<Wasserstand> alamierung = new ArrayList<>();
        for (Wasserstand w: wasserstaende) {
            if (w.getMessWert() >= w.getMessWertFuerAlamierung()){
                alamierung.add(w);
            }
        }
        return alamierung;
    }

    public double calcMittlererWasserstand (String gewaesserName){
        double mittlererWasserstand = 0;
        double summeMesswerte = 0;
        int counter = 0;
        for (Wasserstand w: wasserstaende) {
            if (w.getGewaesserName().equals(gewaesserName)){
                counter++;
                summeMesswerte += w.getMessWert();
            }
            mittlererWasserstand = summeMesswerte / counter;

        }
        return mittlererWasserstand;
    }

    public ArrayList<Wasserstand> findByZeitpunkt (int von, int bis, String gewaesserName){
        ArrayList<Wasserstand> zeitpunkt = new ArrayList<>();
        for (Wasserstand w: wasserstaende) {
            if (w.getGewaesserName().equals(gewaesserName)){
                if (w.getZeitpunkt() >= von &&  w.getZeitpunkt() <= bis){
                    zeitpunkt.add(w);
                }
            }
        }
        return zeitpunkt;
    }
}
