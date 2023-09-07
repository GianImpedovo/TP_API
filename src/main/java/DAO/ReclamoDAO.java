package DAO;

import entity.ReclamoEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Reclamo;
@Repository
public class ReclamoDAO {

    @Autowired
    ReclamoRepository reclamoRepository;

    @Autowired
    PersonaDAO personaDAO;

    @Autowired
    EdificioDAO edificioDAO;

    @Autowired
    UnidadDAO unidadDAO;


    private ReclamoDAO reclamoDAO;

    public ReclamoDAO(){}

    public Reclamo toNegocio(ReclamoEntity re){
        //Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad
        Reclamo r = new Reclamo(personaDAO.toNegocio(re.getPersona()),
                edificioDAO.toNegocio(re.getEdificio()),
                re.getUbicacion(),
                re.getDescripcion(),
                unidadDAO.toNegocio(re.getUnidad()));
        return r;
    }


}
