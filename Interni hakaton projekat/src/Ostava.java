
public class Ostava implements SluzbaNabavke{
	
	int stanjeNaSkladistuNamirnice;
	int stanjeNaSkladistuPice;
	
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