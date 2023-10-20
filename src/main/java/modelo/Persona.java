package modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import vista.PersonaView;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "personas")
public class Persona {

	@Id
	private String documento;
	private String nombre;
	private String mail;

	@Column(name = "contrasenia")
	private String password;

	@ManyToMany(mappedBy = "duenios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Unidad> unidadesComoDuenio;

	@ManyToMany(mappedBy = "inquilinos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Unidad> unidadesComoInquilino;


	public Persona (){}

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

	public List<Unidad> getUnidadesComoDuenio() {
		return unidadesComoDuenio;
	}

	public void agregarUnidadComoDuenio(Unidad unidad){
		unidadesComoDuenio.add(unidad);
	}

	public List<Unidad> getUnidadesComoInquilino() {
		return unidadesComoInquilino;
	}

	public void agregarUnidadComoInquilino(Unidad unidad){
		unidadesComoInquilino.add(unidad);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre, mail);
	}
}
