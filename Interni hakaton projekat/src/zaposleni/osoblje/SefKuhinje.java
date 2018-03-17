package zaposleni.osoblje;

import zaposleni.Zaposleni;

public class SefKuhinje extends Zaposleni{

	public SefKuhinje(String ime, String prezime, String jmbg) {
		super(ime, prezime, jmbg);
	}
	
	public void ispisi() {
		System.out.println("\nSef kuhinje");
		super.ispisi();
	}
	
	@Override
	public void izracunajPlatu(int brojSati) {
		plata = 300 * brojSati;
		System.out.println("Plata: " + plata);
	}

	@Override
	public String toString() {
		return "\nSef kuhinje\nIme: " + ime + ", prezime: " + prezime + ", jmbg: " + jmbg;
	}
	
	
	
}