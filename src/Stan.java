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
        polozeniegracza = gracz.polozenie_gracza(wyrzuconaliczba, gracz);
        gracz.napotkanemiejsce(polozeniegracza, plansza);
        decyzjeGracza(gracz, polozeniegracza, plansza);


    }
    public void decyzjeGracza(Gracz g, int polozenie, Plansza plansza){
        int tmp;
        if(polozenie == 0){
            plansza.statusMiejsca(0);
        }
        else if(polozenie == 1){
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
                        komunikaty.infoograczu(App.gracze[i].imie);
                        if(App.gracze[i].zakupione.contains(3)){
                            int ilosc = 0;
                            for(int j=0; j<App.gracze[i].wybudowane.size(); j++){
                                if(App.gracze[i].wybudowane.equals("Saloniki")){
                                    ilosc++;
                                }
                                if(ilosc == 0){
                                    System.out.println("Gracz nie ma żadnych budynków tutaj");
                                    System.out.println("Płacisz graczowi 20zł");
                                    App.gracze[i].finanse += 20;
                                    if(g.finanse > 20) {
                                        g.finanse -= 20;
                                    }
                                    else{
                                        System.out.println("koniec gry!");
                                    }
                                }
                                else if(ilosc == 1){
                                    System.out.println("Gracz ma teren z 1 zabudową");
                                    System.out.println("Płacisz graczowi 60zł");
                                    App.gracze[i].finanse += 60;
                                    if (g.finanse > 60) {
                                        g.finanse -= 60;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 2){
                                    System.out.println("Gracz ma teren z 2 domami");
                                    System.out.println("Płacisz graczowi 120zł");
                                    App.gracze[i].finanse += 120;
                                    if(g.finanse > 120) {
                                        g.finanse -= 120;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 3){
                                    System.out.println("Gracz ma teren z 3 domami");
                                    System.out.println("Płacisz graczowi 300zł");
                                    App.gracze[i].finanse += 300;
                                    if(g.finanse > 300) {
                                        g.finanse -= 300;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 4){
                                    System.out.println("Gracz ma teren z 4 domami");
                                    System.out.println("Płacisz graczowi 600zł");
                                    App.gracze[i].finanse += 600;
                                    if(g.finanse > 600) {
                                        g.finanse -= 600;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 5){
                                    System.out.println("Gracz ma teren z 1 hotelem");
                                    System.out.println("Płacisz graczowi 900zł");
                                    App.gracze[i].finanse += 900;
                                    if(g.finanse > 900) {
                                        g.finanse -= 900;
                                    }else{
                                        System.out.println("koniec gry");
                                    }
                                }
                            }
                        }else{
                            System.out.println("Płacisz za teren niezabudowany 10zł");
                            App.gracze[i].finanse += 10;
                            if(g.finanse > 10) {
                                g.finanse -= 10;
                            }
                            else{
                                System.out.println("koniec gry");
                            }
                        }
                    }
                }
            }
        }
        else if(polozenie == 2){
            if(g.finanse > 100) {
                g.finanse -= 100;
            }
            else{
                System.out.println("koniec gry");
            }
        }
        else if(polozenie == 3){
            tmp = plansza.statusMiejsca(3);
            if(g.finanse > tmp){
                g.finanse = g.finanse - tmp;
                g.zakupione.add(3);
            }else if((g.finanse < tmp) && (tmp != 1000000)){
                komunikaty.niemoznosc_kupna();
                plansza.zmianaStatusuPola(3);
            }
            else if(tmp == 1000000){
                for(int i=0; i<App.liczbagraczy; i++){
                    if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(3)){
                        komunikaty.infoograczu(App.gracze[i].imie);
                        if(App.gracze[i].zakupione.contains(1)){
                            int ilosc = 0;
                            for(int j=0; j<App.gracze[i].wybudowane.size(); j++){
                                if(App.gracze[i].wybudowane.equals("Ateny")){
                                    ilosc++;
                                }
                                if(ilosc == 0){
                                    System.out.println("Gracz nie ma żadnych budynków tutaj");
                                    System.out.println("Płacisz graczowi 20zł");
                                    App.gracze[i].finanse += 20;
                                    if(g.finanse > 20) {
                                        g.finanse -= 20;
                                    }
                                    else{
                                        System.out.println("koniec gry!");
                                    }
                                }
                                else if(ilosc == 1){
                                    System.out.println("Gracz ma teren z 1 zabudową");
                                    System.out.println("Płacisz graczowi 90zł");
                                    App.gracze[i].finanse += 90;
                                    if (g.finanse > 90) {
                                        g.finanse -= 90;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 2){
                                    System.out.println("Gracz ma teren z 2 domami");
                                    System.out.println("Płacisz graczowi 180zł");
                                    App.gracze[i].finanse += 180;
                                    if(g.finanse > 180) {
                                        g.finanse -= 180;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 3){
                                    System.out.println("Gracz ma teren z 3 domami");
                                    System.out.println("Płacisz graczowi 400zł");
                                    App.gracze[i].finanse += 400;
                                    if(g.finanse > 400) {
                                        g.finanse -= 400;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 4){
                                    System.out.println("Gracz ma teren z 4 domami");
                                    System.out.println("Płacisz graczowi 800zł");
                                    App.gracze[i].finanse += 800;
                                    if(g.finanse > 800) {
                                        g.finanse -= 800;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 5){
                                    System.out.println("Gracz ma teren z 1 hotelem");
                                    System.out.println("Płacisz graczowi 1000zł");
                                    App.gracze[i].finanse += 1000;
                                    if(g.finanse > 1000) {
                                        g.finanse -= 1000;
                                    }else{
                                        System.out.println("koniec gry");
                                    }
                                }
                            }
                        }else{
                            System.out.println("Płacisz za teren niezabudowany 10zł");
                            App.gracze[i].finanse += 10;
                            if(g.finanse > 10) {
                                g.finanse -= 10;
                            }
                            else{
                                System.out.println("koniec gry");
                            }
                        }
                    }
                }
            }
        }
        else if(polozenie == 4){
            g.finanse -= 400;
        }
        else if(polozenie == 5){
            tmp = plansza.statusMiejsca(5);
            if(g.finanse > tmp) {
                g.finanse -= tmp;
                g.zakupione.add(5);
            }else if((g.finanse < tmp) && (tmp != 1000000)){
                komunikaty.niemoznosc_kupna();
                plansza.zmianaStatusuPola(5);
            }
            else if(tmp == 1000000){
                for(int i=0; i<App.liczbagraczy; i++){
                    if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(5)){
                        komunikaty.infoograczu(App.gracze[i].imie);
                        if(App.gracze[i].zakupione.contains(15) && App.gracze[i].zakupione.contains(25) && App.gracze[i].zakupione.contains(35)){
                            System.out.println(App.gracze[i].imie + " posiada wszystkie koleje");
                            System.out.println("Płacisz mu 400 zł");
                            App.gracze[i].finanse += 400;
                            if(g.finanse > 400){
                                g.finanse -= 400;
                            }else{
                                System.out.println("koniec gry");
                            }
                        }
                        else{
                            System.out.println("Płacisz za jedne koleje 100zł");
                            App.gracze[i].finanse += 100;
                            if(g.finanse > 100) {
                                g.finanse -= 100;
                            }
                            else{
                                System.out.println("koniec gry");
                            }
                        }
                    }
                }
            }
        }
        else if(polozenie == 6){
            tmp = plansza.statusMiejsca(6);
            if(g.finanse > tmp){
                g.finanse = g.finanse - tmp;
                g.zakupione.add(6);
            }else if((g.finanse < tmp) && (tmp != 1000000)){
                komunikaty.niemoznosc_kupna();
                plansza.zmianaStatusuPola(6);
            }
            else if(tmp == 1000000){
                for(int i=0; i<App.liczbagraczy; i++){
                    if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(6)){
                        komunikaty.infoograczu(App.gracze[i].imie);
                        if(App.gracze[i].zakupione.contains(8) && App.gracze[i].zakupione.contains(9)){
                            int ilosc = 0;
                            for(int j=0; j<App.gracze[i].wybudowane.size(); j++){
                                if(App.gracze[i].wybudowane.equals("Neapol")){
                                    ilosc++;
                                }
                                if(ilosc == 0){
                                    System.out.println("Gracz nie ma żadnych budynków tutaj ale posiada całe Włochy");
                                    System.out.println("Płacisz graczowi 60zł");
                                    App.gracze[i].finanse += 60;
                                    if(g.finanse > 60) {
                                        g.finanse -= 60;
                                    }
                                    else{
                                        System.out.println("koniec gry!");
                                    }
                                }
                                else if(ilosc == 1){
                                    System.out.println("Gracz ma teren z 1 zabudową");
                                    System.out.println("Płacisz graczowi 190zł");
                                    App.gracze[i].finanse += 190;
                                    if (g.finanse > 190) {
                                        g.finanse -= 190;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 2){
                                    System.out.println("Gracz ma teren z 2 domami");
                                    System.out.println("Płacisz graczowi 280zł");
                                    App.gracze[i].finanse += 280;
                                    if(g.finanse > 280) {
                                        g.finanse -= 280;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 3){
                                    System.out.println("Gracz ma teren z 3 domami");
                                    System.out.println("Płacisz graczowi 500zł");
                                    App.gracze[i].finanse += 500;
                                    if(g.finanse > 500) {
                                        g.finanse -= 500;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 4){
                                    System.out.println("Gracz ma teren z 4 domami");
                                    System.out.println("Płacisz graczowi 800zł");
                                    App.gracze[i].finanse += 800;
                                    if(g.finanse > 800) {
                                        g.finanse -= 800;
                                    }
                                    else{
                                        System.out.println("koniec gry");
                                    }
                                }
                                else if(ilosc == 5){
                                    System.out.println("Gracz ma teren z 1 hotelem");
                                    System.out.println("Płacisz graczowi 1200zł");
                                    App.gracze[i].finanse += 1200;
                                    if(g.finanse > 1200) {
                                        g.finanse -= 1200;
                                    }else{
                                        System.out.println("koniec gry");
                                    }
                                }
                            }
                        }else{
                            System.out.println("Płacisz za teren niezabudowany 15zł");
                            App.gracze[i].finanse += 15;
                            if(g.finanse > 15) {
                                g.finanse -= 15;
                            }
                            else{
                                System.out.println("koniec gry");
                            }
                        }
                    }
                }
            }
        }
        else if(polozenie == 7){
            g.finanse += 100;
        }
        else if(polozenie == 17){
            if(g.finanse > 50) {
                g.finanse -= 50;
            }
            else{
                System.out.println("koniec gry");
            }
        }
        else if(polozenie == 22){
            for(int j=0; j<App.liczbagraczy; j++){
                if(App.gracze[j] != g){
                    App.gracze[j].finanse -= 20;
                    g.finanse += 20;
                }
            }
        }
        else if(polozenie == 33){
           int koszt = 0;
           int ilosc = g.wybudowane.size();
           int ilosc_hoteli;
           int ilosc_domow;
           ilosc_hoteli = ilosc / 5;
           ilosc_domow = ilosc - ilosc_hoteli;
           koszt = ilosc_hoteli * 50 + ilosc_domow * 20;
           g.finanse -= koszt;
           System.out.println("Zapłaciłeś " + koszt + " zł.");
        }
        else if(polozenie == 36){
            g.punkt_startu = 0;
        }
        else if(polozenie == 38){
            g.finanse -= 200;
        }
    }
}
