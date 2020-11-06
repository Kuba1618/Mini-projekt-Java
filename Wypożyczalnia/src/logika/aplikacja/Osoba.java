package logika.aplikacja;

import java.sql.Date;

public class Osoba {

    private String imie;
    private String nazwisko;
    private int nrTel;
    private Date dataUrodzenia;
    private long pesel;
    private char plec; // ("K","M");

    Osoba(String imie,String nazwisko,int nrTelefonu,Date dataUr,long nrPesel,char plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTelefonu;
        this.dataUrodzenia = dataUr;
        this.pesel = nrPesel;
        this.plec = plec;
    }

    public String getImie() {
        return this.imie;
    }
    public String getNazwisko() {
        return this.nazwisko;
    }
    public int getNrTel() {
        return this.nrTel;
    }
    public Date getDataUrodzenia() {
        return this.dataUrodzenia;
    }
    public long getPesel() { return this.pesel; }
    public char getPlec() {
        return this.plec;
    }

    public void wyswietlOsobe() {
        System.out.println("Imie: " + this.getImie() + "  Nazwisko: " + this.getNazwisko() +
                "  Nr telefonu: " + this.getNrTel() + "  Urodziny: " + this.getDataUrodzenia() +
                "  Pesel: " + this.getPesel() + "  Plec: " + this.getPlec());
    }
}
