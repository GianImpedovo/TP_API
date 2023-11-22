package modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import excepciones.UnidadException;
import jakarta.persistence.*;
import vista.EdificioView;
import vista.UnidadView;

@Entity
@Table(name = "unidades")
public class Unidad {


	@Id
	@Column(name = "identificador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identificador;
	private String piso;
	private String numero;
	@Column(name = "habitado")
	private char habitado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoedificio")
	private Edificio edificio;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "duenios",
			joinColumns = @JoinColumn(name = "identificador"),
			inverseJoinColumns = @JoinColumn(name = "documento"))
	private List<Persona> duenios;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "inquilinos",
			joinColumns = @JoinColumn(name = "identificador"),
			inverseJoinColumns = @JoinColumn(name = "documento"))
	private List<Persona> inquilinos;

	public Unidad(){}

	public Unidad(String piso, String numero, Edificio edificio) {
		this.piso = piso;
		this.numero = numero;
		this.habitado = 'N';
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public Unidad(int identificador, String piso, String numero, Edificio edificio) {
		this.identificador = identificador;
		this.piso = piso;
		this.numero = numero;
		this.habitado = 'N';
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}

	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}

	public void alquilar(Persona inquilino) throws UnidadException {
		if(this.habitado == 'N') {
			this.habitado = 'S';
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
	}

	public boolean estaHabitado() {
		if (habitado == 'S')
			return true;
		return false;
	}

	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = 'N';
	}

	public void habitar() throws UnidadException {
		if(estaHabitado())
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = 'S';
	}

	public int getId() {
		return identificador;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}


	public Edificio getEdificio() {
		return edificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadView toView() {
		EdificioView auxEdificio = edificio.toView();
		return new UnidadView(identificador, piso, numero, estaHabitado(), auxEdificio);
	}

	public void quitarDuenio(Persona persona) {
		duenios.remove(persona);
	}

	public void quitarInquilino(Persona persona) {
		inquilinos.remove(persona);
	}
}
