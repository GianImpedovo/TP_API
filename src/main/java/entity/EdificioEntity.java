package entity;

import jakarta.persistence.*;
import modelo.Edificio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="edificios")
public class EdificioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String direccion;

	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<UnidadEntity> unidades;

	public EdificioEntity() {
	}

	public EdificioEntity(int codigo, String nombre, String direccion, List<UnidadEntity> unidades) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.unidades = unidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<UnidadEntity> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadEntity> unidades){
		this.unidades = unidades;
	}
}
