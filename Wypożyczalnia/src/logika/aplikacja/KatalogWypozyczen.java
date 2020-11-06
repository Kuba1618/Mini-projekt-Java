package logika.aplikacja;

import java.sql.Date;
import java.util.LinkedList;

public class KatalogWypozyczen {

    private LinkedList<Wypozyczenie> katalog = new LinkedList<>();

    public void dodajWypozyczenie(String marka, String model, Date dataWyp,Date dataZwr,String imie,String nazwisko,long pesel) {
        Wypozyczenie wypozyczenie = new Wypozyczenie(marka,model,dataWyp,dataZwr,imie,nazwisko,pesel);
        katalog.add(wypozyczenie);
    }

    public int getIloscWypozyczen() {
        return katalog.size();
    }
    public Wypozyczenie getWypozyczenie(int i) {
        return katalog.get(i);
    }

    public void wyswietlKatalogWypozyczen(){
        System.out.println("Wypożyczenia:");
        for(int i = 0; i < katalog.size(); i++) {
            Wypozyczenie w = this.getWypozyczenie(i);
            w.wyswietlWypozyczenie();
        }
        System.out.println();
    }


}
