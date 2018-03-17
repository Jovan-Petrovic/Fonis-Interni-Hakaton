
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
		donjiGrad.vlasnik = new Osoba();
		donjiGrad.vlasnik.ime = "Marko";
		donjiGrad.vlasnik.prezime = "Maric";
		donjiGrad.vlasnik.jmbg = "0503652852635";
		donjiGrad.setVlasnik(donjiGrad.vlasnik);
		
		donjiGrad.sefKuhinje = new Osoba();
		donjiGrad.sefKuhinje.ime = "Petar";
		donjiGrad.sefKuhinje.prezime = "Petrovic";
		donjiGrad.sefKuhinje.jmbg = "1202325685215";
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
		//donjiGrad.matricneMetode();
		
		
		
	}

}