package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import DAO.*;
import entity.UnidadEntity;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.ReclamoException;
import excepciones.UnidadException;
import modelo.Edificio;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vista.EdificioView;
import vista.Estado;
import vista.PersonaView;
import vista.ReclamoView;
import vista.UnidadView;


@Controller
public class Controlador {

	@Autowired
	PersonaDAO personaDAO;

	@Autowired
	EdificioDAO edificioDAO;

	@Autowired
	UnidadDAO unidadDAO;

	@Autowired
	DuenioDAO duenioDAO;

	@Autowired
	InquilinoDAO inquilinoDAO;



	// Listo
	public List<EdificioView> getEdificios(){
		List<Edificio> edificiosNegocio = edificioDAO.obtenerTodosEdificios();
		List<EdificioView> edificios = new ArrayList<>();
		for (Edificio e: edificiosNegocio)
			edificios.add(e.toView());
		return edificios;
	}

	// Listo
	public List<UnidadView> getUnidadesPorEdificio(int codigo) throws EdificioException{
		List<UnidadView> resultado = new ArrayList<UnidadView>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for(Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}


	// Listo
	public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for(Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	// Listo
	public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	// Listo
	public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.habitantes();
		for(Persona persona : habitantes)
			resultado.add(persona.toView());
		return resultado;
	}

	// Listo
	public List<PersonaView> dueniosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> duenios = unidad.getDuenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	// Listo
	public List<PersonaView> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> inquilinos = unidad.getInquilinos();
		for(Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}

	// Pasa el duenio antiguo al nuevo duenio ingresado.
	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
	}

	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
	}

	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
	}

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
		Edificio edificio = edificioDAO.ObtenerEdificioCodigo(codigo);
		agregarUnidadesEdificio(edificio);
		return edificio;
	}

	public void agregarUnidadesEdificio(Edificio edificio){
		List<Unidad> unidades = unidadDAO.obtenerTodasUnidades();
		for (Unidad u: unidades){
			if (u.getEdificio().getCodigo() == edificio.getCodigo()){
				agregarPersonas(u);
				edificio.agregarUnidad(u);
			}
		}
	}

	private Unidad buscarUnidad(int identificador) throws UnidadException{
		Unidad u = unidadDAO.obtenerUnidadByIdentificador(identificador);
		agregarPersonas(u);
		return u;
	}

	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		System.out.println(unidades.size());
		for (Unidad u: unidades)
			if (u.getPiso().equals(piso) && u.getNumero().equals(numero) )
				return u;
		return null;
	}

	public void agregarPersonas(Unidad u){
		List<Persona> duenios = duenioDAO.obtenerDueniosIdentificador(u.getId());
		for (Persona p: duenios)
			u.agregarDuenio(p);

		List<Persona> inquilinos = inquilinoDAO.obtenerInquilinoPorIdentificador(u.getId());
		for (Persona p: inquilinos)
			u.agregarInquilino(p);

	}
	
	private Persona buscarPersona(String documento) throws PersonaException {
		Persona persona = personaDAO.obtenerPorDocumento(documento);
		return persona;
	}
	
	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		return null;
	}

}
