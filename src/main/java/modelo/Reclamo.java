package modelo;

import java.util.ArrayList;
import java.util.List;

import entity.ReclamoEntity;
import vista.Estado;

public class Reclamo {

	private int idReclamo;
	private Persona usuario;
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	private Unidad unidad;
	private Estado estado;
	private List<Imagen> imagenes;

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = null;
		imagenes = new ArrayList<Imagen>();
	}
	
	public Reclamo(int idReclamo, Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.idReclamo = idReclamo;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = null;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
	}
	
	public int getNumero() {
		return idReclamo;
	}

	public void setNumero(int numero) {
		this.idReclamo = numero;
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

	public ReclamoEntity toEntity(){
		// PersonaEntity documento, EdificioEntity codigo, String ubicacion, String descripcion, int identificador
		return new ReclamoEntity(this.usuario.toEntity(), this.edificio.toEntity(), this.ubicacion, this.descripcion, this.unidad.getId());
	}


	public String toString(){
		return this.idReclamo + " " + this.descripcion + " " + this.estado;
	}

}
