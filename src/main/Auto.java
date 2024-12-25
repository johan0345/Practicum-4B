package main;

public class Auto {
    private String type;
    private double prijsPerDag;

    public Auto(String tp, double prPd) {
        this.type = tp;
        this.prijsPerDag = prPd;
    }

    public void setPrijsPerDag(double prPd) {
        this.prijsPerDag = prPd;
    }

    public double getPrijsPerDag() {
        return this.prijsPerDag;
    }

    // Methode voor autohuur
    @Override
    public String toString() {
        return "autotype: " + type + " met prijs per dag: " + prijsPerDag;
    }

    // Methode voor gehuurd
    public String verwijderAutotype() {
        return type + " met prijs per dag: " + prijsPerDag;
    }
}
