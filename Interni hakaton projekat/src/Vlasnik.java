
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
	
}