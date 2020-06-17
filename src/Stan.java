import java.util.Random;
import java.util.Scanner;

public class Stan {
    Komunikaty komunikaty = new Komunikaty();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void informacje_gracza(Gracz gracz, int numerzawodnika){
        komunikaty.infogracza1(numerzawodnika);
        gracz.imie = scanner.nextLine();
        gracz.finanse = 3000;
        komunikaty.inforacza2(gracz.imie, gracz.finanse);
    }
    public int losowanie_gracza(int liczbagraczy) {
        return random.nextInt(liczbagraczy);
    }

    public void tura(Gracz gracz, Plansza plansza) {
        komunikaty.rzuckostka();
        int polozeniegracza;
        int przycisk = scanner.nextInt();
        int wyrzuconaliczba;
        wyrzuconaliczba = gracz.wykonaj_ruch(przycisk);
        polozeniegracza = gracz.polozenie_gracza(wyrzuconaliczba);
        gracz.napotkanemiejsce(polozeniegracza, plansza);
        decyzjeGracza(gracz, polozeniegracza, plansza);


    }
    public void decyzjeGracza(Gracz g, int polozenie, Plansza plansza){
        int tmp;
        if(polozenie == 0){
            plansza.statusMiejsca(0);
        }
        if(polozenie == 1){
            tmp = plansza.statusMiejsca(1);
            if(g.finanse > tmp){
                g.finanse = g.finanse - tmp;
                g.zakupione.add(1);
            }else if((g.finanse < tmp) && (tmp != 1000000)){
                komunikaty.niemoznosc_kupna();
                plansza.zmianaStatusuPola(1);
            }
            else if(tmp == 1000000){
                for(int i=0; i<App.liczbagraczy; i++){
                    if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(1)){
                        
                    }
                }
            }
        }
    }
}
