package rest;

import DAO.PersonaDAO;
import excepciones.PersonaException;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vista.EdificioView;

import java.util.List;
import controlador.Controlador;
import vista.PersonaView;
import vista.UnidadView;


class UsuarioDTO{
    private String mail;
    private String contrasenia;
    private String documento;

    private String nombre;

    public String getMail() {
        return mail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre(){
        return nombre;
    }
}

@RestController
@RequestMapping("/personas")
public class ControladorRestPersona {

    @Autowired
    PersonaDAO personaDAO;

    @GetMapping("/")
    public PersonaView recibirPersona(@RequestBody UsuarioDTO usuarioDTO) throws PersonaException {
        return personaDAO.obtenerPersonaPorMail(usuarioDTO.getMail()).toView();
    }

    @PutMapping("/registrar")
    public void registrar(@RequestBody UsuarioDTO usuarioDTO) {
        // String documento, String nombre, String mail, String password
        Persona p = new Persona(usuarioDTO.getDocumento(), usuarioDTO.getNombre(), usuarioDTO.getMail(), usuarioDTO.getContrasenia());
        personaDAO.agregarPersonaBD(p);
    }

    @PutMapping("/actualizar")
    public void actualizarPersona(@RequestBody UsuarioDTO usuarioDTO)throws PersonaException{
        Persona p = buscarPersona(usuarioDTO.getMail());
        p.setNombre(usuarioDTO.getNombre());
        p.setMail(usuarioDTO.getMail());
        p.setPassword(usuarioDTO.getContrasenia());
        personaDAO.actualizarPersona(p);
    }

    public Persona buscarPersona(String mail) throws PersonaException {
        Persona persona = personaDAO.obtenerPersonaPorMail(mail);
        return persona;
    }

}
