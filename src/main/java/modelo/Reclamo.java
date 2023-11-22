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
	private int id;

	@OneToOne
	@JoinColumn(name = "documento", referencedColumnName = "documento")
	private Persona usuario;

	@ManyToOne
	@JoinColumn(name = "codigo")
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "identificador")
	private Unidad unidad;
	private Estado estado;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idReclamo")
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

	public void agregarImagen(Imagen i) {
		imagenes.add(i);
	}

	public int getNumero() {
		return id;
	}

	public void setNumero(int numero) {
		this.id = numero;
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

	public void cambiarEstado(int estado) {
		if (estado == 0){
			this.estado = Estado.nuevo;
		}
		if (estado == 1){
			this.estado = Estado.abierto;
		}
		if (estado == 2){
			this.estado = Estado.enProceso;
		}
		if (estado == 3){
			this.estado = Estado.desestimado;
		}
		if (estado == 4){
			this.estado = Estado.anulado;
		}
		if (estado == 5){
			this.estado = Estado.terminado;
		}
	}

	public void setUsuario(Persona p){
		this.usuario = p;
	}

	public ReclamoView toView(){
		List<ImagenView> viewImagenes = new ArrayList<>();
		for (Imagen i: imagenes)
			viewImagenes.add(i.toView());
		return new ReclamoView(id, usuario.toView(), edificio.toView(), ubicacion, descripcion, unidad.toView(), estado, viewImagenes);
	}

}
