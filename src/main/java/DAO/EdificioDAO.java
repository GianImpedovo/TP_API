package DAO;
import entity.EdificioEntity;
import modelo.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.chrono.MinguoDate;
import java.util.Optional;

@Repository
public class EdificioDAO {

    @Autowired
    EdificioRepository edificioRepositorio;

    public EdificioDAO() {}

//    Verificar que se realiza la inyeccion
//    public void init() {
//        System.out.println("Se inyecta EdificioRepository: " + (edificioRepositorio != null));
//    }

    public Edificio ObtenerEdificioCodigo(int codigo){
        Optional<EdificioEntity> ee = edificioRepositorio.findByCodigo(codigo);
        if (ee.isPresent()){
            return toNegocio(ee.get());
        }
        return null;
    }

    public void guardarEdificio(EdificioEntity e){
        edificioRepositorio.save(e);
    }

    public Edificio toNegocio(EdificioEntity ee){
        Edificio e = new Edificio(ee.getCodigo(), ee.getNombre(), ee.getDireccion());
        return e;
    }

}
