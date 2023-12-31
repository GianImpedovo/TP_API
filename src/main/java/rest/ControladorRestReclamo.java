package rest;


import DAO.*;
import excepciones.EdificioException;
import excepciones.PersonaException;
import excepciones.ReclamoException;
import excepciones.UnidadException;
import modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vista.Estado;
import vista.ImagenView;
import vista.ReclamoView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/reclamos")
public class ControladorRestReclamo {

    @Autowired
    UnidadDAO unidadDAO;

    @Autowired
    EdificioDAO edificioDAO;

    @Autowired
    PersonaDAO personaDAO;

    @Autowired
    ImagenDAO imagenDAO;

    @Autowired
    ReclamoDAO reclamoDAO;

    @GetMapping("/edificio/{codigo}")
    public List<ReclamoView> reclamosPorEdificio(@PathVariable int codigo) throws EdificioException {
        Edificio edificio = buscarEdificio(codigo);
        List<Reclamo> resultado = reclamoDAO.obtenerReclamosEdificio(edificio);
        List<ReclamoView> reclamos= obtenerListaReclamoView(resultado);
        return reclamos;
    }

    @PutMapping ("/agregar")
    public int agregarReclamo(@RequestBody ReclamoView reclamo) throws EdificioException, UnidadException, PersonaException {
        Edificio edificio = buscarEdificio(reclamo.getEdificio().getCodigo());
        Unidad unidad = buscarUnidad(reclamo.getEdificio().getCodigo(), reclamo.getUnidad().getPiso(), reclamo.getUnidad().getNumero());
        Persona persona = buscarPersona(reclamo.getUsuario().getDocumento());
        Set<Persona> habilitados = edificio.habilitados();
        for (Persona p: habilitados) {
            if(p.getDocumento().equals(persona.getDocumento())) {
                Reclamo r = new Reclamo(persona, edificio, reclamo.getUbicacion(), reclamo.getDescripcion(), unidad);
                r.setNumero(reclamoDAO.agregarReclamo(r));
                //reclamo.cambiarEstado(Estado.nuevo);
                return r.getNumero();
            }
        }
        return -1;
    }

    @PutMapping("/agregar/imagen/{id}")
    public void agregarImagenAReclamo(@PathVariable int id, @RequestBody ImagenView i) throws ReclamoException {
        Reclamo reclamo = buscarReclamo(id);
        System.out.println(reclamo.getNumero());
        Imagen imagen = new Imagen(i.getDireccion(), i.getTipo(), reclamo);
        reclamo.agregarImagen(imagen);
        imagenDAO.agregarImagen(imagen);
    }

    @GetMapping("/unidad/codigo:{codigo}/piso:{piso}/numero:{numero}")
    public List<ReclamoView> reclamosPorUnidad(@PathVariable int codigo, @PathVariable String piso, @PathVariable String numero) throws UnidadException, EdificioException{
        Unidad unidad = buscarUnidad(codigo, piso, numero);
        List<Reclamo> resultado = reclamoDAO.obtenerReclamoUnidad(unidad);
        List<ReclamoView> reclamos= obtenerListaReclamoView(resultado);
        return reclamos;
    }

    @GetMapping("/{numero}")
    public ReclamoView reclamosPorNumero(@PathVariable int numero) {
        Reclamo resultado = reclamoDAO.obtenerReclamoId(numero);
        return resultado.toView();
    }

    @GetMapping("/persona:{documento}")
    public List<ReclamoView> reclamosPorPersona(@PathVariable String documento) throws PersonaException{
        Persona persona = buscarPersona(documento);
        List<Reclamo> resultado = reclamoDAO.obtenerReclamoDocumento(persona);
        List<ReclamoView> reclamos = obtenerListaReclamoView(resultado);
        return reclamos;
    }

    @GetMapping("/estado:{estado}")
    public List<ReclamoView> reclamosPorEstado(@PathVariable Estado estado) throws PersonaException{
        List<Reclamo> resultado = reclamoDAO.obtenerReclamoPorEstado(estado);
        List<ReclamoView> reclamos = obtenerListaReclamoView(resultado);
        return reclamos;
    }

    @PutMapping("/cambiarEstado:{numero}/estado={estado}")
    public void cambiarEstado(@PathVariable int numero,@PathVariable int estado) throws ReclamoException {
        Reclamo reclamo = buscarReclamo(numero);
        reclamo.cambiarEstado(estado);
        reclamoDAO.actualizarReclamo(reclamo);
    }

    @GetMapping("/imagenes:{id}")
    public List<ImagenView> obtenerImagenes(@PathVariable int id) throws ReclamoException {
        List<Imagen> imagenes = buscarReclamo(id).getImagenes();
        List<ImagenView> resultado = new ArrayList<>();
        for (Imagen i: imagenes)
            resultado.add(i.toView());

        return resultado;
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarReclamo(@PathVariable int id) throws ReclamoException{
        Reclamo r = buscarReclamo(id);
        reclamoDAO.eliminarReclamo(r);
    }

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
}
