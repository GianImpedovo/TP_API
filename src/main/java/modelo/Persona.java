package modelo;

import vista.PersonaView;

public class Persona {

	private String documento;
	private String nombre;
	private String mail;
	private String password;
	
	public Persona(String documento, String nombre, String mail, String password) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail = mail;
		this.password = password;
	}

	public void cambiarPassword(String password) {
		this.password = password;
	}
	
	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	
	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre);
	}
}
