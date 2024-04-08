package biblioteca;

public class Articulo {
private boolean prestado;
int idarticulo;
String nombre;
String genero;

protected Articulo(int idarticulo, String nombre, String genero) {
	this.idarticulo = idarticulo;
	this.nombre = nombre;
	this.genero = genero;
	this.prestado = false;
}
public boolean isPrestado() {
    return prestado;
}

public void prestar() {
    prestado = true;
}

public void devolver() {
    prestado = false;
}

protected int getIdarticulo() {
	return idarticulo;
}

protected void setIdarticulo(int idarticulo) {
	this.idarticulo = idarticulo;
}

protected String getNombre() {
	return nombre;
}

protected void setNombre(String nombre) {
	this.nombre = nombre;
}

protected String getGenero() {
	return genero;
}

protected void setGenero(String genero) {
	this.genero = genero;
}
public void setPrestado(boolean b) {
	
}



}
