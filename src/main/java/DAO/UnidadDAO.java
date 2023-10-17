package DAO;


import modelo.Persona;
import org.hibernate.sql.results.graph.entity.internal.EntityDelayedFetchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.*;

import modelo.Unidad;
import modelo.Edificio;

@Repository
public class UnidadDAO {

    @Autowired
    UnidadRepository unidadRespository;


//        Verificar que se realiza la inyeccion
//    public void init() {
//        System.out.println("Se inyecta unidadRespository: " + (unidadRespository != null));
//    }

    public Unidad obtenerUnidadPorIdentificador(int identificador){
        Optional<Unidad> unidad = unidadRespository.findByIdentificador(identificador);
        if (unidad.isPresent())
            return unidad.get();
        return null;
    }

    public Unidad obtenerPorEdificioPisoNumero(Edificio e, String piso, String numero){
        Optional<Unidad> unidad = unidadRespository.findByEdificioAndPisoAndNumero(e,piso,numero);
        if (unidad.isPresent())
            return unidad.get();
        return null;
    }

    public void actualizarUnidad(Unidad unidad){
        unidadRespository.save(unidad);
    }


}
