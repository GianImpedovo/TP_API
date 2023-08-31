package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import modelo.Edificio;

@Entity
@Table(name="edificios")
public class EdificioEntity {
	
	@Id
	private int codigo;
	private String nombre;
	private String direccion;
	
	
	public EdificioEntity() {}
	
	public EdificioEntity(int codigo, String nombre, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "EdificioEntity [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	public Edificio toNegocio() {
		Edificio e = new Edificio(this.codigo, this.nombre, this.direccion);
		return e;
	}
	
	

}
