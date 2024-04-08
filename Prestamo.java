package biblioteca;
import java.time.LocalDate;
import java.util.Date;
public class Prestamo {
	 private User usuario;
	 private Articulo articulo;
	 private LocalDate fechaPrestamo;

	 public Prestamo(User usuario, Articulo articulo, String fechaPrestamo2) {
	        this.usuario = usuario;
	        this.articulo = articulo;
	        this.fechaPrestamo = LocalDate.now();
	    }

	protected User getUsuario() {
		return usuario;
	}

	protected void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	protected Articulo getArticulo() {
		return articulo;
	}

	protected void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	protected LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	protected void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@Override
	public String toString() {
		return "Prestamos: Usuario: " + usuario + ", Articulo:" + articulo + ", Fecha del prestamo: " + fechaPrestamo + "";
	}

	public boolean isDevuelto() {
		// TODO Auto-generated method stub
		return false;
	}

	public Date getFechaDevolucion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void devolver() {
		// TODO Auto-generated method stub
		
	}
	 
}
