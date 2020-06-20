import java.util.Collections;
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
    public void zakonczeniegry(){
        Scanner s = new Scanner(System.in);
        System.out.println("Czy chcesz wymusić zakończenie gry? T : N");
        String w = s.nextLine();
        if(w.equals("T") || w.equals("t")){
            App.zaczynajacy = -1;
        }
    }
    public void koniectury(Gracz gracz){
        komunikaty.koniectury();
        Scanner scan = new Scanner(System.in);
        String yn = scan.nextLine();
        if(yn.equals("N") || yn.equals("n")){
            komunikaty.podsumowanie();
            int podsumowanie = scan.nextInt();
            if(podsumowanie == 1){
                for(int k=0; k<App.liczbagraczy; k++){
                    if(App.gracze[k] == gracz){
                        System.out.println("Twój status:");
                        statusgraczy(k);
                    }
                }
            }
            else if(podsumowanie == 2){
                System.out.println("Status rywali:");
                for(int k=0; k<App.liczbagraczy; k++) {
                    if(App.gracze[k] != gracz) {
                        statusgraczy(k);
                    }
                }
            }
            else if(podsumowanie == 3){
                System.out.println("Status wszystkich:");
                for (int k=0; k<App.liczbagraczy; k++){
                    statusgraczy(k);
                }
            }
            else if(podsumowanie == 4){
                gracz.kupno_zabudowy();
                gracz.posiadlosc_kraj();
            }
        }
    }
    public void statusgraczy(int k){
        System.out.println(App.gracze[k].imie + " posiada " + App.gracze[k].nazwypolkup);
        System.out.println("Wybudował "+ App.gracze[k].wybudowane.size()+" budynków");
        System.out.println(App.gracze[k].imie + " ma "+ App.gracze[k].finanse+" zł");
    }

    public void decyzjeGracza(Gracz g, int polozenie, Plansza plansza){
        int tmp;
        switch (polozenie) {
            case 0:
                plansza.statusMiejsca(0);
                break;
            case 1:
                tmp = plansza.statusMiejsca(1);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(1);
                    g.nazwypolkup.add("Saloniki");
                    plansza.zmianaStatusuPola(1);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }
                else if(tmp == 1000000) {
                    tmpdla2(g,polozenie, 3, "Saloniki", 10);
                }
                break;
            case 2:
                if(g.finanse > 100) {
                    g.finanse -= 100;
                    plansza.skarbiec += 100;
                    System.out.println("Do skarbca trafiło 100 zł");
                }
                else{
                    System.out.println("koniec gry");
                    App.zaczynajacy = -1;
                }
                break;
            case 3:
                tmp = plansza.statusMiejsca(3);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(3);
                    g.nazwypolkup.add("Ateny");
                    plansza.zmianaStatusuPola(3);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }
                else if(tmp == 1000000) {
                    tmpdla2(g, polozenie, 1, "Ateny", 15);
                }
                break;
            case 4:
                g.finanse -= 400;
                plansza.skarbiec += 400;
                System.out.println("Do skarbca trafiło 400zł");
                break;
            case 5:
                tmp = plansza.statusMiejsca(5);
                if(g.finanse > tmp) {
                    g.finanse -= tmp;
                    g.zakupione.add(5);
                    g.nazwypolkup.add("kolej poludniowa");
                    plansza.zmianaStatusuPola(5);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlakolei(g, polozenie, 15, 25, 35);
                }
                break;
            case 6:
                tmp = plansza.statusMiejsca(6);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(6);
                    g.nazwypolkup.add("Neapol");
                    plansza.zmianaStatusuPola(6);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000) {
                    tmpdla3(g, polozenie, 8,9,"Neapol", 20);
                }
                break;
            case 7:
                g.finanse += 100;
                break;
            case 8:
                tmp = plansza.statusMiejsca(8);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(8);
                    g.nazwypolkup.add("Mediolan");
                    plansza.zmianaStatusuPola(8);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 6,9,"Mediolan", 20);
                }
                break;
            case 9:
                tmp = plansza.statusMiejsca(9);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(9);
                    g.nazwypolkup.add("Rzym");
                    plansza.zmianaStatusuPola(9);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 6,8,"Rzym", 25);
                }
                break;
            case 10:
                plansza.statusMiejsca(10);
                break;
            case 11:
                tmp = plansza.statusMiejsca(11);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(11);
                    g.nazwypolkup.add("Barcelona");
                    plansza.zmianaStatusuPola(11);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 13,14,"Barcelona", 35);
                }
                break;
            case 12:
                tmp = plansza.statusMiejsca(12);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(12);
                    g.nazwypolkup.add("elektrownia");
                    plansza.zmianaStatusuPola(12);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)) {
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlainfrastruktury(g, polozenie, 28);
                }
                break;
            case 13:
                tmp = plansza.statusMiejsca(13);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(13);
                    g.nazwypolkup.add("Sewilla");
                    plansza.zmianaStatusuPola(13);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 11,14,"Sewilla", 35);
                }
                break;
            case 14:
                tmp = plansza.statusMiejsca(14);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(14);
                    g.nazwypolkup.add("Madryt");
                    plansza.zmianaStatusuPola(14);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 13,11,"Madryt", 45);
                }
                break;
            case 15:
                tmp = plansza.statusMiejsca(15);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(1);
                    g.nazwypolkup.add("kolej zachodnia");
                    plansza.zmianaStatusuPola(15);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlakolei(g, polozenie, 5, 25, 35);
                }
                break;
            case 16:
                tmp = plansza.statusMiejsca(16);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(16);
                    g.nazwypolkup.add("Liverpool");
                    plansza.zmianaStatusuPola(16);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 18,19,"Liverpool", 55);
                }
                break;
            case 17:
                if(g.finanse > 50) {
                    g.finanse -= 50;
                }
                else{
                    System.out.println("koniec gry");
                    App.zaczynajacy = -1;
                }
                break;
            case 18:
                tmp = plansza.statusMiejsca(18);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(18);
                    g.nazwypolkup.add("Glasgow");
                    plansza.zmianaStatusuPola(18);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 16,19,"Glasgow", 55);
                }
                break;
            case 19:
                tmp = plansza.statusMiejsca(19);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(19);
                    g.nazwypolkup.add("Londyn");
                    plansza.zmianaStatusuPola(19);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 18,16,"Londyn", 60);
                }
                break;
            case 20:
                System.out.println("Trafiłeś na skarbiec");
                System.out.println("Otrzymałeś "+ plansza.skarbiec+"zł");
                g.finanse += plansza.skarbiec;
                plansza.skarbiec = 0;
                break;
            case 21:
                tmp = plansza.statusMiejsca(21);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(21);
                    g.nazwypolkup.add("Rotterdam");
                    plansza.zmianaStatusuPola(21);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 23,24,"Rotterdam", 80);
                }
                break;
            case 22:
                for(int j=0; j<App.liczbagraczy; j++){
                    if(App.gracze[j] != g){
                        App.gracze[j].finanse -= 20;
                        g.finanse += 20;
                    }
                }
                break;
            case 23:
                tmp = plansza.statusMiejsca(23);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(23);
                    g.nazwypolkup.add("Bruksela");
                    plansza.zmianaStatusuPola(23);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 21,24,"Bruksela", 80);
                }
                break;
            case 24:
                tmp = plansza.statusMiejsca(24);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(24);
                    g.nazwypolkup.add("Amsterdam");
                    plansza.zmianaStatusuPola(24);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 21,23,"Amsterdam", 100);
                }
                break;
            case 25:
                tmp = plansza.statusMiejsca(25);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(25);
                    g.nazwypolkup.add("kolej polnocna");
                    plansza.zmianaStatusuPola(25);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlakolei(g, polozenie, 5, 15, 35);
                }
                break;
            case 26:
                tmp = plansza.statusMiejsca(26);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(26);
                    g.nazwypolkup.add("Malmo");
                    plansza.zmianaStatusuPola(26);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 27,29,"Malmo", 110);
                }
                break;
            case 27:
                tmp = plansza.statusMiejsca(27);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(27);
                    g.nazwypolkup.add("Goteborg");
                    plansza.zmianaStatusuPola(27);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 26,29,"Goteborg", 110);
                }
                break;
            case 28:
                tmp = plansza.statusMiejsca(28);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(28);
                    g.nazwypolkup.add("wodociagi");
                    plansza.zmianaStatusuPola(28);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)) {
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlainfrastruktury(g, polozenie, 12);
                }
                break;
            case 29:
                tmp = plansza.statusMiejsca(29);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(29);
                    g.nazwypolkup.add("Sztokholm");
                    plansza.zmianaStatusuPola(29);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 26,27,"Sztokholm", 140);
                }
                break;
            case 30:
                g.punkt_startu = 10;
                System.out.println("Przechodzisz do wiezienia");
                break;
            case 31:
                tmp = plansza.statusMiejsca(31);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(31);
                    g.nazwypolkup.add("Frankfurt");
                    plansza.zmianaStatusuPola(31);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 32,34,"Frankfurt", 150);
                }
                break;
            case 32:
                tmp = plansza.statusMiejsca(32);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(32);
                    g.nazwypolkup.add("Kolonia");
                    plansza.zmianaStatusuPola(32);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 32,34,"Kolonia", 150);
                }
                break;
            case 33:
                int koszt = 0;
                int ilosc = g.wybudowane.size();
                int ilosc_hoteli;
                int ilosc_domow;
                ilosc_hoteli = ilosc / 5;
                ilosc_domow = ilosc - ilosc_hoteli;
                koszt = ilosc_hoteli * 50 + ilosc_domow * 20;
                if(g.finanse > koszt) {
                    g.finanse -= koszt;
                    plansza.skarbiec += koszt;
                    System.out.println("Zapłaciłeś " + koszt + " zł.");
                    System.out.println("Pieniądze trafiły do skarbca");
                }
                else{
                    System.out.println("Koniec gry");
                    App.zaczynajacy = -1;
                }
                break;
            case 34:
                tmp = plansza.statusMiejsca(34);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(34);
                    g.nazwypolkup.add("Berlin");
                    plansza.zmianaStatusuPola(34);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdla3(g, polozenie, 32,31,"Berlin", 200);
                }
                break;
            case 35:
                tmp = plansza.statusMiejsca(35);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(35);
                    g.nazwypolkup.add("kolej wschodnia");
                    plansza.zmianaStatusuPola(35);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }else if(tmp == 1000000){
                    tmpdlakolei(g, polozenie, 5, 15, 25);
                }
                break;
            case 36:
                g.punkt_startu = 0;
                break;
            case 37:
                tmp = plansza.statusMiejsca(37);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(37);
                    g.nazwypolkup.add("Insbruk");
                    plansza.zmianaStatusuPola(37);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }
                else if(tmp == 1000000) {
                    tmpdla2(g,polozenie, 39, "Insbruk", 300);
                }
                break;
            case 38:
                if(g.finanse > 200) {
                    g.finanse -= 200;
                    plansza.skarbiec += 200;
                    System.out.println("Skarbiec wzbogacił się o 200zł");
                }
                else {
                    System.out.println("Koniec gry");
                    App.zaczynajacy = -1;
                }
                break;
            case 39:
                tmp = plansza.statusMiejsca(39);
                if(g.finanse > tmp){
                    g.finanse = g.finanse - tmp;
                    g.zakupione.add(39);
                    g.nazwypolkup.add("Wieden");
                    plansza.zmianaStatusuPola(39);
                }else if((g.finanse < tmp) && (tmp != 1000000) && (tmp != 5000000)){
                    komunikaty.niemoznosc_kupna();
                }
                else if(tmp == 1000000) {
                    tmpdla2(g,polozenie, 37, "Wieden", 400);
                }
                break;
        }
    }
    public void tmpdlainfrastruktury(Gracz g, int polozenie, int id2){
        for(int i=0; i<App.liczbagraczy; i++){
            if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(polozenie)){
                komunikaty.infoograczu(App.gracze[i].imie);
                if(App.gracze[i].zakupione.contains(id2)){
                    System.out.println(App.gracze[i].imie + " posiada całą infrastrukture");
                    System.out.println("Płacisz mu 300zł");
                    App.gracze[i].finanse += 300;
                    if(g.finanse > 300){
                        g.finanse -= 300;
                    }else {
                        System.out.println("Koniec gry");
                        App.zaczynajacy = -1;
                    }
                }
                else {
                    System.out.println("Płacisz za elektrownie 80zł");
                    App.gracze[i].finanse += 80;
                    if(g.finanse > 80){
                        g.finanse -= 80;
                    }
                    else{
                        System.out.println("Koniec gry");
                        App.zaczynajacy = -1;
                    }
                }
            }
        }
    }
    public void tmpdlakolei(Gracz g, int polozenie, int id2, int id3, int id4) {
        for(int i=0; i<App.liczbagraczy; i++){
            if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(polozenie)){
                komunikaty.infoograczu(App.gracze[i].imie);
                if(App.gracze[i].zakupione.contains(id2) && App.gracze[i].zakupione.contains(id3) && App.gracze[i].zakupione.contains(id4)){
                    System.out.println(App.gracze[i].imie + " posiada wszystkie koleje");
                    System.out.println("Płacisz mu 400 zł");
                    App.gracze[i].finanse += 400;
                    if(g.finanse > 400){
                        g.finanse -= 400;
                    }else{
                        System.out.println("koniec gry");
                        App.zaczynajacy = -1;
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
                        App.zaczynajacy = -1;
                    }
                }
            }
        }
    }
    public void tmpdla2(Gracz g, int id, int id2, String nazwa, int dom){
        for(int i=0; i<App.liczbagraczy; i++){
            if((App.gracze[i] != g) && App.gracze[i].zakupione.contains(id)){
                komunikaty.infoograczu(App.gracze[i].imie);
                if(App.gracze[i].zakupione.contains(id2)){
                    int ilosc = Collections.frequency(App.gracze[i].wybudowane, nazwa);
                        if(ilosc == 0){
                            System.out.println("Gracz nie ma żadnych budynków tutaj");
                            System.out.println("Płacisz graczowi "+ dom + "zł");
                            App.gracze[i].finanse += dom;
                            if(g.finanse > dom) {
                                g.finanse -= dom;
                            }
                            else{
                                System.out.println("koniec gry!");
                                App.zaczynajacy = -1;
                            }
                        }
                        else if(ilosc == 1){
                            System.out.println("Gracz ma teren z 1 zabudową");
                            System.out.println("Płacisz graczowi "+ dom+100+"zł");
                            App.gracze[i].finanse += (dom + 100);
                            if (g.finanse > dom + 100) {
                                g.finanse -= (dom + 100);
                            }
                            else{
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                        else if(ilosc == 2){
                            System.out.println("Gracz ma teren z 2 domami");
                            System.out.println("Płacisz graczowi "+dom + 140+ "zł");
                            App.gracze[i].finanse += (dom + 140);
                            if(g.finanse > (dom+ 140)) {
                                g.finanse -= (dom + 140);
                            }
                            else{
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                        else if(ilosc == 3){
                            System.out.println("Gracz ma teren z 3 domami");
                            System.out.println("Płacisz graczowi " + dom + 300 +"zł");
                            App.gracze[i].finanse += (dom+300);
                            if(g.finanse > dom+300) {
                                g.finanse -= (dom+300);
                            }
                            else{
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                        else if(ilosc == 4){
                            System.out.println("Gracz ma teren z 4 domami");
                            System.out.println("Płacisz graczowi "+dom+600+"zł");
                            App.gracze[i].finanse += (dom+600);
                            if(g.finanse > dom+600) {
                                g.finanse -= (dom + 600);
                            }
                            else{
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                        else if(ilosc == 5){
                            System.out.println("Gracz ma teren z 1 hotelem");
                            System.out.println("Płacisz graczowi "+dom+900+"zł");
                            App.gracze[i].finanse += (dom+900);
                            if(g.finanse > (dom+900)) {
                                g.finanse -= (dom+900);
                            }else{
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                }else{
                    System.out.println("Płacisz za teren niezabudowany "+dom+"zł");
                    App.gracze[i].finanse += dom;
                    if(g.finanse > dom) {
                        g.finanse -= dom;
                    }
                    else{
                        System.out.println("koniec gry");
                        App.zaczynajacy = -1;
                    }
                }
            }
        }
    }
    public void tmpdla3(Gracz g, int id, int id2, int id3, String nazwa, int dom){
        for(int i=0; i<App.liczbagraczy; i++) {
            if ((App.gracze[i] != g) && App.gracze[i].zakupione.contains(id)) {
                komunikaty.infoograczu(App.gracze[i].imie);
                if (App.gracze[i].zakupione.contains(id2) && App.gracze[i].zakupione.contains(id3)) {
                    int ilosc = Collections.frequency(App.gracze[i].wybudowane, nazwa);
                        if (ilosc == 0) {
                            System.out.println("Gracz nie ma żadnych budynków tutaj");
                            System.out.println("Płacisz graczowi " + dom + "zł");
                            App.gracze[i].finanse += dom;
                            if (g.finanse > dom) {
                                g.finanse -= dom;
                            } else {
                                System.out.println("koniec gry!");
                                App.zaczynajacy = -1;
                            }
                        } else if (ilosc == 1) {
                            System.out.println("Gracz ma teren z 1 zabudową");
                            System.out.println("Płacisz graczowi " + dom + 100 + "zł");
                            App.gracze[i].finanse += (dom + 100);
                            if (g.finanse > dom + 100) {
                                g.finanse -= (dom + 100);
                            } else {
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        } else if (ilosc == 2) {
                            System.out.println("Gracz ma teren z 2 domami");
                            System.out.println("Płacisz graczowi " + dom + 140 + "zł");
                            App.gracze[i].finanse += (dom + 140);
                            if (g.finanse > (dom + 140)) {
                                g.finanse -= (dom + 140);
                            } else {
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        } else if (ilosc == 3) {
                            System.out.println("Gracz ma teren z 3 domami");
                            System.out.println("Płacisz graczowi " + dom + 300 + "zł");
                            App.gracze[i].finanse += (dom + 300);
                            if (g.finanse > dom + 300) {
                                g.finanse -= (dom + 300);
                            } else {
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        } else if (ilosc == 4) {
                            System.out.println("Gracz ma teren z 4 domami");
                            System.out.println("Płacisz graczowi " + dom + 600 + "zł");
                            App.gracze[i].finanse += (dom + 600);
                            if (g.finanse > dom + 600) {
                                g.finanse -= (dom + 600);
                            } else {
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        } else if (ilosc == 5) {
                            System.out.println("Gracz ma teren z 1 hotelem");
                            System.out.println("Płacisz graczowi " + dom + 900+"zł");
                            App.gracze[i].finanse += (dom + 900);
                            if (g.finanse > (dom + 900)) {
                                g.finanse -= (dom + 900);
                            } else {
                                System.out.println("koniec gry");
                                App.zaczynajacy = -1;
                            }
                        }
                } else {
                    System.out.println("Płacisz za teren niezabudowany " + dom + "zł");
                    App.gracze[i].finanse += dom;
                    if (g.finanse > dom) {
                        g.finanse -= dom;
                    } else {
                        System.out.println("koniec gry");
                        App.zaczynajacy = -1;
                    }
                }
            }
        }
    }
}
