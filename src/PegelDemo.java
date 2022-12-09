import java.util.ArrayList;

public class PegelDemo {

    public static void main(String[] args) {

        WasserstandManager wm = new WasserstandManager();
        Wasserstand w1 = new Wasserstand(12, "Mur", 300, 500, 70000);
        Wasserstand w2 = new Wasserstand(13, "Rhein", 600, 700, 80000);
        Wasserstand w3 = new Wasserstand(14, "Mur", 800, 700, 200000);
        Wasserstand w4 = new Wasserstand(15, "Safen", 900, 500, 90000);
        Wasserstand w5 = new Wasserstand(16, "Rhein", 300, 400, 30000);

        wm.add(w1);
        wm.add(w2);
        wm.add(w3);
        wm.add(w4);
        wm.add(w5);

        System.out.println(wm.findForAlamierung());
        System.out.println(wm.findById(16));
        System.out.println(wm.findAllByGewaesser("Mur"));
        System.out.println(wm.findLastWasserstand("Mur"));
        System.out.println(wm.calcMittlererWasserstand("Rhein"));
        System.out.println(wm.findByZeitpunkt(90000, 200000, "Mur"));
    }


}
