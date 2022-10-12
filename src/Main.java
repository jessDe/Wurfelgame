import javax.swing.*;
import java.awt.*;

public class Main {
    public static int SpielerAnz = 3;
    public static Spieler[] SP = new Spieler[SpielerAnz];
    public static Spieler SP2;
    public static Spieler SP3;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Würfel Game");
        frame.setContentPane(new Test().JsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(21, 21, 21));
        frame.setSize(600,300);
        Main.ResetPlayers();


        System.out.println("Finised");
    }
    public static void ResetPlayers(){
        for(int i = 0; i<SpielerAnz; i++){
            SP[i] = new Spieler();
            SP[i].reset();
            System.out.println("Spieler"+i+" Registriert");
        }
    }
    public static int FindWinner(){
        int winpoints = 100;
        int winningPlayer= 999;
        for (int i = 0; i< Main.SpielerAnz; i++){
            int calc = distance(15,SP[i].getAktStand());
            if(winpoints > calc){
                winningPlayer = i;
            }
        }
        return winningPlayer;
    }
    public static int distance(int a, int b) {
        int x = a-b;
        if(x < 0 ){
            x = x*(-1);
        }else if(x>0){
            x = x;
        }
        return x;
    }
}