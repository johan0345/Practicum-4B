package main;

public class AutoHuur {
    private int aantalDagen;
    private Auto gehuurdeAuto;
    private Klant huurder;

    public AutoHuur() {
    }

    public void setAantalDagen(int aD) {
        this.aantalDagen = aD;
    }

    public int getAantalDagen() {
        return this.aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        this.gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return this.gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        this.huurder = k;
    }

    public Klant getHuurder() {
        return this.huurder;
    }

    public double totaalPrijs() {
        if (gehuurdeAuto == null || huurder == null) {
            return 0.0;
        }
        double basisPrijs = aantalDagen * gehuurdeAuto.getPrijsPerDag();
        return basisPrijs - (basisPrijs * huurder.getKorting() / 100);
    }

    @Override
    public String toString() {
        String autoInfo = (gehuurdeAuto == null) ? "er is geen auto bekend" : gehuurdeAuto.toString();
        String klantInfo = (huurder == null) ? "er is geen huurder bekend" : huurder.toString();
        return autoInfo + "\n" + klantInfo + "\naantal dagen: " + aantalDagen + " en dat kost " + totaalPrijs();
    }
}
