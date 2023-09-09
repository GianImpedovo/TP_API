package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import DAO.EdificioDAO;
import DAO.UnidadDAO;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.ReclamoException;
import excepciones.UnidadException;
import jakarta.persistence.Column;
import modelo.Edificio;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import vista.EdificioView;
import vista.Estado;
import vista.PersonaView;
import vista.ReclamoView;
import vista.UnidadView;

@Controller
public class Controlador {

	@Autowired
	EdificioDAO edificioDAO;

	@Autowired
	UnidadDAO unidadDAO;

//	private static Controlador instancia;
//
//	private Controlador() { }
//
//	public static Controlador getInstancia() {
//		if(instancia == null)
//			instancia = new Controlador();
//		return instancia;
//	}

	//Listo
	public List<EdificioView> getEdificios(){
		List<Edificio> edificios = edificioDAO.obtenerTodosEdificios();
		List<EdificioView> edificioViews = new ArrayList<>();
		for (Edificio e: edificios)
			edificioViews.add(e.toView());
		return edificioViews;
	}

	// [x]
	public List<UnidadView> getUnidadesPorEdificio(int codigo) throws EdificioException{
		List<UnidadView> resultado = new ArrayList<UnidadView>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for(Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}

	// []
	public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for(Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	// [x]
	public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	// [x]
	public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.habitantes();
		for(Persona persona : habitantes)
			resultado.add(persona.toView());
		return resultado;
	}

	//[x]
	public List<PersonaView> dueniosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> duenios = unidad.getDuenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	//[x]
	public List<PersonaView> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> inquilinos = unidad.getInquilinos();
		for(Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}

	//[]
	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
	}

	//[]
	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
	}

	//[]
	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
	}

	//[]
	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
	}

	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();
	}
	
	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();;
	}
	
	public void agregarPersona(String documento, String nombre) {
		Persona persona = new Persona(documento, nombre, null, null);
		//guardar el objeto
	}
	
	public void eliminarPersona(String documento) throws PersonaException {
		Persona persona = buscarPersona(documento);
		//eliminar el objeto
	}
	
	public List<ReclamoView> reclamosPorEdificio(int codigo){
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		return resultado;
	}
	
	public List<ReclamoView> reclamosPorUnidad(int codigo, String piso, String numero) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		return resultado;
	}
	
	public ReclamoView reclamosPorNumero(int numero) {
		ReclamoView resultado = null;
		return resultado;
	}
	
	public List<ReclamoView> reclamosPorPersona(String documento) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		return resultado;
	}
 
	public int agregarReclamo(int codigo, String piso, String numero, String documento, String ubicacion, String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		return reclamo.getNumero();
	}
	
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.agregarImagen(direccion, tipo);
	}
	
	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
	}
	
	private Edificio buscarEdificio(int codigo) throws EdificioException {
		Edificio edificio = edificioDAO.obtenerEdificioCodigo(codigo);
		return edificio;
	}

	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		Unidad resultado = null;
		for (Unidad u: edificio.getUnidades())
			if (u.getNumero().equals(numero) && u.getPiso().equals(piso))
				resultado = u;
		return resultado;
	}
	
	private Persona buscarPersona(String documento) throws PersonaException {
		return null;
	}
	
	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		return null;
	}
}
