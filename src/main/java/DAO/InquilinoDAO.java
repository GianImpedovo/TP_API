package DAO;

import entity.DuenioEntity;
import entity.InquilinoEntity;
import modelo.Persona;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InquilinoDAO {

    @Autowired
    InquilinoRepository inquilinoRepository;

    @Autowired
    PersonaDAO personaDAO;

    public InquilinoDAO(){}

    public List<Persona> obtenerTodosInquilinos(){
        List<InquilinoEntity> inquilinos = inquilinoRepository.findAll();
        List<Persona> personas = new ArrayList<>();
        for (InquilinoEntity i: inquilinos){
            personas.add(toNegocio(i));
        }
        return personas;
    }

    public Persona toNegocio(InquilinoEntity ie){
        // String documento, String nombre, String mail, String password
        return personaDAO.obtenerPorDocumento(ie.getDocumento());
    }

    public List<Persona> obtenerInquilinoPorIdentificador(int identificador){
        List<Persona> personas = new ArrayList<>();
        List<InquilinoEntity> inquilinos = inquilinoRepository.findAllByIdentificador(identificador);
        for (InquilinoEntity i: inquilinos){
            Persona persona = personaDAO.obtenerPorDocumento(i.getDocumento());
            personas.add(persona);
        }
        return personas;
    }

    public List<Persona> obtenerInquilino(){
        List<Persona> personas = new ArrayList<>();
        List<InquilinoEntity> inquilinos = inquilinoRepository.findAll();
        for (InquilinoEntity i: inquilinos){
            Persona persona = personaDAO.obtenerPorDocumento(i.getDocumento());
            personas.add(persona);
        }
        return personas;
    }
}
