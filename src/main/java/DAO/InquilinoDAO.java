package DAO;

import entity.DuenioEntity;
import entity.InquilinoEntity;
import entity.PersonaEntity;
import entity.UnidadEntity;
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

    public InquilinoDAO(){}

    public List<Persona> obtenerPorUnidad(UnidadEntity unidad){
        List<InquilinoEntity> personas = inquilinoRepository.findByIdentificador(unidad);
        List<Persona> resultado = new ArrayList<>();
        for (InquilinoEntity p: personas)
            resultado.add(toNegocioPersona(p.getDocumento()));
        return resultado;
    }

    public Persona toNegocioPersona(PersonaEntity p){
        Persona persona = new Persona(p.getDocumento(), p.getNombre(), p.getMail(), p.getContrasenia());
        return persona;
    }

}
