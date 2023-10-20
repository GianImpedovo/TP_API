package vista;

public class PersonaView {
	
	private String documento;
	private String nombre;

	private String mail;
	private String contrasenia;
	
	public PersonaView() {}

	public PersonaView(String documento, String nombre, String mail) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getMail() {
		return mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String toString() {
		return documento + " " + nombre;
	}
	
}
