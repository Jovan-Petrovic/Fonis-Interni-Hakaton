
public class Test {

	public static void main(String[] args) {
		// Inicijalizacija objekta preko konstruktora
		int[] oceneDonjiGrad = {8,6,7,7,8,5,9,6,8,7};
		Restoran  donjiGrad = new Restoran("Donji grad", "Stari grad", "Visokog Stefana 54", oceneDonjiGrad, 85);
		
		// Inicijalizacija objekta preko setera
		/*
		donjiGrad.setNaziv("Donji grad");
		donjiGrad.setOpstina("Stari grad");
		donjiGrad.setAdresa("Visokog Stefana 54");
		int[] oceneDonjiGrad = {8,6,7,7,8,5,9,6,8,7};
		donjiGrad.setOcene(oceneDonjiGrad);
		donjiGrad.setBrojMesta(85);
		*/
		
		donjiGrad.sveOrestoranu();
		
		// Poziv staticke metode - bez inicijalizacije objekta
		/*
		Restoran.brojRestorana();
		Restoran.otvoriRestoran();
		Restoran.zatvoriRestoran();
		*/
	}

}