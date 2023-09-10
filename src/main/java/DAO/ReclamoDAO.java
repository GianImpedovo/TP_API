package DAO;

import entity.EdificioEntity;
import entity.PersonaEntity;
import entity.ReclamoEntity;
import entity.UnidadEntity;
import modelo.Persona;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Reclamo;
import modelo.Edificio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import vista.Estado;
@Repository
public class ReclamoDAO {

    @Autowired
    ReclamoRepository reclamoRepository;

    @Autowired
    EdificioDAO edificioDAO;

    @Autowired
    PersonaDAO personaDAO;

    @Autowired
    UnidadDAO unidadDAO;



    private ReclamoDAO reclamoDAO;

    public ReclamoDAO(){}

    public int agregarReclamo(ReclamoEntity nuevo){
        reclamoRepository.save(nuevo);
        return nuevo.getIdReclamo();
    }

    public void cambiarEstadoBD(int idReclamo, Estado estado){
        ReclamoEntity reclamo = obtenerReclamoEntityId(idReclamo);
        reclamo.setEstado(estado);
        reclamoRepository.save(reclamo);
    }

    public ReclamoEntity obtenerReclamoEntityId(int idReclamo){
        Optional<ReclamoEntity> obtenido = reclamoRepository.findById(idReclamo);
        if (obtenido.isPresent()){
            System.out.println("Reclamo encontrado");
            return obtenido.get();
        }
        return null;
    }

    public Reclamo obtenerReclamoId(int idReclamo){
        Optional<ReclamoEntity> obtenido = reclamoRepository.findById(idReclamo);
        if (obtenido.isPresent()){
            return toNegocio(obtenido.get());
        }
        return null;
    }

    public List<Reclamo> obtenerReclamosEdificio(EdificioEntity edificio){
        List<ReclamoEntity> reclamosEntity = reclamoRepository.findByCodigo(edificio);
        List<Reclamo> reclamosNegocio = new ArrayList<>();
        for (ReclamoEntity r: reclamosEntity)
            reclamosNegocio.add(toNegocio(r));
        return reclamosNegocio;
    }

    public List<Reclamo> obtenerReclamoUnidad(int identificador){
        List<ReclamoEntity> reclamosEntity = reclamoRepository.findByIdentificador(identificador);
        List<Reclamo> reclamosNegocio = new ArrayList<>();
        for (ReclamoEntity r: reclamosEntity)
            reclamosNegocio.add(toNegocio(r));
        return reclamosNegocio;
    }

    public List<Reclamo> obtenerReclamoDocumento(PersonaEntity documento){
        List<ReclamoEntity> reclamosEntity = reclamoRepository.findByDocumento(documento);
        List<Reclamo> reclamosNegocio = new ArrayList<>();
        for (ReclamoEntity r: reclamosEntity)
            reclamosNegocio.add(toNegocio(r));
        return reclamosNegocio;
    }

    public Reclamo toNegocio(ReclamoEntity reclamo){
        //Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad
        Edificio e = edificioDAO.toNegocio(reclamo.getCodigo());
        Persona p = personaDAO.toNegocio(reclamo.getDocumento());
        Unidad u = unidadDAO.toNegocio(unidadDAO.obtenerUnidadPorIdentificador(reclamo.getIdentificador()), e);
        Reclamo r = new Reclamo(reclamo.getIdReclamo(), p, e, reclamo.getUbicacion(), reclamo.getDescripcion(), u);
        r.cambiarEstado(reclamo.getEstado());
        return r;
    }


}
