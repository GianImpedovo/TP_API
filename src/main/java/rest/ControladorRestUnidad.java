package rest;

import DAO.EdificioDAO;
import DAO.PersonaDAO;
import DAO.UnidadDAO;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.UnidadException;
import modelo.Edificio;
import modelo.Persona;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.ControladorRestEdificio;
import vista.PersonaView;
import vista.UnidadView;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/unidades")
public class ControladorRestUnidad {

    @Autowired
    UnidadDAO unidadDAO;

    @Autowired
    EdificioDAO edificioDAO;

    @Autowired
    PersonaDAO personaDAO;

    @GetMapping("/duenios")
    public List<PersonaView> dueniosPorUnidad(@RequestBody UnidadView u) throws UnidadException, EdificioException {
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        List<Persona> duenios = unidad.getDuenios();
        for(Persona persona : duenios)
            resultado.add(persona.toView());
        return resultado;
    }

    @GetMapping("/inquilinos")
    public List<PersonaView> inquilinosPorUnidad(@RequestBody UnidadView u) throws UnidadException, EdificioException{
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        List<Persona> inquilinos = unidad.getInquilinos();
        for(Persona persona : inquilinos)
            resultado.add(persona.toView());
        return resultado;
    }

    @PutMapping("/transferir")
    public void transferirUnidad(@RequestBody UnidadView u) throws UnidadException, PersonaException, EdificioException {
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        Persona persona = buscarPersona(u.getPersona().getDocumento());
        unidad.transferir(persona);
        unidadDAO.actualizarUnidad(unidad);
    }

    @PutMapping("/agregar/duenio")
    public void agregarDuenioUnidad(@RequestBody UnidadView u) throws UnidadException, PersonaException, EdificioException {
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        Persona persona = buscarPersona(u.getPersona().getDocumento());
        unidad.agregarDuenio(persona);
        unidadDAO.actualizarUnidad(unidad);
    }

    @PutMapping("/alquilar")
    public void alquilarUnidad(@RequestBody UnidadView u) throws UnidadException, PersonaException, EdificioException{
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        Persona persona = buscarPersona(u.getPersona().getDocumento());
        unidad.alquilar(persona);
        unidadDAO.actualizarUnidad(unidad);
    }

    @PutMapping("/agregar/inquilino")
    public void agregarInquilinoUnidad(@RequestBody UnidadView u) throws UnidadException, PersonaException, EdificioException{
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        Persona persona = buscarPersona(u.getPersona().getDocumento());
        unidad.agregarInquilino(persona);
        unidadDAO.actualizarUnidad(unidad);
    }

    @PutMapping("/liberar")
    public void liberarUnidad(@RequestBody UnidadView u) throws UnidadException, EdificioException {
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        unidad.liberar();
        unidadDAO.actualizarUnidad(unidad);
    }

    @PutMapping("/habitar")
    public void habitarUnidad(@RequestBody UnidadView u) throws UnidadException, EdificioException {
        Unidad unidad = buscarUnidad(u.getEdificio().getCodigo(), u.getPiso(), u.getNumero());
        unidad.habitar();
        unidadDAO.actualizarUnidad(unidad);
    }

    private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException, EdificioException{
        Edificio edificio = buscarEdificio(codigo);
        Unidad unidad = unidadDAO.obtenerPorEdificioPisoNumero(edificio, piso, numero);
        return unidad;
    }

    private Edificio buscarEdificio(int codigo) throws EdificioException {
        Edificio edificio = edificioDAO.obtenerEdificioCodigo(codigo);
        return edificio;
    }

    public Persona buscarPersona(String documento) throws PersonaException {
        Persona persona = personaDAO.obtenerPersonaDocumento(documento);
        return persona;
    }

}
