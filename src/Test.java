import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test {
    public int CurrentPlayer = 0;
    private boolean WerteSelected = false;
    private boolean Werten = false;
    private JButton nextButton;
    private JButton würfelnButton; //Würfelt für den Aktuellen Spieler
    private JRadioButton wertenRadioButton;
    private JRadioButton nichtWertenRadioButton;
    public JPanel JsPanel;
    private JLabel SpielerID;
    private JLabel Wurf;
    private JLabel DASd;
    private JLabel wurfeCozunter;
    private JLabel gewertetewurfe;

    public Test(){

        Wurf.setText("");
        würfelnButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.SP[CurrentPlayer].wuerfeln();
                würfelnButton.setVisible(false);
                System.out.println("Spieler "+ (CurrentPlayer+1)+ " hat eine "+Main.SP[CurrentPlayer].getWurf()+" gewürfelt ("+Main.SP[CurrentPlayer].getAnzWuerfe()+"/10)");
                Wurf.setText(String.valueOf(Main.SP[CurrentPlayer].getWurf()));
                wurfeCozunter.setText(Main.SP[CurrentPlayer].getAnzWuerfe()+"/10 Würfe");

                nextButton.setVisible(true);
            }
        });
        nextButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WerteSelected) {
                    if(Werten){
                        Main.SP[CurrentPlayer].werten();
                        if(10-Main.SP[CurrentPlayer].getAnzWuerfe() > 6-Main.SP[CurrentPlayer].getAnzGewertetd()){
                            nichtWertenRadioButton.setVisible(true);
                        }else{
                            WerteSelected = true;
                            Werten = true;
                            wertenRadioButton.setSelected(true);
                            nichtWertenRadioButton.setVisible(false);
                        }
                        DASd.setText("Gesammte Punkte: "+Main.SP[CurrentPlayer].getAktStand());
                        gewertetewurfe.setText(Main.SP[CurrentPlayer].getAnzGewertetd()+" gewertet!");
                        würfelnButton.setVisible(true);
                        if( Main.SP[CurrentPlayer].getAnzWuerfe() == 10 || 6 == Main.SP[CurrentPlayer].getAnzGewertetd()){
                            if(CurrentPlayer+1 < Main.SpielerAnz){
                                System.out.println("CurrentPlayer:"+CurrentPlayer+"/ Spieler Anzahl: "+Main.SpielerAnz);
                                CurrentPlayer++;
                                SpielerID.setText("Spieler "+ (CurrentPlayer+1));
                                DASd.setText("Gesammte Punkte: 0");
                                wurfeCozunter.setText("0/10 Würfe");
                                gewertetewurfe.setText("0 gewertet!");
                                nichtWertenRadioButton.setVisible(true);
                            }else{
                                //Ending
                                würfelnButton.setVisible(false);
                                JOptionPane.showMessageDialog(null,"Spieler "+ Main.FindWinner()+" hat gewonnen mit "+Main.SP[Main.FindWinner()].getAktStand()+" Punkten!");
                            }
                        }



                        nextButton.setVisible(false); Wurf.setText("");
                    }else{
                        würfelnButton.setVisible(true);
                        nextButton.setVisible(false);
                        Wurf.setText("");
                        if(10-Main.SP[CurrentPlayer].getWurf() > 6-Main.SP[CurrentPlayer].getAnzGewertetd()){
                            nichtWertenRadioButton.setVisible(true);
                        }else{
                            WerteSelected = true;
                            Werten = true;
                            wertenRadioButton.setSelected(true);
                            nichtWertenRadioButton.setVisible(false);
                        }

                        if(10 == Main.SP[CurrentPlayer].getWurf() || 6 == Main.SP[CurrentPlayer].getAnzGewertetd()){
                            if(CurrentPlayer+1 < Main.SpielerAnz){
                                System.out.println("CurrentPlayer:"+CurrentPlayer+"/ Spieler Anzahl: "+Main.SpielerAnz);
                                CurrentPlayer++;
                                SpielerID.setText("Spieler "+ (CurrentPlayer+1));
                                DASd.setText("Gesammte Punkte: 0");
                                wurfeCozunter.setText("0/10 Würfe");
                                gewertetewurfe.setText("0 gewertet!");
                                nichtWertenRadioButton.setVisible(true);
                            }else{
                                //Ending
                                würfelnButton.setVisible(false);
                                JOptionPane.showMessageDialog(null,"Spieler "+ Main.FindWinner()+" hat gewonnen mit "+Main.SP[Main.FindWinner()].getAktStand()+" Punkten!");
                            }
                        }
                    }
                }

            }
        });







        wertenRadioButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WerteSelected = true;
                Werten = true;
            }
        });
        nichtWertenRadioButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WerteSelected = true;
                Werten = false;
            }
        });
    }
}
