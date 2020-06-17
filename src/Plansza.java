import java.util.Scanner;

public class Plansza {
    public int[] pole = new int[40];
    public int i;
    public int[] wiezienia = new int[2];
    public int[] kara = new int[2];
    public int skarbiec = 0;
    public int id_skarbca;
    public int pole_startu;
    public String wybor;


    Komunikaty komunikaty = new Komunikaty();
    Panstwo []panstwa = new Panstwo[8];
    Miasto []greckie = new Miasto[2];
    Miasto []wloskie = new Miasto[3];
    Miasto []hiszpanskie = new Miasto[3];
    Miasto []brytyjskie = new Miasto[3];
    Miasto []beneluxu = new Miasto[3];
    Miasto []szwedzkie = new Miasto[3];
    Miasto []niemieckie = new Miasto[3];
    Miasto []austriackie = new Miasto[2];
    Pytajnik []pytajniki = new Pytajnik[6];
    Kolej []kolejki = new Kolej[4];
    Infrastruktura []infrastruktury = new Infrastruktura[2];
    Scanner scanner = new Scanner(System.in);

    public void uzupelnij_plansze(){

        for(i=0; i<3; i++){
            if(i < 2){
                greckie[i] = new Miasto();
                austriackie[i] = new Miasto();
            }
            wloskie[i] = new Miasto();
            hiszpanskie[i] = new Miasto();
            brytyjskie[i] = new Miasto();
            beneluxu[i] = new Miasto();
            szwedzkie[i] = new Miasto();
            niemieckie[i] = new Miasto();
        }

        for(i=0; i<8; i++){
            panstwa[i] = new Panstwo();

            if(i == 0){
                panstwa[i].name = "Grecja";
                greckie[0].name = "Ateny";
                greckie[0].koszt = 120;
                greckie[1].name = "Saloniki";
                greckie[1].koszt = 120;
            }
            if(i == 1){
                panstwa[i].name = "Wlochy";
                wloskie[0].name = "Neapol";
                wloskie[0].koszt = 200;
                wloskie[1].name = "Mediolan";
                wloskie[1].koszt = 200;
                wloskie[2].name = "Rzym";
                wloskie[2].koszt = 240;
            }
            if(i == 2){
                panstwa[i].name = "Hiszpania";
                hiszpanskie[0].name = "Barcelona";
                hiszpanskie[0].koszt = 250;
                hiszpanskie[1].name = "Sewilla";
                hiszpanskie[1].koszt = 250;
                hiszpanskie[2].name = "Madryt";
                hiszpanskie[2].koszt = 280;
            }
            if(i == 3){
                panstwa[i].name = "Wielka Brytania";
                brytyjskie[0].name = "Liverpool";
                brytyjskie[0].koszt = 350;
                brytyjskie[1].name = "Glasgow";
                brytyjskie[1].koszt = 350;
                brytyjskie[2].name = "Londyn";
                brytyjskie[2].koszt = 400;
            }
            if(i == 4){
                panstwa[i].name = "Benelux";
                beneluxu[0].name = "Rotterdam";
                beneluxu[0].koszt = 440;
                beneluxu[1].name = "Bruksela";
                beneluxu[1].koszt = 440;
                beneluxu[2].name = "Amsterdam";
                beneluxu[2].koszt = 490;
            }
            if(i == 5){
                panstwa[i].name = "Szwecja";
                szwedzkie[0].name = "Malmo";
                szwedzkie[0].koszt = 520;
                szwedzkie[1].name = "Goteborg";
                szwedzkie[1].koszt = 520;
                szwedzkie[2].name = "Sztokholm";
                szwedzkie[2].koszt = 580;
            }
            if(i == 6){
                panstwa[i].name = "Niemcy";
                niemieckie[0].name = "Frankfurt";
                niemieckie[0].koszt = 600;
                niemieckie[1].name = "Kolonia";
                niemieckie[1].koszt = 600;
                niemieckie[2].name = "Berlin";
                niemieckie[2].koszt = 650;
            }
            if(i == 7){
                panstwa[i].name = "Austria";
                austriackie[0].name = "Insbruk";
                austriackie[0].koszt = 700;
                austriackie[1].name = "Wieden";
                austriackie[1].koszt = 800;
            }
        }
    for(i=0; i<40; i++){
        pole[i] = i;
    }

    for(i=0; i<6; i++){
        pytajniki[i] = new Pytajnik();
    }
    for(i=0; i<40; i++) {
        if(i == 0){
            pole_startu = pole[i];
        }
        if(i == 1){
            greckie[0].id = pole[i];
        }
        if(i == 2){
            pytajniki[0].id = pole[i];
        }
        if(i == 3){
            greckie[1].id = pole[i];
        }
        if(i == 4) {
            kara[0] = pole[i];
        }
        if(i == 5) {
            kolejki[0] = new Kolej();
            kolejki[0].id = pole[i];
            kolejki[0].nazwa = "kolej poludniowa";
            kolejki[0].koszt = 400;
        }
        if(i == 6){
            wloskie[0].id = pole[i];
        }
        if(i == 7){
            pytajniki[1].id = pole[i];
        }
        if(i == 8){
            wloskie[1].id = pole[i];
        }
        if(i == 9){
            wloskie[2].id = pole[i];
        }
        if(i == 10){
            wiezienia[0] = pole[i];
        }
        if(i == 11){
            hiszpanskie[0].id = pole[i];
        }
        if(i == 12){
            infrastruktury[0] = new Infrastruktura();
            infrastruktury[0].id = pole[i];
            infrastruktury[0].nazwa = "elektrownia";
            infrastruktury[0].koszt = 300;
        }
        if(i == 13){
            hiszpanskie[1].id = pole[i];
        }
        if(i == 14){
            hiszpanskie[2].id = pole[i];
        }
        if(i == 15){
            kolejki[1] = new Kolej();
            kolejki[1].id = pole[i];
            kolejki[1].nazwa = "kolej zachodnia";
            kolejki[1].koszt = 400;
        }
        if(i == 16){
            brytyjskie[0].id = pole[i];
        }
        if(i == 17){
            pytajniki[2].id = pole[i];
        }
        if(i == 18){
            brytyjskie[1].id = pole[i];
        }
        if(i == 19){
            brytyjskie[2].id = pole[i];
        }
        if(i == 20){
            id_skarbca = pole[i];
        }
        if(i == 21){
            beneluxu[0].id = pole[i];
        }
        if(i == 22){
            pytajniki[3].id = pole[i];
        }
        if(i == 23){
            beneluxu[1].id = pole[i];
        }
        if(i == 24){
            beneluxu[2].id = pole[i];
        }
        if(i == 25){
            kolejki[2] = new Kolej();
            kolejki[2].id = pole[i];
            kolejki[2].nazwa = "kolej północna";
            kolejki[2].koszt = 400;
        }
        if(i == 26){
            szwedzkie[0].id = pole[i];
        }
        if(i == 27){
            szwedzkie[1].id = pole[i];
        }
        if(i == 28){
            infrastruktury[1] = new Infrastruktura();
            infrastruktury[1].id = pole[i];
            infrastruktury[1].nazwa = "wodociągi";
            infrastruktury[1].koszt = 300;
        }
        if(i == 29){
            szwedzkie[2].id = pole[i];
        }
        if(i == 30){
            wiezienia[1] = pole[i];
        }
        if(i == 31){
            niemieckie[0].id = pole[i];
        }
        if(i == 32){
            niemieckie[1].id = pole[i];
        }
        if(i == 33){
            pytajniki[4].id = pole[i];
        }
        if(i == 34){
            niemieckie[2].id = pole[i];
        }
        if(i == 35){
            kolejki[3] = new Kolej();
            kolejki[3].id = pole[i];
            kolejki[3].nazwa = "kolej wschodnia";
            kolejki[3].koszt = 400;
        }
        if(i == 36){
            pytajniki[5].id = pole[i];
        }
        if(i == 37){
            austriackie[0].id = pole[i];
        }
        if(i == 38){
            kara[1] = pole[i];
        }
        if(i == 39){
            austriackie[1].id = pole[i];
        }
    }
    }
    public int statusMiejsca(int id_miejsca) {
        if (id_miejsca == 0) {
            return 1;
        } else if (id_miejsca == 1) {
            if (!(greckie[0].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + greckie[0].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    greckie[0].kupione = true;
                    return greckie[0].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 3) {
            if (!(greckie[1].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + greckie[1].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    greckie[1].kupione = true;
                    return greckie[1].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if(id_miejsca == 5) {
            if(!(kolejki[0].kupione)) {
                komunikaty.infokolejki();
                System.out.println("Cena: " + kolejki[0].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if(wybor.equals("y") || wybor.equals("Y")) {
                    kolejki[0].kupione = true;
                    return kolejki[0].koszt;
                }
            } else {
                return 1000000;
            }
        }
        else if (id_miejsca == 6) {
            if (!(wloskie[0].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + wloskie[0].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    wloskie[0].kupione = true;
                    return wloskie[0].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 8) {
            if (!(wloskie[1].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + wloskie[1].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    wloskie[1].kupione = true;
                    return wloskie[1].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 9) {
            if (!(wloskie[2].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + wloskie[2].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    wloskie[2].kupione = true;
                    return wloskie[2].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 11) {
            if (!(hiszpanskie[0].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + hiszpanskie[0].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    hiszpanskie[0].kupione = true;
                    return hiszpanskie[0].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 13) {
            if (!(hiszpanskie[1].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + hiszpanskie[1].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    hiszpanskie[1].kupione = true;
                    return hiszpanskie[1].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 14) {
            if (!(hiszpanskie[2].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + hiszpanskie[2].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    hiszpanskie[2].kupione = true;
                    return hiszpanskie[2].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        else if (id_miejsca == 16) {
            if (!(brytyjskie[0].kupione)) {
                komunikaty.infomiasta();
                System.out.println("Cena: " + brytyjskie[0].koszt);
                komunikaty.zacheta_kupna();
                wybor = scanner.nextLine();
                while (!((wybor.equals("y")) || (wybor.equals("Y")) || (wybor.equals("n")) || (wybor.equals("N")))) {
                    System.out.println("Chyba nie podałeś poprawnie akcji jaką wykonać, spróbuj ponownie");
                    wybor = scanner.nextLine();
                }
                if (wybor.equals("y") || wybor.equals("Y")) {
                    brytyjskie[0].kupione = true;
                    return brytyjskie[0].koszt;
                }
            }
            else{
                return 1000000;
            }
        }
        return 0;
    }
    public void zmianaStatusuPola(int x){
        if(x == 1){
            greckie[0].kupione = false;
        }
        else if(x == 3){
            greckie[1].kupione = false;
        }
        else if(x == 5){
            kolejki[0].kupione = false;
        }
        else if(x == 6){
            wloskie[0].kupione = false;
        }
        else if(x == 8){
            wloskie[1].kupione = false;
        }
        else if(x == 9){
            wloskie[2].kupione = false;
        }
        else if(x == 11){
            hiszpanskie[0].kupione = false;
        }
        else if(x == 13){
            hiszpanskie[1].kupione = false;
        }
        else if(x == 14){
            hiszpanskie[2].kupione = false;
        }
        else if(x == 16){
            brytyjskie[0].kupione = false;
        }
        else if(x == 18){
            brytyjskie[1].kupione = false;
        }
        else if(x == 19){
            brytyjskie[2].kupione = false;
        }
        else if(x == 21){
            beneluxu[0].kupione = false;
        }
        else if(x == 23){
            beneluxu[1].kupione = false;
        }
        else if(x == 24){
            beneluxu[2].kupione = false;
        }
        else if(x == 26){
            szwedzkie[0].kupione = false;
        }
        else if(x == 27){
            szwedzkie[1].kupione = false;
        }
        else if(x == 29){
            szwedzkie[2].kupione = false;
        }
        else if(x == 31){
            niemieckie[0].kupione = false;
        }
        else if(x == 32){
            niemieckie[1].kupione = false;
        }
        else if(x == 34){
            niemieckie[2].kupione = false;
        }
        else if(x == 37){
            austriackie[0].kupione = false;
        }
        else if(x == 39){
            austriackie[1].kupione = false;
        }
    }

    public void miejsceGracza(int nr_miejsca){
        if(nr_miejsca == 0){
            System.out.println("Jesteś na polu start");
        }
        else if(nr_miejsca == 1){
            System.out.println("Saloniki");
        }
        else if(nr_miejsca == 2){
            pytajniki[0].tresc("Nie stawiłeś się rano w pracy. Płacisz 100zł");
        }
        else if(nr_miejsca == 3){
            System.out.println("Ateny");
        }
        else if(nr_miejsca == 4) {
            System.out.println("Szpital, płacisz 400zł");
        }
        else if(nr_miejsca == 5) {
            System.out.println(kolejki[0].nazwa = "kolej poludniowa");
        }
        else if(nr_miejsca == 6){
            System.out.println(wloskie[0].name);
        }
        else if(nr_miejsca == 7){
            pytajniki[1].tresc("Dobrze obstawiłeś, wygrywasz 100zł");
        }
        else if(nr_miejsca == 8){
            System.out.println(wloskie[1].name);
        }
        else if(nr_miejsca == 9){
            System.out.println(wloskie[2].name);
        }
        else if(nr_miejsca == 10){
            System.out.println("Wiezienie");
        }
        else if(nr_miejsca == 11){
            System.out.println(hiszpanskie[0].name);
        }
        else if(nr_miejsca == 12){
            System.out.println(infrastruktury[0].nazwa);
        }
        else if(nr_miejsca == 13){
            System.out.println(hiszpanskie[1].name);
        }
        else if(nr_miejsca == 14){
            System.out.println(hiszpanskie[2].name);
        }
        else if(nr_miejsca == 15){
            System.out.println(kolejki[1].nazwa);
        }
        else if(nr_miejsca == 16){
            System.out.println(brytyjskie[0].name);
        }
        else if(nr_miejsca == 17){
            pytajniki[2].tresc("Niestety za szybko jechałeś. Płacisz 50zł");
        }
        else if(nr_miejsca == 18){
            System.out.println(brytyjskie[1].name);
        }
        else if(nr_miejsca == 19){
            System.out.println(brytyjskie[2].name);
        }
        else if(nr_miejsca == 20){
            System.out.println("Skarbiec");;
        }
        else if(nr_miejsca == 21){
            System.out.println(beneluxu[0].name);
        }
        else if(nr_miejsca == 22){
            pytajniki[3].tresc("Masz urodziny, od każdego gracza otrzymujesz 20zł");
        }
        else if(nr_miejsca == 23){
            System.out.println(beneluxu[1].name);
        }
        else if(nr_miejsca == 24){
            System.out.println(beneluxu[2].name);
        }
        else if(nr_miejsca == 25){
            System.out.println(kolejki[2].nazwa);
        }
        else if(nr_miejsca == 26){
            System.out.println(szwedzkie[0].name);
        }
        else if(nr_miejsca == 27){
            System.out.println(szwedzkie[1].name);
        }
        else if(nr_miejsca == 28){
            System.out.println(infrastruktury[1].nazwa);
        }
        else if(nr_miejsca == 29){
            System.out.println(szwedzkie[2].name);
        }
        else if(nr_miejsca == 30){
            System.out.println("Wiezienie");;
        }
        else if(nr_miejsca == 31){
            System.out.println(niemieckie[0].name);
        }
        else if(nr_miejsca == 32){
            System.out.println(niemieckie[1].name);
        }
        else if(nr_miejsca == 33){
            pytajniki[4].tresc("Placisz za każdy dom 20zł za każdy hotel 50zł");
        }
        else if(nr_miejsca == 34){
            System.out.println(niemieckie[2].name);
        }
        else if(nr_miejsca == 35){
            System.out.println(kolejki[3].nazwa);
        }
        else if(nr_miejsca == 36){
            pytajniki[5].tresc("Przenosisz się na START");
        }
        else if(nr_miejsca == 37){
            System.out.println(austriackie[0].name);
        }
        else if(nr_miejsca == 38){
            System.out.println("Kara, placisz 200zł");
        }
        else if(nr_miejsca == 39){
            System.out.println(austriackie[1].name);
        }
    }
}
