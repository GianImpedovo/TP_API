package DAO;

import entity.PersonaEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public class PersonaDAO{

    @Autowired
    PersonaRepository personaRepository;
    private PersonaDAO personaDAO;

    public PersonaDAO(){}

    public Persona obtenerPorDocumento(String documento){
        Optional<PersonaEntity> recuperada = personaRepository.findByDocumento(documento);
        if (recuperada.isPresent())
            return toNegocio(recuperada.get());
        return toNegocio(recuperada.get());
    }

    public Persona toNegocio(PersonaEntity p){
        //String documento, String nombre, String mail, String password
        Persona nueva = new Persona(p.getDocumento(), p.getNombre(), p.getMail(), p.getContrasenia());
        return nueva;
    }
}
