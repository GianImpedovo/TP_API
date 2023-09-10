package DAO;


import entity.*;
import modelo.Persona;
import org.hibernate.sql.results.graph.entity.internal.EntityDelayedFetchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import modelo.Unidad;
import modelo.Edificio;

@Repository
public class UnidadDAO {

    @Autowired
    UnidadRepository unidadRespository;

    @Autowired
    DuenioDAO duenioDAO;

    @Autowired
    InquilinoDAO inquilinoDAO;


//        Verificar que se realiza la inyeccion
//    public void init() {
//        System.out.println("Se inyecta unidadRespository: " + (unidadRespository != null));
//    }

    public UnidadEntity obtenerUnidadPorIdentificador(int identificador){
        Optional<UnidadEntity> unidad = unidadRespository.findByIdentificador(identificador);
        if (unidad.isPresent())
            return unidad.get();
        return null;
    }

    public void eliminarDuenios(Unidad unidad){
        UnidadEntity u = obtenerUnidadPorIdentificador(unidad.getId());
        List<Persona> duenios = duenioDAO.obtenerPorUnidad(u);
        for (Persona d: duenios){
            duenioDAO.eliminarDuenio(d.toEntity());
            System.out.println(d.toView().toString() + " - SE ELIMINO");
        }
    }

    public void agregarDuenioUnidad(PersonaEntity persona, UnidadEntity unidad){
        duenioDAO.agregarDuenio(persona, unidad);
    }

    public Unidad toNegocio(UnidadEntity unidad, Edificio edificio){
        //int id, String piso, String numero, boolean habitado,Edificio edificio
        Unidad u = new Unidad(unidad.getIdentificador(), unidad.getPiso(), unidad.getNumero(), unidad.getHabitado(), edificio);
        List<Persona> duenios = duenioDAO.obtenerPorUnidad(unidad);
        List<Persona> inquilinos = inquilinoDAO.obtenerPorUnidad(unidad);
        u.setDuenios(duenios);
        u.setInquilinos(inquilinos);
        return u;
    }


}
