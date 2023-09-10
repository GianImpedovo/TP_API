package DAO;

import entity.DuenioEntity;
import entity.PersonaEntity;
import entity.UnidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import modelo.Persona;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import modelo.Unidad;

@Repository
public class DuenioDAO {

    @Autowired
    DuenioRepository duenioRepository;

    public DuenioDAO(){}

    public Persona obtenerDuenioPorDocumento(int id){
        Optional<DuenioEntity> de = duenioRepository.findById(id);
        if (de.isPresent()){
            return toNegocioPersona(de.get().getDocumento());
        }
        return null;
    }

    public List<Persona> obtenerPorUnidad(UnidadEntity unidad){
        List<DuenioEntity> personas = duenioRepository.findByIdentificador(unidad);
        List<Persona> resultado = new ArrayList<>();
        for (DuenioEntity p: personas)
            resultado.add(toNegocioPersona(p.getDocumento()));
        return resultado;
    }

    public DuenioEntity obtenerPorDocumento(PersonaEntity persona){
        Optional<DuenioEntity> duenioObtenido = duenioRepository.findByDocumento(persona);
        if (duenioObtenido.isPresent())
            return duenioObtenido.get();
        return null;
    }

    public void eliminarDuenio(PersonaEntity d){
        DuenioEntity duenio = obtenerPorDocumento(d);
        duenioRepository.delete(duenio);
    }

    public void agregarDuenio(PersonaEntity persona, UnidadEntity unidad){
        DuenioEntity duenio = new DuenioEntity(unidad, persona);
        duenioRepository.save(duenio);
        System.out.println("Duenio agregado: " + duenio.getDocumento().getDocumento());
    }

    public Persona toNegocioPersona(PersonaEntity p){
        Persona persona = new Persona(p.getDocumento(), p.getNombre(), p.getMail(), p.getContrasenia());
        return persona;
    }

}
