package logika.aplikacja;

public class Auto {

    private String marka;
    private String model;
    private String rejestracja;
    private int rocznik;
    private String rodzajPaliwa;
    private boolean maHaka;

    public Auto(String marka,String model,String rejestracja,int rocznik,String rodzajPaliwa,boolean maHaka){
        this.marka = marka;
        this.model = model;
        this.rejestracja = rejestracja;
        this.rocznik = rocznik;
        this.rodzajPaliwa = rodzajPaliwa;
        this.maHaka = maHaka;
    }

    public String getMarka() {
        return this.marka;
    }
    public String getModel() {
        return this.model;
    }
    public String getRejestracja() {
        return rejestracja;
    }
    public int getRocznik() {
        return this.rocznik;
    }
    public String getPaliwo() {
        return this.rodzajPaliwa;
    }
    public boolean getHak() {
        return this.maHaka;
    }

    public void wyswietlAuto() {
        System.out.print("Marka:" + this.marka + "  Model:" + this.model + "  NrRejestracyjny:" + this.rejestracja +
                 "  Rocznik: " + this.rocznik + "  Paliwo:" +  this.rodzajPaliwa);
        if (this.maHaka == true) {
            System.out.println(" (Samochód ma haka)");
        } else {
            System.out.println(" (Samochód nie ma haka)");
        }
    }
}
