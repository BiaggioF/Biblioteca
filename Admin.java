package biblioteca;

public class Admin extends Persona{
protected int codigo;

protected Admin(String user, String password, int codigo) {
	super(user, password);
	this.codigo = codigo;
}

protected int getCodigo() {
	return codigo;
}

protected void setCodigo(int codigo) {
	this.codigo = codigo;
}

}
