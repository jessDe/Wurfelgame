/**
 * Klasse Wuerfel stellt einen rudimentÃ¤ren WÃ¼rfel zur VerfÃ¼gung.
 *
 * @author HeuÃŸer, HÃ¶rrle, Keibl, Kissel, Wunderlich
 * @version 0.9
 */
public class Wuerfel
{

    private int augenzahl;
    private boolean gezinkt = false;


    /**
     * Constructor for objects of class Wuerfel
     */
    public Wuerfel()
    {
        augenzahl = 0;
    }
    public Wuerfel(int gewunschteaugenzahl){
        System.out.println("Du hast dir eine Zahl gewünscht ("+gewunschteaugenzahl+")");
        augenzahl = gewunschteaugenzahl % 6 +1;
        gezinkt = true;
    }
    public int getaugenzahl(){
        return augenzahl;
    }

    /** Wuerfeln und Melden des Wurfergebnisses */
    public int getAugenzahl() {
        if (!gezinkt) {
            augenzahl = 1 + (int) (Math.random() * 6);  // erzeugt Zufallszahl zwischen 1 und 6
        }
        return  augenzahl;
    }

}
