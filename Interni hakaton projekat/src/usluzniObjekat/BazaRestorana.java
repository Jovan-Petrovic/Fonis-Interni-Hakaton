package usluzniObjekat;

import java.util.LinkedList;

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
	
}
