package usluzniObjekat;

// Izuzeci u Javi su klase, tako da je moguce praviti sopstvene izuzetke.
// Potrebno je samo da se nasledi klasa Runtimeexception (za proveravane)
// ili Exception (za neproveravane) izuzetke i da se napise konstruktor
public class RestoranException extends RuntimeException{
	
	public RestoranException(String poruka) {
		super(poruka);
	}
	
}