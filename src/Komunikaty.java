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
        System.out.println("Prodaj swoją nazwe:");
    }
    public void inforacza2(String imie, int finanse) {
        System.out.println("Witaj " + imie + ". Na początek zaczynasz z kwotą " + finanse + " euro");
    }
    public void infomiasta(){
        System.out.println("Miasto nie zostało jeszcze kupione");
    }
    public void zacheta_kupna(){
        System.out.println("Kupujesz? Y : N");
    }
    public void niemoznosc_kupna(){
        System.out.println("Niestety masz za mało pieniędzy, aby to kupić");
    }
}
