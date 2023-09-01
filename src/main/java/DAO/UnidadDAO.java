package DAO;


import entity.UnidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import modelo.Unidad;
import modelo.Edificio;

@Repository
public class UnidadDAO {

    @Autowired
    EdificioDAO edificioDAO;

    @Autowired
    UnidadRepository unidadRespository;

    public UnidadDAO() {}

//        Verificar que se realiza la inyeccion
//    public void init() {
//        System.out.println("Se inyecta unidadRespository: " + (unidadRespository != null));
//    }
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
