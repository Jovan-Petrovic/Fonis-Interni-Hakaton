package usluzniObjekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class BazaRestorana {
	// Liste
	private static LinkedList<Restoran> restorani;
	
	public BazaRestorana() {
		restorani = new LinkedList<Restoran>();
	}
	
	public boolean daLiJeUBazi(Restoran r) {
		// metoda contains(Object o) automatski poziva equals metodu klase koja je uneta kao element liste
		return restorani.contains(r);
	}
	
	public void unesiUBazu(Restoran r) {
		if(daLiJeUBazi(r)) System.out.println("Taj restoran se vec nalazi u bazi");
		else restorani.add(r);
	}
	
	public void izbaciIzBaze(Restoran r) {
		if(!daLiJeUBazi(r)) System.out.println("Taj restoran se ne nalazi u bazi");
		else restorani.remove(r);
	}
	
	public void ispisi() {
		for(int i = 0; i < restorani.size(); i++) {
			System.out.println(restorani.get(i));
		}
	}
	
	public void naboljeOcenjenRrestoran() {
		double maxOcena = restorani.get(0).prosecnaOcena();
		Restoran r = restorani.get(0);
		for(int i = 0; i < restorani.size(); i++) {
			if(restorani.get(i).prosecnaOcena() > maxOcena) {
				maxOcena = restorani.get(i).prosecnaOcena();
				r = restorani.get(i);
			}
		}
		System.out.println("Najbolje ocenjen restoran: " + r);
		System.out.println("Ocena: " + maxOcena);
	}
	
	// SWITCH naredba
	public static void izaberiteNaOsnovuBudzeta(int budzet, int brojOsoba) {
		double vrednost = budzet / brojOsoba;
		int selektor;
		if(vrednost < 300) selektor = 1;
		else {
			if(vrednost > 300 && vrednost < 600) selektor = 2;
			else {
				if(vrednost > 600 && vrednost < 1000) selektor = 3;
				else {
					if(vrednost > 1000 && vrednost < 2000) selektor = 4;
					else selektor = 5;
				}
			}
		}
		System.out.println("Preporucujemo vam sledece restorane shodno finansijama");
		switch (selektor) {
			case 1: ispisiSveSaLuksuznoscu(1); break;
			case 2: ispisiSveSaLuksuznoscu(2); break;
			case 3: ispisiSveSaLuksuznoscu(3); break;
			case 4: ispisiSveSaLuksuznoscu(4); break;
			case 5: ispisiSveSaLuksuznoscu(5); break;
		}
	}
	
	public static void ispisiSveSaLuksuznoscu(int luksuz) {
		for(int i = 0; i < restorani.size(); i++) {
			if(restorani.get(i).getLuksuznost() == luksuz) System.out.println(restorani.get(i));
		}
	}
	
	// Rad sa tekstualnim fajlovima, ucitavanje sa tastature pomocu klase BufferedReader
		public static void dodajRestoranUBazu(String fajl) {
			try {
				// Upisivanje u tekstualni fajl vrsi se koriscenjem klase PrintWriter
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fajl, true)));
				Scanner in1 = new Scanner(System.in);
				System.out.print("Unesite naziv restorana: ");
				String s1 = in1.nextLine();
				Scanner in2 = new Scanner(System.in);
				System.out.print("Unesite opstinu restorana: ");
				String s2 = in2.nextLine();
				Scanner in3 = new Scanner(System.in);
				System.out.print("Unesite adresu restorana: ");
				String s3 = in3.nextLine();
				Scanner in4 = new Scanner(System.in);
				System.out.print("Unesite ocenu restorana: ");
				double s4 = in4.nextDouble();
				String restoran = s1 + " " + s2 + " " + s3 + " " + s4;
				out.println(restoran);
				out.close();
			} catch (IOException e) {
				System.out.println("Greska: " + e.getMessage());
			}
		}
		
		// Vise metoda moze biti istog imena ali moraju imati razlicitu povratnu vrednost ili broj ili tip parametara
		public static void dodajRestoranUBazu(Restoran r, String fajl) {
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fajl, true)));
				String s1 = r.getNaziv();
				String s2 = r.getOpstina();
				String s3 = r.getAdresa();
				double s4 = r.prosecnaOcena();
				String pom = s1 + " " + s2 + " " + s3 + " " + s4;
				out.println(pom);
				out.close();
			} catch (Exception e) {
				System.out.println("Greska: " + e.getMessage());
			}
		}
		
		public static void ispisiSverestoraneIzBaze(String fajl) {
			try {
				// Citanje iz tekstualnog fajla koriscenjem klase BufferedReader
				BufferedReader in = new BufferedReader (new FileReader(fajl));
				boolean kraj = false;
				String s = "";
				
				while (!kraj) {
					String pom = "";
					try {
						pom = in.readLine();
					} catch (IOException e) {
						System.out.println("Greska: " + e.getMessage());
					}
					if (pom == null) kraj = true;
					else s = s + pom + "\n";
				}
				
				in.close();
				System.out.println("Svi restorani iz baze");
				System.out.println(s);
			} catch (FileNotFoundException e) {
				System.out.println("Greska: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Greska: " + e.getMessage());
			}
		}
	
}
