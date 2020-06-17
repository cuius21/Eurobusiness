public class Miasto {
    public int id;
    public String name;
    public int koszt;
    public boolean kupione = false;
    public int[] domy = new int[4];
    public int hotel = 0;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }

    public void setKupione(boolean kupione) {
        this.kupione = kupione;
    }

    public void setDomy(int[] domy) {
        this.domy = domy;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getKoszt() {
        return koszt;
    }

    public boolean isKupione() {
        return kupione;
    }

    public int[] getDomy() {
        return domy;
    }

    public int getHotel() {
        return hotel;
    }
}
