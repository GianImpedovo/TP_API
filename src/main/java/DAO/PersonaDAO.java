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

    public Persona obtenerPersonaPorMail(String mail){
        Optional<Persona> resultado = personaRepository.findByMail(mail);
        if (resultado.isPresent())
            return resultado.get();
        return null;
    }

    public void actualizarPersona(Persona p){
        personaRepository.save(p);
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

    public List<Unidad> obtenerUnidadesComoDuenio(String mail) {
        Persona persona = personaRepository.findByMail(mail).orElse(null);
        if (persona != null) {
            List<Unidad> unidades = persona.getUnidadesComoDuenio();
            return unidades;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Unidad> obtenerUnidadesComoInquilino(String mail) {
        Persona persona = personaRepository.findByMail(mail).orElse(null);
        if (persona != null) {
            List<Unidad> unidades = persona.getUnidadesComoInquilino();
            return unidades;
        } else {
            return new ArrayList<>();
        }
    }

}
