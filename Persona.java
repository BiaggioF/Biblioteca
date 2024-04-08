package biblioteca;

public abstract class Persona {
protected String user, password;

protected Persona(String user, String password) {
	this.user = user;
	this.password = password;
}

protected String getUser() {
	return user;
}

protected void setUser(String user) {
	this.user = user;
}

}
