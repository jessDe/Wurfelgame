import javax.swing.*;

/**Klasse Spieler
 * @author  Bednorz, Gargya, HeuÃŸer, HÃ¶rrle, Keibl, Kissel, Wunderlich
 * @version 0.91
 */

public class Spieler
{
    // --- Objektvariable ---
    private String name;
    private int aktStand;
    private int aktWurf;
    private int anzWuerfe;
    private int anzGewertet;
    private boolean istWertbar;
    private Wuerfel wuerfel;

    // --- Konstruktoren ---
    /** Konstruktor zur Erzeugung einzelner Spieler fuer Ziel15;
     *  Festlegung der Anfangswerte.
     *  Ein Spielername wie "Bert" ist in "Anfuehrungszeichen" anzugeben
     */
    public Spieler(String neuName)    {
        name = neuName;
        reset();
    }

    /** Schnell-Konstruktor;
     *  Erzeugt Spieler fuer Ziel15 mit festem Namen "Demo";  */
    public Spieler()    {
        name = "Demo";
        reset();
    }

    // --- get/set-Methoden -----
    /** Melden, ob das Spiel beendet ist,
     *  da 6 gewertete Wuerfe vorliegen
     */
    public boolean istFertig()  {
        return anzGewertet >= 6;
    }

    /** eine typische get-Methode, die den Wert einer Objektvariable
     *  (Eigenschaft) als Antwort nach auÃŸen liefert  */
    public int getAktStand(){
        return aktStand;
    }

    /** eine typische get-Methode, die den Wert der Objektvariable
     *  (Eigenschaft) anzWuerfe als Antwort nach auÃŸen liefert  */
    public int getAnzWuerfe(){
        return anzWuerfe;
    }

    /** get-Methode, die den Wert der Objektvariable aktWurf
     *  als Antwort nach auÃŸen liefert
     *  koennte auch getAktWurf() heissen   */
    public int getWurf(){
        return aktWurf;
    }

    /** typische get-Methode, die den Wert der Objektvariable: name
     *  als Antwort nach auÃŸen liefert; Datentyp ist String  */
    public String getName(){
        return name;
    }

    /** typische set-Methode, die den Wert der Objektvariable: name
     *  neu festsetzt. Eingabe ist der neue Name */
    public void setName(String neuName){
        name = neuName;
    }

    //---- Spiel-Methoden ---------
    /** Wuerfeln, Wurfergebnis in aktWurf merken
     */
    public void wuerfeln() {
        if (anzGewertet < 6) {
            aktWurf = wuerfel.getAugenzahl();  // speichert Augenzahl in aktWurf
            anzWuerfe ++;
            istWertbar = true;
        }
    }
    public int getAnzGewertetd(){
        return anzGewertet;
    }

    /** Wurf pruefen und entscheiden, ob dieser Wurf gewertet wird
     *  oder nicht.  beachtet, ob es moeglich ist; gibt Warnmeldungen aus;
     *  Wertung erst nach einem Wurf moeglich und nur einmal */
    public boolean entscheiden() {
        /*#
         *  Hier Implementierung zu AB4, Aufgabe 2 & 3 ergÃ¤nzen.
         *
         */

        return true; // Akzeptiert derzeit jeden Wurf, unabhÃ¤ngig von allen Spielregeln.
    }

    /** jede einzelne Spielstrategie erstellt seine pruefe()-Methode
     *  und liefert jeweils die Antwort Ja/Nein zurueck.  */
    public boolean pruefe(){
        String frage = "Du hast aktuell " + aktStand + " Punkte.\n";
        frage += "Soll die eben geworfene " + aktWurf + " gewertet werden?";
        // Benutzer entscheidet per Dialogbox
        String[] options = {"Ja", "NEIN"};
        int n = JOptionPane.showOptionDialog(null, frage, "Wertung:" + name,
                JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return n==0; //bei Ja wird true, bei NEIN wird false gemeldet.
    }
    /*#  // MUSS in Unterklasse implementiert werden   */

    /** fuehrt die eigentliche Wertung durch; aktualisiert den Stand;
     *  zaehlt die Anzahl der gewerteten Wuerfe hoch,
     *  verhindert erneute Wertung dieses Wurfes */
    public void werten() {
        aktStand  += aktWurf;
        istWertbar = false;  // Wertung erfolgt; neuen Wurf erzwingen
        anzGewertet++;
    }

    /** 3 Schritte: erst wuerfeln();
     *  dann entscheiden() und ggf. werten()  */
    public void spieleRunde(){
        wuerfeln();
        if (entscheiden() ) {werten();}
    }

    /**  nochmal von vorne anfangen = alle Eigenschaftswerte
     *   zuruecksetzen, damit nochmal gespielt werden kann */
    public void reset() {
        aktStand    = 0;
        aktWurf     = 0;
        anzWuerfe   = 0;
        anzGewertet = 0;
        istWertbar  = false;
        wuerfel = new Wuerfel();
    }

    /** Hilfsmethode, um Daten auszugeben
     *  ersetzt toString(); besser dies ueberschreiben   */
    public String gibDaten() {
        return (name + " Stand: " + aktStand + ";\tAnzWuerfe: "+ anzWuerfe +
                ";\tgewertet: "+ anzGewertet);
    }

    /** interne Hilfsmethode fÃ¼r Bildschirmmeldungen
     */
    public void melde(String meldungstext) {
        JOptionPane.showMessageDialog(null, meldungstext);
    }

}
