package DAO;


import entity.EdificioEntity;
import entity.UnidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    EdificioDAO edificioDAO;

//        Verificar que se realiza la inyeccion
//    public void init() {
//        System.out.println("Se inyecta unidadRespository: " + (unidadRespository != null));
//    }

    public List<Unidad> obtenerTodasUnidades(){
        List<UnidadEntity> unidadesEntity = unidadRespository.findAll();
        List<Unidad> unidades = new ArrayList<>();
        for (UnidadEntity u: unidadesEntity)
            unidades.add(toNegocio(u));
        return unidades;
    }

    public Unidad obtenerUnidadByIdentificador(int id){
        Optional<UnidadEntity> unidadEntity = unidadRespository.findByIdentificador(id);
        if (unidadEntity.isPresent())
            return toNegocio(unidadEntity.get());
        return null;
    }

    public Unidad toNegocio(UnidadEntity ue){
        Edificio nuevoEdificio = edificioDAO.toNegocio(ue.getEdificio());
        Unidad u = new Unidad(ue.getIdentificador(), ue.getPiso(), ue.getNumero(), nuevoEdificio);
        return u;
    }

}
