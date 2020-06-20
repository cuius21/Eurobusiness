public class Miasto {
    public int id;
    public String name;
    public int koszt;
    public boolean kupione = false;


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
}
