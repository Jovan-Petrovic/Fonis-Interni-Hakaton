
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Restoran {
	private String naziv;
	private String opstina;
	private String adresa;
	int[] ocene;
	private int brojMesta;
	private double ocena;
	private int maxOcena = 0;
	private int minOcena = 10;
	private boolean imaLiSlobodnihMesta;
	boolean[][] matrica;
	int slobodniStolovi = 0;
	GregorianCalendar datumOtvaranja;  // Klasa gregorianCalendar
	
	// Globalana promenljiva
	static int brojRestorana = 100;
	
	// Asocijacija - tip podataka atributa druga klasa asocijacije
	Osoba vlasnik;
	Osoba sefKuhinje;
	
	// Kelner glavniKelner1;
	Osoba glavniKelner;

	// Upotreba konstruktora, this naredba
	Restoran(String naziv, String opstina, String adresa, int[] ocene, int brojMesta, Osoba vlasnik, Osoba sefKuhinje) {
		this.naziv = naziv;  
		this.opstina = opstina;
		this.adresa = adresa;
		this.ocene = ocene;
		this.brojMesta = brojMesta;
		this.vlasnik = vlasnik;
		this.sefKuhinje = sefKuhinje;
	}
	
	// Prazan konstruktor
	Restoran() {
		
	}
	
	// Seteri i Geteri 
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
	
	public static int getBrojRestorana() {
		return brojRestorana;
	}

	public static void setBrojRestorana(int brojRestorana) {
		Restoran.brojRestorana = brojRestorana;
	}

	public Osoba getVlasnik() {
		return vlasnik;
	}
	
	// Relacija koriscenja
	// Klasa koristi objekat druge klase u okviru svoje metode. Nebitno da li kao parametar, povratnu vrednost ili u telu metode
	public void setVlasnik(Osoba vlasnik) {
		this.vlasnik = vlasnik;
	}
	
	public Osoba getSefKuhinje() {
		return sefKuhinje;
	}

	public void setSefKuhinje(Osoba sefKuhinje) {
		this.sefKuhinje = sefKuhinje;
	}
	
	
	
	public boolean[][] getMatrica() {
		return matrica;
	}

	public void setMatrica(boolean[][] matrica) {
		this.matrica = matrica;
	}
	
	public GregorianCalendar getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(GregorianCalendar date) {
		this.datumOtvaranja = date;
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
	
	// Uslovno grananje - if naredba
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
		ocena = prosecnaOcena(ocene);
		System.out.println("\nProsecna ocena korisnika: " + ocena);
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
		System.out.println("Unesite ocenu koju biste dali restoranu " + naziv + ": (1-10, 0 ako ne zelite da ocenite)");
		int novaOcena = in.nextInt();
		//in.close();
		if(novaOcena == 0) return;   // Koriscenje naredbe return kod metode bez povratne vrednosti
		if(novaOcena >= 1 && novaOcena <= 10) {
			ocena = novaProsecnaOcena(novaOcena);
			System.out.println("Nova prosecna ocena restorana " + naziv + ": " + ocena);
		} else {
			System.out.println("Ocena mora biti u intervalu 1-10! Pokusajte ponovo.");
			Scanner in1 = new Scanner(System.in);
			System.out.println("Unesite ocenu koju biste dali restoranu " + naziv + ": (1-10)");
			int novaOcena1 = in1.nextInt();
			double prosecnaOcena = novaProsecnaOcena(novaOcena1);
			System.out.println("Nova prosecna ocena restorana " + naziv + ": " + prosecnaOcena);
		}
	}
	
	// Globalne (staticke) metode
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
	
	/*
	public void podaciOVlasniku() {
		System.out.println("Ime vlasnika: " + vlasnik.ime);
		System.out.println("Prezime vlasnika: " + vlasnik.prezime);
	}
	*/
	
	public void ispisi() {
		System.out.println("\nVlasnik");
		// Direktno se poziva metoda ispisi klase osoba da bi se ispisalo ime i prezime vlasnika
		vlasnik.ispisi();
		
		System.out.println("\nSef kuhinje");
		// Direktno se poziva metoda ispisi klase osoba da bi se ispisalo ime i prezime sefa kuhinje
		sefKuhinje.ispisi();
	}
	
	// Ciklicno ponavljanje - for petlja
	public void maxOcenaRestorana() {
		for(int i = 0; i < ocene.length; i++) {
			if(ocene[i] > maxOcena) maxOcena = ocene[i];
		}
		System.out.println("Maksimalna ocena restorana: " + maxOcena);
	}
	
	// Ciklicno ponavljanje - while petlja
	public void minOcenaRestorana() {
		int i = 0;
		while(i < ocene.length) {
			if(ocene[i] < minOcena) minOcena = ocene[i];
			i++;
		}
		System.out.println("Mnimalna ocena restorana: " + minOcena);
	}
	
	// Dvodimenzionalan niz - matrica
	public void zauzetostStolova() {
		for(int i = 0; i < matrica.length; i++) {
			for(int j = 0; j < matrica[0].length; j++) {
				if(matrica[i][j] == true) slobodniStolovi++;
			}
		}
		System.out.println("\nSlobodnih stolova: " + slobodniStolovi);
	}
	
	public boolean imaLiSlobodnih() {
		for(int i = 0; i < matrica.length; i++) {
			for(int j = 0; j < matrica[0].length; j++) {
				if(matrica[i][j] == true) return true;
			}
		}
		return false;
	}
	
	public boolean imaLiZauzetih() {
		for(int i = 0; i < matrica.length; i++) {
			for(int j = 0; j < matrica[0].length; j++) {
				if(matrica[i][j] == false) return true;
			}
		}
		return false;
	}
	
	public void popuniSto() {
		boolean provera = imaLiSlobodnih();
		if(provera) {
			for(int i = 0; i < matrica.length; i++) {
				for(int j = 0; j < matrica.length; j++) {
					if(matrica[i][j] == true) {
						matrica[i][j] = false;
						slobodniStolovi--;
						System.out.println("Popunjen je prvi slobodan sto.");
						return;
					}
				}
			}
		}
	}
	
	public void isprazniSto() {
		boolean provera = imaLiZauzetih();
		int red = 0;
		int kolona = 0;
		if(provera) {
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("Unesite red stola kojeg zelite da ispraznite:");
			red = in1.nextInt();
			System.out.println("Unesite kolonu stola kojeg zelite da ispraznite:");
			kolona = in2.nextInt();
			matrica[red - 1][kolona - 1] = true;
		}
		System.out.println("Ispraznjen je sto u redu " + red + " i koloni " + kolona);
	}
	
	public void tabelaZauzetostistolova() {
		System.out.println("Tabela zauzetosti stolova: (false - zauzet, true - slobodan)");
		for(int i = 0; i < matrica.length; i++) {
			for(int j = 0; j < matrica[0].length; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Pozivanje svih metoda odjednom
	public void sveOrestoranu() {
		ispisiNaziv();
		nazivOpstine();
		adresaRestorana();
		velicinaRestorana();
		datumOtvaranja();
		ispisi();		
		ocenaRestorana();
		maxOcenaRestorana();
		minOcenaRestorana();
		oceniRestoran();
		ispisiKelnera();
	}
	
	public void matricneMetode() {
		zauzetostStolova();
		tabelaZauzetostistolova();
		System.out.println();
		popuniSto();
		tabelaZauzetostistolova();
		isprazniSto();
		System.out.println();
		tabelaZauzetostistolova();
	}
	
	// Rad sa stringovima, metoda compareTo
	public void restoraniIzStarogGrada(Restoran[] restorani) {
		System.out.println("Restorani iz Starog Grada:");
		for(int i = 0; i < restorani.length; i++) {
			if(restorani[i].opstina.compareTo("Stari Grad") == 0) {
				System.out.println(restorani[i].naziv + ", ");
			}
		}
	}
	
	// Nizovi objekata, substring metoda, konverzija iz stringa u int koriscenjem parseInt metode
	public Osoba[] rodjeniPosle1970(Osoba[] osobe) {
		Osoba[] vlasniciPosle1970 = new Osoba[1000];
		int br = 0;
		for(int i  = 0; i < osobe.length; i++) {
			String godina = osobe[i].jmbg.substring(5,8);
			int godina1 = Integer.parseInt(godina);
			if(godina1 > 970) vlasniciPosle1970[br++] = osobe[i];
		}
		if(br == 0) {
			System.out.println("Nema vlasnika rodjenih posle 1970. godine");
			return null;
		}
		return vlasniciPosle1970;
	}
	
	// Upotreba GregorianCalendar-a
	public void datumOtvaranja() {
		System.out.println("Datum otvarnja: " + datumOtvaranja);
	}
	
	public void najstarijiRestoran(Restoran[] restorani) {
		Restoran najstariji = restorani[0];
		for(int i = 1; i < restorani.length; i++) {
			if(restorani[i].datumOtvaranja.before(najstariji)) najstariji = restorani[i];
		}
		System.out.println("Najstariji restoran: " + najstariji + ". Datum otvaranja: " + datumOtvaranja);
	}
	
	public void ispisiKelnera() {
		System.out.println("Glavni kelner ");
		// Poziva se redefinisana metoda "ispisi" klase Kelner
		glavniKelner.ispisi();
	}
}