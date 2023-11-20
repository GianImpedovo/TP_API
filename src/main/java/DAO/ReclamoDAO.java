package DAO;

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

    public int agregarReclamo(Reclamo nuevo){
        reclamoRepository.save(nuevo);
        return nuevo.getNumero();
    }

    public void actualizarReclamo(Reclamo reclamo){
        reclamoRepository.save(reclamo);
    }

    public Reclamo obtenerReclamoEntityId(int idReclamo){
        Optional<Reclamo> obtenido = reclamoRepository.findById(idReclamo);
        if (obtenido.isPresent()){
            System.out.println("Reclamo encontrado");
            return obtenido.get();
        }
        return null;
    }

    public Reclamo obtenerReclamoId(int idReclamo){
        Optional<Reclamo> obtenido = reclamoRepository.findById(idReclamo);
        if (obtenido.isPresent()){
            return obtenido.get();
        }
        return null;
    }

    public List<Reclamo> obtenerReclamosEdificio(Edificio edificio){
        List<Reclamo> resultado = reclamoRepository.findByEdificio(edificio);
        return resultado;
    }

    public List<Reclamo> obtenerReclamoUnidad(Unidad unidad){
        List<Reclamo> resultado = reclamoRepository.findByUnidad(unidad);
        return resultado;
    }

    public List<Reclamo> obtenerReclamoDocumento(Persona documento){
        List<Reclamo> reclamos = reclamoRepository.findByUsuario(documento);
        return reclamos;
    }

    public void eliminarReclamo(Reclamo r){
        reclamoRepository.delete(r);
    }

}
