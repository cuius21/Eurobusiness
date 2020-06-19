import java.util.Scanner;

public class App {
    public static int liczbagraczy;
    public static int zaczynajacy;
    public static Gracz []gracze;

    public static void main(String[] args){
        Plansza plansza = new Plansza();
        plansza.uzupelnij_plansze();

        Komunikaty komunikaty = new Komunikaty();
        komunikaty.start();
        komunikaty.ile_graczy();
        Scanner scanner = new Scanner(System.in);
        liczbagraczy = scanner.nextInt();

        gracze = new Gracz[liczbagraczy];
        Stan stan = new Stan();
        for(int i=0; i<liczbagraczy; i++){
            gracze[i] = new Gracz();
            stan.informacje_gracza(gracze[i], i);
        }

        komunikaty.rozpoczecie();
        zaczynajacy = stan.losowanie_gracza(liczbagraczy);
        while(zaczynajacy != -1) {
            komunikaty.info_o_zaczynajacym_graczu(gracze[zaczynajacy]);
            stan.tura(gracze[zaczynajacy], plansza);
            stan.koniectury(gracze[zaczynajacy]);
            stan.zakonczeniegry();
            if(zaczynajacy + 1 == liczbagraczy){
                zaczynajacy = 0;
            }
            else if(zaczynajacy + 1 != liczbagraczy && zaczynajacy != -1) {
                zaczynajacy++;
            }
        }
        komunikaty.koniec();
    }
}
