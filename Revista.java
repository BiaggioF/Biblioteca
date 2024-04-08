package biblioteca;

public class Revista extends Articulo {
	String Editorial;

	protected Revista(int idarticulo, String nombre, String genero, String editorial) {
		super(idarticulo, nombre, genero);
		Editorial = editorial;
	}

	protected String getEditorial() {
		return Editorial;
	}

	protected void setEditorial(String editorial) {
		Editorial = editorial;
	}

	@Override
	public String toString() {
		return "Revista, Editorial: " + Editorial + ", ID Articulo" + idarticulo + ", Nombre=" + nombre + ", Genero: "
				+ genero + "";
	}
	

}
