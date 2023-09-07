package DAO;

import entity.DuenioEntity;
import entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DuenioDAO {

    @Autowired
    DuenioRepository duenioRepository;

    @Autowired
    PersonaDAO personaDAO;

    public DuenioDAO(){}

    public List<Persona> obtenerTodosDuenios(){
        List<DuenioEntity> duenios = duenioRepository.findAll();
        List<Persona> personas = new ArrayList<>();
        for (DuenioEntity d: duenios){
            personas.add(toNegocio(d));
        }
        return personas;
    }

    public Persona toNegocio(DuenioEntity de){
        // String documento, String nombre, String mail, String password
        return personaDAO.obtenerPorDocumento(de.getDocumento());
    }
}
