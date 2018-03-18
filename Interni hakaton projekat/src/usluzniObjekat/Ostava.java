package usluzniObjekat;

import sluzbe.SluzbaNabavke;

public class Ostava implements SluzbaNabavke{
	
	private int stanjeNaSkladistuNamirnice;
	private int stanjeNaSkladistuPice;
	
	public int getStanjeNaSkladistuNamirnice() {
		return stanjeNaSkladistuNamirnice;
	}

	public void setStanjeNaSkladistuNamirnice(int stanjeNaSkladistuNamirnice) {
		if(stanjeNaSkladistuNamirnice > 0) this.stanjeNaSkladistuNamirnice = stanjeNaSkladistuNamirnice;
		else System.out.println("Greska, uneta kolicina namirnica na skladistu mora biti veca od 0");
	}

	public int getStanjeNaSkladistuPice() {
		return stanjeNaSkladistuPice;
	}

	public void setStanjeNaSkladistuPice(int stanjeNaSkladistuPice) {
		if(stanjeNaSkladistuPice > 0) this.stanjeNaSkladistuPice = stanjeNaSkladistuPice;
		else System.out.println("Greska, uneta kolicina pica na skladistu mora biti veca od 0");
	}

	@Override
	public void dodajNamirnice(int kolicina) {
		if(kolicina > 0) stanjeNaSkladistuNamirnice += kolicina;
		else System.out.println("Kolicina mora biti veca od nule");
	}

	@Override
	public void dodajPice(int kolicina) {
		if(kolicina > 0) stanjeNaSkladistuPice += kolicina;
		else System.out.println("Kolicina mora biti veca od nule");
	}
	
	// Nove metode koje ne sadrzi interfejs SluzbaNabavke
	public void skiniSaStanjeNamirnice(int kolicina) {
		if(kolicina > 0 && stanjeNaSkladistuNamirnice >= kolicina) stanjeNaSkladistuNamirnice -= kolicina;
		else {
			if(kolicina < 0) System.out.println("Kolicina mora biti veca od nule");
			else System.out.println("Nema dovoljno namirnica za pripremu hrane");
		}
	}
	
	public void skiniSaStanjaPice(int kolicina) {
		if(kolicina > 0 && stanjeNaSkladistuPice >= kolicina) stanjeNaSkladistuPice -= kolicina;
		else {
			if(kolicina < 0) System.out.println("Kolicina mora biti veca od nule");
			else System.out.println("Nema dovoljno pica za uslugu gostiju");
		}
	}
	
	public void ispisiStanjeNamirnice() {
		System.out.println("U ostavi ima: " + stanjeNaSkladistuNamirnice + "kg namirnica. ");
	}
	
	public void ispisiStanjePice() {
		System.out.println("U ostavi ima: " + stanjeNaSkladistuPice + "l pica.");
	}
	
	public void ispisiStanje() {
		ispisiStanjeNamirnice();
		ispisiStanjePice();
		
	}
}