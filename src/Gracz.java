import java.util.*;

public class Gracz {
    public String imie;
    public int finanse = 3000;
    public List<Integer> zakupione = new ArrayList<>();
    public List<String> nazwypolkup = new ArrayList<>();
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

    public void kupno_zabudowy(){
        System.out.println("Kupiłeś do tej pory");
        System.out.println(nazwypolkup + " ");
        System.out.println("Domki");
        System.out.println(wybudowane + " ");
    }

    public boolean niemoznosc_kupna_domku(String nazwa){
        int krotnosc = Collections.frequency(wybudowane, nazwa);

        if(krotnosc < 5){
            return true;
        }
        return false;
    }

    public boolean decyzje_kupna_domu(){
        System.out.println(" ");
        komunikaty.zacheta_domu();
        Scanner scanner = new Scanner(System.in);
        String decyzja = scanner.nextLine();
        while(!(decyzja.equals("t") || decyzja.equals("T") || decyzja.equals("n") || decyzja.equals("N"))){
            System.out.println("Nie podałeś poprawnej akcji, spróbuj wpisać ponownie");
            decyzja = scanner.nextLine();
        }
        if(decyzja.equals("t") || decyzja.equals("T")){
            return true;
        }
        return false;
    }
    public int decyzja_ile(){
        System.out.println("Możliwości");
        komunikaty.info_ile_domkow();
        Scanner scanner = new Scanner(System.in);
        int decyzja = scanner.nextInt();
        while(!(decyzja == 1 || decyzja == 2 || decyzja == 3)){
            System.out.println("Nie podałeś poprawnej akcji, spróbuj wpisać ponownie");
            decyzja = scanner.nextInt();
        }
        if(decyzja == 1){
            return 1;
        }
        else if(decyzja == 2){
            return 2;
        }
        return 3;
    }

    public void posiadlosc_kraj(){
        if(zakupione.contains(1) && zakupione.contains(3)){
            System.out.println("Posiadasz Grecję");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Salonikach czy Atenach? wybierz S lub A");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("S") || odp.equals("s") || odp.equals("A") || odp.equals("a"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("S") || odp.equals("s")){
                        if(niemoznosc_kupna_domku("Saloniki")) {
                            System.out.println("Każdy domek 40zł");

                            if (finanse > 40) {
                                System.out.println("Zapłaciłeś 40zł");
                                finanse -= 40;
                                wybudowane.add("Saloniki");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Ateny")) {
                            System.out.println("Każdy domek 60zł");

                            if (finanse > 60) {
                                System.out.println("Zapłaciłeś 60zł");
                                finanse -= 60;
                                wybudowane.add("Ateny");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 2 || decyzja_ile() == 3){
                    if(niemoznosc_kupna_domku("Saloniki")) {
                        if(niemoznosc_kupna_domku("Ateny")) {
                            System.out.println("Domek w Atenach 60zł, w Salonikach 40zł");
                            if (finanse > 100) {
                                System.out.println(" Zapłaciłeś 100zł");
                                finanse -= 100;
                                wybudowane.add("Ateny");
                                wybudowane.add("Saloniki");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            System.out.println("Masz wszystkie domy w Atenach");
                        }
                    }
                    else{
                        System.out.println("Masz wszystkie domy w Salonikach");
                    }
                }
            }
        }
        if(zakupione.contains(37) && zakupione.contains(39)){
            System.out.println("Posiadasz Austrie");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Insbruku czy Wiedniu? wybierz I lub W");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("I") || odp.equals("i") || odp.equals("W") || odp.equals("w"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("I") || odp.equals("i")){
                        if(niemoznosc_kupna_domku("Insbruk")) {
                            System.out.println("Każdy domek 300zł");

                            if (finanse > 300) {
                                System.out.println("Zapłaciłeś 300zł");
                                finanse -= 300;
                                wybudowane.add("Insbruk");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Wieden")) {
                            System.out.println("Każdy domek 400zł");

                            if (finanse > 400) {
                                System.out.println("Zapłaciłeś 400zł");
                                finanse -= 400;
                                wybudowane.add("Wieden");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 2 || decyzja_ile() == 3){
                    if(niemoznosc_kupna_domku("Insbruk")) {
                        if (niemoznosc_kupna_domku("Wieden")) {
                            System.out.println("Domek we Wiedniu 400zł, w Insbruku 300zł");
                            if (finanse > 700) {
                                System.out.println(" Zapłaciłeś 700zł");
                                finanse -= 700;
                                wybudowane.add("Wieden");
                                wybudowane.add("Insbruk");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            System.out.println("We wiedniu masz wszystkie domki");
                        }
                    }
                    else{
                        System.out.println("W insbruku masz wszystkie domki");
                    }
                }
            }
        }
        if(zakupione.contains(6) && zakupione.contains(8) && zakupione.contains(9)){
            System.out.println("Posiadasz Włochy");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Neapolu, Mediolanie czy Rzymie? wybierz N, M lub R");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("N") || odp.equals("n") || odp.equals("M") || odp.equals("m") || odp.equals("R") || odp.equals("r"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("N") || odp.equals("n")){
                        if(niemoznosc_kupna_domku("Neapol")) {
                            System.out.println("Każdy domek 55zł");

                            if (finanse > 55) {
                                System.out.println("Zapłaciłeś 55zł");
                                finanse -= 55;
                                wybudowane.add("Neapol");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("M") || odp.equals("m")){
                        if(niemoznosc_kupna_domku("Mediolan")) {
                            System.out.println("Każdy domek 55zł");
                            if (finanse > 55) {
                                System.out.println("Zapłaciłeś 55zł");
                                finanse -= 55;
                                wybudowane.add("Mediolan");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Rzym")) {
                            System.out.println("Każdy domek 80zł");

                            if (finanse > 80) {
                                System.out.println("Zapłaciłeś 80zł");
                                finanse -= 80;
                                wybudowane.add("Rzym");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Neapol")) {
                        if(niemoznosc_kupna_domku("Mediolan")) {
                            if(niemoznosc_kupna_domku("Rzym")) {
                                System.out.println("Domek w Rzymie 80zł, w Neapolu i Mediolanie 55zł");
                                if (finanse > 190) {
                                    System.out.println(" Zapłaciłeś 190zł");
                                    finanse -= 190;
                                    wybudowane.add("Rzym");
                                    wybudowane.add("Mediolan");
                                    wybudowane.add("Neapol");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Rzymie już");
                            }
                        }else{
                            System.out.println("Masz w Mediolanie wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już w Neapolu domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Neapol i Mediolan, Neapol i Rzym czy Mediolan i Rzym? Wybierz NM lub NR lub MR");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("NM") || od.equals("nm") || od.equals("NR") || od.equals("nr") || od.equals("MR") || od.equals("mr"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("NM") || od.equals("nm")){
                        if(niemoznosc_kupna_domku("Neapol")) {
                            if(niemoznosc_kupna_domku("Mediolan")) {
                                System.out.println("Każdy domek 55zł");
                                if (finanse > 110) {
                                    System.out.println("Zapłaciłeś 110zł");
                                    finanse -= 110;
                                    wybudowane.add("Neapol");
                                    wybudowane.add("Mediolan");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Mediolanie");
                            }
                        }else{
                            System.out.println("Masz w Neapolu już wszystkie domy");
                        }
                    }
                    else if(od.equals("NR") || od.equals("nr")){
                        if(niemoznosc_kupna_domku("Neapol")) {
                            if(niemoznosc_kupna_domku("Rzym")) {
                                System.out.println("Domek w Neapolu 55zł a w Rzymie 80zł");
                                if (finanse > 135) {
                                    System.out.println("Zapłaciłeś 135zł");
                                    finanse -= 135;
                                    wybudowane.add("Neapol");
                                    wybudowane.add("Rzym");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Rzymie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy w Neapolu");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Mediolan")) {
                            if (niemoznosc_kupna_domku("Rzym")) {
                                System.out.println("Domek w Mediolanie 55zł a w Rzymie 80zł");
                                if (finanse > 135) {
                                    System.out.println("Zapłaciłeś 135zł");
                                    finanse -= 135;
                                    wybudowane.add("Mediolan");
                                    wybudowane.add("Rzym");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Rzymie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Mediolanie");
                        }
                    }
                }
            }
        }
        if(zakupione.contains(11) && zakupione.contains(13) && zakupione.contains(14)){
            System.out.println("Posiadasz Hiszpanie");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Barcelonie, Sewilli czy Madrycie? wybierz B, S lub M");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("B") || odp.equals("b") || odp.equals("S") || odp.equals("s") || odp.equals("M") || odp.equals("m"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("B") || odp.equals("b")){
                        if(niemoznosc_kupna_domku("Barcelona")) {
                            System.out.println("Każdy domek 65zł");

                            if (finanse > 65) {
                                System.out.println("Zapłaciłeś 65zł");
                                finanse -= 65;
                                wybudowane.add("Barcelona");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("S") || odp.equals("s")){
                        if(niemoznosc_kupna_domku("Sewilla")) {
                            System.out.println("Każdy domek 65zł");
                            if (finanse > 65) {
                                System.out.println("Zapłaciłeś 65zł");
                                finanse -= 65;
                                wybudowane.add("Sewilla");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Madryt")) {
                            System.out.println("Każdy domek 90zł");

                            if (finanse > 90) {
                                System.out.println("Zapłaciłeś 90zł");
                                finanse -= 90;
                                wybudowane.add("Madryt");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Barcelona")) {
                        if(niemoznosc_kupna_domku("Sewilla")) {
                            if(niemoznosc_kupna_domku("Madryt")) {
                                System.out.println("Domek w Madrycie 90zł, w Barcelonie i Sewilli 65zł");
                                if (finanse > 220) {
                                    System.out.println(" Zapłaciłeś 220zł");
                                    finanse -= 220;
                                    wybudowane.add("Madryt");
                                    wybudowane.add("Sewilla");
                                    wybudowane.add("Barcelona");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Madrycie już");
                            }
                        }else{
                            System.out.println("Masz w Sewilli wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już w Barcelonie domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Barcelona i Sewilla, Barcelona i Madryt czy Sewilla i Madryt? Wybierz BS lub BM lub SM");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("BS") || od.equals("bs") || od.equals("BM") || od.equals("bm") || od.equals("SM") || od.equals("sm"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("BS") || od.equals("bs")){
                        if(niemoznosc_kupna_domku("Barcelona")) {
                            if(niemoznosc_kupna_domku("Sewilla")) {
                                System.out.println("Każdy domek 65zł");
                                if (finanse > 130) {
                                    System.out.println("Zapłaciłeś 130zł");
                                    finanse -= 130;
                                    wybudowane.add("Barcelona");
                                    wybudowane.add("Sewilla");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Sewille");
                            }
                        }else{
                            System.out.println("Masz w Barcelonie już wszystkie domy");
                        }
                    }
                    else if(od.equals("BM") || od.equals("bm")){
                        if(niemoznosc_kupna_domku("Barcelona")) {
                            if(niemoznosc_kupna_domku("Madryt")) {
                                System.out.println("Domek w Barcelonie 65zł a w Rzymie 90zł");
                                if (finanse > 155) {
                                    System.out.println("Zapłaciłeś 155zł");
                                    finanse -= 155;
                                    wybudowane.add("Barcelona");
                                    wybudowane.add("Madryt");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Madrycie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy w Barcelonie");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Sewilla")) {
                            if (niemoznosc_kupna_domku("Madryt")) {
                                System.out.println("Domek w Sewilli 65zł a w Madrycie 90zł");
                                if (finanse > 155) {
                                    System.out.println("Zapłaciłeś 155zł");
                                    finanse -= 155;
                                    wybudowane.add("Sewilla");
                                    wybudowane.add("Madryt");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Madrycie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Sewilli");
                        }
                    }
                }
            }
        }
        if(zakupione.contains(16) && zakupione.contains(18) && zakupione.contains(19)){
            System.out.println("Posiadasz Wielką Brytanie");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Liverpoolu, Glasgow czy Londynie? wybierz L, G lub Lon");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("L") || odp.equals("l") || odp.equals("G") || odp.equals("g") || odp.equals("Lon") || odp.equals("lon"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("L") || odp.equals("l")){
                        if(niemoznosc_kupna_domku("Liverpool")) {
                            System.out.println("Każdy domek 85zł");

                            if (finanse > 85) {
                                System.out.println("Zapłaciłeś 85zł");
                                finanse -= 85;
                                wybudowane.add("Liverpool");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("G") || odp.equals("g")){
                        if(niemoznosc_kupna_domku("Glasgow")) {
                            System.out.println("Każdy domek 85zł");
                            if (finanse > 85) {
                                System.out.println("Zapłaciłeś 85zł");
                                finanse -= 85;
                                wybudowane.add("Glasgow");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Londyn")) {
                            System.out.println("Każdy domek 110zł");

                            if (finanse > 110) {
                                System.out.println("Zapłaciłeś 110zł");
                                finanse -= 110;
                                wybudowane.add("Londyn");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Liverpool")) {
                        if(niemoznosc_kupna_domku("Glasgow")) {
                            if(niemoznosc_kupna_domku("Londyn")) {
                                System.out.println("Domek w Londynie 110zł, w Liverpoolu i Glasgow 85zł");
                                if (finanse > 280) {
                                    System.out.println(" Zapłaciłeś 280zł");
                                    finanse -= 280;
                                    wybudowane.add("Londyn");
                                    wybudowane.add("Glasgow");
                                    wybudowane.add("Liverpool");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Londynie już");
                            }
                        }else{
                            System.out.println("Masz w Glasgow wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już w Liverpoolu domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Liverpool i Glasgow, Liverpool i Londyn czy Glasgow i Londyn? Wybierz LG lub LL lub GL");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("LG") || od.equals("lg") || od.equals("LL") || od.equals("ll") || od.equals("GL") || od.equals("gl"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("LG") || od.equals("lg")){
                        if(niemoznosc_kupna_domku("Liverpool")) {
                            if(niemoznosc_kupna_domku("Glasgow")) {
                                System.out.println("Każdy domek 85zł");
                                if (finanse > 170) {
                                    System.out.println("Zapłaciłeś 170zł");
                                    finanse -= 170;
                                    wybudowane.add("Liverpool");
                                    wybudowane.add("Glasgow");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Glasgow");
                            }
                        }else{
                            System.out.println("Masz w Liverpoolu już wszystkie domy");
                        }
                    }
                    else if(od.equals("LL") || od.equals("ll")){
                        if(niemoznosc_kupna_domku("Liverpool")) {
                            if(niemoznosc_kupna_domku("Londyn")) {
                                System.out.println("Domek w Liverpoolu 85zł a w Londynie 110zł");
                                if (finanse > 195) {
                                    System.out.println("Zapłaciłeś 195zł");
                                    finanse -= 195;
                                    wybudowane.add("Liverpool");
                                    wybudowane.add("Londyn");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Londynie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy w Liverpoolu");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Glasgow")) {
                            if (niemoznosc_kupna_domku("Londyn")) {
                                System.out.println("Domek w Glasgow 85zł a w Londynie 110zł");
                                if (finanse > 195) {
                                    System.out.println("Zapłaciłeś 195zł");
                                    finanse -= 195;
                                    wybudowane.add("Glasgow");
                                    wybudowane.add("Londyn");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Londynie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Glasgow");
                        }
                    }
                }
            }
        }
        if(zakupione.contains(21) && zakupione.contains(23) && zakupione.contains(24)){
            System.out.println("Posiadasz Państwa Beneluxu");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Rotterdamie, Brukseli czy Amsterdamie? wybierz R, B lub A");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("R") || odp.equals("r") || odp.equals("B") || odp.equals("b") || odp.equals("A") || odp.equals("a"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("R") || odp.equals("r")){
                        if(niemoznosc_kupna_domku("Rotterdam")) {
                            System.out.println("Każdy domek 100zł");

                            if (finanse > 100) {
                                System.out.println("Zapłaciłeś 100zł");
                                finanse -= 100;
                                wybudowane.add("Rotterdam");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("B") || odp.equals("b")){
                        if(niemoznosc_kupna_domku("Bruksela")) {
                            System.out.println("Każdy domek 100zł");
                            if (finanse > 100) {
                                System.out.println("Zapłaciłeś 100zł");
                                finanse -= 100;
                                wybudowane.add("Bruksela");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Amsterdam")) {
                            System.out.println("Każdy domek 150zł");

                            if (finanse > 150) {
                                System.out.println("Zapłaciłeś 150zł");
                                finanse -= 150;
                                wybudowane.add("Amsterdam");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Rotterdam")) {
                        if(niemoznosc_kupna_domku("Bruksela")) {
                            if(niemoznosc_kupna_domku("Amsterdam")) {
                                System.out.println("Domek w Amsterdamie 150zł, w Rotterdamie i Brukseli 100zł");
                                if (finanse > 350) {
                                    System.out.println(" Zapłaciłeś 350zł");
                                    finanse -= 350;
                                    wybudowane.add("Amsterdam");
                                    wybudowane.add("Bruksela");
                                    wybudowane.add("Rotterdam");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Amsterdamie już");
                            }
                        }else{
                            System.out.println("Masz w Brukseli wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już w Rotterdamie domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Rotterdam i Bruksela, Rotterdam i Amsterdam czy Bruksela i Amsterdam? Wybierz RB lub RA lub BA");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("RB") || od.equals("rb") || od.equals("RA") || od.equals("ra") || od.equals("BA") || od.equals("ba"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("RB") || od.equals("rb")){
                        if(niemoznosc_kupna_domku("Rotterdam")) {
                            if(niemoznosc_kupna_domku("Bruksela")) {
                                System.out.println("Każdy domek 100zł");
                                if (finanse > 200) {
                                    System.out.println("Zapłaciłeś 200zł");
                                    finanse -= 200;
                                    wybudowane.add("Rotterdam");
                                    wybudowane.add("Bruksela");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Brukseli");
                            }
                        }else{
                            System.out.println("Masz w Rotterdamie już wszystkie domy");
                        }
                    }
                    else if(od.equals("RA") || od.equals("ra")){
                        if(niemoznosc_kupna_domku("Rotterdam")) {
                            if(niemoznosc_kupna_domku("Amsterdam")) {
                                System.out.println("Domek w Rotterdamie 100zł a w Amsterdamie 150zł");
                                if (finanse > 250) {
                                    System.out.println("Zapłaciłeś 250zł");
                                    finanse -= 250;
                                    wybudowane.add("Rotterdam");
                                    wybudowane.add("Amsterdam");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Amsterdamie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy w Rotterdamie");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Bruksela")) {
                            if (niemoznosc_kupna_domku("Amsterdam")) {
                                System.out.println("Domek w Brukseli 100zł a w Amsterdamie 150zł");
                                if (finanse > 250) {
                                    System.out.println("Zapłaciłeś 250zł");
                                    finanse -= 250;
                                    wybudowane.add("Bruksela");
                                    wybudowane.add("Amsterdam");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Amsterdamie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Brukseli");
                        }
                    }
                }
            }
        }
        if(zakupione.contains(26) && zakupione.contains(27) && zakupione.contains(29)){
            System.out.println("Posiadasz Szwecje");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("W Malmo, Goteborgu czy Sztokholmie? wybierz M, G lub S");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("M") || odp.equals("m") || odp.equals("G") || odp.equals("g") || odp.equals("S") || odp.equals("s"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("M") || odp.equals("m")){
                        if(niemoznosc_kupna_domku("Malmo")) {
                            System.out.println("Każdy domek 180zł");

                            if (finanse > 180) {
                                System.out.println("Zapłaciłeś 180zł");
                                finanse -= 180;
                                wybudowane.add("Malmo");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("G") || odp.equals("g")){
                        if(niemoznosc_kupna_domku("Goteborg")) {
                            System.out.println("Każdy domek 180zł");
                            if (finanse > 180) {
                                System.out.println("Zapłaciłeś 180zł");
                                finanse -= 180;
                                wybudowane.add("Goteborg");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Sztokholm")) {
                            System.out.println("Każdy domek 190zł");

                            if (finanse > 190) {
                                System.out.println("Zapłaciłeś 190zł");
                                finanse -= 190;
                                wybudowane.add("Sztokholm");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Malmo")) {
                        if(niemoznosc_kupna_domku("Goteborg")) {
                            if(niemoznosc_kupna_domku("Sztokholm")) {
                                System.out.println("Domek w Sztokholmie 190zł, w Malmo i Goteborgu 180zł");
                                if (finanse > 550) {
                                    System.out.println(" Zapłaciłeś 550zł");
                                    finanse -= 550;
                                    wybudowane.add("Sztokholm");
                                    wybudowane.add("Goteborg");
                                    wybudowane.add("Malmo");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Sztokholmie już");
                            }
                        }else{
                            System.out.println("Masz w Goteborgu wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już w Malmo domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Malmo i Goteborg, Malmo i Sztokholm czy Goteborg i Sztokholm? Wybierz MG lub MS lub GS");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("MG") || od.equals("mg") || od.equals("MS") || od.equals("ms") || od.equals("GS") || od.equals("gs"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("MG") || od.equals("mg")){
                        if(niemoznosc_kupna_domku("Malmo")) {
                            if(niemoznosc_kupna_domku("Goteborg")) {
                                System.out.println("Każdy domek 180zł");
                                if (finanse > 360) {
                                    System.out.println("Zapłaciłeś 360zł");
                                    finanse -= 360;
                                    wybudowane.add("Malmo");
                                    wybudowane.add("Goteborg");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Goteborgu");
                            }
                        }else{
                            System.out.println("Masz w Malmo już wszystkie domy");
                        }
                    }
                    else if(od.equals("MS") || od.equals("ms")){
                        if(niemoznosc_kupna_domku("Malmo")) {
                            if(niemoznosc_kupna_domku("Sztokholm")) {
                                System.out.println("Domek w Malmo 180zł a w Sztokholmie 190zł");
                                if (finanse > 370) {
                                    System.out.println("Zapłaciłeś 370zł");
                                    finanse -= 370;
                                    wybudowane.add("Malmo");
                                    wybudowane.add("Sztokholm");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Sztokholmie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy w Malmo");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Goteborg")) {
                            if (niemoznosc_kupna_domku("Sztokholm")) {
                                System.out.println("Domek w Goteborgu 180zł a w Sztokholmie 190zł");
                                if (finanse > 370) {
                                    System.out.println("Zapłaciłeś 370zł");
                                    finanse -= 370;
                                    wybudowane.add("Goteborg");
                                    wybudowane.add("Sztokholm");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Sztokholmie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Goteborgu");
                        }
                    }
                }
            }
        }
        if(zakupione.contains(31) && zakupione.contains(32) && zakupione.contains(34)){
            System.out.println("Posiadasz Niemcy");
            boolean dkd = decyzje_kupna_domu();
            if(dkd){
                int di = decyzja_ile();
                if(di == 1){
                    System.out.println("We Frankfurcie, Kolonii czy Berlinie? wybierz F, K lub B");
                    Scanner s = new Scanner(System.in);
                    String odp = s.nextLine();
                    while(!(odp.equals("F") || odp.equals("f") || odp.equals("K") || odp.equals("k") || odp.equals("B") || odp.equals("b"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        odp = s.nextLine();
                    }
                    if(odp.equals("F") || odp.equals("f")){
                        if(niemoznosc_kupna_domku("Frankfurt")) {
                            System.out.println("Każdy domek 200zł");

                            if (finanse > 200) {
                                System.out.println("Zapłaciłeś 200zł");
                                finanse -= 200;
                                wybudowane.add("Frankfurt");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }
                        else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else if(odp.equals("K") || odp.equals("k")){
                        if(niemoznosc_kupna_domku("Kolonia")) {
                            System.out.println("Każdy domek 200zł");
                            if (finanse > 200) {
                                System.out.println("Zapłaciłeś 200zł");
                                finanse -= 200;
                                wybudowane.add("Kolonia");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                    else {
                        if(niemoznosc_kupna_domku("Berlin")) {
                            System.out.println("Każdy domek 250zł");

                            if (finanse > 250) {
                                System.out.println("Zapłaciłeś 250zł");
                                finanse -= 250;
                                wybudowane.add("Berlin");
                            } else {
                                System.out.println("Nie masz tyle pieniedzy");
                            }
                        }else {
                            komunikaty.wszystkiedomy();
                        }
                    }
                }
                else if(di == 3){
                    if(niemoznosc_kupna_domku("Frankfurt")) {
                        if(niemoznosc_kupna_domku("Kolonia")) {
                            if(niemoznosc_kupna_domku("Berlin")) {
                                System.out.println("Domek w Berlinie 250zł, we Frankfurcie i Kolonii 200zł");
                                if (finanse > 650) {
                                    System.out.println(" Zapłaciłeś 650zł");
                                    finanse -= 650;
                                    wybudowane.add("Berlin");
                                    wybudowane.add("Kolonia");
                                    wybudowane.add("Frankfurt");
                                } else {
                                    System.out.println("Nie masz tyle pieniedzy");
                                }
                            }else {
                                System.out.println("Masz wszystkie domy w Berlinie już");
                            }
                        }else{
                            System.out.println("Masz w Kolonii wszystkie domy już");
                        }
                    }else{
                        System.out.println("Masz już we Frankfurcie domy wszystkie już");
                    }
                }
                else if(di == 2){
                    System.out.println("W których miastach chcesz kupić domy" +
                            " Frankfurt i Kolonia, Frankfurt i Berlin czy Kolonia i Berlin? Wybierz FK lub FB lub KB");
                    Scanner sc = new Scanner(System.in);
                    String od = sc.nextLine();
                    while(!(od.equals("FK") || od.equals("fk") || od.equals("FB") || od.equals("fb") || od.equals("KB") || od.equals("kb"))){
                        System.out.println("Podaj wlasciwie jeszcze raz");
                        od = sc.nextLine();
                    }
                    if(od.equals("FK") || od.equals("fk")){
                        if(niemoznosc_kupna_domku("Frankfurt")) {
                            if(niemoznosc_kupna_domku("Kolonia")) {
                                System.out.println("Każdy domek 200zł");
                                if (finanse > 400) {
                                    System.out.println("Zapłaciłeś 400zł");
                                    finanse -= 400;
                                    wybudowane.add("Frankfurt");
                                    wybudowane.add("Kolonia");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Masz już wszystkie domy w Kolonii");
                            }
                        }else{
                            System.out.println("Masz we Frankfurcie już wszystkie domy");
                        }
                    }
                    else if(od.equals("FB") || od.equals("fb")){
                        if(niemoznosc_kupna_domku("Frankfuurt")) {
                            if(niemoznosc_kupna_domku("Berlin")) {
                                System.out.println("Domek we Frankfurcie 200zł a w Berlinie 250zł");
                                if (finanse > 450) {
                                    System.out.println("Zapłaciłeś 450zł");
                                    finanse -= 450;
                                    wybudowane.add("Frankfurt");
                                    wybudowane.add("Berlin");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else {
                                System.out.println("Masz juz wszystkie domy w Berlinie");
                            }
                        }else{
                            System.out.println("Masz juz wszystkie domy we Frankfurcie");
                        }
                    }
                    else{
                        if(niemoznosc_kupna_domku("Kolonia")) {
                            if (niemoznosc_kupna_domku("Berlin")) {
                                System.out.println("Domek w Kolonii 200zł a w Berlinie 250zł");
                                if (finanse > 450) {
                                    System.out.println("Zapłaciłeś 450zł");
                                    finanse -= 450;
                                    wybudowane.add("Kolonia");
                                    wybudowane.add("Berlin");
                                } else {
                                    System.out.println("Nie masz tyle pieniędzy");
                                }
                            }else{
                                System.out.println("Wszystkie domy masz już w Berlinie");
                            }
                        }else{
                            System.out.println("Wszystkie domy masz już w Kolonii");
                        }
                    }
                }
            }
        }
    }
}
