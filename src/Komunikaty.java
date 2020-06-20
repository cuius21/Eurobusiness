public class Komunikaty {

    public void start(){
        System.out.println("Witaj w grze");
        System.out.println("EUROBUSSINESS");
    }
    public void ile_graczy(){
        System.out.println("Ile graczy ma zagrać?");
    }
    public void rozpoczecie(){
        System.out.println("No to zaczynajmy ...");
    }
    public void info_o_zaczynajacym_graczu(Gracz gracz_zaczynajacy){
        System.out.println("Zaczyna " + gracz_zaczynajacy.imie);
    }
    public void rzuckostka() {
        System.out.println("Kliknij w dowolną liczbe, aby rzucić kością");
    }
    public void wylosowanaliczba(int liczba) {
        System.out.println("Wyrzucono " + liczba);
    }

    public void infogracza1(int g){
        System.out.print("Gracz nr " + g);
        System.out.println();
        System.out.println("Podaj swoją nazwe:");
    }
    public void inforacza2(String imie, int finanse) {
        System.out.println("Witaj " + imie + ". Na początek zaczynasz z kwotą " + finanse + " zł");
    }
    public void infomiasta(){
        System.out.println("Miasto nie zostało jeszcze kupione");
    }
    public void zacheta_kupna(){
        System.out.println("Kupujesz? T : N");
    }
    public void niemoznosc_kupna(){
        System.out.println("Niestety masz za mało pieniędzy, aby to kupić");
    }
    public void zacheta_domu(){
        System.out.println("Chcesz kupić domki? T : N");
    }
    public void info_ile_domkow(){
        System.out.println("Domek w 1 miescie - naciśnij 1");
        System.out.println("Domki w 2 miastach - naciśnij 2");
        System.out.println("Domki w każdym mieście - naciśnij 3");
    }
    public void wszystkiedomy(){
        System.out.println("Masz już tu wszystkie możliwe do kupienia domy");
    }
    public void gotowka() {
        System.out.println("Przeszedłeś przez start, otrzymujesz 400zł");
    }
    public void infoograczu(String imie) {
        System.out.println("To miejsce należy do " + imie);
    }
    public void koniectury(){
        System.out.println("Czy to koniec tury? T : N");
    }
    public void podsumowanie(){
        System.out.println("Chcesz sprawdzic swój status? 1");
        System.out.println("Chcesz sprawdzic rywali status? 2");
        System.out.println("Chcesz sprawdzic swój i rywali status? 3");
        System.out.println("Chcesz kupić domy? 4");
    }
    public void koniec(){
        System.out.println("");
        System.out.println("---------------KONIEC GRY---------------");
    }
}
