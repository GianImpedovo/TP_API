package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import DAO.*;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.ReclamoException;
import excepciones.UnidadException;
import jakarta.persistence.Column;
import modelo.*;
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
	EdificioDAO edificioDAO;

	@Autowired
	UnidadDAO unidadDAO;


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

	// [x]
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
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
		unidadDAO.actualizarUnidad(unidad);
	}

	//[x]
	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
		unidadDAO.actualizarUnidad(unidad);
	}

	//[x]
	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
		unidadDAO.actualizarUnidad(unidad);
	}

	//[x]
	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
		unidadDAO.actualizarUnidad(unidad);
	}

	// [x]
	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();
		unidadDAO.actualizarUnidad(unidad);
	}

	//[x]
	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();
		unidadDAO.actualizarUnidad(unidad);
	}

	// [x]
//	public void agregarPersona(String documento, String nombre) {
//		Persona persona = new Persona(documento, nombre, null, null);
//		personaDAO.agregarPersonaBD(persona);
//	}
//
//	// [x]
//	public void eliminarPersona(String documento) throws PersonaException {
//		Persona persona = buscarPersona(documento);
//		personaDAO.eliminarPersonaBD(persona);
//	}

	// ------------------------------------ Hasta aca venimos 10/10 --------------------------------------

	// [x]
	public List<ReclamoView> reclamosPorEdificio(int codigo) throws EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamosEdificio(edificio);
		List<ReclamoView> reclamos= obtenerListaReclamoView(resultado);
		return reclamos;
	}

	// [x]
	public List<ReclamoView> reclamosPorUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamoUnidad(unidad);
		List<ReclamoView> reclamos= obtenerListaReclamoView(resultado);
		return reclamos;
	}

	// [x]
	public ReclamoView reclamosPorNumero(int numero) {
		Reclamo resultado = reclamoDAO.obtenerReclamoId(numero);
		return resultado.toView();
	}

	// [x]
	public List<ReclamoView> reclamosPorPersona(String documento) throws PersonaException{
		Persona persona = buscarPersona(documento);
		List<Reclamo> resultado = reclamoDAO.obtenerReclamoDocumento(persona);
		List<ReclamoView> reclamos = obtenerListaReclamoView(resultado);
		return reclamos;
	}

	// [x]
	public int agregarReclamo(int codigo, String piso, String numero, String documento, String ubicacion, String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		Set<Persona> habilitados = edificio.habilitados();
		for (Persona p: habilitados) {
			if(p.getDocumento().equals(persona.getDocumento())) {
				Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
				reclamo.setNumero(reclamoDAO.agregarReclamo(reclamo));
				//reclamo.cambiarEstado(Estado.nuevo);
				return reclamo.getNumero();
			}
		}
		return -1;
	}

	// [x]
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		Imagen imagen = new Imagen(direccion, tipo, reclamo);
		reclamo.agregarImagen(direccion, tipo);
		imagenDAO.agregarImagen(imagen);
	}

	// [x]
	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
		reclamoDAO.actualizarReclamo(reclamo);
	}


	// ----------------------------------------------------------------------

	private Edificio buscarEdificio(int codigo) throws EdificioException {
		Edificio edificio = edificioDAO.obtenerEdificioCodigo(codigo);
		return edificio;
	}

	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = unidadDAO.obtenerPorEdificioPisoNumero(edificio, piso, numero);
		return unidad;
	}

	public Persona buscarPersona(String documento) throws PersonaException {
		Persona persona = personaDAO.obtenerPersonaDocumento(documento);
		return persona;
	}

	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		return reclamoDAO.obtenerReclamoId(numero);
	}

	public List<ReclamoView> obtenerListaReclamoView(List<Reclamo> lista){
		List<ReclamoView> reclamos = new ArrayList<>();
		for (Reclamo r: lista)
			reclamos.add(r.toView());
		return reclamos;
	}

	// Uso como ejemplos para obtener unidades desde la persona
	public List<UnidadView> obtenerUnidades(){
		List<Unidad> unidades = personaDAO.obtenerPersonaDocumento("CI 13230978").getUnidadesComoDuenio();
		List<UnidadView> vista = new ArrayList<>();
		for (Unidad u: unidades)
			vista.add(u.toView());
		return vista;
	}

	public PersonaView iniciarSesion(String mail){
		Persona p = personaDAO.obtenerPersonaPorMail(mail);
		return p.toView();
	}

	public void guardarPersona(Persona p){
		personaDAO.actualizarPersona(p);
	}

}
