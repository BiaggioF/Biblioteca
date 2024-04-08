package biblioteca;

public class Pelicula extends Articulo {
String director;

protected Pelicula(int idarticulo, String nombre, String genero, String director) {
	super(idarticulo, nombre, genero);
	this.director = director;
}

protected String getDirector() {
	return director;
}

protected void setDirector(String director) {
	this.director = director;
}

@Override
public String toString() {
	return "Pelicula [director=" + director + ", idarticulo=" + idarticulo + ", nombre=" + nombre + ", genero=" + genero
			+ "]";
}

}
