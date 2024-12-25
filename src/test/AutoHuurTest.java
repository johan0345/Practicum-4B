package test;

import main.AutoHuur;
import main.Auto;
import main.Klant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AutoHuurTest {

    @Test
    void GeenHuurderGeenAuto() {
        AutoHuur ah = new AutoHuur();
        // Controleer totaalprijs zonder huurder en auto
        assertEquals(0.0, ah.totaalPrijs(), "De totaalprijs moet 0 zijn als er geen huurder en geen auto is.");
        assertEquals("er is geen auto bekend\ner is geen huurder bekend\naantal dagen: 0 en dat kost 0.0", ah.toString());
    }

    @Test
    void GeenHuurderWelAuto() {
        AutoHuur ah = new AutoHuur();
        Auto a = new Auto("Peugeot 207", 50.0);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        // Controleer totaalprijs zonder huurder
        assertEquals(0.0, ah.totaalPrijs(), "De totaalprijs moet 0 zijn als er geen huurder is.");
        assertEquals("autotype: Peugeot 207 met prijs per dag: 50.0\ner is geen huurder bekend\naantal dagen: 3 en dat kost 0.0", ah.toString());
    }

    @Test
    void WelHuurderGeenAuto() {
        AutoHuur ah = new AutoHuur();
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        ah.setHuurder(k);
        // Controleer totaalprijs zonder auto
        assertEquals(0.0, ah.totaalPrijs(), "De totaalprijs moet 0 zijn als er geen auto is.");
        assertEquals("er is geen auto bekend\nop naam van: Mijnheer de Vries (korting: 10.0%)\naantal dagen: 0 en dat kost 0.0", ah.toString());
    }

    @Test
    void WelHuurderWelAutoGeenKorting() {
        AutoHuur ah = new AutoHuur();
        Auto a = new Auto("Peugeot 207", 50.0);
        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(0.0); // Geen korting
        ah.setGehuurdeAuto(a);
        ah.setHuurder(k);
        ah.setAantalDagen(3);

        // Controleer totaalprijs zonder korting
        assertEquals(150.0, ah.totaalPrijs(), "De totaalprijs moet gelijk zijn aan aantal dagen en prijs per dag als er geen korting is.");

        assertEquals("autotype: Peugeot 207 met prijs per dag: 50.0\nop naam van: Mijnheer de Vries (korting: 0.0%)\naantal dagen: 3 en dat kost 150.0", ah.toString());
    }
}
