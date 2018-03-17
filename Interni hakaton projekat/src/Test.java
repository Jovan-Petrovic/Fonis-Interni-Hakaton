
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		// Inicijalizacija objekta preko konstruktora - 1. nacin
		/*
		int[] oceneDonjiGrad = {8,6,7,7,8,5,9,6,8,7};
		
		Restoran donjiGrad1 = new Restoran();
		donjiGrad1.vlasnik = new Osoba();
		
		donjiGrad1.vlasnik.ime = "Marko";
		donjiGrad1.vlasnik.prezime = "Maric";
		donjiGrad1.vlasnik.jmbg = "0503652852635";
		donjiGrad1.sefKuhinje.ime = "Petar";
		donjiGrad.sefKuhinje.prezime = "Petrovic";
		donjiGrad.sefKuhinje.jmbg = "1202325685215";
		Restoran  donjiGrad = new Restoran("Donji grad", "Stari grad", "Visokog Stefana 54", oceneDonjiGrad, 85, donjiGrad1.vlasnik, donjigrad1.sefKuhinje);
		*/
		
		// Inicijalizacija objekta preko setera - 2. nacin
		Restoran donjiGrad =  new Restoran();
		
		donjiGrad.setNaziv("Donji grad");
		donjiGrad.setOpstina("Stari Grad");
		donjiGrad.setAdresa("Visokog Stefana 54");
		int[] oceneDonjiGrad = {8,6,7,7,8,5,9,6,8,7}; // Inicijalizacija niza - 1. nacin
		// Inicijalizacija niza - 2. nacin
		/*
		int[] oceneDonjiGrad = new int[10];
		oceneDonjigrad[0] = 8;
		...
		oceneDonjiGrad[9] = 7;
		 */
		donjiGrad.setOcene(oceneDonjiGrad);
		donjiGrad.setBrojMesta(20);
		boolean[][] slobodnaMesta = {{false,false,false,false,false},
									{false,false,true,false,false},
									{false,false,false,true,false},
									{false,false,false,false,false}
									};
		donjiGrad.setMatrica(slobodnaMesta);
		// Atribut vlasnik je objekat klase Osoba pa prvo mora da se inicijalizuje
		donjiGrad.vlasnik = new Vlasnik("Marko", "Milicic", "0503652852635");
		// 2. nacin, dodeljivanje vrednosti atributima objekta klase Osoba da nije koriscen konstruktor
		/*
		donjiGrad.vlasnik.ime = "Marko";
		donjiGrad.vlasnik.prezime = "Maric";
		donjiGrad.vlasnik.jmbg = "0503652852635";
		*/
		donjiGrad.setVlasnik(donjiGrad.vlasnik);
		
		donjiGrad.sefKuhinje = new SefKuhinje("Petar", "Petrovic", "1202325685215");
		/*
		donjiGrad.sefKuhinje.ime = "Petar";
		donjiGrad.sefKuhinje.prezime = "Petrovic";
		donjiGrad.sefKuhinje.jmbg = "1202325685215";
		*/
		donjiGrad.setSefKuhinje(donjiGrad.sefKuhinje);
		GregorianCalendar datOtv = new GregorianCalendar();
		datOtv.set(2012,9,15);
		donjiGrad.setDatumOtvaranja(datOtv);
		
		// Poziv staticke metode - bez inicijalizacije objekta
		/*
		Restoran.brojRestorana();
		Restoran.otvoriRestoran();
		Restoran.zatvoriRestoran();
		*/
		
		
		
		donjiGrad.sveOrestoranu();
		donjiGrad.matricneMetode();
		
		donjiGrad.glavniKelner = new Kelner("Zoran", "Zivkovic", "0206996532653");
		donjiGrad.sefKuhinje = new SefKuhinje("Petar", "Stojanovic", "0911992563565");
		
		System.out.println(donjiGrad.glavniKelner);
		//donjiGrad.glavniKelner.ispisi();
		donjiGrad.glavniKelner.izracunajPlatu(100);
		System.out.println(donjiGrad.sefKuhinje);
		//donjiGrad.sefKuhinje.ispisi();
		donjiGrad.sefKuhinje.izracunajPlatu(100);
		
		// Primer kako ista metoda moze da opsluzuje vise klasa ako se koriste interfejsi. Kada se oni ne bi koristili, 
		// morale bi da se u okviru klase Dobavljac napisu dve metode izvrsiIsporuku koje bi radile isto samo bi jedna
		// bila zaduzena za klasu Restoran, a druga za klasu Prodavnica
		Ostava donjiGradOstava = new Ostava();
		Dobavljac donjiGradDobavljac = new Dobavljac();
		
		donjiGrad.namirnice = 300;
		donjiGrad.pice = 420;
		donjiGradOstava.stanjeNaSkladistuNamirnice = 100;
		donjiGradOstava.stanjeNaSkladistuPice = 110;
		
		System.out.println();
		donjiGrad.ispisiStanje();
		donjiGradOstava.ispisiStanje();
		System.out.println("Isporuka za restoran");
		// Metodi izvrsiIsporuku se moze kao parametar proslediti objekat klase Restoran jer ova klasa implementira
		// interfejs SluzbaNabavke. Onda se u okviru metode izvrsiIsporuku preko interfejsa SluzbaNabavke pozivaju metode
		// dodajNamirnice i dodajPice klase Restoran
		donjiGradDobavljac.izvrsiIsporuku(donjiGrad, 75, 38);
		System.out.println("Isporuka za ostavu");
		// Metodi izvrsiIsporuku se moze kao parametar proslediti objekat klase Ostava jer ova klasa implementira
		// interfejs SluzbaNabavke. Onda se u okviru metode izvrsiIsporuku preko interfejsa SluzbaNabavke pozivaju metode
		// dodajNamirnice i dodajPice klase ostava
		donjiGradDobavljac.izvrsiIsporuku(donjiGradOstava, 12, 17);
		System.out.println("Novo stanje restorana");
		donjiGrad.ispisiStanje();
		System.out.println("Novo stanje ostave");
		donjiGradOstava.ispisiStanje();
		
	}

}