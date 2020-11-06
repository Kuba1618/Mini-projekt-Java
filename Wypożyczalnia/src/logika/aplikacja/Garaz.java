package logika.aplikacja;

import java.util.LinkedList;

public class Garaz {

    private LinkedList<Auto> garaz = new LinkedList<>();

    public void addItem(String marka, String model, String nrRej, int rok, String paliwo, boolean hak) {
        Auto autko = new Auto(marka, model, nrRej, rok, paliwo, hak);
        garaz.add(autko);
    }

    public Auto getAuto(int i) {
        return garaz.get(i);
    }

    public int ileAut() {
        return garaz.size();
    }

    public void wyswietlGaraz(Garaz garaz) {
        for (int i = 0; i < garaz.ileAut(); i++) {
            Auto autko = garaz.getAuto(i);

            String jestHak;
            if (autko.getHak()) {
                jestHak = "tak";
            } else {
                jestHak = "nie";
            }

            System.out.print("Marka: " + autko.getMarka() + "  Model: " + autko.getModel() +
                    "  Nr rejestracyjny: " + autko.getRejestracja() + "  Rok produkcji: " + autko.getRocznik() +
                    "  Paliwo: " + autko.getPaliwo() + "  Hak: " + jestHak);
            System.out.println();
        }
        System.out.println();
    }

}
