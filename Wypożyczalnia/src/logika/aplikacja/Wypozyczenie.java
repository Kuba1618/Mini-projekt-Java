package logika.aplikacja;

import java.sql.Date;

public class Wypozyczenie {
    private String marka;
    private String model;
    private Date dataWypozyczenia;
    private Date dataZwrotu;
    private String imie;
    private String nazwisko;
    private long pesel;

    public Wypozyczenie(String marka,String model,Date dataWyp,Date dataZwr,String imie,String nazwisko,long pesel) {
        this.marka = marka;
        this.model = model;
        this.dataWypozyczenia = dataWyp;
        this.dataZwrotu = dataZwr;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String getMarka() {
        return this.marka;
    }
    public String getModel() {
        return this.model;
    }
    public Date getDataWypozyczenia() {
        return this.dataWypozyczenia;
    }
    public Date getDataZwrotu() {
        return this.dataZwrotu;
    }
    public String getImie() {
        return this.imie;
    }
    public String getNazwisko() {
        return this.nazwisko;
    }
    public long getPesel() {
        return this.pesel;
    }

    public void wyswietlWypozyczenie() {
        System.out.println("Marka:" + this.marka + "  Model:" + this.model + "  Data wypozyczenia:" + this.dataWypozyczenia +
                "  Data zwrotu:" + this.dataZwrotu + "  Imie:" + this.imie + "  Nazwisko:" + this.nazwisko +
                "  Pesel:" + this.pesel);
    }


}
