package DAO;

import jakarta.transaction.Transactional;
import modelo.Persona;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class PersonaDAO{

    @Autowired
    PersonaRepository personaRepository;

    public PersonaDAO(){}

    public Persona obtenerPersonaDocumento(String documento){
        Optional<Persona> resultado = personaRepository.findByDocumento(documento);
        if (resultado.isPresent())
            return resultado.get();
        return null;
    }

    public void agregarPersonaBD(Persona persona){
        personaRepository.save(persona);
    }


    public void eliminarPersonaBD(Persona persona){

        for (Unidad unidad : persona.getUnidadesComoInquilino()) {
            unidad.quitarInquilino(persona);
        }

        for (Unidad unidad : persona.getUnidadesComoDuenio()) {
            unidad.quitarDuenio(persona);
        }

        personaRepository.delete(persona);
    }

}
