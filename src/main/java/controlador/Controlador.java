package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import DAO.*;
import entity.ReclamoEntity;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.ReclamoException;
import excepciones.UnidadException;
import jakarta.persistence.Column;
import modelo.*;
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

	@Autowired
	DuenioDAO duenioDAO;

	@Autowired
	PersonaDAO personaDAO;

	@Autowired
	ReclamoDAO reclamoDAO;

	@Autowired
	ImagenDAO imagenDAO;

//	private static Controlador instancia;
//
//	private Controlador() { }
//
//	public static Controlador getInstancia() {
//		if(instancia == null)
//			instancia = new Controlador();
//		return instancia;
//	}

	// [x]
	public List<EdificioView> getEdificios(){
		List<Edificio> edificios = edificioDAO.obtenerTodosEdificios();
		List<EdificioView> edificioViews = new ArrayList<>();
		for (Edificio e: edificios)
			edificioViews.add(e.toView());
		return edificioViews;
	}

	// [x]
	//HOLA 
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

	//[x]
	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Edificio edificio = buscarEdificio(codigo);
		unidad.setEdificio(edificio);

		// Elimino de la BD
		unidadDAO.eliminarDuenios(unidad);
		Persona persona = buscarPersona(documento);

		// Agregamos duenio con su unidad
		unidadDAO.agregarDuenioUnidad(persona.toEntity(), unidad.toEntity());
		unidad.transferir(persona);
	}

	//[x]
	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
		unidadDAO.agregarDuenioUnidad(persona.toEntity(), unidad.toEntity());
	}

	//[x]
	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
		unidadDAO.cambiarHabitado(unidad.toEntity());
		unidadDAO.agregarInquilino(unidad.toEntity(), persona.toEntity());
	}

	//[x]
	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
		unidadDAO.agregarInquilino(unidad.toEntity(), persona.toEntity());
	}

	// [x]
	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();
		unidadDAO.eliminarInquilinos(unidad.toEntity());
	}

	//[]
	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();;
	}

	// [x]
	public void agregarPersona(String documento, String nombre) {
		Persona persona = new Persona(documento, nombre, null, null);
		personaDAO.agregarPersonaBD(persona.toEntity());
	}

	// [x]
	public void eliminarPersona(String documento) throws PersonaException {
		Persona persona = buscarPersona(documento);
		personaDAO.eliminarPersonaBD(persona.toEntity());
	}


	// Por ahora voy a usar reclamo negocio pero hay que cambiarlo al view
	public List<Reclamo> reclamosPorEdificio(int codigo) throws EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamosEdificio(edificio.toEntity());
//		List<Reclamo> resultado = new ArrayList<>();
//		for (Reclamo r: reclamosEdificio)
//			resultado.add()
		return resultado;
	}

	// Por ahora voy a usar reclamo negocio pero hay que cambiarlo al view
	public List<Reclamo> reclamosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamoUnidad(unidad.getId());
//		List<Reclamo> resultado = new ArrayList<>();
//		for (Reclamo r: reclamosEdificio)
//			resultado.add()
		return resultado;
	}

	// Por ahora voy a usar reclamo negocio pero hay que cambiarlo al view
	public Reclamo reclamosPorNumero(int numero) {
		Reclamo resultado = reclamoDAO.obtenerReclamoId(numero);
		//ReclamoView resultado = null;
		return resultado;
	}

	// Por ahora voy a usar reclamo negocio pero hay que cambiarlo al view
	public List<Reclamo> reclamosPorPersona(String documento) throws PersonaException{
		Persona persona = buscarPersona(documento);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamoDocumento(persona.toEntity());
//		List<Reclamo> resultado = new ArrayList<>();
//		for (Reclamo r: reclamosEdificio)
//			resultado.add()
		return resultado;
	}

	// [x]
	public int agregarReclamo(int codigo, String piso, String numero, String documento, String ubicacion, String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		reclamo.setNumero(reclamoDAO.agregarReclamo(reclamo.toEntity()));
		reclamo.cambiarEstado(Estado.nuevo);
		return reclamo.getNumero();
	}

	// [XXXXXXXXXXXXXXXXXXXXXXX]
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
//		reclamo.agregarImagen(direccion, tipo);
//		Imagen i = reclamo.buscarImagen(direccion);
//		imagenDAO.agregarImagen(i.toEntity(reclamo));
		ReclamoEntity re = reclamoDAO.obtenerReclamoEntityId(numero);
		imagenDAO.agregarImagen(re, direccion, tipo);
		reclamo.agregarImagen(direccion, tipo);
	}

	// [x]
	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
		reclamoDAO.cambiarEstadoBD(numero, estado);
	}


	// ----------------------------------------------------------------------

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
		Persona persona = personaDAO.obtenerPersonaDocumento(documento);
		return persona;
	}

	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		return reclamoDAO.obtenerReclamoId(numero);
	}
}
