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

    public Persona obtenerPersonaDocumento(String documento){
        Optional<PersonaEntity> resultado = personaRepository.findByDocumento(documento);
        if (resultado.isPresent())
            return toNegocio(resultado.get());
        return null;
    }

    public void agregarPersonaBD(PersonaEntity persona){
        personaRepository.save(persona);
    }

    public void eliminarPersonaBD(PersonaEntity persona){
        personaRepository.delete(persona);
    }

    public Persona toNegocio(PersonaEntity persona){
        Persona nueva = new Persona(persona.getDocumento(),persona.getNombre(),persona.getMail(), persona.getContrasenia());
        return nueva;
    }

}
