package biblioteca;

public class libro extends Articulo{
String autor;

protected libro(int idarticulo, String nombre, String genero, String autor) {
	super(idarticulo, nombre, genero);
	this.autor = autor;
}

protected String getAutor() {
	return autor;
}

protected void setAutor(String autor) {
	this.autor = autor;
}

@Override
public String toString() {
	return "ID Libro: " + idarticulo + ", Autor libro: " + autor + ", Nombre: " + nombre + ", Genero: " + genero + "";
}


}
