package usluzniObjekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Uvozenje klasa koje ne pripadaju istom paketu kao klasa Restoran, a ciji atributi ili metode se koriste
import sluzbe.SluzbaNabavke;
import sluzbe.SluzbaProdaje;
import zaposleni.Zaposleni;
import zaposleni.osoblje.Kelner;
import zaposleni.osoblje.SefKuhinje;
import zaposleni.vlasnik.Vlasnik;

// Jedna klasa moze istovremeno da implementira vise interfejsa, i to se oznacava uz pomoc rezervisane reci "implements"
public class Restoran implements SluzbaNabavke, SluzbaProdaje{
	private String naziv;
	private String opstina;
	private String adresa;
	private int[] ocene;
	private int brojMesta;
	private double ocena;
	private int maxOcena = 0;
	private int minOcena = 10;
	private boolean imaLiSlobodnihMesta;
	private boolean[][] matrica;
	private int slobodniStolovi = 0;
	private GregorianCalendar datumOtvaranja;  // Klasa gregorianCalendar
	private int luksuznost;
	private int namirnice;
	private int pice;
	
	// Globalana promenljiva
	static int brojRestorana = 100;
	
	// Asocijacija - tip podataka atributa druga klasa asocijacije
	public Vlasnik vlasnik;
	public SefKuhinje sefKuhinje;
	
	// Kelner glavniKelner1;
	public Kelner glavniKelner;
	
	// Upotreba konstruktora, this naredba
	Restoran(String naziv, String opstina, String adresa, int[] ocene, int brojMesta, Vlasnik vlasnik, SefKuhinje sefKuhinje) {
		this.naziv = naziv;  
		this.opstina = opstina;
		this.adresa = adresa;
		this.ocene = ocene;
		this.brojMesta = brojMesta;
		this.vlasnik = vlasnik;
		this.sefKuhinje = sefKuhinje;
	}
	
	// Prazan konstruktor
	public Restoran() {
		
	}
	
	// Seteri i Geteri 
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv == null) throw new RestoranException("Naziv restorana ne moze biti null");
		this.naziv = naziv;
	}

	public String getOpstina() {
		return opstina;
	}
	
	// Proveravani izuzetak klase Exception. Poziv metode koja baca proveravani izuzetak
	// mora biti uokviren try-catch blokom koji hvata taj izuzeak, a metoda mora da bude
	// oznacena rezervisanom reci throws i nazivom klase izuzetka koji baca.
	public void setOpstina(String opstina) throws Exception{
		if(opstina == null) throw new Exception("Naziv opstine ne moze biti null");
		this.opstina = opstina;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		if(adresa == null) throw new RestoranException("Adresa ne moze biti null");
		this.adresa = adresa;
	}


	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		if(brojMesta < 0) throw new RestoranException("Broj mesta u restoranu mora biti veci od nule");
		this.brojMesta = brojMesta;
	}

	public int[] getOcene() {
		return ocene;
	}

	public void setOcene(int[] ocene) {
		if(ocene == null) throw new RestoranException("Niz ocena ne moze biti null");
		this.ocene = ocene;
	}
	
	public static int getBrojRestorana() {
		return brojRestorana;
	}

	public static void setBrojRestorana(int brojRestorana) {
		if(brojRestorana < 0) throw new RestoranException("Broj restorana ne moze biti manji od nule");
		Restoran.brojRestorana = brojRestorana;
	}

	public SefKuhinje getSefKuhinje() {
		return sefKuhinje;
	}

	public void setSefKuhinje(SefKuhinje sefKuhinje) {
		if(sefKuhinje == null) throw new RestoranException("Sef kuhinje ne moze biti null");
		this.sefKuhinje = sefKuhinje;
	}
	
	public Vlasnik getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Vlasnik vlasnik) {
		if(vlasnik == null) throw new RestoranException("Vlasnik ne moze biti null");
		this.vlasnik = vlasnik;
	}

	public boolean[][] getMatrica() {
		return matrica;
	}

	public void setMatrica(boolean[][] matrica) {
		if(matrica == null) throw new RestoranException("Matrica zauzetosti stolova ne moze biti null");
		this.matrica = matrica;
	}
	
	public GregorianCalendar getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(GregorianCalendar date) {
		if(date == null) throw new RestoranException("Datum otvaranja ne moze biti null");
		this.datumOtvaranja = date;
	}
	
	public int getLuksuznost() {
		return luksuznost;
	}

	public void setLuksuznost(int luksuznost) {
		if(luksuznost < 1 || luksuznost > 5) throw new RestoranException("Ocena luksuznosti ne moze biti manja od 1 ili veca od 5");
		this.luksuznost = luksuznost;
	}
	
	public int getNamirnice() {
		return namirnice;
	}

	public void setNamirnice(int namirnice) {
		if(namirnice > 0) this.namirnice = namirnice;
		//else System.out.println("Greska, kolicina namirnica mora biti veca od 0");
		else throw new RestoranException("Greska, kolicina namirnica mora biti veca od 0");
	}

	public int getPice() {
		return pice;
	}

	public void setPice(int pice) {
		if(pice > 0) this.pice = pice;
		//else System.out.println("Greska, kolicina pica mora biti veca od 0");
		else throw new RestoranException("Greska, kolicina pica mora biti veca od 0");
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
	
	public double prosecnaOcena() {
		int ukupno = 0;
		for(int i = 0; i < ocene.length; i++) {
			ukupno += ocene[i];
		}
		return (double)ukupno / ocene.length;
	}
	
	// Pozivanje metode unutar druge metode
	public void ocenaRestorana() {
		ocena = prosecnaOcena();
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
	public static void brojRestorana() {
		System.out.println("Trenutni broj restorana: "  + brojRestorana);
	}
	
	public static void otvoriRestoran() {
		brojRestorana++;
		System.out.println("Trenutni broj restorana (nakon otvaranja novog): "  + brojRestorana);
	}
	
	public static void zatvoriRestoran() {
		brojRestorana--;
		System.out.println("Trenutni broj restorana (nakon zatvaranja postojeceg): "  + brojRestorana);
	}
	
	/*
	public void podaciOVlasniku() {
		System.out.println("Ime vlasnika: " + vlasnik.ime);
		System.out.println("Prezime vlasnika: " + vlasnik.prezime);
	}
	*/
	
	public void ispisiVlasnika() {
		System.out.println("\nVlasnik");
		// Direktno se poziva metoda ispisi klase osoba da bi se ispisalo ime i prezime vlasnika
		//vlasnik.ispisi();
		System.out.println(vlasnik);
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
		ispisiVlasnika();		
		ocenaRestorana();
		maxOcenaRestorana();
		minOcenaRestorana();
		oceniRestoran();
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
	public void rodjeniPosle1970(Vlasnik[] vlasnici) {
		Vlasnik[] vlasniciPosle1970 = new Vlasnik[1000];
		int br = 0;
		for(int i  = 0; i < vlasnici.length; i++) {
			String godina = vlasnici[i].jmbg.substring(5,8);
			int godina1 = Integer.parseInt(godina);
			if(godina1 > 970) vlasniciPosle1970[br++] = vlasnici[i];
		}
		if(br == 0) {
			System.out.println("Nema vlasnika rodjenih posle 1970. godine");
			return;
		}
		System.out.println("Vlasnici rodjeni posle 1970. godine");
		for(int i = 0; i < vlasniciPosle1970.length; i++) {
			System.out.println(vlasniciPosle1970[i]);
		}
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
	
	// Metode koje implementiraju metode iz interfejsa moraju da budu javne (public)
	@Override
	public void prodajHranu(int kolicina) {
		if(kolicina > 0 && namirnice >= kolicina) namirnice -= kolicina;
		else {
			if(kolicina < 0) throw new RestoranException("Kolicina mora biti veca od nule");   //System.out.println("Kolicina mora biti veca od nule");
			else throw new RestoranException("Nema dovoljno namirnica za pripremu hrane");  //System.out.println("Nema dovoljno namirnica za pripremu hrane");
		}
	}

	@Override
	public void prodajPice(int kolicina) {
		if(kolicina > 0 && pice >= kolicina) pice -= kolicina;
		else {
			if(kolicina < 0) throw new RestoranException("Kolicina mora biti veca od nule");  //System.out.println("Kolicina mora biti veca od nule");
			else throw new RestoranException("Nema dovoljno pica za uslugu gostiju");  //System.out.println("Nema dovoljno pica za uslugu gostiju");
		}
	}

	@Override
	public void dodajNamirnice(int kolicina) {
		if(kolicina > 0) namirnice += kolicina;
		else throw new RestoranException("Kolicina mora biti veca od nule");  //System.out.println("Kolicina mora biti veca od nule");
	}

	@Override
	public void dodajPice(int kolicina) {
		if(kolicina > 0) pice += kolicina;
		else throw new RestoranException("Kolicina mora biti veca od nule");  //System.out.println("Kolicina mora biti veca od nule");
	}
	
	public void ispisiStanjeNamirnice() {
		System.out.println("U restoranu ima: " + namirnice + " kg namirnica.");
	}
	
	public void ispisiStanjePice() {
		System.out.println("U restoranu ima: " + pice + "l pica.");
	}
	
	public void ispisiStanje() {
		ispisiStanjeNamirnice();
		ispisiStanjePice();
	}
	
	// equals metoda - poredi dva objekta i vraca true ako su jednaki a false ako nisu
	// potrebno je redefinisati je
	public boolean equals(Object o) {
		// Uneti objekat se mora eksplicitno konvertovati u odgovarajuci tip
		// pre toga potrebno je proveriti da li je Object o stvarno objekat zeljene klase (Restoran)
		// operator instanceof
		if(o instanceof Restoran) {
			Restoran r = (Restoran) (o);
			if(naziv.equals(r.getNaziv()) && adresa.equals(r.getAdresa())) return true;
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Restoran: naziv=" + naziv + ", opstina=" + opstina + ", adresa=" + adresa + ", ocena=" + ocena
				+ ", vlasnik=" + vlasnik;
	}
	
}	