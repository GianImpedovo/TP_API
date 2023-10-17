package vista;

import java.util.List;

public class ReclamoView {

	private int numero;
	private PersonaView usuario;
	private EdificioView edificio;
	private String ubicacion;
	private String descripcion;
	private UnidadView unidad;
	private Estado estado;
	private List<ImagenView> imagenes;

	public ReclamoView(int numero, PersonaView usuario,
					   EdificioView edificio, String ubicacion,
					   String descripcion, UnidadView unidad,
					   Estado estado, List<ImagenView> imagenes) {
		this.numero = numero;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = estado;
		this.imagenes = imagenes;
	}

	@Override
	public String toString() {
		return "ReclamoView{" +
				"numero=" + numero +
				", usuario=" + usuario +
				", edificio=" + edificio +
				", ubicacion='" + ubicacion + '\'' +
				", descripcion='" + descripcion + '\'' +
				", unidad=" + unidad +
				", estado=" + estado +
				'}';
	}
}
