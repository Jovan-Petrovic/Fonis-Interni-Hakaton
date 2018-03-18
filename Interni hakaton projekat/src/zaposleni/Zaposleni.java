package zaposleni;

public abstract class Zaposleni {
	
	// Zasticeni (protected) nivo pristupa - vidljivost u istom paketu i klasama drugih paketa koje
	// koje nasledjuju klasu koja nasledjuje klasu ili metodu koja je zasticena ili sadrzi zasticeni element
	protected String ime;
	protected String prezime;
	// Atribut jmbg je public(vidljiv svuda) radi lakse manipulacije njime u klasi Restoran koriscenjem metode substring
	public String jmbg;
	
	protected int plata;
	
	public Zaposleni(String ime, String prezime, String jmbg) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	protected void ispisi() {
		System.out.println("Ime: " + ime);
		System.out.println("Prezime: " + prezime);
		System.out.println("Jmbg: " + jmbg);
	}
	
	public abstract void izracunajPlatu(int brojSati);
	
}