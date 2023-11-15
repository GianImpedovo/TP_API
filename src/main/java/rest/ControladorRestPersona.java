package rest;

import DAO.PersonaDAO;
import excepciones.PersonaException;
import modelo.Persona;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import vista.PersonaView;
import vista.UnidadView;


@CrossOrigin
@RestController
@RequestMapping("/personas")
public class ControladorRestPersona {

    @Autowired
    PersonaDAO personaDAO;


    @GetMapping("/")
    public PersonaView recibirPersona(@RequestBody PersonaView usuario) throws PersonaException {
        return personaDAO.obtenerPersonaPorMail(usuario.getMail()).toView();
    }

    @GetMapping("/duenio/{mail}")
    public List<UnidadView> obtenerUnidadesDuenio(@PathVariable String mail){
        List<Unidad> resultado = personaDAO.obtenerUnidadesComoDuenio(mail);
        List<UnidadView> unidades = pasarAUnidadView(resultado);
        return unidades;
    }

    @GetMapping("/inquilino/{mail}")
    public List<UnidadView> obtenerUnidadesInquilino(@PathVariable String mail){
        List<Unidad> resultado = personaDAO.obtenerUnidadesComoInquilino(mail);
        List<UnidadView> unidades = pasarAUnidadView(resultado);
        return unidades;
    }

    @PutMapping("/registrar")
    public void registrar(@RequestBody PersonaView usuario) {
        // String documento, String nombre, String mail, String password
        Persona p = new Persona(usuario.getDocumento(), usuario.getNombre(), usuario.getMail(), usuario.getContrasenia());
        personaDAO.agregarPersonaBD(p);
    }

    @PutMapping("/actualizar")
    public void actualizarPersona(@RequestBody PersonaView usuario)throws PersonaException{
        Persona p = buscarPersona(usuario.getMail());
        if (usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
            p.setNombre(usuario.getNombre());
        }
        if (usuario.getContrasenia() != null && !usuario.getContrasenia().isEmpty()) {
            p.setPassword(usuario.getContrasenia());
        }
        personaDAO.actualizarPersona(p);
    }

    @DeleteMapping("/eliminar/{mail}")
    public void eliminarPersona(@PathVariable String mail) throws PersonaException{
        Persona persona = buscarPersona(mail);
        personaDAO.eliminarPersonaBD(persona);
    }

    public Persona buscarPersona(String mail) throws PersonaException {
        Persona persona = personaDAO.obtenerPersonaPorMail(mail);
        return persona;
    }

    public List<UnidadView> pasarAUnidadView(List<Unidad> unidades){
        List<UnidadView> resultado = new ArrayList<>();
        for (Unidad u: unidades)
            resultado.add(u.toView());
        return resultado;
    }


}
