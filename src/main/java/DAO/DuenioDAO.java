package DAO;

import entity.DuenioEntity;
import entity.PersonaEntity;
import entity.UnidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import modelo.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void cambiarDuenio(DuenioEntity duenio, int identificador){
        List<DuenioEntity> duenios = obtenerPorUnidad(identificador);
        for (DuenioEntity d: duenios)
            duenioRepository.delete(d);

    }

    public List<DuenioEntity> obtenerPorUnidad(int identificador){
        List<DuenioEntity> duenios = duenioRepository.findAllByIdentificador(identificador);
        return duenios;
    }

    public Persona toNegocio(DuenioEntity de){
        // String documento, String nombre, String mail, String password
        return personaDAO.obtenerPorDocumento(de.getDocumento());
    }

    public List<Persona> obtenerDueniosIdentificador(int identificador){
        List<Persona> personas = new ArrayList<>();
        List<DuenioEntity> duenios = duenioRepository.findAllByIdentificador(identificador);
        for (DuenioEntity d: duenios){
            Persona persona = personaDAO.obtenerPorDocumento(d.getDocumento());
            personas.add(persona);
        }
        return personas;
    }

    public List<Persona> obtenerDuenios(){
        List<Persona> personas = new ArrayList<>();
        List<DuenioEntity> duenios = duenioRepository.findAll();
        for (DuenioEntity d: duenios){
            Persona persona = personaDAO.obtenerPorDocumento(d.getDocumento());
            personas.add(persona);
        }
        return personas;
    }
}
