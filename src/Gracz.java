import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gracz {
    public String imie;
    public int finanse = 3000;
    public List<Integer> zakupione = new ArrayList<>();
    public List<String> wybudowane = new ArrayList<>();
    public int punkt_startu = 0;


    Komunikaty komunikaty = new Komunikaty();
    /////////////////////// ruchy ////////////////////////////
    public int polozenie_gracza(int ruch, Gracz gracz){
        if(punkt_startu + ruch > 39){
            punkt_startu = punkt_startu + ruch - 40;
            gracz.finanse = gracz.finanse + 400;
            komunikaty.gotowka();
        }else{
            punkt_startu = punkt_startu + ruch;
        }
        return punkt_startu;
    }
    public int wykonaj_ruch(int rzut){
        Random random = new Random();
        rzut = random.nextInt(6) + 1;
        komunikaty.wylosowanaliczba(rzut);
        return rzut;
    }
    ///////////////////// mozliwosci gracza ///////////////////////
    public void napotkanemiejsce(int miejsce, Plansza plansza) {
        plansza.miejsceGracza(miejsce);
    }
    public void kupno_miejsca(int polozenie_miejsca){
    }
}
