package logika.aplikacja;

import java.util.LinkedList;

public class Garaz {

    private LinkedList<Auto> garaz = new LinkedList<>();

    public void dodajAuto(String marka, String model, String nrRej, int rok, String paliwo, boolean hak) {
        Auto autko = new Auto(marka, model, nrRej, rok, paliwo, hak);
        garaz.add(autko);
    }

    public Auto getAuto(int i) {
        return garaz.get(i);
    }

    public int ileAut() {
        return garaz.size();
    }

    public void wyswietlGaraz() {
        System.out.println("Garaż: ");
        for (int i = 0; i < garaz.size(); i++) {
            Auto autko = this.getAuto(i);
            autko.wyswietlAuto();
        }
        System.out.println();
    }

}
