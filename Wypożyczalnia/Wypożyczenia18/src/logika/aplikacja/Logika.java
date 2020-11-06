package logika.aplikacja;

import java.sql.Date;

public class Logika {
    public static void main(String[] args) {
        Garaz garaz = new Garaz();
        garaz.dodajAuto("Opel", "Astra", "TKI 48125", 2008, "benzyna", false);
        garaz.dodajAuto("Opel", "Insignia", "TKI 21835", 2014, "benzyna + LPG", true);
        garaz.dodajAuto("Skoda", "Octavia", "TKI 31478", 2017, "diesel", false);
        garaz.wyswietlGaraz();

        Spolecznosc spolecznosc = new Spolecznosc();
        spolecznosc.addPerson("Jan1","Kowalski1",123456789, Date.valueOf("1999-05-28"),12345678910L,'M');
        spolecznosc.addPerson("Jan1","Kowalski1",125601782, Date.valueOf("1997-01-17"),12345678911L,'K');
        spolecznosc.addPerson("Jan2","Kowalski2",987654321, Date.valueOf("1998-09-30"),12345678912L,'M');
        spolecznosc.wyswietlSpolecznosc();

        KatalogWypozyczen katalog = new KatalogWypozyczen();
        katalog.dodajWypozyczenie("Opel","Astra H",Date.valueOf("1999-05-28"),Date.valueOf("1999-05-30"),
                "Jan","Nowak",12345678910L);
        katalog.dodajWypozyczenie("Skoda","Octavia",Date.valueOf("2003-05-28"),Date.valueOf("2008-05-30"),
                "Robert","Kowalski",93345678910L);
        katalog.dodajWypozyczenie("Audi","A4",Date.valueOf("2000-05-28"),Date.valueOf("2000-05-30"),
                "Stanislaw","Rak",12345654910L);
        katalog.wyswietlKatalogWypozyczen();
    }

}

