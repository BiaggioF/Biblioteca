package biblioteca;

import java.util.Date;

public class User extends Persona{
protected String nombre;

protected User(String user, String password, String nombre) {
	super(user, password);
	this.nombre = nombre;
}

protected String getNombre() {
	return nombre;
}

protected void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Usuario * Nombre: " + nombre + ", Usuario:" + user + ", Contraseña:" + password + "*";
}

public void setPenalizado(boolean b) {
	// TODO Auto-generated method stub
	
}

public void setFechaFinPenalizacion(Date fechaFinPenalizacion) {
	// TODO Auto-generated method stub
	
}

}
