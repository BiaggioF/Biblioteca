package biblioteca;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		  Admin adminPredeterminado = new Admin("admin", "admin", 1); 
		  ArrayList<Persona> personas = new ArrayList<>();
		  ArrayList<Articulo> articulos = new ArrayList<>();
		  ArrayList<Prestamo> prestamos = new ArrayList<>();
		  personas.add(adminPredeterminado);
		  Logica.Menuser (personas, articulos, prestamos);
	}

}
