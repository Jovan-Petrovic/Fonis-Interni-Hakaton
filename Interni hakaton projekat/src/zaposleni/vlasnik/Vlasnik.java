package zaposleni.vlasnik;

public class Vlasnik {
	private String ime;
	private String prezime;
	// public da bi koristili substring metodu
	public String jmbg;
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Vlasnik(String ime, String prezime, String jmbg) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	public void ispisi() {
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
