package logika.aplikacja;

import java.sql.Date;

public class Logika {
    public static void main(String[] args) {
        Garaz garaz = new Garaz();
        garaz.dodajAuto("Opel", "Astra", "TKI 48125", 2008, "benzyna", false);
        garaz.dodajAuto("Opel", "Insignia", "TKI 21835", 2014, "benzyna + LPG", true);
        garaz.dodajAuto("Skoda", "Octavia", "TKI 31478", 2017, "diesel", false);
        garaz.wyswietlGaraz(garaz);

        Spolecznosc spolecznosc = new Spolecznosc();
        spolecznosc.addPerson("Jan1","Kowalski1",123456789, Date.valueOf("1999-05-28"),'M');
        spolecznosc.addPerson("Jan1","Kowalski1",125601782, Date.valueOf("1997-01-17"),'K');
        spolecznosc.addPerson("Jan2","Kowalski2",987654321, Date.valueOf("1998-09-30"),'M');
        spolecznosc.wyswietlSpolecznosc();
    }

}

