package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.EdificioEntity;
import entity.UnidadEntity;
import vista.EdificioView;

public class Edificio {
	
	private int codigo;
	private String nombre;
	private String direccion;
	private List<Unidad> unidades;

	public Edificio() {}

	public Edificio(int codigo, String nombre, String direccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.unidades = new ArrayList<Unidad>();
	}

	public Edificio(int codigo, String nombre, String direccion, List<Unidad> unidades) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.unidades = unidades;
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}
	
	public Set<Persona> habilitados(){
		Set<Persona> habilitados = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				habilitados.add(p);
			List<Persona> inquilinos = unidad.getInquilinos();
			for(Persona p : inquilinos)
				habilitados.add(p);
		}
		return habilitados;
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

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades){
		this.unidades = unidades;
	}

	public Set<Persona> duenios() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				resultado.add(p);
		}
		return resultado;
	}

	public Set<Persona> habitantes() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			if(unidad.estaHabitado()) {
				List<Persona> inquilinos = unidad.getInquilinos();

				if(inquilinos.size() > 0) 
					for(Persona p : inquilinos)
						resultado.add(p);
				else {
					List<Persona> duenios = unidad.getDuenios();
					for(Persona p : duenios)
						resultado.add(p);
				}
			}
		}
		return resultado;
	}

	public EdificioView toView() {
		return new EdificioView(codigo, nombre, direccion);
	}

	public EdificioEntity toEntity(){
		List<UnidadEntity> unidadesEntity = new ArrayList<>();
		for(Unidad u: unidades)
			unidadesEntity.add(u.toEntity());
		return new EdificioEntity(this.codigo, this.nombre, this.direccion, unidadesEntity);
	}
}
