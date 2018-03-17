
public class Vlasnik {
	String ime;
	String prezime;
	String jmbg;
	
	public Vlasnik(String ime, String prezime, String jmbg) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	void ispisi() {
		System.out.println("Ime: " + ime);
		System.out.println("Prezime: " + prezime);
		System.out.println("Jmbg: " + jmbg);
	}
	
	// toString metoda - po konvenciji se koristi za vracanje vrednosti svih atributa klase spojene u jedan String
	// To se postize kada syso naredbi prosledimo samo naziv objekta (moze i nazivObjekta.toString)
	@Override
	public String toString() {
		return "Ime: " + ime + ", prezime: " + prezime + ", jmbg: " + jmbg;
	}
	
	
	
}