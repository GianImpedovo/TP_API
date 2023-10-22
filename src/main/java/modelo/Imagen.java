package modelo;


import jakarta.persistence.*;
import vista.ImagenView;

@Entity
@Table(name = "imagenes")
public class Imagen {

	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;

	@Column(name = "path")
	private String direccion;

	@Column(name = "tipo")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idReclamo")
	private Reclamo idReclamo;

	public Imagen(){}

	public Imagen(String direccion, String tipo, Reclamo idReclamo) {
		this.direccion = direccion;
		this.tipo = tipo;
		this.idReclamo = idReclamo;
	}

	public int getNumero() {
		return numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ImagenView toView(){
		return new ImagenView(direccion, tipo);
	}
}
