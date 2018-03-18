package zaposleni.osoblje;
// Nasledjivanje (upotrebom rezervisane reci extends)

import zaposleni.Zaposleni;

public class Kelner extends Zaposleni{
	 
	public Kelner(String ime, String prezime, String jmbg) {
		// Poziva se konstruktor nadklase koriscenjem reci "super"
		super(ime, prezime, jmbg);
	}
	
	public void ispisi() {
		// Pozivanje metode "ispisi" nadklase (klase Zaposleni) koja ce da uradi ispis prva tri
		// podatka: ime, prezime, jmbg. Na ovaj nacin kod se ne ponavlja
		System.out.println("\nGlavni kelner");
		super.ispisi();
	}

	@Override
	public void izracunajPlatu(int brojSati) {
		plata = 150 * brojSati;
		System.out.println("Plata: " + plata);
	}

	@Override
	public String toString() {
		return "\nGlavni kelner\nIme: " + ime + ", prezime: " + prezime + ", jmbg: " + jmbg;
	}
	
	
	
}
