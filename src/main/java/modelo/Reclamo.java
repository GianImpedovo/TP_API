package modelo;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import vista.Estado;
import vista.ImagenView;
import vista.ReclamoView;

@Entity
@Table(name = "reclamos")
public class Reclamo {

	@Id
	@Column(name = "idReclamo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;

	@OneToOne
	@JoinColumn(name = "documento", referencedColumnName = "documento")
	private Persona usuario;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "identificador")
	private Unidad unidad;
	private Estado estado;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "numero")
	private List<Imagen> imagenes;

	public Reclamo(){}

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo, this);
		imagenes.add(imagen);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public List<Imagen> getImagenes(){
		return this.imagenes;
	}

	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

	public ReclamoView toView(){
		List<ImagenView> viewImagenes = new ArrayList<>();
		for (Imagen i: imagenes)
			viewImagenes.add(i.toView());
		return new ReclamoView(numero, usuario.toView(), edificio.toView(), ubicacion, descripcion, unidad.toView(), estado, viewImagenes);
	}

}
