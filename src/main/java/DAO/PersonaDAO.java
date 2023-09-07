package DAO;

import entity.PersonaEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDAO{

    @Autowired
    PersonaRepository personaRepository;

    public PersonaDAO(){}

    public Persona obtenerPorDocumento(String documento){
        Optional<PersonaEntity> recuperada = personaRepository.findByDocumento(documento);
        if (recuperada.isPresent())
            return toNegocio(recuperada.get());
        return toNegocio(recuperada.get());
    }

    public List<Persona> obtenerPersonas(){
        List<PersonaEntity> personasEntidad = personaRepository.findAll();
        List<Persona> personas = new ArrayList<>();
        for (PersonaEntity pe: personasEntidad)
            personas.add(toNegocio(pe));
        return personas;
    }

    public Persona toNegocio(PersonaEntity p){
        //String documento, String nombre, String mail, String password
        Persona nueva = new Persona(p.getDocumento(), p.getNombre(), p.getMail(), p.getContrasenia());
        return nueva;
    }
}
