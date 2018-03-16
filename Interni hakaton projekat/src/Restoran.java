
import java.util.Scanner;

public class Restoran {
	private String naziv;
	private String opstina;
	private String adresa;
	int[] ocene;
	private int brojMesta;
	
	
	
	// Upotreba konstruktora, "this" naredba
	Restoran(String naziv, String opstina, String adresa, int[] ocene, int brojMesta) {
		this.naziv = naziv;  
		this.opstina = opstina;
		this.adresa = adresa;
		this.ocene = ocene;
		this.brojMesta = brojMesta;
	}
	
	// Prazan konstruktor
	Restoran() {
		
	}
	
	// Seteri i Geteri, JavaBeans specifikacija
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpstina() {
		return opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public int[] getOcene() {
		return ocene;
	}

	public void setOcene(int[] ocene) {
		this.ocene = ocene;
	}
	
	// Metode klase
	public void ispisiNaziv() {
		System.out.println("Naziv restorana: " + naziv);
	}
	
	public void nazivOpstine() {
		System.out.println("Opstina: " + opstina);
	}
	
	public void adresaRestorana() {
		System.out.println("Adresa: " + adresa);
	}
	
	public void velicinaRestorana() {
		int x = brojMesta % 10;
		if(x >=1 && x <= 4) System.out.println("Restoran moze da primi " + brojMesta + " gosta.");
		else System.out.println("Restoran moze da primi " + brojMesta + " gostiju");
	}
	
	public double prosecnaOcena(int[] ocene) {
		int ukupno = 0;
		for(int i = 0; i < ocene.length; i++) {
			ukupno += ocene[i];
		}
		return (double)ukupno / ocene.length;
	}
	
	// Pozivanje metode unutar druge metode
	public void ocenaRestorana() {
		double prosecnaOcena = prosecnaOcena(ocene);
		System.out.println("Prosecna ocena korisnika: " + prosecnaOcena);
	}
	
	public double novaProsecnaOcena(int ocena) {
		int ukupno = 0;
		for(int i = 0; i < ocene.length; i++) {
			ukupno += ocene[i];
		}
		double novaProsecnaOcena = (double)(ukupno + ocena) / (ocene.length + 1);
		return novaProsecnaOcena;
	}
	
	// Ucitavanje sa tastature pomocu klase Scanner
	public void oceniRestoran() {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite ocenu koju biste dali restoranu " + naziv + ": (1-10)");
		// Metoda "nextInt" ucitava jedan red znakova sa tastature, pretvara ga u ceo broj
		// i vraca taj broj kao povratnu vrednost.
		int novaOcena = in.nextInt();
		//in.close();
		if(novaOcena >= 1 && novaOcena <= 10) {
			double prosecnaOcena = novaProsecnaOcena(novaOcena);
			System.out.println("Nova prosecna ocena restorana " + naziv + ": " + prosecnaOcena);
		} else {
			System.out.println("Ocena mora biti u intervalu 1-10! Pokusajte ponovo.");
			Scanner in1 = new Scanner(System.in);
			System.out.println("Unesite ocenu koju biste dali restoranu " + naziv + ": (1-10)");
			int novaOcena1 = in1.nextInt();
			double prosecnaOcena = novaProsecnaOcena(novaOcena1);
			System.out.println("Nova prosecna ocena restorana " + naziv + ": " + prosecnaOcena);
		}
	}
	
	// Globalana promenljiva
	// Nije vezana ni za jedan objekat, koriscenje ove promenljive ne podrazumeva inicijalizaciju 
	// objekta klase, vec joj se pristupa direktno preko naziva klase 
	static int brojRestorana = 100;
	
	// Globalne (staticke) metode
	// Nije potrebno inicijalizovati objekat date klase da bi se metoda koristila, vec se
	// poziv vrsi preko naziva klase u kojoj je metoda definisana
	static void brojRestorana() {
		System.out.println("Trenutni broj restorana: "  + brojRestorana);
	}
	
	static void otvoriRestoran() {
		brojRestorana++;
		System.out.println("Trenutni broj restorana (nakon otvaranja novog): "  + brojRestorana);
	}
	
	static void zatvoriRestoran() {
		brojRestorana--;
		System.out.println("Trenutni broj restorana (nakon zatvaranja postojeceg): "  + brojRestorana);
	}
	
	// Pozivanje svih metoda odjednom
	public void sveOrestoranu() {
		ispisiNaziv();
		nazivOpstine();
		adresaRestorana();
		velicinaRestorana();
		ocenaRestorana();
		oceniRestoran();
	}

}
