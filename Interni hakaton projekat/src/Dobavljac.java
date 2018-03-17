
public class Dobavljac {
	
	// Ovako napisana metoda izvrsiIsporuku omogucava klasi Dobavljac da vrsi isporuku bilo kakvom restoranu
	// tj. ostavi. Jedino je bitno da taj restoran yj. klasa kojom se predstavlja implementira interfejs
	// SluzbaNabavke
	public void izvrsiIsporuku(SluzbaNabavke n, int kolicinaNamirnice, int kolicinaPice) {
		n.dodajNamirnice(kolicinaNamirnice);
		System.out.println("Izvrsena isporuka namirnica u kolicini: " + kolicinaNamirnice + " kg");
		n.dodajPice(kolicinaPice);
		System.out.println("Izvrsena isporuka pica u kolicini: " + kolicinaPice + " l");
	}
}