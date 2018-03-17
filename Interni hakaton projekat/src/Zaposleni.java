
public abstract class Zaposleni {
	String ime;
	String prezime;
	String jmbg;
	
	int plata;
	
	public Zaposleni(String ime, String prezime, String jmbg) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	void ispisi() {
		System.out.println("Ime: " + ime);
		System.out.println("Prezime: " + prezime);
		System.out.println("Jmbg: " + jmbg);
	}
	
	public abstract void izracunajPlatu(int brojSati);
	
}
