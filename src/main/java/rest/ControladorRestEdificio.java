package rest;

import DAO.EdificioDAO;
import excepciones.EdificioException;
import modelo.Edificio;
import modelo.Persona;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vista.EdificioView;
import vista.PersonaView;
import vista.UnidadView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/edificios")
public class ControladorRestEdificio {

    @Autowired
    EdificioDAO edificioDAO;

    @GetMapping("/")
    public List<EdificioView> getEdificios(){
        List<Edificio> edificios = edificioDAO.obtenerTodosEdificios();
        List<EdificioView> edificioViews = new ArrayList<>();
        for (Edificio e: edificios)
            edificioViews.add(e.toView());
        return edificioViews;
    }

    @GetMapping("/unidades/{codigo}")
    public List<UnidadView> getUnidadesPorEdificio(@PathVariable int codigo) throws EdificioException {
        List<UnidadView> resultado = new ArrayList<UnidadView>();
        Edificio edificio = buscarEdificio(codigo);
        List<Unidad> unidades = edificio.getUnidades();
        for(Unidad unidad : unidades)
            resultado.add(unidad.toView());
        return resultado;
    }

    @GetMapping("/habilitados/{codigo}")
    public List<PersonaView> habilitadosPorEdificio(@PathVariable int codigo) throws EdificioException{
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Edificio edificio = buscarEdificio(codigo);
        Set<Persona> habilitados = edificio.habilitados();
        for(Persona persona : habilitados)
            resultado.add(persona.toView());
        return resultado;
    }

    @GetMapping("/duenios/{codigo}")
    public List<PersonaView> dueniosPorEdificio(@PathVariable int codigo) throws EdificioException{
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Edificio edificio = buscarEdificio(codigo);
        Set<Persona> duenios = edificio.duenios();
        for(Persona persona : duenios)
            resultado.add(persona.toView());
        return resultado;
    }

    @GetMapping("/habitantes/{codigo}")
    public List<PersonaView> habitantesPorEdificio(@PathVariable int codigo) throws EdificioException{
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Edificio edificio = buscarEdificio(codigo);
        Set<Persona> habitantes = edificio.habitantes();
        for(Persona persona : habitantes)
            resultado.add(persona.toView());
        return resultado;
    }

    @PutMapping("/registrar")
    public void registrarEdificio(@RequestBody EdificioView nuevo){
        Edificio e = new Edificio(nuevo.getNombre(), nuevo.getDireccion());
        edificioDAO.guardarEdificio(e);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarEdificio(@PathVariable int codigo) throws EdificioException{
        Edificio e = buscarEdificio(codigo);
        edificioDAO.eliminarEdificio(e);
    }

    private Edificio buscarEdificio(int codigo) throws EdificioException {
        Edificio edificio = edificioDAO.obtenerEdificioCodigo(codigo);
        return edificio;
    }


}
