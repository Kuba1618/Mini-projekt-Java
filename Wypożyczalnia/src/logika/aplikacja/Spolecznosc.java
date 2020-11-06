package logika.aplikacja;

import java.sql.Date;
import java.util.LinkedList;

public class Spolecznosc {

    private LinkedList<Osoba> ludzie = new LinkedList<>();

    public void addPerson(String imie, String nazwisko, int nrTel, Date dataUr,long nrPesel, char plec) {
        Osoba osoba = new Osoba(imie,nazwisko,nrTel,dataUr,nrPesel,plec);
        ludzie.add(osoba);
    }

    public Osoba getOsoba(int i) {
        return ludzie.get(i);
    }

    public int ileOsob() {
        return ludzie.size();
    }

    public void wyswietlSpolecznosc() {
        for(int i = 0; i < ludzie.size(); i++) {
            Osoba osoba = ludzie.get(i);
            osoba.wyswietlOsobe();
        }
        System.out.println();
    }
}
